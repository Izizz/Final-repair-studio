<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" var="lang"/>

<html>
<head>
    <title><fmt:message key="repair.studio" bundle="${lang}"/></title>
</head>
<body>

<div class="header">
    <a href="controller?action=home" class="logo"><fmt:message key="repair.studio" bundle="${lang}"/> </a>
    <a href="controller?action=change-language&locale=uk">UKR</a>
    <a href="controller?action=change-language&locale=en">En</a>

    <div class="header-right">
        <% if (session.getAttribute("role") != null){%>

        <a class="active" href="controller?action=choice"><%
            if(session.getAttribute("firstname")!=null){

                String firstname = (String)session.getAttribute("firstname");
                out.print(firstname);
            }

        %>
        </a>
        <%}%>




        <%if(session.getAttribute("firstname") == null){%>

        <a class="active" href="controller?action=login"><fmt:message key="login" bundle="${lang}"/></a>
        <%}else{%>
        <a class="active" href="controller?action=logout"><fmt:message key="logout" bundle="${lang}"/></a>
        <%}%>

    </div>
</div>

<style type="text/css">
    .header {
        overflow: hidden;
        /*background-color: opacity;*/
        padding: 20px 10px;
        /*width: 100%;*/
        margin: -10px -10px 0 -10px;

    }

    /* Style the header links */
    .header a {
        float: left;
        color: black;
        text-align: center;
        padding: 12px;
        text-decoration: none;
        font-size: 18px;
        line-height: 25px;
        border-radius: 4px;
    }

    /* Style the logo link (notice that we set the same value of line-height and font-size to prevent the header to increase when the font gets bigger */
    .header a.logo {
        font-size: 25px;
        font-weight: bold;

    }

    /* Change the background color on mouse-over */
    .header a:hover {
        background-color: #ddd;
        color: black;
    }

    /* Style the active/current link*/
    .header a.active {
        background-color: mediumblue;
        color: white;
    }

    /* Float the link section to the right */
    .header-right {
        float: right;
    }

    /* Add media queries for responsiveness - when the screen is 500px wide or less, stack the links on top of each other */
    @media screen and (max-width: 500px) {
        .header a {
            float: none;
            display: block;
            text-align: left;
        }
        .header-right {
            float: none;
        }
    }
</style>
</body>

</html>