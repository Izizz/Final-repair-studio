package com.example.finalrepairstudio.controller.command.common;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.UserDAO;
import com.example.finalrepairstudio.model.entity.User;
import com.example.finalrepairstudio.model.entity.UserBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.example.finalrepairstudio.model.utils.Pages.loginPage;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        UserDAO userDAO = new UserDAO();


        String path = null;
        User user = new UserBuilder()
                .setEmail(email)
                .setPassword(password)
                .build();
        try {
            String userValidate = userDAO.validate(user);
            User newUser = userDAO.findUser(user);
            switch (userValidate) {
                case "Admin": {
                    HttpSession session = request.getSession();

                    session.setAttribute("Admin", email);
                    session.setAttribute("role",newUser.getRole());
                    session.setAttribute("firstname",newUser.getFirstname());
                    System.out.println(newUser.getRole());

                    return  "redirect:controller?action=home";

                }
                case "Master": {
                    HttpSession session = request.getSession();
                    session.setAttribute("Master", email);
                    session.setAttribute("role", newUser.getRole());
                    session.setAttribute("firstname",newUser.getFirstname());

                    System.out.println(newUser.getRole());

                    return "redirect:controller?action=home";

//                    response.sendRedirect(request.getContextPath() + "/master");
                }
                case "User": {
                    HttpSession session = request.getSession();
                    session.setAttribute("User", email);
                    session.setAttribute("role",newUser.getRole());
                    session.setAttribute("firstname",newUser.getFirstname());
                    session.setAttribute("id",newUser.getId());
                    session.setAttribute("lastname",newUser.getLastname());
                    session.setAttribute("email",newUser.getEmail());
                    session.setAttribute("phone",newUser.getPhonenumber());


                    System.out.println(newUser.getRole());
                    return   "redirect:controller?action=home";

                }
                default:
                    System.out.println("Error message = " + userValidate);
                    request.setAttribute("errMessage", userValidate);

                    return loginPage;
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return path;
    }
}
