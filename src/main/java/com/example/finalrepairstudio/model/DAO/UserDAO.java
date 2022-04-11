package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.User;
import com.example.finalrepairstudio.model.entity.UserBuilder;
import com.example.finalrepairstudio.model.utils.SQL_Queries;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class UserDAO {

    public String insert(User user)  {
        String result  = "DATA entered successfully";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DBManager.getConnection();

            String query = SQL_Queries.ADD_USER;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1,user.getFirstname());
            ps.setString(2,user.getLastname());
            ps.setString(3,user.getPassword());
            ps.setString(4,user.getEmail());
            ps.setString(5,user.getPhonenumber());



            ps.executeUpdate();

            connection.close();
            ps.close();

        } catch (SQLException  e) {
            e.printStackTrace();
            result = "Data was not entered";
        }

        return result;
    }

    public int getId(User user){
        String sql = SQL_Queries.GET_USER_ID;
        User newUser = null;
        String email = user.getEmail();
        try{
            Connection connection = DBManager.getConnection();

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                 newUser = new UserBuilder()
                        .setId(rs.getInt("user_id"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assert newUser != null;
        return newUser.getId();
    }

    public String insertBalance(User user){
        String result  = "DATA entered successfully";

        try {
            Connection connection = DBManager.getConnection();

            PreparedStatement ps = connection.prepareStatement(SQL_Queries.ADD_USER_BALANCE);
            ps.setInt(1,user.getId());
            ps.executeUpdate();

            connection.close();
            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
            result = "Data was not entered";
        }
        return result;
    }

    public String validate(User user){

        String query = SQL_Queries.FIND_USER;


        String email  = user.getEmail();
        String password  = user.getPassword();


        try{

            Connection connection = DBManager.getConnection();

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
            connection.close();
            ps.close();

        }catch (SQLException e ) {
            e.printStackTrace();
        }


        return "Invalid user credentials";
    }

    public User findUser(User user) throws SQLException {
        Connection connection= DBManager.getConnection();
        User newUser = null;
        PreparedStatement ps = connection.prepareStatement(SQL_Queries.FIND_USER);
        ps.setString(1,user.getEmail());
        ps.setString(2,user.getPassword());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            newUser = new UserBuilder()
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

}
