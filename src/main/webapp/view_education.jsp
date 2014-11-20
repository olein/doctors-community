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
  <s:iterator value="dateOut">

    <tr>
      <td>Degree   </td><td><s:property value="degree"/></td>
    </tr>
    <tr>
      <td>Institute   </td><td><s:property value="institute"/></td>
    </tr>
    <tr>
      <td>Result   </td><td><s:property value="result"/></td>
    </tr>


  </s:iterator>
</table>
</body>
</html>
