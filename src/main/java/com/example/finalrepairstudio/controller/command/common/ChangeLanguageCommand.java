package com.example.finalrepairstudio.controller.command.common;

import com.example.finalrepairstudio.controller.command.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class ChangeLanguageCommand implements Command {
    private static final String LOCALE = "locale";
    private static final String SESSION_LOCALE = "locale";

    private ArrayList<String> supportedLanguages = new ArrayList<>();
    private static final String ENGLISH = "en";
    private static final String UKRAINIAN = "uk";


    public ChangeLanguageCommand() {
        supportedLanguages.add(ENGLISH);
        supportedLanguages.add(UKRAINIAN);
    }

    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        String locale =  request.getParameter(LOCALE);
        HttpSession session = request.getSession(false);
        if(locale != null){
            if(!supportedLanguages.contains(locale)){
                locale = ENGLISH;

            }
            session.setAttribute(SESSION_LOCALE,locale);
        }

        String com = request.getHeader("Referer");

        return "redirect:" + com.replace("http://localhost:8080/RepairStudio/","");
    }
}
