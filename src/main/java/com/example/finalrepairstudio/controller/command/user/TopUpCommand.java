package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.DAO.UserDAO;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;

import static com.example.finalrepairstudio.model.utils.Pages.USERPAGE;

/**
 * Top up user balances for admin controller command.
 *
 * @author Ostap Semotiuk
 */
public class TopUpCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session =request.getSession(false);
        int id = (int) session.getAttribute("id");

        double balance = Double.parseDouble(request.getParameter("balanceToAdd"));
        UserDAO userDao = new UserDAO();
        OrderDAO orderDAO  = new OrderDAO();
        try {
            userDao.TopupBalance(id,balance);
            double newBalance = orderDAO.getBalance((Integer) session.getAttribute("id"));
            session.setAttribute("balance",newBalance);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return "redirect:controller?action=user-";

    }
}
