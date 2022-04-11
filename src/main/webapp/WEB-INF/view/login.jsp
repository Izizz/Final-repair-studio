
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <title>Login</title>
</head>
<body>
<form action="controller?action=login" method="post" >

<section class="vh-100" style="background-color: dodgerblue;">
    <div class="container py-5 h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-12 col-md-8 col-lg-6 col-xl-5">
                <div class="card shadow-2-strong" style="border-radius: 1rem;">
                    <div class="card-body p-5 text-center">

                        <h3 class="mb-5">Sign in</h3>

                        <div class="form-outline mb-4">
                            <input type="email" name = "email" id="typeEmailX-2" class="form-control form-control-lg" />
                            <label class="form-label" for="typeEmailX-2">Email</label>
                        </div>

                        <div class="form-outline mb-4">
                            <input type="password" name = "password" id="typePasswordX-2" class="form-control form-control-lg" />
                            <label class="form-label" for="typePasswordX-2">Password</label>
                        </div>


                        <button class="btn btn-primary btn-lg btn-block" type="submit">Login</button>


                        <div>
                            <p class="mb-0">Don't have an account? <a href="controller?action=registerpage" class="text-black-50 fw-bold">Sign Up</a></p>
                        </div>





                    </div>
                </div>
            </div>
        </div>
    </div>
</section>



</form>
<%--<div align="center">--%>
<%--    <h1>User Login Form</h1>--%>
<%--    <form action="login" method="post">--%>
<%--        <table>--%>
<%--            <tr><td>Email</td>--%>
<%--                <td><input type = "text" name = "email"></td></tr>--%>
<%--            <tr><td>Password</td>--%>
<%--                <td><input type = "password" name = "password"></td></tr>--%>
<%--            <tr><td></td><td><input type = "submit" value = "login"></td></tr>--%>
<%--        </table>--%>
<%--    </form>--%>
<%--</div>--%>


</body>
</html>
