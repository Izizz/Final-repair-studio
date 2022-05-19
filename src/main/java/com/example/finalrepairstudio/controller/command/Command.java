package com.example.finalrepairstudio.controller.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Main interface for the Command pattern implementation.
 *
 * @author Ostap Semotiuk
 */
public interface Command {
    /**
     * Execution method for command.
     *
     * @return Address to go once the command is executed.
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException;

}
