<%@ page import="java.sql.Connection" %>
<%@ page import="com.example.finalrepairstudio.model.DAO.DBManager" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.example.finalrepairstudio.model.utils.SQL_Queries" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--

  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/8/2022
  Time: 5:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title>Order</title>
</head>
<body>
<div class="container"
     style="display: flex;
     align-items: center;
     margin-top: 200px ;
     flex-direction: column;

     " >
    <h3>Order form:</h3>

    <form action="controller?action=user-addToOrder" method="post">

      <input type="checkbox" name="change-glass">Change Glass<br>
      <input type="checkbox" name="polish-glass">Polish Glass<br>

      <textarea name="descr" rows=10 cols=40  placeholder="Write about your problem"></textarea>
      <div style="text-align: center">
            <button type="submit">Submit</button>
      </div>

    </form>
</div>

</body>
</html>
