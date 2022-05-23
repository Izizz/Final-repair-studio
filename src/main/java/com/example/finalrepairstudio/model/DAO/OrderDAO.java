package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.Master;
import com.example.finalrepairstudio.model.entity.OrderRequest;
import com.example.finalrepairstudio.model.entity.BuilderOrderRequest;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.example.finalrepairstudio.model.utils.SQL_Queries.*;
/**
 * Order DAO implements for JDBC
 */
public class OrderDAO {
    private static final Logger log  = Logger.getLogger(String.valueOf(OrderDAO.class));

    public static final String APP_DATE_FORMAT = "MM/dd/yyyy";
    private static final SimpleDateFormat formatter = new SimpleDateFormat(APP_DATE_FORMAT);

    public static Date getDate(String val) {
        Date date = null;
        try {
            date = formatter.parse(val);
        } catch (Exception e) {
        }
        return date;
    }

    public List<OrderRequest> queryFilterOrders(Connection connection, String sort, String filterList, String sql ) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql  + " master = " + filterList +" OR status = " + filterList + " ORDER BY "+ sort );

        ResultSet rs = ps.executeQuery();
        List<OrderRequest> list = new ArrayList<>();
        while (rs.next()){
            OrderRequest orderRequest = new BuilderOrderRequest()
                    .setRequestId(rs.getInt("id"))
                    .setUserId(rs.getInt("user_id"))
                    .setRequestDescr(rs.getString("description"))
                    .setPrice(rs.getDouble("price"))
                    .setMaster(rs.getString("master"))
                    .setStatus(rs.getString("status"))
                    .setRequestDate(rs.getDate("date"))
                    .build();

            list.add(orderRequest);

        }
        rs.close();
        connection.close();

        return list;

    }

    public  List<OrderRequest> queryMasterOrders(Connection connection,String sort,String sql ) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(sql + sort  ) ;
        ResultSet rs = ps.executeQuery();
        List<OrderRequest> list = new ArrayList<>();
        while (rs.next()){
            OrderRequest orderRequest = new BuilderOrderRequest()
                    .setRequestId(rs.getInt("id"))
                    .setUserId(rs.getInt("user_id"))
                    .setRequestDescr(rs.getString("description"))
                    .setPrice(rs.getDouble("price"))
                    .setMaster(rs.getString("master"))
                    .setStatus(rs.getString("status"))
                    .setRequestDate(rs.getDate("date"))
                    .setFeedback(rs.getString("feedback"))
                    .build();

            list.add(orderRequest);
        }
        rs.close();
        connection.close();
        return list;
    }

    public List<OrderRequest> queryOrders(Connection connection, String sort, String sql) throws SQLException{
        PreparedStatement ps = connection.prepareStatement(sql + sort  ) ;
        ResultSet rs = ps.executeQuery();
        List<OrderRequest> list = new ArrayList<>();
        while (rs.next()){
            OrderRequest orderRequest = new BuilderOrderRequest()
                    .setRequestId(rs.getInt("id"))
                    .setUserId(rs.getInt("user_id"))
                    .setRequestDescr(rs.getString("description"))
                    .setPrice(rs.getDouble("price"))
                    .setMaster(rs.getString("master"))
                    .setStatus(rs.getString("status"))
                    .setRequestDate(rs.getDate("date"))
                    .build();

            list.add(orderRequest);
        }
        rs.close();
        connection.close();

        return list;
    }

    public OrderRequest getOrder(String desr) throws SQLException {
            OrderRequest order = null;
            Connection  connection  = DBManager.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(GET_ORDER);
            ps.setString(1,desr);
            ResultSet rs =ps.executeQuery();
            while(rs.next()){
                 order = new BuilderOrderRequest()
                         .setRequestId(rs.getInt("id"))
                        .setUserId(rs.getInt("user_id"))
                        .setRequestDescr(rs.getString("description"))
                        .setPrice(rs.getDouble("price"))
                        .setMaster(rs.getString("master"))
                        .setStatus(rs.getString("status"))
                        .setRequestDate(rs.getDate("date"))
                        .build();
            }

        rs.close();
        connection.close();
        return order;

    }

    public void DeleteOrder(int id) {
        String sql = "call deleteOrder( " + id + ")";
        try {
            Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            int update = ps.executeUpdate();
            if (update > 0) {
                log.debug("Order was deleted successfully");
                return;
            }
            connection.close();
        } catch (SQLException e) {
            log.error(e);
        }
    }

    public  void addOrder(OrderRequest orderRequest){
        try {
            log.debug("Adding order to database");


            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate localDate = LocalDate.now();
            String dateToday = dtf.format(localDate);
            Date date = getDate(dateToday);

            Connection connection = DBManager.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(ADD_ORDER);
            ps.setInt(1, orderRequest.getUser());
            ps.setString(2, orderRequest.getRequestDescr());
            ps.setDouble(3, orderRequest.getPrice());
            ps.setString(4, orderRequest.getMaster());
            ps.setString(5, orderRequest.getStatus());
            ps.setDate(6, new java.sql.Date(date.getTime()));

            ps.executeUpdate();
            connection.close();
            ps.close();
        }catch (SQLException e ){
            log.error(e);
            e.printStackTrace();
        }
    }

    public void updateOrder(Master master,int price,String status,int id){
        try {
            log.debug("Updating order in database");
            Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_ORDER);
            ps.setInt(1,price);
            ps.setString(2, master.getLastname());
            ps.setString(3,status);
            ps.setInt(4,id);
            ps.executeUpdate();



        } catch (SQLException e) {
            log.error(e);
            e.printStackTrace();
        }
    }

    public void checkBalance(int request_id) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(CHECK_BALANCE);
        ps.setInt(1,request_id);
        ResultSet rs = ps.executeQuery();

        while(rs.next()){
            if(rs.getDouble("price") <= rs.getDouble("balance")){
                updateStatus("Paid",request_id);
                pay(rs.getDouble("price"), rs.getDouble("balance"),rs.getInt("user_id"));
            }

        }


    }

    public  double getBalance  (int user_id) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps  = connection.prepareStatement(GET_NEW_BALANCE);
        double balance = 0 ;
        ps.setInt(1,user_id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            balance = rs.getDouble("balance");
        }
        return balance;

    }

    public void pay(double price,double balance,int id) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(UPDATE_BALANCE);
        ps.setDouble(1,balance-price);
        ps.setInt(2,id);
        ps.executeUpdate();


    }

    public void updateStatus(String status,int id){
        try{
            Connection connection = DBManager.getInstance().getConnection();
            PreparedStatement ps = connection.prepareStatement(UPDATE_STATUS);
            ps.setString(1,status);
            ps.setInt(2,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void leaveFeedback(int order_id , String feedback) throws SQLException {
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(ADD_FEEDBACK);
        ps.setString(1,feedback);
        ps.setInt(2,order_id);
        ps.executeUpdate();


    }
}
