<%--
  Created by IntelliJ IDEA.
  User: Fahim
  Date: 10/11/2014
  Time: 9:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title></title>
</head>
<body>

<s:form action="update_education_detail">
  <s:textfield name="degree" label="Degree"/>
  <s:textfield name="institute" label="Institute"/>
  <s:textfield name="result" label="Result"/>
  <s:submit/>
</s:form>

</body>
</html>
