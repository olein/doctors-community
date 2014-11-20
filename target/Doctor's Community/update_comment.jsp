<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
  <title></title>
</head>
<body>
<h1>See the output in Console</h1>
<p></p>

<form action="update_comment_detail" method="post">
  Comment<input type="text" name="content"><br/>
  <input type="submit" value="Submit">
</form>

</body>
</html>

