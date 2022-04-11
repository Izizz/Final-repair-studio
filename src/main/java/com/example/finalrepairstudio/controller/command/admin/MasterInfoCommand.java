package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.MasterDAO;
import com.example.finalrepairstudio.model.entity.Master;
import com.example.finalrepairstudio.model.entity.MasterBuilder;
import com.example.finalrepairstudio.model.utils.Pages;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import static com.example.finalrepairstudio.model.utils.Pages.*;

public class MasterInfoCommand implements Command {
    MasterDAO masterDAO;
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        if(request.getParameter("Action").equals("Add Master")){
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            MasterDAO masterDAO = new MasterDAO();
            Master master = new MasterBuilder()
                    .setFirstname(request.getParameter("firstname"))
                    .setLastname(request.getParameter("lastname"))
                    .setEmail(request.getParameter("email"))
                    .setPhone(request.getParameter("phone"))
                    .setPassword(request.getParameter("password"))
                    //setStatus(request.getParameter("status"))
                    .setRole("master")
                    .build();
            try {
                masterDAO.insertMaster(master);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return ADDMASTER;
        }

        if(request.getParameter("Action").equals("Edit")){
            MasterDAO masterDAO = new MasterDAO();
            Master master = new MasterBuilder()
                    .setFirstname(request.getParameter("firstname"))
                    .setLastname(request.getParameter("lastname"))
                    .setEmail(request.getParameter("email"))
                    .setPhone(request.getParameter("phone"))
                    .setStatus(request.getParameter("status"))
                    .build();

            try {
                masterDAO.updateMaster(master);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return  EDITMASTER;
        }
        if (request.getParameter("Action").equals("Delete")) {
            Master master = new MasterBuilder().build();
            MasterDAO masterdao = new MasterDAO();
            try {
                masterDAO.deleteMaster(Integer.parseInt(request.getParameter("master_id")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return DELETEMASTER;
        }

        return null;
    }
}
