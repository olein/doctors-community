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
        Article detail
        <a href="new-article" class="btn btn-default pull-right">Add New</a>
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
          </tr>
          </thead>
          <tbod>
            <s:iterator value="dataOut">
              <tr>
                <td><s:property value="category_name"/></td>
                <td><s:property value="title"/></td>
                <td><s:property value="description"/></td>
                <td><s:property value="date"/></td>
              </tr>
            </s:iterator>
          </tbod>
        </table>
        All Comments
        <table class="table">
          <thead>
          <tr>
            <th>Name</th>
            <th>Comment</th>
            <th>Creation Date</th>
            <th></th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="comment">
              <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="content"/></td>
                <td><s:property value="date"/></td>
                <td><a href="delete-comment?type=5&id=<s:property value="id"/>" class="btn btn-default">Delete</a></td>
              </tr>
            </s:iterator>
          </tbod>
        </table>

        <s:iterator value="dataOut">
          <form class="form-horizontal" role="form" method="post" action="add-comment?type=5&id=<s:property value="id"/>">
          <label for="inputName" class="col-sm-2 control-label">Comment</label>
          <div class="col-sm-4">
            <input type="text" class="form-control" id="inputName" placeholder="Comment" name="content" >
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
              <button type="submit" class="btn btn-primary">Save Changes</button>
            </div>
          </div>
          </form>
        </s:iterator>

      </div>
    </div>
  </div>
</div>

<%@include file="./template/_footer.jsp" %>