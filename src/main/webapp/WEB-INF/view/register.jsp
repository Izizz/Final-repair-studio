<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 2/22/2022
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:requestEncoding value="UTF-8" />
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="messages" var="lang"/>

<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title><fmt:message key="sign.up" bundle="${lang}"/></title>
</head>
<body>
<div align="center">

    <form action="controller?action=register" method="post">


    <section class="vh-100" style="background-color: dodgerblue;">
        <div class="container py-5 h-100">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                    <div class="card shadow-2-strong" style="border-radius: 1rem;">
                        <div class="card-body p-5 text-center">

                            <h3 class="mb-5"><fmt:message key="sign.up" bundle="${lang}"/></h3>

                            <div class="form-outline mb-4">
                                <input type="text" name = "firstname" id="typeFirstnameX-2" class="form-control form-control-lg"
                                       required="required"
                                       pattern="^[a-zA-Z\u0430-\u044f\u0410-\u042f\u0456\u0457\u0406\u0407\s]+"
                                       title="First Name should contain cyrillic or latin letters" />
                                <label class="form-label" for="typeFirstnameX-2"><fmt:message key="firstname" bundle="${lang}"/></label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="text" name = "lastname" id="typeLastnameX-2" class="form-control form-control-lg" required="required"
                                       pattern="^[a-zA-Z\u0430-\u044f\u0410-\u042f\u0456\u0457\u0406\u0407\s]+"
                                       title="First Name should contain cyrillic or latin letters" />
                                <label class="form-label" for="typeLastnameX-2"><fmt:message key="lastname" bundle="${lang}"/></label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="email" name = "email" id="typeEmailX-2" class="form-control form-control-lg" required="required"
                                       pattern="^[_A-Za-z0-9-]+(\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\.[A-Za-z0-9]+)*(\.[A-Za-z]{2,})$"
                                       title="email should only contain email addres. e.g. ostap.semotiuk@gmail.com"/>
                                <label class="form-label" for="typeEmailX-2"><fmt:message key="email" bundle="${lang}"/></label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="text" name = "phone" id="typePhoneX-2" class="form-control form-control-lg" required="required"
                                       pattern="^[+0-9]{10,13}"
                                       title="Mobile number should be only like this +380955596551,0986087607, 380986087603" />
                                <label class="form-label" for="typePhoneX-2"><fmt:message key="phone" bundle="${lang}"/></label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" name = "password" id="typePasswordX-2" class="form-control form-control-lg" required="required"
                                       pattern="^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[\S])[A-Za-z0-9\S]{8,20}$"
                                       title="password should only contain at least 1 big letter, 1 numbers and at least 8 letters e.g. Danylo1v"/>
                                <label class="form-label" for="typePasswordX-2"><fmt:message key="password" bundle="${lang}"/></label>
                            </div>




                            <button class="btn btn-primary btn-lg btn-block" type="submit"><fmt:message key="sign.up" bundle="${lang}"/></button>

                            <div>
                                <p class="mb-0"><fmt:message key="have.account" bundle="${lang}"/><a href="controller?action=login" class="text-black-50 fw-bold"><fmt:message key="sing.in" bundle="${lang}"/></a></p>
                            </div>





                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    </form>
</div>


</body>
</html>
