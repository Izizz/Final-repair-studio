<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/18/2022
  Time: 12:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="/includes/header.jsp"%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" var="lang"/>

<html>
<head>
    <title><fmt:message key="feedback" bundle="${lang}"/></title>
</head>
<body style="
background-color: #407bed;
text-align: center;
display: flex;
justify-content: center;
font-family: sans-serif;
" >


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
    <span style="font-weight: 700; margin: 20px 0 15px 0 ;  font-size: 20px;"><fmt:message key="feedback" bundle="${lang}"/></span>

    <form action="controller?action=user-feedback&id=<%=request.getParameter("id")%>" method="post" accept-charset="UTF-8">
        <br>
        <textarea name="feedback" rows=10 cols=40 placeholder="<fmt:message key="leave.feedback" bundle="${lang}"/>" style="
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
</body>
</html>
