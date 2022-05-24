<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 4/13/2022
  Time: 12:36 AM
  To change this template use File | Settings | File Templates.
--%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" var="lang"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title><fmt:message key="order" bundle="${lang}"/></title>
</head>
<body>
<form action="controller?action=admin-update&id=<%=request.getParameter("id")%>" method="post">
<section class="vh-100" style="background-color: dodgerblue;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <h3 class="mb-5"><fmt:message key="update" bundle="${lang}"/></h3>

                            <div class="form-outline mb-4">
                                <input type="number" name ="price"
                                       id="typePriceX-2"
                                       class="form-control form-control-lg"
                                       value="0"/>
                                <label class="form-label" for="typePriceX-2"><fmt:message key="price" bundle="${lang}"/></label>
                            </div>



                            <label for="status"><fmt:message key="status" bundle="${lang}"/></label>
                            <select name="status" id="status">
                                <option value="Waiting.to.pay"><fmt:message key="Waiting.to.pay" bundle="${lang}"/></option>
                                <option value="Paid"><fmt:message key="Paid" bundle="${lang}"/></option>
                                <option value="Deny"><fmt:message key="Deny" bundle="${lang}"/></option>
                            </select>

    <br>
                            <label  for="master"><fmt:message key="master" bundle="${lang}"/></label>
                            <select name="master" id="master" >
                                <option value="Roman-Prydyn">Roman Prydyn</option>
                                <option value="Danylo-Konyk">Danylo Konyk</option>
                                <option value="Yosyp-Radyy">Yosyp Radyy</option>
                            </select>

                            <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="update" bundle="${lang}"/></button>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</form>

</body>
</html>
