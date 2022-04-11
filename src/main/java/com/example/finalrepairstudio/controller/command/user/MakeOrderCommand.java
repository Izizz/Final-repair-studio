package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.finalrepairstudio.model.utils.Pages.MAKEORDER;
import static com.example.finalrepairstudio.model.utils.Pages.loginPage;

public class MakeOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("role") == null){
            return loginPage;
        }else{
            return MAKEORDER;
        }
        
    }
}
