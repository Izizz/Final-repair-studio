package com.example.finalrepairstudio.controller.command.admin;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.DBManager;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.entity.OrderRequest;
import com.example.finalrepairstudio.model.utils.SQL_Queries;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

import static com.example.finalrepairstudio.model.utils.Pages.REQUESTLIST;

public class ShowOrderCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List list = null;
        String sort = request.getParameter("sort");
        String filterList =   request.getParameter("filterlist") ;
        OrderDAO order = new OrderDAO();

        if(filterList != null){
            try {
                list = order.queryFilterOrders(DBManager.getInstance().getConnection(),
                        sort,
                        filterList,
                        SQL_Queries.SHOW_FILTERED_ORDERS)
                        ;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            try {
                list = order.queryOrders(DBManager.getInstance().getConnection(),
                        sort,
                        SQL_Queries.SHOW_ORDERS);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        request.setAttribute("list",list);
        return REQUESTLIST;
    }
}
