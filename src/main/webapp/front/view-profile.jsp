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
        <div class="panel panel-default col-xs-8">
          <div class="panel-heading">
            <h3 class="panel-title">Basic profile</h3>
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
              </tr>
            </s:iterator>
          </tbod>
        </table>
          </div>
          </div>


        <div class="panel panel-default col-xs-8">
          <div class="panel-heading">
            <h3 class="panel-title">Education</h3>
          </div>
          <div class="panel-body">
            <table class="table table-hover">
              <thead>
              <tr>
                <th>Degree</th>
                <th>Institute</th>
                <th>Result</th>
              </tr>
              </thead>
              <tbod>
                <s:iterator value="educations">
                  <tr>
                    <td><s:property value="degree"/></td>
                    <td><s:property value="institute"/></td>
                    <td><s:property value="result"/></td>
                  </tr>
                </s:iterator>
              </tbod>
            </table>
          </div>
        </div>

        <div class="panel panel-default col-xs-8">
          <div class="panel-heading">
            <h3 class="panel-title">Experience</h3>
          </div>
          <div class="panel-body">

        <table class="table table-hover">
          <thead>
          <tr>
            <th>Title</th>
            <th>Experience</th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="experiences">
              <tr>
                <td><s:property value="title"/></td>
                <td><s:property value="description"/></td>
              </tr>
            </s:iterator>
          </tbod>
        </table>
            </div>
          </div>

        <div class="panel panel-default col-xs-8">
          <div class="panel-heading">
            <h3 class="panel-title">Chamber</h3>
          </div>
          <div class="panel-body">
        <table class="table table-hover">
          <thead>
          <tr>
            <th>Name</th>
            <th>Address</th>
            <th>Telephone</th>
            <th>Fees</th>
            <th>Visiting Hours</th>
            <th>Visiting Days</th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="chambers">
              <tr>
                <td><s:property value="name"/></td>
                <td><s:property value="address"/></td>
                <td><s:property value="telephone"/></td>
                <td><s:property value="fees"/></td>
                <td><s:property value="visitingHour"/></td>
                <td><s:property value="visitingDays"/></td>
              </tr>
            </s:iterator>

          </tbod>
        </table>
            </div>
          </div>

        <div class="panel panel-default col-xs-8">
          <div class="panel-heading">
            <h3 class="panel-title">Speciality</h3>
          </div>
          <div class="panel-body">
        <table class="table table-hover">
          <thead>
          <tr>
            <th>Name</th>
          </tr>
          </thead>
          <tbod>
            <s:iterator value="specialities">
              <tr>
                <td><s:property value="categoryName"/></td>
              </tr>
            </s:iterator>
          </tbod>
        </table>
            </div>
          </div>

</div>
</div>
</div>
</div>

<%@include file="./template/_footer.jsp" %>