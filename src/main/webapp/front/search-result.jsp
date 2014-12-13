<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>


<div class="row chambers">
  <div class="col-md-12">
    <div class="panel panel-default">
      <div class="panel-heading clearfix">
        Search Result
      </div>
      <div class="panel-body">

      <s:iterator value="dataOut">
        <div class="col-md-4">
          <div class="panel panel-default">
            <div class="panel-body">
              <h1><s:property value="email"/></h1>
              <b>First Name : </b><s:property value="firstName"/><br/>
              <b>Last Name : </b><s:property value="lastName"/><br/>
              <b>Address : </b><s:property value="address"/><br/>
              <b>District : </b><s:property value="district"/><br/>
              <a href="view-profile?id=<s:property value="id"/>" class="btn btn-default">View Profile</a>
            </div>
          </div>
        </div>
      </s:iterator>
      </div>
    </div>
  </div>
</div>

<%@include file="./template/_footer.jsp" %>