<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Masters</title>
</head>
<style>
    <!--
    a {
        text-decoration: none;
    }
    -->
</style>
<body >
<form action="">
    <h1 align="center">Master Management</h1>
    <h2 align="center">
        <a href="controller?action=admin-addmaster">Add New Master</a><br>
    </h2>
    <h1 align="center">List of Masters</h1>
    <table border="1" align="center" cellpadding="5"
           style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Phone</th>
        </tr>
            <%


        Connection con = DBManager.getConnection();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_Queries.SHOW_MASTERS);

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
                    out.print(resultSet.getString(2));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(3));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(4));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(5));
                %>
            </td>
            <td>
                <%
                    out.print(resultSet.getString(6));
                %>
            </td>
            <form action="controller?action=masters" method="post">
                <td><a value="Edit" name="Action"
                       href="controller?action=admin-editmaster">Edit</a> <input
                        type="hidden" name="j" value="<%= resultSet.getInt(1) %>">&nbsp;&nbsp;&nbsp;
                    <a href="controller?action=admin-deletemaster">Delete</a>&nbsp;&nbsp;&nbsp;</td>
        </tr>
            </form>
<%
    }
%>
</table>
</form>
</body>
</html>