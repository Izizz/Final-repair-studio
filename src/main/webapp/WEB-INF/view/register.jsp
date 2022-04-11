<%--
  Created by IntelliJ IDEA.
  User: ostap
  Date: 2/22/2022
  Time: 9:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Registration</title>
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

                            <h3 class="mb-5">Sign up</h3>

                            <div class="form-outline mb-4">
                                <input type="text" name = "firstname" id="typeFirstnameX-2" class="form-control form-control-lg" />
                                <label class="form-label" for="typeFirstnameX-2">First Name</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="text" name = "lastname" id="typeLastnameX-2" class="form-control form-control-lg" />
                                <label class="form-label" for="typeLastnameX-2">Last Name</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="email" name = "email" id="typeEmailX-2" class="form-control form-control-lg" />
                                <label class="form-label" for="typeEmailX-2">Email</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="text" name = "phone" id="typePhoneX-2" class="form-control form-control-lg" />
                                <label class="form-label" for="typePhoneX-2">Phone number</label>
                            </div>

                            <div class="form-outline mb-4">
                                <input type="password" name = "password" id="typePasswordX-2" class="form-control form-control-lg" />
                                <label class="form-label" for="typePasswordX-2">Password</label>
                            </div>




                            <button class="btn btn-primary btn-lg btn-block" type="submit">Sign Up</button>

                            <div>
                                <p class="mb-0">Have an account? <a href="controller?action=login" class="text-black-50 fw-bold">Sign in</a></p>
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
