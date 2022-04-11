package com.example.finalrepairstudio.controller.filters;

import com.example.finalrepairstudio.controller.command.common.LogoutCommand;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import static com.example.finalrepairstudio.model.utils.Pages.loginPage;
//@WebFilter("/*")
public class AuthFilter implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session =  request.getSession(false);

        Boolean access = false;
        String role = (String) request.getAttribute("role");
        if(request.getRequestURI().contains("home")
                || request.getRequestURI().contains("login")
                || request.getRequestURI().contains("registerpage")
                || request.getRequestURI().contains("register")
                || request.getRequestURI().contains("choice"))
            access = true;
        else{

        }

        if(access){
            request.getRequestDispatcher(request.getRequestURI()).forward(request,response);
        }
//        String reqPath = req.getRequestURI().replace();

        filterChain.doFilter(servletRequest,servletResponse);
    }




}
