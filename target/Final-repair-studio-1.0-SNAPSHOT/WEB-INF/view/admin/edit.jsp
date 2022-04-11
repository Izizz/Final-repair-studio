<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<form action="controller?action=masters" method="post">
    <h1 align="center">Edit Master</h1>
    <h1>
        <a href="controller?action=admin-showmasters">List Masters</a>
    </h1>
    <table border="1" align="center" cellpadding="5"
           style="font-size: 200%; font-family: inherit; font-style: normal; background-color: window;">

        <tr>
            <td>Enter Master First Name</td>
            <td><input type="text" name="firstname" ></td>
        </tr>
        <tr>
            <td>Enter Master Last Name</td>
            <td><input type="text" name="lastname" ></td>
        </tr>
        <tr>
            <td>Enter Master Email</td>
            <td><input type="text" name="email" ></td>
        </tr>
        <tr>
            <td>Enter Master Phone</td>
            <td><input type="text" name="phone" ></td>
        </tr>
        <tr>
            <td>Enter Master Password</td>
            <td><input type="text" name="password" ></td>
        </tr>
        <tr>
            <td></td>
            <td align="center"><input type="submit" name="Action"
                                      value="Edit"></td>
        </tr>
    </table>
</form>
</body>
</html>