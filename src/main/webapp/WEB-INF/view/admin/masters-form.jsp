<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/3/2022
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Masters</title>
</head>
<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark"
         style="background-color: dodgerblue">
        <div>
            <a href="controller?action=home" class="navbar-brand"> Repair Studio </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list"
                   class="nav-link">Masters</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${master != null}">
            <form action="controller?action=admin-editmaster" method="post">
                </c:if>
                <c:if test="${master == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${master != null}">
                                Edit Master
                            </c:if>
                            <c:if test="${master == null}">
                                Add New Master
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${user != null}">
                        <input type="hidden" name="master_id" value="<c:out value='${master.id}' />" />
                    </c:if>

                    <fieldset class="form-group">
                        <label>First Name</label> <input type="text"
                                                        value="<c:out value='${master.firstname}' />" class="form-control"
                                                        name="firstname" required="required">
                    </fieldset>
                    <fieldset class="form-group">
                        <label>Last Name</label> <input type="text"
                                                         value="<c:out value='${master.lastname}' />" class="form-control"
                                                         name="lastname" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Email</label> <input type="text"
                                                         value="<c:out value='${master.email}' />" class="form-control"
                                                         name="email">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Phone</label> <input type="text"
                                                    value="<c:out value='${master.phone}' />" class="form-control"
                                                    name="phone">
                    </fieldset>

                    <fieldset class="form-group">
                            <label>Status</label> <input type="text"
                                                        value="<c:out value='${master.status}' />" class="form-control"
                                                        name="status">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>
</html>
