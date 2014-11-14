
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Doctor's Community</title>
</head>
<body>
<form action="update_content_detail" method="post">
  Title: <input type="text" name="title"><br>
  Description: <input	type="text" name="description"><br />
  Privacy:<select name="privacy">
  <option value="1">Private</option>
  <option value="2">Public</option>
  </select><br />
  Can others comment on the discussion?<select name="allow_comment">
  <option value="1">Yes</option>
  <option value="2">No</option>
  </select><br />
  <input type="submit" value="Submit">
</form>

</body>
</html>