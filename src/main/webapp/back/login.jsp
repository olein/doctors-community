<%@ page import="com.jonak.lib.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>

    <!-- bootstrap -->
    <link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap/dist/css/bootstrap.css">

    <!-- font awesome -->
    <link rel="stylesheet" type="text/css" href="../assets/vendor/fontawesome/css/font-awesome.css">

    <!-- custom -->
    <link rel="stylesheet" type="text/css" href="../assets/css/back/main.css">
</head>
<body>

    <div class="container login-form">

        <form class="form-signin" role="form" action="loginprocess">
            <h2 class="form-signin-heading">Please Login Here</h2>
            <p>
                <label for="inputEmail" class="sr-only">Email address</label>
                <input type="email" id="inputEmail" class="form-control input-lg" placeholder="Email address" required autofocus name="email">
            </p>
            <p>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" class="form-control input-lg" placeholder="Password" required name="password">
            </p>
            <!-- div class="checkbox">
                <label>
                    <input type="checkbox" value="remember-me"> Remember me
                </label>
            </div -->
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        </form>

    </div> <!-- /container -->

    <script type="text/javascript" src="../assets/vendor/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="../assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="../assets/js/back/app.js"></script>
</body>
</html>