package com.example.finalrepairstudio.model.DAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {

    public static Connection getConnection () throws SQLException {
        Connection connection = null;
        try {
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/repairStudio");
            connection = ds.getConnection();
        } catch (NamingException e) {

            e.printStackTrace();
        }
        return connection;
    }
}
