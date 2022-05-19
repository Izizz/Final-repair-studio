package com.example.finalrepairstudio.model.DAO;

import org.apache.log4j.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Connection pool for DB.
 *
 * @author Ostap Semotiuk.
 */

public class DBManager {
    private static final Logger log  = Logger.getLogger(String.valueOf(DBManager.class));

    private static DBManager instance;


    /**
     * Singleton.
     */
    public static DBManager getInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }
    private DBManager() {
    }


    /**
     * Establishes a connection to the database.
     *
     * @return the connection to the database
     */
    public  Connection getConnection () throws SQLException {
        Connection connection = null;
        try {
            log.debug("Connection created");
            Context ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/repairStudio");
            connection = ds.getConnection();
        } catch (NamingException e) {
            log.error(e);
            e.printStackTrace();
        }
        return connection;
    }
    /**
     * Closes the connection.
     *
     * @param connection closes the database connection
     */
    public void closeConnection (Connection connection){
        log.debug("Conncetion closed");
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
