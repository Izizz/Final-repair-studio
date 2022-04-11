package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.OrderRequest;
import com.example.finalrepairstudio.model.entity.OrderRequestBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import static com.example.finalrepairstudio.model.utils.SQL_Queries.ADD_ORDER;
import static com.example.finalrepairstudio.model.utils.SQL_Queries.SHOW_ORDERS;

public class OrderDAO {
    public static List<OrderRequest> queryOrders(Connection connection) throws SQLException{
        PreparedStatement ps =connection.prepareStatement(SHOW_ORDERS);
        ResultSet rs = ps.executeQuery();
        List<OrderRequest> list = new ArrayList<>();
        while (rs.next()){
            OrderRequest orderRequest = new OrderRequestBuilder()
                    .setUserId(rs.getInt("user_id"))
                    .setRequestDescr(rs.getString("description"))
                    .setPrice(rs.getDouble("price"))
                    .setMasterId(Integer.parseInt(rs.getString("master_id")))
                    .setStatus(rs.getString("status"))
                    .setRequestDate(rs.getDate("date"))
                    .build();

            list.add(orderRequest);
        }
        return list;
    }

    public  void addOrder(OrderRequest orderRequest){
        try {
            Connection connection = DBManager.getConnection();

            PreparedStatement ps = connection.prepareStatement(ADD_ORDER);
            ps.setInt(1, orderRequest.getUser());
            ps.setString(2, orderRequest.getRequestDescr());
            ps.setDouble(3, orderRequest.getPrice());
            ps.setInt(4, orderRequest.getMaster());
            ps.setString(5, orderRequest.getStatus());
            ps.setDate(6, orderRequest.getRequestDate());

            ps.executeUpdate();
            connection.close();
            ps.close();
        }catch (SQLException e ){
            e.printStackTrace();
        }
    }
}
