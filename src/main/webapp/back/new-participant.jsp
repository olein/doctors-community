<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
	String update = Tools.get("update");
%>


<div class="row profile">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				Add New Board
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" method="post" action="processparticipant">
					<div class="form-group">
						<label for="inputName" class="col-sm-2 control-label">User List</label>
						<select class="form-control" id="inputName" placeholder="User List" name="participants[]"
								multiple="multiple">
							<option value=0>--select option--</option>
							<s:iterator value="dataOut">
								<option value=<s:property value="id"/>><s:property value="firstName"/> <s:property
										value="lastName"/></option>
							</s:iterator>
						</select>
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