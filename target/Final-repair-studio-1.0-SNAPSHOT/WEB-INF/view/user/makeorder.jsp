<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" var="lang"/>
<%@include file="/includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<html>
<head>

    <title><fmt:message key="order" bundle="${lang}"/></title>
</head>

<style>
    <%@include file="/css/OrderForm.css"%>
</style>

<body style="
background-color: #407bed;
text-align: center;
display: flex;

flex-direction: column;
justify-content: center;
font-family: sans-serif;
">
<div style="display: flex;justify-content: center; width: 100vw" >

<div style="
    background-color: white;
    width: fit-content;
    height: fit-content;
    border-radius: 10px;
    display: flex;
    align-items: center;
    margin-top: 200px ;
    flex-direction: column;
    -webkit-font-smoothing: antialiased;
    ">
    <span style="font-weight: 700; margin: 20px 0 15px 0 ;  font-size: 20px;"><fmt:message key="order" bundle="${lang}"/></span>
    <form class="order" action="controller?action=user-addToOrder" method="post" style="width: fit-content;height: fit-content;" accept-charset="UTF-8">

        <input class="custom-checkbox" type="checkbox" id="change-glass" name="change-glass">
        <label for="change-glass"><fmt:message key="option1" bundle="${lang}"/></label>

        <input class="custom-checkbox" type="checkbox" id="polish-glass" name="polish-glass">
        <label for="polish-glass"><fmt:message key="option2" bundle="${lang}"/></label>

        <br>
        <textarea name="descr" rows=10 cols=40 placeholder="<fmt:message key="describe.problem" bundle="${lang}"/>" required="required" style="
                margin:10px;
                border-radius: 5px;
                box-shadow: 2px 3px 2px -2px;
                text-align: center;

                "></textarea>
        <div>
            <button type="submit" style="
                    width: 150px;
                    height: 30px;
                    text-align: center;
                    margin-top:10px;
                    border-radius: 5px;
                    border:none;
                    background-color: #1c60e6;
                    color: azure;
                    box-shadow: 2px 3px 2px -2px;
                    "><fmt:message key="submit" bundle="${lang}"/></button>
        </div>
    </form>
</div>
</div>


</body>

</html>
