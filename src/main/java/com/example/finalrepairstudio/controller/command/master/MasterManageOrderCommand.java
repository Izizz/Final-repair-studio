package com.example.finalrepairstudio.controller.command.master;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Manage orders for master  command.
 *
 * @author Ostap Semotiuk
 */
public class MasterManageOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int request_id = Integer.parseInt((request.getParameter("id")));
        String status = request.getParameter("status");
        OrderDAO orderDAO  = new OrderDAO();
        orderDAO.updateStatus(status,request_id);
        return "redirect:controller?action=master-orders";
    }
}
