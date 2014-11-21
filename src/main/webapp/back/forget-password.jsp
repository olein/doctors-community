<%@ page import="com.jonak.lib.*" %>
<% if ( SessionLib.isLogin() ) { Tools.redirect("dashboard"); } %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String  confirm = Tools.get("confirm");
%>
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

        <form class="form-signin" role="form" action="process-forget-password" method="post">
            <h2 class="form-signin-heading">Forget password?</h2>

            <% if( confirm != null && confirm.equals("true") ) { %>
            <p class="alert alert-success">Email Confirmed!</p>
            <p>An email with detail instructions has been sent to your address successfully! Follow the instructions to reset your password.</p>
            <p class="text-center">Thank You!</p>
            <p class="forget-link text-center"><a href="login">Back to Login</a></p>
            <% } else  { %>
                <% if( confirm != null && confirm.equals("false") ) { %>
                <p class="alert alert-danger">Invalid email!</p>
                <% } %>
            <p>
                <label for="inputEmail" >Enter your email address</label>
                <input type="email" id="inputEmail" class="form-control input-lg" placeholder="Email address" required autofocus name="email">
            </p>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit Email</button>

            <p class="forget-link text-center"><a href="login">Back to Login</a></p>
            <% } %>

        </form>

    </div> <!-- /container -->

    <div class="text-center">&copy; Doctor's Community.</div>

    <script type="text/javascript" src="../assets/vendor/jquery/dist/jquery.js"></script>
    <script type="text/javascript" src="../assets/vendor/jquery-ui/ui/jquery-ui.js">redmond</script>
    <script type="text/javascript" src="../assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="../assets/js/back/app.js"></script>
</body>
</html>