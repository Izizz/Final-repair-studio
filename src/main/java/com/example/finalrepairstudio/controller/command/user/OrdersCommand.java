package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.finalrepairstudio.model.utils.Pages.ORDERPAGE;

public class OrdersCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return ORDERPAGE;
    }
}
