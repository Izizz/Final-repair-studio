package com.example.finalrepairstudio.model.DAO;

import com.example.finalrepairstudio.model.entity.Master;
import com.example.finalrepairstudio.model.entity.BuilderMaster;
import com.example.finalrepairstudio.model.utils.SQL_Queries;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.finalrepairstudio.model.utils.SQL_Queries.FIND_MASTER;
/**
 * Master DAO implements for JDBC
 */
public class MasterDAO {
    public Master findMaster(String firstname,String lastname) throws SQLException {
        Master master = new Master();
        Connection connection = DBManager.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(FIND_MASTER);
        ps.setString(1,lastname);
        ps.setString(2,firstname);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            master = new BuilderMaster()
                        .setFirstname(rs.getString("firstname"))
                        .setLastname(rs.getString("lastname"))
                        .setEmail(rs.getString("email"))
                        .setPassword(rs.getString("password"))
                        .setPhone(rs.getString("phone"))
                        .build();
            }

        return master;
    }
}
