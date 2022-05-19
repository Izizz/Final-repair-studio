package com.example.finalrepairstudio.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.controller.command.CommandFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Front controller, handle all user requests and redirect them
 * to specific commands according to request URL
 */
@WebServlet(name = "Controller", value = "/controller")
public class Controller extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException{
            logger.debug("Controller working....");
            CommandFactory commandFactory = CommandFactory.commandFactory();
            Command ic = commandFactory.getCommand(req);
            String page = ic.execute(req, res);

            if(!page.contains("redirect:")){
                req.getRequestDispatcher(page).forward(req,res);
            }
            else{
                res.sendRedirect(page.replace("redirect:",""));
            }




    }
}
