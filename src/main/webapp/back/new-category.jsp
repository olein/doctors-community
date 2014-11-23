<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
  String  update = Tools.get("update");
%>


<div class="row profile">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading">
        Add New Category
      </div>
      <div class="panel-body">

        <form class="form-horizontal" role="form" method="post" action="processcategory">
          <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Name</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputName" placeholder="Name" name="name" >
            </div>
          </div>
          <div class="form-group">
            <label for="inputDescription" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-4">
              <textarea class="form-control" id="inputDescription" placeholder="Description" rows="3" name="detail"></textarea>
            </div>
          </div>
          <div class="form-group">
            <label for="inputParent" class="col-sm-2 control-label">Parent Category</label>
            <div class="col-sm-4">
              <select class="form-control" id="inputParent" placeholder="Parent Category" name="parentId">
                <option value=0>--select option--</option>
                <s:iterator value="categoryList">
                  <option value=<s:property value="id"/>><s:property value="name"/></option>
                </s:iterator>
              </select>
            </div>
          </div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-4">
              <button type="submit" class="btn btn-primary">Save Changes</button>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>

<%@include file="./template/_footer.jsp" %>