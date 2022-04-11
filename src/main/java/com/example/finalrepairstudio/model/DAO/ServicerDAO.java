package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.ServiceEntity;
import com.example.finalrepairstudio.model.entity.ServiceEntityBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServicerDAO {

    public static List<ServiceEntity> queryServices(Connection connection) throws SQLException{
        String sql = "SELECT * FROM services";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<ServiceEntity> list = new ArrayList<ServiceEntity>();
        while(rs.next()){
            String name = rs.getString("name");
            String price = rs.getString("price");
            ServiceEntity se = new ServiceEntityBuilder()
                   .setName(name)
                   .setPrice(price)
                   .build();
           list.add(se);
        }
        return list;

    }

    public static void updateService(Connection connection,ServiceEntity se) throws SQLException{
        String sql = "UPDATE services SET name = ? , price = ? WHERE id = ? ";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,se.getName());
        ps.setString(2,se.getPrice());
        ps.setInt(3,se.getId());
        ps.executeUpdate();

    }

    public static void insertService(Connection connection,  ServiceEntity se) throws SQLException{
        String sql = "INSERT INTO services (name,price) values (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, se.getName());
        ps.setString(2, se.getPrice());

        ps.executeUpdate();
    }

    public static void deleteService(Connection connection, int id) throws SQLException{
        String sql= "DELETE FROM services WHERE id= ?";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setInt(1,id);
        ps.executeUpdate();

    }
}
