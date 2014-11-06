<%--
  Created by IntelliJ IDEA.
  User: lenin
  Date: 11/5/14
  Time: 5:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
    <title></title>
</head>
<body>
    <h1>See the output in Console</h1>
    <p>Olein, MUST call me before doing anything</p>

    <s:iterator value="messages">
        <tr>
            <td><s:property value="firstName"/></td>
            <td><s:property value="lastName"/></td>
        </tr>
    </s:iterator>

</body>
</html>
