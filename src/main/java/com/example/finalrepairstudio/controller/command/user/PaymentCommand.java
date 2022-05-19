package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;

import static com.example.finalrepairstudio.model.utils.Pages.ORDERPAGE;
/**
 * Payment controller command.
 *
 * @author Ostap Semotiuk
 */
public class PaymentCommand implements Command {
    private static final Logger log  = Logger.getLogger(String.valueOf(PaymentCommand.class));

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int request_id = Integer.parseInt((request.getParameter("id")));
        HttpSession session = request.getSession();
        OrderDAO orderDAO = new OrderDAO();
        try {
            log.debug("PaymentCommand working start");
            orderDAO.checkBalance(request_id);
            double balance = orderDAO.getBalance((Integer) session.getAttribute("id"));
            session.setAttribute("balance",balance);
            log.debug("PaymentCommand working finish");

        } catch (SQLException e) {
            e.printStackTrace();
            log.error("PaymentCommand Error");
        }



        return  "redirect:controller?action=user-orders";
    }
}
