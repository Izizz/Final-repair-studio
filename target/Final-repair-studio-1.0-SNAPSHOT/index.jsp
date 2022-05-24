<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="ex" uri="WEB-INF/tlds/mytags.tld"%>
<!DOCTYPE html>
<%@include file="/includes/header.jsp"%>
<html>
<style>
    body {
        background-image: url('images/unnamed.jpg');
        background-repeat: no-repeat;
        background-attachment: fixed;
        background-size: 100% 100%;
    }
</style>
<head>
    <title><ex:Hello/></title>
</head>
<body>
<%--<%@include file="/includes/header.jsp" %>--%>

<div class="container" style="text-align: center" >
<a href = "controller?action=user-makeorder" ><fmt:message key="make.order" bundle="${lang}"/></a>
</div>

</body>
</html>