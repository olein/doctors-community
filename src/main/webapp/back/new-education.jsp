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
        Add New Education
      </div>
      <div class="panel-body">

        <form class="form-horizontal" role="form" method="post" action="processeducation">
          <div class="form-group">
            <label for="inputName" class="col-sm-2 control-label">Degree</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputName" placeholder="Degree" name="degree" >
            </div>
          </div>
          <div class="form-group">
            <label for="inputResult" class="col-sm-2 control-label">Result</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputResult" placeholder="Result" name="result" >
            </div>
          </div>
          <div class="form-group">
            <label for="inputTelephone" class="col-sm-2 control-label">Institute</label>
            <div class="col-sm-4">
              <input type="text" class="form-control" id="inputTelephone" placeholder="Institute" name="institute" >
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