package com.example.finalrepairstudio.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutCommand implements Command{


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return "/WEB-INF/view/About.jsp";
    }
}
