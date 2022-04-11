package com.example.finalrepairstudio.controller.command;

import com.example.finalrepairstudio.controller.command.admin.*;
import com.example.finalrepairstudio.controller.command.common.*;
import com.example.finalrepairstudio.controller.command.master.MainMasterCommand;
import com.example.finalrepairstudio.controller.command.user.AddToOrderCommand;
import com.example.finalrepairstudio.controller.command.user.MainUserCommand;
import com.example.finalrepairstudio.controller.command.user.MakeOrderCommand;
import com.example.finalrepairstudio.controller.command.user.OrdersCommand;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static CommandFactory factory = new CommandFactory();
    private static Map<String,Command> commandMap = new HashMap<>();

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
        commandMap.put("admin-masters",new ShowMasterCommand());
        commandMap.put("admin-editmaster",new EditMasterCommand());
        commandMap.put("admin-deletemaster",new DeleteMasterCommand());
        commandMap.put("admin-addmaster",new AddMasterCommand());
        //master
        commandMap.put("master-",new MainMasterCommand());
        //user
        commandMap.put("user-addToOrder",new AddToOrderCommand());
        commandMap.put("user-",new MainUserCommand());
        commandMap.put("user-orders",new OrdersCommand());
        //common
        commandMap.put("user-makeorder",new MakeOrderCommand());
        commandMap.put("about",new AboutCommand());
        commandMap.put("login",new LoginCommand());
        commandMap.put("home",new HomeCommand());
        commandMap.put("registerpage",new RegisterPageCommand());
        commandMap.put("register",new RegisterCommand());
        commandMap.put("logout",new LogoutCommand());
        commandMap.put("choice",new ChooseRoleCommand());

    }
    public Command getCommand(HttpServletRequest request){
        String action =  request.getParameter("action");
        return commandMap.get(action);
    }

}
