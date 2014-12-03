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
        All My health-tips
        <a href="new-health-tips" class="btn btn-default pull-right">Add New</a>
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
                <td><s:property value="category_name"/></td>
                <td><s:property value="title"/></td>
                <td><s:property value="description"/></td>
                <td><s:property value="date"/></td>
                <td>
                  <a href="edit-health-tips?id=<s:property value="id"/>" class="btn btn-default">Edit</a>
                  <a href="delete-health-tips?type=6&id=<s:property value="id"/>"class="btn btn-default">Delete</a>
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