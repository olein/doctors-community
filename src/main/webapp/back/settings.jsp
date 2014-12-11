<%@ include file="./template/_header.jsp" %>
<%
    String  update = Tools.get("update");
%>

<div class="row profile">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h3 class="panel-title">Site Options</h3>
            </div>
            <div class="panel-body">

                <% if( update != null && update.equals("true") ) { %>
                <p class="alert alert-success">Updated successfully!</p>
                <% } %>

                <form class="form-horizontal" role="form" method="post" action="save-settings">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Site Name</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" placeholder="site name" name="siteTitle" value="<% out.print(Configuration.get("siteTitle")); %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Site URL</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" placeholder="site url" name="siteURL" value="<% out.print(Configuration.get("siteURL")); %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Admin Email</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" placeholder="admin email" name="adminEmail" value="<% out.print(Configuration.get("adminEmail")); %>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Upload Directory Name</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" placeholder="upload directory name" name="uploadDir" value="<% out.print(Configuration.get("uploadDir")); %>">
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