package com.example.finalrepairstudio.controller.command.common;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.finalrepairstudio.model.utils.Pages.*;

public class ChooseRoleCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession();

        String role = (String) session.getAttribute("role");
        switch (role){
            case "admin":
                return ADMINPAGE;
            case "user":
                return USERPAGE;
            case "master":
                return MASTERPAGE;
        }
        return null;
    }
}
