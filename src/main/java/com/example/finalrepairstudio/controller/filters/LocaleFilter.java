package com.example.finalrepairstudio.controller.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Locale filter implementation
 */

@WebFilter(filterName = "LocaleFilter ", urlPatterns = "/*")
public class LocaleFilter implements Filter {
   // private static final Logger log  = Logger.getLogger(String.valueOf(LocaleFilter.class));

    @Override
    public void destroy(){
       // log.debug("Locale filter destruction starts");
       // log.debug("Locale filter destruction finished");
    }

    @Override
    public void init(FilterConfig config){
       // log.debug("Locale filter initialization starts");
       // log.debug("Locale filter initialization finished");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
       // log.debug("Locale filter starts");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();

        String locale = request.getParameter("locale");
        String defaultLocale = "en";

        if(locale != null){
            session.setAttribute("lang", locale);
        }
        else if (session.getAttribute("lang")==null){
            session.setAttribute("lang",defaultLocale);
        }
       // log.debug("Locale filter finished");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
