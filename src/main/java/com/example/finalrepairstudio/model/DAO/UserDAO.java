package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.User;
import com.example.finalrepairstudio.model.entity.BuilderUser;
import com.example.finalrepairstudio.model.utils.SQL_Queries;

import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * User DAO implements for JDBC
 */
public class UserDAO {
    private static final Logger log  = Logger.getLogger(String.valueOf(UserDAO.class));

    private int noOfRecords ;

    public int getNoOfRecords() {
        return noOfRecords;
    }


    public String insert(User user)  {
        String result  = "DATA entered successfully";

        try {
            log.debug("Inserting user into database");

            Connection connection = DBManager.getInstance().getConnection();

            String query = SQL_Queries.ADD_USER;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPhonenumber());


            ps.executeUpdate();



        } catch (SQLException  e) {
            log.error(e);
            e.printStackTrace();
            result = "Data was not entered";
        }

        return result;
    }

    public int getId(User user){
        String sql = SQL_Queries.GET_USER_ID;
        User newUser = new User();
        String email = user.getEmail();
        try{
            Connection connection = DBManager.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                 newUser = new BuilderUser()
                        .setId(rs.getInt("user_id"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newUser.getId();
    }


    public String validate(User user){

        String query = SQL_Queries.FIND_LOGIN;


        String email  = user.getEmail();
        String password  = user.getPassword();


        try{
            log.debug("User validation starts");
            Connection connection = DBManager.getInstance().getConnection();

            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getEmail());
            ps.setString(2,user.getPassword());

            ResultSet rs =  ps.executeQuery();
            while(rs.next())
            {
                 String useremailDB = rs.getString("email");
                 String passwordDB = rs.getString("password");
                 String roleDB = rs.getString("role");

                if(email.equals(useremailDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                    return "Admin";
                else if(email.equals(useremailDB) && password.equals(passwordDB) && roleDB.equals("master"))
                    return "Master";
                else if(email.equals(useremailDB) && password.equals(passwordDB) && roleDB.equals("user"))
                    return "User";
            }
            log.debug("User validation finished");

            connection.close();
            ps.close();

        }catch (SQLException e ) {
            log.error(e);
            e.printStackTrace();
        }

        return "Invalid user credentials";
    }

    public User findUser(User user) throws SQLException {
        Connection connection= DBManager.getInstance().getConnection();
        User newUser = null;
        PreparedStatement ps = connection.prepareStatement(SQL_Queries.FIND_LOGIN);
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            newUser = new BuilderUser()
                    .setId(rs.getInt("user_id"))
                    .setFirstname(rs.getString("firstname"))
                    .setLastname(rs.getString("lastname"))
                    .setEmail(rs.getString("email"))
                    .setPassword(rs.getString("password"))
                    .setPhonenumber(rs.getString("phone"))
                    .setRole(rs.getString("role"))
                    .build();
        }
        return newUser;

    }

    public double getBalance(int user_id) throws SQLException{
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_Queries.GET_BALANCE);
        ps.setInt(1,user_id);
        ResultSet rs = ps.executeQuery();
        double balance = 0;
        while (rs.next()) {
             balance = rs.getDouble("balance");
        }
        return balance;
    }

    public void TopupBalance(int user_id,double balance) throws SQLException{
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(SQL_Queries.UPDATE_BALANCE);
        ps.setDouble(1,getBalance(user_id)+balance);
        ps.setInt(2,user_id);
        ps.executeUpdate();

    }

    public List<User> getUserBalance (String sql,int offset,int noOfRecords) throws SQLException{
        List <User> userList = new ArrayList<>();
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(sql + offset + ", " + noOfRecords);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            User user = new BuilderUser()
                    .setId(rs.getInt("user_id"))
                    .setFirstname(rs.getString("firstname"))
                    .setLastname(rs.getString("lastname"))
                    .setBalance(rs.getDouble("balance"))
                    .build();
            userList.add(user);
        }
        rs.close();

        rs = ps.executeQuery("SELECT FOUND_ROWS()");
        if (rs.next()) {
            this.noOfRecords = rs.getInt(1);
        }

        connection.close();
        return  userList;

    }

//    public void deleteUser(String email) throws  SQLException{
//        try {
//         Connection connection  =  DBManager.getInstance().getConnection();
//         PreparedStatement ps = connection.prepareStatement();
//        }
//    }
}
