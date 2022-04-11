package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.Master;
import com.example.finalrepairstudio.model.entity.MasterBuilder;
import com.example.finalrepairstudio.model.utils.SQL_Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MasterDAO {

    public boolean insertMaster(Master master) throws SQLException {
            String query = SQL_Queries.ADD_MASTER;
            Connection connection = DBManager.getConnection();
            int i = 0;
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, master.getFirstname());
            ps.setString(2, master.getLastname());
            ps.setString(3, master.getEmail());
            ps.setString(4, master.getPhone());
            ps.setString(5, master.getPassword());
            //ps.setString(5, master.getStatus());

             i = ps.executeUpdate();

            connection.close();
            ps.close();


        return i != 0;
    }

//    public int findMaster (Master master) {
//         int result = 0;
//         try {
//             Connection connection = DBManager.getConnection();
//             String query  = SQL_Queries.FIND_MASTER;
//             PreparedStatement ps = connection.prepareStatement(query);
//             ps.setString(1,master.getLastname());
//             ps.setString(2,master.getEmail());
//             ps.setString(3,master.getPhone());
//
//             ps.executeUpdate();
//             result = 1;
//             connection.close();
//             ps.close();
//
//         }catch (SQLException e){
//             e.printStackTrace();
//
//         }
//    return result;
//    }

    public Master selectMaster(int id) {
        Master master = null;

        try (Connection connection = DBManager.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Queries.SELECT_MASTER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String status = rs.getString("status");

                master = new MasterBuilder()
                        .setFirstname(firstname)
                        .setLastname(lastname)
                        .setEmail(email)
                        .setPhone(phone)
                        .setStatus(status)
                        .build();
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return master;
    }

    public boolean updateMaster(Master master) throws SQLException {
        int i ;
        try (Connection connection = DBManager.getConnection();
             PreparedStatement ps = connection.prepareStatement(SQL_Queries.UPDATE_MASTERS);) {
            ps.setString(1,master.getFirstname());
            ps.setString(2, master.getLastname());
            ps.setString(3, master.getEmail());
            ps.setString(4, master.getPhone());
//            ps.setString(5,master.getStatus());
            ps.setString(5, master.getPassword());
            ps.setInt(6,master.getId());
            i = ps.executeUpdate() ;
        }
        return i != 0;
    }

    public void deleteMaster(int id) throws SQLException {

        try (Connection connection = DBManager.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_Queries.DELETE_MASTER);) {
            statement.setInt(1, id);
            statement.executeUpdate() ;
        }

    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    public List < Master > selectAllUsers() {

        List< Master > masters = new ArrayList< >();
        try (Connection connection = DBManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Queries.SHOW_MASTERS);) {

            ResultSet rs = preparedStatement.executeQuery();


            while (rs.next()) {

                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phonenumber");
                String status = rs.getString("status");

                masters.add(new MasterBuilder()
                        .setFirstname(firstname)
                        .setLastname(lastname)
                        .setEmail(email)
                        .setPhone(phone)
                        .setStatus(status)
                        .build());
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return masters;
    }

}
