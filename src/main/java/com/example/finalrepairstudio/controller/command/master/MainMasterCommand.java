package com.example.finalrepairstudio.controller.command.master;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.example.finalrepairstudio.model.utils.Pages.MASTERPAGE;
/**
 * Menu page for master  command.
 *
 * @author Ostap Semotiuk
 */
public class MainMasterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        return MASTERPAGE;
    }
}
