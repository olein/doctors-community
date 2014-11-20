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
  <s:iterator value="messages">

    <tr>
      <td>User name   </td><td><s:property value="name"/></td>
    </tr>
    <tr>
      <td>Created date   </td><td><s:property value="date"/></td>
    </tr>
    <tr>
      <td>Comment   </td><td><s:property value="content"/></td>
    </tr>
    <tr>
      <td><a href=<s:property value="update"/>>Update</a></td>
      <td><a href=<s:property value="delete"/>>Delete</a></td>
    </tr>



  </s:iterator>
  <tr>
    <td>
      <form action=<s:property value="add_comment"/> method="post">
        Comment<input type="text" name="content"><br/>
        <input type="submit" value="Submit">
      </form>
    </td>
  </tr>
</table>

</body>
</html>
