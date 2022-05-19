<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.OrderDAO" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.finalrepairstudio.model.entity.OrderRequest" %>
<%@include file="/includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title><fmt:message key="orders" bundle="${lang}"/></title>
</head>
<style>
    .content{
        text-align: center;
    }
</style>
<body>
<form action="" method="post" style="margin-top: 20px " >
    <%request.setAttribute("sort","id");%>

    <span style="margin: 0 10px"><fmt:message key="sort.by" bundle="${lang}"/></span>
    <select  name="sort" id="sort" style="margin: 0 5px">
        <option selected disabled><fmt:message key="choose.sort" bundle="${lang}"/></option>
        <option value="date"><fmt:message key="date" bundle="${lang}"/></option>
        <option value="status"><fmt:message key="status" bundle="${lang}"/></option>
        <option value="price"><fmt:message key="price" bundle="${lang}"/></option>
    </select>
    <span style="margin: 0 5px"><fmt:message key="filter.by" bundle="${lang}"/></span>
    <select  name="filterlist" id="filterlist" style="margin: 0 5px">
        <option selected disabled><fmt:message key="choose.master" bundle="${lang}"/> </option>
        <option value="'Prydyn'">Roman Prydyn</option>
        <option value="'Konyk'">Danylo Konyk</option>
        <option value="'Radyy'">Josyp Radyy</option>
        <option disabled><fmt:message key="choose.status" bundle="${lang}"/></option>
        <option value="'done'"><fmt:message key="Done" bundle="${lang}"/></option>
        <option value="'waiting'"><fmt:message key="Waiting.to.pay" bundle="${lang}"/></option>
        <option value="'paid'"><fmt:message key="Paid" bundle="${lang}"/></option>
        <option value="'in-work'"><fmt:message key="in.work" bundle="${lang}"/></option>
        <option value="'deny'"><fmt:message key="Deny" bundle="${lang}"/></option>
    </select>


    <input type="submit" value="<fmt:message key="submit" bundle="${lang}"/>"/>
</form>
<table class="table table-striped" style="border: solid 2px; margin-top: 10px">
    <thead>
    <tr>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="id" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="user.id" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="description" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="price" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="master" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="status" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"><fmt:message key="date" bundle="${lang}"/></th>
        <th class="content" style="border-bottom:solid 2px;font-weight:700;font-size:large" scope="col"></th>
    </tr>
    </thead>
    <tbody>
        <c:forEach var = "order" items="${list}">
            <tr>
            <td> <c:out value="${order.requestId}"/></td>
            <td> <c:out value="${order.user}"/></td>
            <td> <c:out value="${order.requestDescr} "/></td>
            <td> <c:out value="${order.price}"/> &#8372</td>
            <td> <c:out value="${order.master}"/></td>
            <td> <fmt:message key="${order.status}" bundle="${lang}"/> </td>
            <td> <c:out value="${order.requestDate}"/></td>
            <td>
                <c:if test="${order.status != 'Done' && order.status != 'Deny'&& order.status != 'Paid'}">
                    <a class="btn-primary" href="controller?action=admin-manage&id=${order.requestId}&price=${order.requestDescr}"><fmt:message key="edit" bundle="${lang}"/></a>
                </c:if>
            </td>
            </c:forEach>

    </tbody>
</table>


</body>
</html>
