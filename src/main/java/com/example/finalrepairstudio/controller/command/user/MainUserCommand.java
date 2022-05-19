package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static com.example.finalrepairstudio.model.utils.Pages.USERPAGE;
/**
 * Menu page  for user  command.
 *
 * @author Ostap Semotiuk
 */
public class MainUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return USERPAGE;
    }
}
