package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.MasterDAO;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.entity.Master;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class UpdateOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int request_id = Integer.parseInt((request.getParameter("id")));
        int price = Integer.parseInt(request.getParameter("price"));
        String status = request.getParameter("status");
        String firstlast = request.getParameter("master");

        String[] split = firstlast.split("-");

        Master master = new Master();
        MasterDAO masterDAO = new MasterDAO();


        try {
            master = masterDAO.findMaster(split[0],split[1]);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        OrderDAO orderDAO = new OrderDAO();


        orderDAO.updateOrder(master,price,status,request_id);
        return "redirect:controller?action=admin-orders";
    }
}
