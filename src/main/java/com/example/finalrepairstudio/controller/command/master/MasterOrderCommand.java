package com.example.finalrepairstudio.controller.command.master;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.DBManager;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import com.example.finalrepairstudio.model.utils.SQL_Queries;
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.SQLException;
import java.util.List;

import static com.example.finalrepairstudio.model.utils.Pages.MASTERORDERPAGE;
/**
 * Showing orders for master  command.
 *
 * @author Ostap Semotiuk
 */
public class MasterOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        HttpSession session = request.getSession(false);
        OrderDAO order = new OrderDAO();

        List list = null;
        try {
            list = order.queryMasterOrders(DBManager.getInstance().getConnection(),
                    request.getParameter("sort"),
                    SQL_Queries.SHOW_MASTER_ORDERS + "'" + session.getAttribute("lastname") + "'" +" "+ "ORDER BY " );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("list",list);

        return MASTERORDERPAGE;
    }
}
