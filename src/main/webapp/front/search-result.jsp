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

        <table class="table table-hover">
          <thead>
          <tr>
            <th>Email</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Address</th>
            <th>District</th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="dataOut">
              <tr>
                <td><s:property value="email"/></td>
                <td><s:property value="firstName"/></td>
                <td><s:property value="lastName"/></td>
                <td><s:property value="address"/></td>
                <td><s:property value="district"/></td>
                <td>
                  <a href="view-profile?id=<s:property value="id"/>" class="btn btn-default">View Profile</a>
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