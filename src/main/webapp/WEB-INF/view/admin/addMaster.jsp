<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add master</title>
</head>
<body >
<form action="masters" method="post">
    <h1 align="center">Add Doctor</h1>
    <h1>
        <a href="masters">List Masters</a>
    </h1>
    <table border="1" align="center" cellpadding="5"
           style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">
        <tr>
            <td>First Name</td>
            <td><input type="text" name="firstname"></td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastname"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>Phone</td>
            <td><input type="text" name="phone"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" name="Action" value="Add Master"></td>
        </tr>
    </table>
</form>
</body>
</html>