<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Form</title>
</head>
<body>

	<form action="registerUser" method="post">
		Email: <input type="text" name="email"><br> 
		Password: <input	type="password" name="password"><br /> 
		First Name: <input	type="text" name="firstName"><br> 
		Last name: <input
			type="text" name="lastName"><br> 
			Address: <input 	type="text" name="address"><br> 
			District: <input	type="text" name="district"><br> 
			Date of birth: <br />
			Month<input	type="text" name="month">Day<input type="text" name="day">Year<input	type="text" name="year"><br> 
			Gender:<select name="gender">
				<option value="male">Male</option>
				<option value="female">Female</option>
			</select><br /> 
			Type:<select name="type">
				<option value="Doctor">Doctor</option>
				<option value="Patient">Patient</option>
			</select><br /> 
			Can others message you?<select name="allow_message">
				<option value="Yes">Yes</option>
				<option value="No">No</option>
			</select><br /> <input type="submit" value="Submit">
		</form>

</body>
</html>