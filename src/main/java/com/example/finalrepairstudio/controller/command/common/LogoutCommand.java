package com.example.finalrepairstudio.controller.command.common;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.finalrepairstudio.model.utils.Pages.HOMEPAGE;

public class LogoutCommand implements Command
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       request.getSession().invalidate();
        return "redirect:" + HOMEPAGE;
    }
}

