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
<s:form action="create_profile">
  <s:textfield name="title" label="Title"/>
  <s:textarea name="description" label="Description"/>
  <s:submit/>
</s:form>

</body>
</html>