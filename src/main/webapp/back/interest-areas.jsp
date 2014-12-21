<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.EducationController" %>
<%@ include file="./template/_header.jsp" %>
<%
	String update = Tools.get("update"),
			addnew = Tools.get("addnew");
%>

<div class="row chambers">
	<div class="col-md-12">
		<div class="panel panel-default">
			<div class="panel-heading clearfix">
				All Interests
				<a href="new-interest-area" class="btn btn-default pull-right">Add New</a>
			</div>
			<div class="panel-body">

				<% if (update != null && update.equals("true")) { %>
				<p class="alert alert-success">Education updated successfully!</p>
				<% } %>
				<% if (addnew != null && addnew.equals("true")) { %>
				<p class="alert alert-success">New Education added successfully!</p>
				<% } %>

				<table class="table">
					<thead>
					<tr>
						<th>Name</th>

						<th>Action</th>
					</tr>
					</thead>
					<tbod>
						<s:iterator value="specialities">
							<tr>
								<td><s:property value="categoryName"/></td>

								<td>
									<a href="delete-interest-area?id=<s:property value="id"/>" class="btn btn-default">Delete</a>

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