<%@ page import="com.jonak.lib.*" %>
<% if ( SessionLib.isLogin() ) { Tools.redirect("dashboard"); } %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
    String  confirm = Tools.get("confirm"),
            currentPage = Tools.getCurrentPage();
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

    <% if( currentPage.equals("cancel-reset") && confirm != null && confirm.equals("true") ) { %>
    <p class="alert alert-success">Password reset request canceled!</p>

    <p class="forget-link text-center"><a href="login">Back to Login</a></p>
    <% } else if( currentPage.equals("confirm-reset") ) { %>
        <% if( confirm != null && confirm.equals("true") ) { %>
        <p class="alert alert-success">Your password has been reset successfully!</p>

        <p class="forget-link text-center"><a href="login">Back to Login</a></p>
        <% } else if( confirm != null && confirm.equals("false")) { %>
        <p class="alert alert-danger">Error reseting your password! please try again!</p>
        <% } else {%>
        <p class="alert alert-info">Something went WRONG!!!</p>
        <% } %>
    <% } else { %>
    <p class="alert alert-info">Something went WRONG!!!</p>
    <% } %>

</div> <!-- /container -->

<div class="text-center">&copy; Doctor's Community.</div>

<script type="text/javascript" src="../assets/vendor/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="../assets/vendor/jquery-ui/ui/jquery-ui.js">redmond</script>
<script type="text/javascript" src="../assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../assets/js/back/app.js"></script>
</body>
</html>