package com.example.finalrepairstudio.controller.command.common;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.UserDAO;
import com.example.finalrepairstudio.model.entity.User;
import com.example.finalrepairstudio.model.entity.UserBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String phone = request.getParameter("phone");


        UserDAO userDAO = new UserDAO();

        User user = new UserBuilder()
                .setPassword(password)
                .setEmail(email)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setPhonenumber(phone)
                .setRole("user")
                .build();

        userDAO.insert(user);
        userDAO.getId(user);
        userDAO.insertBalance(user);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<html><body><b>Successfully Inserted"
                + "</b></body></html>");
        return "redirect:controller?action=home";
    }
}
