package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.finalrepairstudio.model.utils.Pages.MASTERLIST;

public class ShowMasterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return MASTERLIST;
    }
}
