<%@ page import="com.jonak.lib.Configuration" %>
<%@ page import="com.jonak.lib.Tools" %>
<%
	String currentPage = Tools.getCurrentPage();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <title>Home</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/vendor/bootstrap/dist/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="assets/css/front/main.css" rel="stylesheet">

</head>

<body>

<nav class="navbar navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><% out.print(Configuration.get("siteTitle")); %></a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li class="<% if(currentPage.equals("home")){ out.print("active"); } %>"><a href="./home">Home <span class="sr-only">(current)</span></a></li>
            <li class="<% if(currentPage.equals("health-tips")){ out.print("active"); } %>"><a href="health-tips?type=6">Health Tips</a></li>
            <li><a href="./user/login">Login</a></li>
            <li><a href="#">Register</a></li>
        </ul>
    </div>
</nav>