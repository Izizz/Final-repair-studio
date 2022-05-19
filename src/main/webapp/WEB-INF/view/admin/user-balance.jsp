<%@ page import="java.util.List" %>
<%@ page import="static com.example.finalrepairstudio.model.utils.SQL_Queries.GET_BALANCE_LIST" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.UserDAO" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.example.finalrepairstudio.model.entity.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/15/2022
  Time: 11:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@include file="/includes/header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title><fmt:message key="users" bundle="${lang}"/></title>
</head>
<body>
<div class="container">
    <table id="pages" border="1" cellpadding="5" cellspacing="5">
        <tr>
            <td>
                <c:if test="${currentPage != 1}">
                    <a href="controller?action=admin-user-balance&page=${currentPage - 1}"><fmt:message key="previous" bundle="${lang}"/></a>
                </c:if>
            </td>
            <c:forEach begin="1" end="${noOfPages}" var="i">
                <c:choose>
                    <c:when test="${currentPage eq i}">
                        <td>${i}</td>
                    </c:when>
                    <c:otherwise>
                        <td><a href="controller?action=admin-user-balance&page=${i}">${i}</a></td>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
            <td>
                <c:if test="${currentPage lt noOfPages}">
                    <a href="controller?action=admin-user-balance&page=${currentPage + 1}"><fmt:message key="next" bundle="${lang}"/></a>
                </c:if>
            </td>
        </tr>
    </table>
</div>
<br>


    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="user.id" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="firstname" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="lastname" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="balance" bundle="${lang}"/></th>
            <th scope="col"><fmt:message key="top.up" bundle="${lang}"/></th>
        </tr>
        </thead>
        <tbody>

            <c:forEach items="${list}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.firstname}"/></td>
                    <td><c:out value="${user.lastname}"/></td>
                    <td><c:out value="${user.balance}"/> &#8372</td>
                    <td>
                        <form
                                action="controller?action=admin-add-balance&id=${user.id}"
                                method="post">
                           <input type="number"
                                  name ="balanceToAdd"
                                  id="balanceToAdd"
                                  placeholder="Input balance to add"
                                  value="0"
                           />
                            <button type="submit"><fmt:message key="submit" bundle="${lang}"/></button>
                        </form>
                    </td>
                </tr>
            </c:forEach>


        </tbody>
    </table>

</body>
</html>
