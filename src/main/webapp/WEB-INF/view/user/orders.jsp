<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %><%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/6/2022
  Time: 5:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<%@include file="/includes/header.jsp"%>
<form action="">

    <h2 align="center">

    </h2>
    <h1 align="center">List of orders</h1>
    <table border="1" align="center" cellpadding="5"
           style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
        <tr>
            <th>ID</th>
            <th>user_id</th>
            <th>description</th>
            <th>price</th>
            <th>master_id</th>
            <th>status</th>
            <th>date</th>

        </tr>
            <%


        Connection con = DBManager.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_Queries.SHOW_USERS_ORDERS + session.getAttribute("id"));

        while (resultSet.next()) {
      %>
        <tr>
            <td>
                <%
                    out.print(resultSet.getInt(1));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getInt(2));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(3));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getDouble(4));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getInt(5));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(6));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getDate(7));
                %>
            </td>

<%
    }
%>
</table>
</form>
</body>
</html>
