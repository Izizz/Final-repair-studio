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
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>AdminPage</title>
</head>
<body>
<% String userSession = (String)session.getAttribute("role");%>
<%@include file="/includes/header.jsp"%>



    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><a href="controller?action=home"><fmt:message key="home" bundle="${lang}"/></a></li>
                        <li class="breadcrumb-item active" aria-current="page"><fmt:message key="profile" bundle="${lang}"/></li>
                    </ol>
                </nav>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4">
                <div class="card mb-4">
                    <div class="card-body text-center">
                        <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-chat/ava3.webp" alt="avatar" class="rounded-circle img-fluid" style="width: 150px;">
                        <h5 class="my-3"><%=session.getAttribute("firstname")%></h5>

                        <div class="d-flex justify-content-center mb-2">
                            <button type="button" class="btn btn-info">
                                <a href="controller?action=admin-orders"><fmt:message key="orders" bundle="${lang}"/></a>
                            </button>

                            <button type="button" class="btn btn-info">
                                <a href="controller?action=admin-user-balance"><fmt:message key="users" bundle="${lang}"/></a>
                            </button>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-lg-8">
                <div class="card mb-4">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0"><fmt:message key="fullname" bundle="${lang}"/></p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%=session.getAttribute("firstname")%> <%=session.getAttribute("lastname")%></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0"><fmt:message key="email" bundle="${lang}"/></p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%=session.getAttribute("email")%></p>
                            </div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-sm-3">
                                <p class="mb-0"><fmt:message key="phone" bundle="${lang}"/></p>
                            </div>
                            <div class="col-sm-9">
                                <p class="text-muted mb-0"><%=session.getAttribute("phone")%></p>
                            </div>
                        </div>

                    </div>
                </div>
                <div class="row">


                </div>
            </div>
        </div>
    </div>

</body>
</html>
