<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
  String  update = Tools.get("update"),
          addnew = Tools.get("addnew");
%>

<div class="row chambers">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading clearfix">
        My Boards
        <a href="new-board" class="btn btn-default pull-right">Add New</a>
      </div>
      <div class="panel-body">

        <% if( update != null && update.equals("true") ) { %>
        <p class="alert alert-success">Chamber updated successfully!</p>
        <% } %>
        <% if( addnew != null && addnew.equals("true") ) { %>
        <p class="alert alert-success">New Chamber added successfully!</p>
        <% } %>

        <table class="table">
          <thead>
          <tr>
            <th>ID</th>
            <th>Category</th>
            <th>Title</th>
            <th>Description</th>
            <th>Creation Date</th>
            <th>Action</th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="dataOut">
              <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="category_name"/></td>
                <td><s:property value="title"/></td>
                <td><s:property value="description"/></td>
                <td><s:property value="date"/></td>
                <td>
                  <a href="participants?id=<s:property value="id"/>" class="btn btn-default">Participants</a>
                  <a href="edit-board?id=<s:property value="id"/>" class="btn btn-default">Edit</a>
                  <a href="delete-board?type=1&id=<s:property value="id"/>"class="btn btn-default">Delete</a>
                  <a href="board-detail?type=1&id=<s:property value="id"/>" class="btn btn-default">more</a>
                </td>
              </tr>
            </s:iterator>

          </tbod>
        </table>

      </div>
    </div>
  </div>
</div>

<%@include file="./template/_footer.jsp" %>