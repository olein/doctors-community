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
        Add New health-tips
      </div>
      <div class="panel-body">
        <form class="form-horizontal" role="form" method="post" action="processhealth-tips?type=6&allow_comment=0">
          <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Category</label>
            <select class="form-control" id="inputParent" placeholder="Category" name="categoryId">
              <option value=0>--select option--</option>
              <s:iterator value="output">
                <option value=<s:property value="id"/>><s:property value="name"/></option>
              </s:iterator>
            </select>
          </div>
          <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Title</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputName" placeholder="Title" name="title" >
            </div>
          </div>
          <div class="form-group">
            <label for="inputAddress" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-4">
              <textarea class="form-control" id="inputAddress" placeholder="Description" rows="3" name="description"></textarea>
            </div>
          </div>
          <div class="form-group">
            <label for="inputTelephone" class="col-sm-2 control-label">Privacy</label>
            <div class="col-sm-4">
              <select class="form-control" id="inputTelephone" placeholder="Privacy" name="privacy">
                <option value="1">Private</option>
                <option value="2">Public</option>
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