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
				Add New patient-question
			</div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" method="post" action="processpatient-question">

					<input type="hidden" name="id" value="<% out.print( Tools.toInt(Tools.get("id")) ); %>">
					<input type="hidden" name="user_id" value="<% out.print( SessionLib.getUserID() ); %>">
					<input type="hidden" name="type" value="4">
					<input type="hidden" name="parent_id" value="0">
					<input type="hidden" name="allowComment" value="1">

					<div class="form-group">
						<input type="hidden" class="form-control" id="inputCategory" placeholder="Title"
							   name="categoryId" value="0"><br/>
						<label for="inputName" class="col-sm-2 control-label">Title</label>

						<div class="col-sm-4">
							<input type="text" class="form-control" id="inputName" placeholder="Title" name="title">
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress" class="col-sm-2 control-label">Description</label>

						<div class="col-sm-4">
							<textarea class="form-control" id="inputAddress" placeholder="Description" rows="3"
									  name="description"></textarea>
						</div>
					</div>
					<div class="form-group">
						<label for="inputTelephone" class="col-sm-2 control-label">Privacy</label>

						<div class="col-sm-4">
							<select class="form-control" id="inputTelephone" placeholder="Privacy" name="privacy">
								<option value="1">Private</option>
								<option value="2">Public</option>
							</select>
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