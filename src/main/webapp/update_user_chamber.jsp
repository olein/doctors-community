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

<s:form action="update_chamber_detail">
  <s:textfield name="address" label="Address"/>
  <s:textfield name="telephone" label="Telephone"/>
  <s:textfield name="visiting_hour" label="Visiting hour"/>
  <s:textfield name="visiting_days" label="Visiting Days"/>
  <s:textfield name="fees" label="Fees"/>
  <s:submit/>
</s:form>

</body>
</html>
