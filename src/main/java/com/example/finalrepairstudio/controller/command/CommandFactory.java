package com.example.finalrepairstudio.controller.command;

import com.example.finalrepairstudio.controller.command.admin.*;
import com.example.finalrepairstudio.controller.command.common.*;
import com.example.finalrepairstudio.controller.command.master.MainMasterCommand;
import com.example.finalrepairstudio.controller.command.master.MasterManageOrderCommand;
import com.example.finalrepairstudio.controller.command.master.MasterOrderCommand;
import com.example.finalrepairstudio.controller.command.user.*;
import com.google.protobuf.RpcUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Main Command factory for Controller.
 *
 * @author Ostap Semotiuk
 */
public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    public static Map<String,Command> commandMap = new HashMap<>();

    private  CommandFactory(){}

    public static CommandFactory commandFactory() {
        if (factory == null) {
            factory = new CommandFactory();
        }
        return factory;
    }

    static {
        //admin
        commandMap.put("admin-",new MainAdminCommand());
        commandMap.put("admin-orders",new ShowOrderCommand());
        commandMap.put("admin-manage",new ManageOrderCommand());
        commandMap.put("admin-update",new UpdateOrderCommand());
        commandMap.put("admin-user-balance",new UserBalanceCommand());
        commandMap.put("admin-add-balance",new AddBalanceCommand());
        //master
        commandMap.put("master-",new MainMasterCommand());
        commandMap.put("master-orders",new MasterOrderCommand());
        commandMap.put("master-manage",new MasterManageOrderCommand());
        //user
        commandMap.put("user-",new MainUserCommand());
        commandMap.put("user-addToOrder",new AddToOrderCommand());
        commandMap.put("user-orders",new OrdersCommand());
        commandMap.put("user-pay",new PaymentCommand());
        commandMap.put("user-makeorder",new MakeOrderCommand());
        commandMap.put("user-topup",new TopUpCommand());
        commandMap.put("user-leave-feedback",new FeedbackFormCommand());
        commandMap.put("user-feedback",new FeedbackCommand());
        //common
        commandMap.put("change-language",new ChangeLanguageCommand());
        commandMap.put("login",new LoginCommand());
        commandMap.put("home",new HomeCommand());
        commandMap.put("registerpage",new RegisterPageCommand());
        commandMap.put("register",new RegisterCommand());
        commandMap.put("logout",new LogoutCommand());
        commandMap.put("choice",new ChooseRoleCommand());
        commandMap.put("error",new ErrorCommand());


    }

    public Command getCommand(HttpServletRequest request)  {
        String action =  request.getParameter("action");
//        if(action == null || !commandMap.containsKey(action)){
//            return new ErrorCommand();
//        }
        return commandMap.get(action);
    }

}
