<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ page import="javax.mail.Session" %>
<%@ include file="./template/_header.jsp" %>
<%
	String update = Tools.get("update");
%>

<div class="row profile">
	<form class="form" role="form" method="post" action="processboard?type=1">
		<input type="hidden" name="id" value="<% out.print( Tools.toInt(Tools.get("id")) ); %>">
		<input type="hidden" name="user_id" value="<% out.print( SessionLib.getUserID() ); %>">
		<input type="hidden" name="type" value="1">
		<input type="hidden" name="parent_id" value="0">

		<%--board main--%>
		<div class="col-md-7">
			<div class="panel panel-default">
				<div class="panel-heading">
					Add New Board
				</div>

				<div class="panel-body">
					<div class="form-group">
						<label for="inputName">Title</label>
						<input type="text" class="form-control" id="inputName" placeholder="Title" name="title">
					</div>

					<div class="form-group">
						<label for="inputAddress" class="control-label sr-only">Description</label>
						<textarea class="form-control" id="inputAddress" placeholder="Description" rows="20"
								  name="description"></textarea>
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Save Changes</button>
					</div>
				</div>
			</div>
		</div>


		<%--left side--%>

		<div class="col-sm-4">

			<div class="panel panel-default">
				<div class="panel-heading">
					Associated Fields
				</div>

				<div class="panel-body">
					<div class="form-group">
						<label for="inputCategory" class="col-sm-2 control-label sr-only">Category</label>
						<select class="form-control" id="inputCategory" placeholder="Category"
								name="categoryId" >
							<s:iterator value="output">
								<option value=<s:property value="id"/>><s:property value="name"/></option>
							</s:iterator>
						</select>
					</div>
				</div>
			</div>
			<%--end category/fields--%>

			<div class="panel panel-default">
				<div class="panel-heading">
					Privacy
				</div>

				<div class="panel-body">
					<div class="form-group">
						<div class="col-sm-6">
							<label for="inputPrivate">
								<input type="radio" name="privacy" id="inputPrivate" value="1"> Private
							</label>
						</div>
						<div class="col-sm-6">
							<label for="inputPublic">
								<input type="radio" name="privacy" id="inputPublic" value="2"> Public
							</label>
						</div>
					</div>
				</div>
			</div>
			<%--end privacy--%>

			<div class="panel panel-default">
				<div class="panel-heading">
					Discussion option
				</div>

				<div class="panel-body">
					<div class="form-group">
						<div class="col-sm-6">
							<label>Allow Comments?</label>
						</div>
						<div class="col-sm-3">
							<label for="inputCommentYes">
								<input type="radio" name="allowComment" id="inputCommentYes" value="1"> Yes
							</label>
						</div>
						<div class="col-sm-3">
							<label for="inputCommentNo">
								<input type="radio" name="allowComment" id="inputCommentNo" value="0"> No
							</label>
						</div>
					</div>
				</div>
			</div>
			<%--end allow comments--%>

		</div>
		<%--right side--%>
	</form>
</div>

<%@include file="./template/_footer.jsp" %>