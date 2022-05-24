package com.example.finalrepairstudio.controller.listeners;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

@WebListener
public class ContainerContextClosedHandler implements ServletContextListener {
    private static final Logger log = Logger.getLogger(ContainerContextClosedHandler.class);

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.debug("WebListener works");
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        Driver driver;


        while(drivers.hasMoreElements()) {
            try {
                driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            } catch (SQLException ex) {

            }
        }

        AbandonedConnectionCleanupThread.checkedShutdown();



    }

}