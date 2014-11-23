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
        Edit Education
      </div>
      <div class="panel-body">

        <% if( update != null && update.equals("true") ) { %>
        <p class="alert alert-success">Updated successfully!</p>
        <% } %>
        <% if( update != null && update.equals("false") ) { %>
        <p class="alert alert-danger">Error Updating!</p>
        <% } %>
        <s:iterator value="dateOut">
          <form class="form-horizontal" role="form" method="post" action="processeducation">

            <div class="form-group">
              <label for="inputName" class="col-sm-2 control-label">Degree</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="inputName" placeholder="Degree" name="degree" value="<s:property value="degree"/>">
              </div>
            </div>
            <div class="form-group">
              <label for="inputAddress" class="col-sm-2 control-label">Result</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="inputAddress" placeholder="Result" name="result" value="<s:property value="result"/>">
              </div>
            </div>
            <div class="form-group">
              <label for="inputTelephone" class="col-sm-2 control-label">Institute</label>
              <div class="col-sm-4">
                <input type="text" class="form-control" id="inputTelephone" placeholder="Institute" name="institute" value="<s:property value="institute"/>">
              </div>
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