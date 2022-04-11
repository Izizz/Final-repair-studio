package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.DBManager;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.entity.OrderRequest;
import com.example.finalrepairstudio.model.entity.OrderRequestBuilder;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class AddToOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession  session = request.getSession();
        String description = request.getParameter("descr") ;
        String change =  request.getParameter("change-glass");
        String polish = request.getParameter("polish-glass");
        List <String> list = new ArrayList<>();
        if(description != null){
        list.add(description);
        }
        if(change != null && change.equals("on") ){
            change= "change glass";
            list.add(change);
        }
        if(polish != null && polish.equals("on")){
            polish= "polish glass";
            list.add(polish);
        }
        System.out.println(list.size());
        String final_descr;
        if(list.size()==1){
            final_descr = list.get(0);
        }else{
            final_descr = String.join(",",list);
        }



        OrderRequest orderRequest = new OrderRequestBuilder()
                .setUserId((int) session.getAttribute("id"))
                .setRequestDescr(final_descr)
                .setStatus("Pending to approve")
                .build();

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.addOrder(orderRequest);
        return "redirect:controller?action=user-";
    }
}
