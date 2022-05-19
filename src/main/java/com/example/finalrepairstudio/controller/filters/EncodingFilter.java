package com.example.finalrepairstudio.controller.filters;


import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import org.apache.log4j.Logger;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {
    private static final Logger log = Logger.getLogger(EncodingFilter.class);
    private String encoding = "UTF-8";

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws ServletException, IOException {
        log.debug("Encoding filter");
        req.setCharacterEncoding(encoding);
        chain.doFilter(req, resp);
    }
    @Override
    public void init(FilterConfig config) throws ServletException {
        String encodingParam = config.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }

    }

}


//



//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import java.io.IOException;
//import org.apache.log4j.Logger;
///**
// * Encoding filter implementation
// */
//@WebFilter(filterName = "EncodingFilter",urlPatterns = "/*")
//public class EncodingFilter implements Filter {
//    private static final Logger log  = Logger.getLogger(String.valueOf(EncodingFilter.class));
//    private String encoding = "UTF-8";
//
//    @Override
//    public void destroy(){
//        log.debug("Encoding filter destruction starts");
//        log.debug("Encoding filter destruction finished");
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//            throws IOException, ServletException {
//        log.debug("Encoding filter starts");
//       request.setCharacterEncoding(encoding);
//        log.debug("Encoding filter finished");
//        chain.doFilter(request, response);
//    }
//
//    @Override
//    public void init(FilterConfig config) throws ServletException{
//        log.debug("Encoding filter initialization starts");
//        String encodingParam = config.getInitParameter("encoding");
//        if(encodingParam != null){
//            encoding = encodingParam;
//        }
//        log.trace("Encoding from web.xml --> " + encodingParam);
//        log.debug("Encoding filter initialization finished");
//
//    }
//}
