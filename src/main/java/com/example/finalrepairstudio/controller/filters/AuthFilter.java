package com.example.finalrepairstudio.controller.filters;


import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;
/**
 * Authentication filter implementation
 */
@WebFilter("/controller")
public class AuthFilter implements Filter {
    private static final Logger log  = Logger.getLogger(String.valueOf(AuthFilter.class));
    private HttpServletRequest httpRequest;
    private static final ArrayList<String> common = new ArrayList<>(Arrays.asList("login","logout","home","registerpage","register","change-language","choice"));
    private static final ArrayList<String> adminRequiredURLs = new ArrayList<>(Arrays.asList("admin-",  "admin-orders",  "admin-manage",  "admin-update","user-makeorder", "admin-user-balance",  "admin-add-balance"));
    private static final ArrayList<String> masterRequiredURLs  = new ArrayList<>(Arrays.asList("master-", "master-orders","master-manage","user-makeorder"));
    private static final ArrayList<String> userRequiresURLs = new ArrayList<>(Arrays.asList("user-","user-addToOrder","user-orders","user-pay","user-makeorder","user-topup","user-leave-feedback","user-feedback"));

    private boolean isAuthorized(HttpServletRequest req) {
        String command = req.getParameter("action");
        if (command == null){
            return true;
        }
        if (common.contains(command)) {
            return true;
        }

        String role = (String) req.getSession(false).getAttribute("role");

        if ("admin".equals(role) && adminRequiredURLs.contains(command)) {
            return true;
        }
        if ("master".equals(role) && masterRequiredURLs.contains(command)) {
            return true;
        }
        return "user".equals(role) && userRequiresURLs.contains(command);
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.debug("Auth filter starts");
        httpRequest = (HttpServletRequest) servletRequest;

        HttpServletResponse response = (HttpServletResponse) servletResponse;


        HttpSession session=((HttpServletRequest) servletRequest).getSession(false);

        boolean isLoggedIn = (session != null && session.getAttribute("role") != null);

        String loginURL = "login";
        String makeOrderURL = "user-makeorder";
        boolean isLoginRequest = httpRequest.getParameter("action").equals(loginURL);
        boolean isMakeOrderRequest = httpRequest.getParameter("action").equals(makeOrderURL);

        if(isLoggedIn && isLoginRequest){
            httpRequest.getRequestDispatcher("/").forward(servletRequest,servletResponse);
        }else if (isAuthorized(httpRequest)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else if(!isLoggedIn && isMakeOrderRequest) {
            httpRequest.getRequestDispatcher("controller?action=login").forward(servletRequest,servletResponse);

        } else {
            response.sendRedirect("controller?action=home");
        }
        log.debug("Auth filter finished");
    }
    public AuthFilter() {
    }

    public void destroy() {
        log.debug("Auth filter destroyed");
    }

    public void init(FilterConfig fConfig) throws ServletException {
        log.debug("Auth filter initialized start");
        log.debug("Auth filter initialized finish");
    }





}
