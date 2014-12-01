<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
  String  update = Tools.get("update"),
          addnew = Tools.get("addnew");
%>

<form class="navbar-form pull-left" method="post" action="searchByKeyWord?type=3">
  Search: <input type="text" class="form-control" name="searchWord" placeholder="Search...">
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
  </div>
</form>
  <form class="navbar-form pull-left" method="post" action="searchByCategory?type=3">
  <div class="form-group">
    <label for="inputCAtegory" class="col-sm-2 control-label">Search By Category</label><br/>
    <select class="form-control" id="inputCategory" placeholder="Category" name="categoryId">
      <option value=0>--select option--</option>
      <s:iterator value="output">
        <option value=<s:property value="id"/>><s:property value="name"/></option>
      </s:iterator>
    </select>
  </div>
    <div class="col-sm-offset-2 col-sm-4">
      <button type="submit" class="btn btn-primary">Submit</button>
    </div>
</form>


<div class="row chambers">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading clearfix">
        All discussion
        <a href="new-discussion" class="btn btn-default pull-right">Add New</a>
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
            <th>Title</th>
            <th>Description</th>
            <th>Creation Date</th>
            <th></th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="dataOut">
              <tr>
                <td><s:property value="id"/></td>
                <td><s:property value="title"/></td>
                <td><s:property value="description"/></td>
                <td><s:property value="date"/></td>
                <td>
                  <a href="discussion-detail?type=3&id=<s:property value="id"/>" class="btn btn-default">more</a>
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