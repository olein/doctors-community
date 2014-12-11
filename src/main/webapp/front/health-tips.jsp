<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>

<div class="row chambers">
  <div class="col-md-12">
    <div class="panel panel-default">
    <div><p></p><p></p></div>

      <s:iterator value="dataOut">
        <div class="panel panel-default col-xs-4">
          <div class="panel-heading">
            <h3 class="panel-title"> <s:property value="title"/></h3>
          </div>
          <div class="panel-body">
            <s:property value="description"/>
          </div>
        </div>
      </s:iterator>

      </div>
    </div>
  </div>
</div>

<%@include file="./template/_footer.jsp" %>