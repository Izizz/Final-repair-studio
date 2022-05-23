package com.example.finalrepairstudio.model.DAO;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Connection pool for DB.
 *
 * @author Ostap Semotiuk.
 */

public class DBManager {

    private static final Logger log  = Logger.getLogger(String.valueOf(DBManager.class));

    /**
     * JDBC Database connection pool ( DCP )
     */
    private static DBManager datasource;
    private DBManager() {
    }
    private ComboPooledDataSource cpds = null;
    /**
     * Create instance of Connection Pool
     *
     * @return
     */
    public static DBManager getInstance() {
        if (datasource == null) {
            ResourceBundle rb = ResourceBundle.getBundle("WebAppResources.System");
            datasource = new DBManager();
            datasource.cpds = new ComboPooledDataSource();
            try {
                datasource.cpds.setDriverClass(rb.getString("driver"));
            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
            datasource.cpds.setJdbcUrl(rb.getString("url"));
            datasource.cpds.setUser(rb.getString("username"));
            datasource.cpds.setPassword(rb.getString("password"));
            datasource.cpds.setInitialPoolSize(new Integer((String) rb .getString("initialPoolSize")));
            datasource.cpds.setAcquireIncrement(new Integer((String) rb.getString("acquireIncrement")));
            datasource.cpds.setMaxPoolSize(new Integer((String) rb.getString("maxPoolSize")));
            datasource.cpds.setMaxIdleTime(Integer.parseInt(rb.getString("timeout")));
            datasource.cpds.setMinPoolSize(new Integer((String) rb.getString("minPoolSize")));
        }
        return datasource;
    }
    /**
     * Gets the connection from ComboPooledDataSource
     *
     * @return connection
     */
    public Connection getConnection() throws SQLException {
        log.debug("Connection created");
        return getInstance().cpds.getConnection();
    }
    /**
     * Closes a connection4
     *
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
                log.debug("Connection close");

            } catch (Exception e) {
                e.printStackTrace();
                log.error(e);
            }
        }
    }
//    private static DBManager instance;
//
//
//    /**
//     * Singleton.
//     */
//    public static DBManager getInstance(){
//        if(instance == null){
//            instance = new DBManager();
//        }
//        return instance;
//    }
//    private DBManager() {
//    }
//
//
//    /**
//     * Establishes a connection to the database.
//     *
//     * @return the connection to the database
//     */
//    public  Connection getConnection () throws SQLException {
//        Connection connection = null;
//        try {
//            log.debug("Connection created");
//            Context ctx = new InitialContext();
//            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/repairStudio");
//            connection = ds.getConnection();
//        } catch (NamingException e) {
//            log.error(e);
//            e.printStackTrace();
//        }
//        return connection;
//    }
//    /**
//     * Closes the connection.
//     *
//     * @param connection closes the database connection
//     */
//    public void closeConnection (Connection connection){
//        log.debug("Conncetion closed");
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }


}
