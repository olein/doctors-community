<%--
  Created by IntelliJ IDEA.
  User: Fahim
  Date: 12/11/2014
  Time: 6:06 PM
  To change this template use File | Settings | File Templates.
--%>
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
<form action="add_speciality_user" method="post">


  Select your specialities :
  <select name="speciality[]" multiple="multiple">

    <s:iterator value="dataOut">
      <option value=<s:property value="id"/>><s:property value="name"/></option>
    </s:iterator>
  </select>

  <input type="submit" value="Submit">

</form>

</body>
</html>
