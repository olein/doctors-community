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
  <s:iterator value="dataOut">
    <tr>
      <td>Parent   </td><td><s:property value="parent_name"/></td>
    </tr>
    <tr>
      <td>Name   </td><td><s:property value="name"/></td>
    </tr>
    <tr>
      <td>Detail   </td><td><s:property value="detail"/></td>
    </tr>
    <tr>
      <td>Created at   </td><td><s:property value="date"/></td>
    </tr>

  </s:iterator>
</table>
</body>
</html>
