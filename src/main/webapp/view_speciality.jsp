<%--
  Created by IntelliJ IDEA.
  User: Fahim
  Date: 12/11/2014
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
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
<table>
  <s:iterator value="specialities">

    <tr>
      <td>Speciality   </td><td><s:property value="category_name"/></td>
    </tr>

    <tr>
      <td><a href=<s:property value="delete"/>>Delete</a></td>
    </tr>

  </s:iterator>
</table>
</body>
</html>
