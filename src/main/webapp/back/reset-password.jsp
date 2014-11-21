<%@ page import="com.jonak.lib.*" %>
<% if ( SessionLib.isLogin() ) { Tools.redirect("dashboard"); } %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String  confirm = Tools.get("confirm"),
            token = Tools.get("token"),
            email = Tools.get("email");
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

    <form class="form-signin" role="form" action="process-reset-password" method="post">
        <h2 class="form-signin-heading">Reset password</h2>

        <% if( confirm == null && token != null && ! token.isEmpty() && email != null && ! email.isEmpty() ) { %>
        <input type="hidden" name="token" value="<% out.print(token); %>">
        <input type="hidden" name="email" value="<% out.print(email); %>">
        <p>
            <label for="inputPassword" >Reset your password</label>
            <input type="password" id="inputPassword" class="form-control input-lg" placeholder="password" required autofocus name="password">
        </p>
        <p>
            <label for="inputConfPassword" >Confirm password</label>
            <input type="password" id="inputConfPassword" class="form-control input-lg" placeholder="confirm password" required name="confpassword">
        </p>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Reset Password</button>

        <p class="forget-link text-center"><a href="login">Back to Login</a></p>
        <% } else if( confirm != null && confirm.equals("false") ) { %>
        <p class="alert alert-danger">Invalid token!</p>
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