<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.EducationController" %>
<%@ include file="./template/_header.jsp" %>
<%
	String 	update = Tools.get("update"),
			addnew = Tools.get("addnew"),
			delete = Tools.get("delete");
%>

<%--<s:iterator value="dataOut">--%>
<div class="row chambers">
	<div class="col-md-5">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Add Medical Fields</h3>
			</div>
			<div class="panel-body">
				<form class="form" role="form" method="post" action="save-medical-field">
					<div class="form-group">
						<label for="inputParent" class="control-label">Field Name</label>
						<input type="text" name="name" class="form-control">
					</div>
					<div class="form-group">
						<label for="inputParent" class="control-label">Parent Category</label>
						<select class="form-control" id="inputParent" placeholder="Interest" name="parentId">
							<option value="0">- Select Parent -</option>
							<s:iterator value="dataOut">
								<option value=<s:property value="id"/>><s:property value="name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="form-group">
						<label for="inputParent" class="control-label">Detail</label>
						<textarea name="detail" class="form-control" rows="3"></textarea>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%--add medical fields--%>

	<div class="col-md-7">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				<h3 class="panel-title">Medical Fields</h3>
			</div>
			<div class="panel-body">

				<% if (update != null && update.equals("true")) { %>
				<p class="alert alert-success">Education updated successfully!</p>
				<% } %>
				<% if (addnew != null && addnew.equals("true")) { %>
				<p class="alert alert-success">New Education added successfully!</p>
				<% } %>
				<% if (delete != null && delete.equals("true")) { %>
				<p class="alert alert-danger">Education updated successfully!</p>
				<% } %>

				<table class="table table-striped">
					<thead>
					<tr class="bg-warning">
						<th>Name</th>
						<th>Parent</th>
						<th width="80">Action</th>
					</tr>
					</thead>
					<tbod>
						<s:iterator value="dataOut">
							<tr>
								<td><s:property value="name"/></td>
								<td><s:property value="@com.jonak.model.Category@getNameById(parentId)"/></td>
								<td>
									<%--<a href="edit-medical-field?id=<s:property value="id"/>" class="btn btn-default btn-xs">Edit</a>--%>
									<a href="delete-medical-field?id=<s:property value="id"/>" class="btn btn-default btn-xs">Delete</a>
								</td>
							</tr>
						</s:iterator>
					</tbod>
				</table>

			</div>
		</div>
	</div>
	<%-- all medical fields--%>
</div>
<%--</s:iterator>--%>
<%@include file="./template/_footer.jsp" %>