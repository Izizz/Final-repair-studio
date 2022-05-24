package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.DAO.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static com.example.finalrepairstudio.model.utils.Pages.USERBALANCE;

public class AddBalanceCommand implements Command {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int user_id = Integer.parseInt(request.getParameter("id"));

        UserDAO userDAO = new UserDAO();
        try {
            String bal = ""+request.getParameter("balanceToAdd");
            double balanceToAdd;
            if(!bal.equals("null")) {
                balanceToAdd = Double.parseDouble(bal);
                userDAO.TopupBalance(user_id,balanceToAdd);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:controller?action=admin-user-balance";
    }
}
