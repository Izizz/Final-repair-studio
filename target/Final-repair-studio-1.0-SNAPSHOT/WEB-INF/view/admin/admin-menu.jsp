<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 2/22/2022
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminPage</title>
</head>
<body>
<% String userSession = (String)session.getAttribute("role");%>
<%@include file="/includes/header.jsp"%>



<div align="center">
    <h1>Admin page</h1>
</div>
<a href = "controller?action=admin-masters">Masters</a>
<a href = "requests">Requests</a>
</body>
</html>
