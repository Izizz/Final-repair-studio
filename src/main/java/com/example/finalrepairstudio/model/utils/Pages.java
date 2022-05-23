package com.example.finalrepairstudio.model.utils;

public class Pages {
    //admin section
    public final static String ADMINPAGE = "/WEB-INF/view/admin/admin-menu.jsp";
    public final static String MASTERLIST = "/WEB-INF/view/admin/masters.jsp";
    public final static String REQUESTLIST = "/WEB-INF/view/admin/orders.jsp";
    public final static String MANAGEORDER = "/WEB-INF/view/admin/edit-order.jsp";
    public final static String USERBALANCE = "/WEB-INF/view/admin/user-balance.jsp";
    //user section
    public final static String MAKEORDER = "/WEB-INF/view/user/makeorder.jsp";
    public final static String USERPAGE = "/WEB-INF/view/user/user-menu.jsp";
    public final static String ORDERPAGE = "/WEB-INF/view/user/orders.jsp";
    public final static String FEEDBACKPAGE = "/WEB-INF/view/user/feedback.jsp";
    //master section
    public final static   String MASTERPAGE = "/WEB-INF/view/master/master-menu.jsp";
    public final static String MASTERORDERPAGE = "/WEB-INF/view/master/orders.jsp";
    public final static String EDITORDER = "/WEB-INF/view/master/edit-order.jsp";
    //common
    public final static String HOMEPAGE ="index.jsp";
    public final static String loginPage = "/WEB-INF/view/login.jsp";
    public final static String REGISTERPAGE = "/WEB-INF/view/register.jsp";

    public static String getPath(String s){
        return s;
    }
}
