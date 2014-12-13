<%@ page import="com.jonak.lib.*" %>
<% if ( ! SessionLib.isLogin() ) { Tools.redirect("login"); } %>
<% String currentPage = Tools.getCurrentPage();
String siteName = SessionLib.get("siteTitle"); %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>

	<!-- bootstrap -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/bootstrap/dist/css/bootstrap.css">

    <!-- jquery ui css -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/jquery-ui/themes/redmond/jquery-ui.css">
	<link rel="stylesheet" type="text/css" href="../assets/vendor/DataTables/media/css/jquery.dataTables.css">
    <link rel="stylesheet" type="text/css" href="../assets/css/dataTables.bootstrap.css">

	<!-- font awesome -->
	<link rel="stylesheet" type="text/css" href="../assets/vendor/fontawesome/css/font-awesome.css">

	<!-- custom -->
	<link rel="stylesheet" type="text/css" href="../assets/css/back/main.css">
</head>
<body>
<!-- top navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
			<span class="sr-only">Toggle navigation</span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#"><i class="fa fa-user-md"></i><% out.print(siteName); %></a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="all-article?type=5">Articles</a></li>
				<li><a href="published-boards?type=1">Publications</a></li>
				<li><a href="#">Doctors</a></li>
				<li><a href="/">Front Page</a></li>
			</ul>
			<%--<form class="navbar-form pull-left">--%>
				<%--<input type="text" class="form-control" placeholder="Search...">--%>
			<%--</form>--%>
		</div>
	</div>
</nav><!-- end top navbar -->

<!-- main wrap -->
<div class="container-fluid main-wrap">
  	<div class="row">

        <%@ include file="sidebar.jsp" %>

		<!-- main content area -->
	    <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">