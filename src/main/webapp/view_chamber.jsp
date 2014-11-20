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
      <td>Address   </td><td><s:property value="address"/></td>
    </tr>
    <tr>
      <td>Telephone   </td><td><s:property value="telephone"/></td>
    </tr>
    <tr>
      <td>Visiting Hour   </td><td><s:property value="visiting_hour"/></td>
    </tr>
    <tr>
      <td>Visiting Days   </td><td><s:property value="visiting_days"/></td>
    </tr>
    <tr>
      <td>Fees   </td><td><s:property value="fees"/></td>
    </tr>
    <tr>

    </tr>

  </s:iterator>
</table>
</body>
</html>
