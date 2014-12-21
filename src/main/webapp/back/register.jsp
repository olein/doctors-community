<%@ page import="com.jonak.lib.*" %>
<% if (SessionLib.isLogin()) {
	Tools.redirect("dashboard");
} %>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String 	logout = Tools.get("logout"),
			invalid = Tools.get("invalid");
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

	<form class="form-signin" action="registerUser" method="post">
		<h2 class="form-signin-heading">Please Register Here</h2>
		<p>
			Email: <input type="text" name="email">
		</p>
		<p>
			Password: <input	type="password" name="password">
		</p>
		<p>
			First Name: <input	type="text" name="firstName">
		</p>
		<p>
			Last name: <input type="text" name="lastName">
		</p>
		<p>
			Address: <input 	type="text" name="address">
		</p>
		<p>
			District: <input	type="text" name="district">
		</p>
		<p>
			Date of birth: <br />
			Month<input	type="text" name="month">Day<input type="text" name="day">Year<input	type="text" name="year">
		</p>
		<p>
			Gender:
			<select name="gender">
				<option value="1">Male</option>
				<option value="2">Female</option>
			</select>
		</p>
		<p>
			Type:
			<select name="type">
				<option value="2">Doctor</option>
				<option value="3">Patient</option>
			</select>
		</p>
		<p>
			Can others message you?
			<select name="allow_message">
				<option value="1">Yes</option>
				<option value="2">No</option>
			</select>
		</p>
		<p>
			<input type="submit" value="Submit">
		</p>
	</form>

</div>
<!-- /container -->

<div class="text-center">&copy; Doctor's Community.</div>

<script type="text/javascript" src="../assets/vendor/jquery/dist/jquery.js"></script>
<script type="text/javascript" src="../assets/vendor/jquery-ui/ui/jquery-ui.js">redmond</script>
<script type="text/javascript" src="../assets/vendor/bootstrap/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="../assets/js/back/app.js"></script>
</body>
</html>