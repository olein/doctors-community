<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>

<div class="row ">
	<div class="container helthtips">
		<s:iterator value="dataOut">
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><s:property value="title"/></h3>
					</div>
					<div class="panel-body">
						<s:property value="description"/>
					</div>
				</div>
			</div>
		</s:iterator>
	</div>
</div>

<%@include file="./template/_footer.jsp" %>