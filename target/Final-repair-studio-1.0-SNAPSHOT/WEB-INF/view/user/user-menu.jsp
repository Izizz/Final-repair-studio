<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="com.mysql.cj.protocol.Resultset" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 2/22/2022
  Time: 11:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User home</title>
</head>
<body>
<%@include file="/includes/header.jsp"%>
<% String userSession = (String)session.getAttribute("role");%><%--<div class="header">--%>



<div align="center">
    <h1>User page</h1>
</div>
<a href="controller?action=user-makeorder">Make Order</a>
<a href="controller?action=user-orders">My orders</a>
    <div>
        <br>First name:
        <% String firstname = (String) session.getAttribute("firstname");
            out.print(firstname);
        %>
    </div>

    <div>
        Last name:
        <% String lastname = (String) session.getAttribute("lastname");
            out.print(lastname);
        %>
    </div>

    <div>
        Email:
        <% String email = (String) session.getAttribute("email");
            out.print(email);
        %>
    </div>

    <div>Phone:
        <% String phone = (String) session.getAttribute("phone");
            out.print(phone);
        %>
    </div>

</body>
</html>
