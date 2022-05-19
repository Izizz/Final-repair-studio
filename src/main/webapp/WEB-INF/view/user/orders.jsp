<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.OrderDAO" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.finalrepairstudio.model.entity.OrderRequest" %>
<%@ page import="java.util.Objects" %>
<%@include file="/includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    <%@include file="/css/select.css"%>
</style>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title><fmt:message key="orders" bundle="${lang}"/></title>
</head>
<body>

<form action="" method="post">
    <% request.setAttribute("sort","id");%>

        <select name="sort" id="sort" >
            <option selected disabled><fmt:message key="choose.sort" bundle="${lang}"/></option>
            <option value = "date"><fmt:message key="date" bundle="${lang}"/></option>
            <option value="status"><fmt:message key="status" bundle="${lang}"/></option>
            <option value ="price"><fmt:message key="price" bundle="${lang}"/></option>
        </select>
        <input type="submit" value="<fmt:message key="submit" bundle="${lang}"/>"/>
    <h1 align="center"><fmt:message key="list.order" bundle="${lang}"/></h1>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="id" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="description" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="price" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="master" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="status" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="date" bundle="${lang}"/></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>

            <c:forEach var = "order" items="${list}">
            <tr>
               <td> <c:out value="${order.requestId}"/></td>
                <td> <c:out value="${order.requestDescr}"/></td>
                <td> <c:out value="${order.price}"/> &#8372</td>
                <td> <c:out value="${order.master}"/></td>
                <td> <fmt:message key="${order.status}" bundle="${lang}"/> </td>
                <td> <c:out value="${order.requestDate}"/></td>
                <td>
                    <c:if test="${order.status == 'Waiting.to.pay'}">
                        <a class="btn btn-primary mb-2" href="controller?action=user-pay&id=${order.requestId}&price=${order.price}"><fmt:message key="pay" bundle="${lang}"/></a>
                    </c:if>
                    <c:if test="${order.status == 'Done'}">
                        <a class = "btn btn-primary mb-2" href="controller?action=user-leave-feedback&id=${order.requestId}"><fmt:message key="feedback" bundle="${lang}"/></a>
                    </c:if>

                </td>
            </tr>
            </c:forEach>
        </tbody>
</table>
</form>
</body>
</html>
