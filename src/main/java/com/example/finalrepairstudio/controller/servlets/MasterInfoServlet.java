package com.example.finalrepairstudio.controller.servlets;

import com.example.finalrepairstudio.model.DAO.MasterDAO;
import com.example.finalrepairstudio.model.entity.Master;
import com.example.finalrepairstudio.model.entity.MasterBuilder;
import com.example.finalrepairstudio.model.utils.Pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "MasterInfoServlet", value = "/masters")
public class MasterInfoServlet extends HttpServlet {
    private MasterDAO masterDAO ;

    public MasterInfoServlet(){
        this.masterDAO = new MasterDAO();
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("Action").equals("Add Master")){
            PrintWriter out = response.getWriter();
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
            RequestDispatcher requestDispatcher =request.getRequestDispatcher(Pages.ADDMASTER);
            requestDispatcher.include(request,response);
            out.print("<br><h2>MAster added Successfully!!</h2>");
        }

        if(request.getParameter("Action").equals("Edit")){
            PrintWriter out = response.getWriter();
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
            RequestDispatcher dispatcher= request.getRequestDispatcher(Pages.EDITMASTER);
            dispatcher.include(request,response);
            out.print("<br><h2>Master Edited Successfully!!</h2>");
        }
        if (request.getParameter("Action").equals("Delete")) {
            PrintWriter printWriter = response.getWriter();
            Master master= new MasterBuilder().build();
            MasterDAO mastyrdao = new MasterDAO();
            try {
                masterDAO.deleteMaster(Integer.parseInt(request.getParameter("master_id")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(Pages.DELETEMASTER);
            dispatcher.include(request, response);
            printWriter.print("<br><h2>Master Deleted Successfully!!</h2>");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher(Pages.MASTERLIST).forward(request,response);

//         String action = request.getServletPath();
//         switch (action){
//             case"/new":
////                 showNewForm(request,response);
//                 request.getRequestDispatcher(Pages.MASTERFORM).forward(request,response);
//                 break;
//             case"/insert":
//                 try {
//                     insertMaster(request,response);
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//                 break;
//             case"/delete":
//                 try {
//                     deleteUser(request,response);
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//                 break;
//             case "/edit":
//                 try {
//                     showEditForm(request,response);
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//                 break;
//             case"/update":
//                 try {
//                     updateMaster(request,response);
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//                 break;
//             default:
//                 try {
//                     listmaster(request,response);
//                 } catch (SQLException e) {
//                     e.printStackTrace();
//                 }
//

         }
    }
//
//    private void showNewForm(HttpServletRequest req ,HttpServletResponse res) throws ServletException,IOException{
//        req.getRequestDispatcher(Pages.MASTERFORM).forward(req,res);
//    }
//
//    private void listmaster(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        List<Master> masterList = this.masterDAO.selectAllUsers();
//        request.setAttribute("masterList", masterList);
//        request.getRequestDispatcher(Pages.MASTERLIST).forward(request, response);
//
//    }
//
//    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
//        int id = Integer.parseInt(request.getParameter("master_id"));
//        Master existingMaster = this.masterDAO.selectMaster(id);
//        RequestDispatcher dispatcher = request.getRequestDispatcher(Pages.MASTERFORM);
//        request.setAttribute("master", existingMaster);
//        dispatcher.forward(request, response);
//    }
//
//    private void insertMaster(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phone");
//        String status = request.getParameter("status");
//        Master master = new MasterBuilder()
//                .setFirstname(firstname)
//                .setLastname(lastname)
//                .setEmail(email)
//                .setPhone(phone)
//                .setStatus(status)
//                .build();
//        this.masterDAO.insertMaster(master);
//        response.sendRedirect("list");
//    }
//
//    private void updateMaster(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//       int id = Integer.parseInt(request.getParameter("master_id"));
//        String firstname = request.getParameter("firstname");
//        String lastname = request.getParameter("lastname");
//        String email = request.getParameter("email");
//        String phone = request.getParameter("phonenumber");
//        String status = request.getParameter("status");
//        Master master = new MasterBuilder()
//                .setFirstname(firstname)
//                .setLastname(lastname)
//                .setEmail(email)
//                .setPhone(phone)
//                .setStatus(status)
//                .build();
//        this.masterDAO.updateMaster(master);
//        response.sendRedirect("list");
//    }
//
//    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
//        int id = Integer.parseInt(request.getParameter("master_id"));
//        this.masterDAO.deleteMaster(id);
//        response.sendRedirect("list");
//    }
//}
