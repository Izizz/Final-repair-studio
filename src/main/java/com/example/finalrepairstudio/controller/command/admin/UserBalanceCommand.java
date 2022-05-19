package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.DAO.UserDAO;
import com.example.finalrepairstudio.model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static com.example.finalrepairstudio.model.utils.Pages.USERBALANCE;
import static com.example.finalrepairstudio.model.utils.SQL_Queries.GET_BALANCE_LIST;

public class UserBalanceCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int page = 1;
        int recordsPerPage = 8;
        if(request.getParameter("page") != null)
            page = Integer.parseInt(request.getParameter("page"));
        UserDAO userDAO = new UserDAO();

        try {
            List list = userDAO.getUserBalance(GET_BALANCE_LIST,(page-1)*recordsPerPage,recordsPerPage);
            int noOfRecords = userDAO.getNoOfRecords();
            int noOfPages = (int) Math.ceil(noOfRecords * 1.0 / recordsPerPage);
            request.setAttribute("list",list);
            request.setAttribute("noOfPages", noOfPages);
            request.setAttribute("currentPage", page);
        } catch (SQLException e) {
            e.printStackTrace();
        }
//
        return USERBALANCE;
    }
}
