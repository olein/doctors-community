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
    <td>Title   </td><td><s:property value="title"/></td>
  </tr>
  <tr>
    <td>Description   </td><td><s:property value="description"/></td>
  </tr>


</s:iterator>
</table>
</body>
</html>
