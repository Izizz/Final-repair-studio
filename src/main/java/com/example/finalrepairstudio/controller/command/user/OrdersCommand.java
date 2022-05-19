package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.DBManager;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.utils.SQL_Queries;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

import static com.example.finalrepairstudio.model.utils.Pages.ORDERPAGE;
/**
 * Showing orders for user  command.
 *
 * @author Ostap Semotiuk
 */
public class OrdersCommand implements Command {
    private static final Logger log  = Logger.getLogger(String.valueOf(OrdersCommand.class));
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession(false);
        OrderDAO order = new OrderDAO();

        List list = null;
        try {
            log.debug("OrdersCommand working start");
             list = order.queryOrders(DBManager.getInstance().getConnection(),
                    request.getParameter("sort"),
                    SQL_Queries.SHOW_USERS_ORDERS  + session.getAttribute("id")  +" "+ "ORDER BY " );
            log.debug("OrdersCommand working finish");

        } catch (SQLException e) {
            log.error("OrdersCommand Error");
            e.printStackTrace();
        }
        request.setAttribute("list",list);
        return ORDERPAGE;
    }
}
