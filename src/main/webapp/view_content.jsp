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
      <td>Category Name   </td><td><s:property value="category_name"/></td>
    </tr>
    <tr>
      <td>Created date   </td><td><s:property value="date"/></td>
    </tr>
    <tr>
      <td>Title   </td><td><s:property value="title"/></td>
    </tr>
    <tr>
      <td>Description   </td><td><s:property value="description"/></td>
    </tr>
    <tr>
      <td><a href=<s:property value="update"/>>Update</a></td>
      <td><a href=<s:property value="delete"/>>Delete</a></td>
    </tr>
    <tr>
      <td><a href=<s:property value="add_participant"/>>Add participant</a></td>
      <td><a href=<s:property value="show_participant"/>>Show participant</a></td>
      <td><a href=<s:property value="comments"/>>Other Comments</a></td>
    </tr>
    <tr>
      <td>
      <form action=<s:property value="comment"/> method="post">
        Comment<input type="text" name="content"><br/>
        <input type="submit" value="Submit">
      </form>
      </td>
    </tr>

  </s:iterator>
</table>

</body>
</html>
