package com.example.finalrepairstudio.controller.command.user;

import com.example.finalrepairstudio.controller.command.Command;
import com.example.finalrepairstudio.model.DAO.OrderDAO;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import static com.example.finalrepairstudio.model.utils.Pages.ORDERPAGE;
/**
 * Post feedback for user  command.
 *
 * @author Ostap Semotiuk
 */
public class FeedbackCommand implements Command {
    private static final Logger log  = Logger.getLogger(String.valueOf(FeedbackCommand.class));

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        int order_id = Integer.parseInt(request.getParameter("id"));

        String feedback = request.getParameter("feedback");
        OrderDAO orderDAO = new OrderDAO();
        try {
            log.debug("FeedbackCommand working start");
            orderDAO.leaveFeedback(order_id,feedback);
            log.debug("FeedbackCommand working finish");
        } catch (SQLException e) {
            e.printStackTrace();
            log.error("Feedback error");
        }

        return ORDERPAGE;
    }
}
