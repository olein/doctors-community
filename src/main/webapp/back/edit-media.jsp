<%
    String  update = Tools.get("update");
%>
<%@ include file="./template/_header.jsp" %>

<s:iterator value="dataOut">

<div class="row profile">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h3 class="panel-title">Media File Options
                    <a href="media-library" class="btn btn-default pull-right"><span class="fa fa-reply"> Back</span></a>
                </h3>
            </div>
            <div class="panel-body">

                <% if( update != null && update.equals("true") ) { %>
                <p class="alert alert-success">Updated successfully!</p>
                <% } %>

                <div id="image-view" class="col-md-5 text-center">
                    <img src="<s:property value="link" />" class="img-responsive img-thumbnail" style="max-width: 550px; margin: auto;">
                </div>

                <form class="form-horizontal col-md-6" role="form" method="post" action="save-media">

                    <input type="hidden" name="id" value="<s:property value="id" />"/>
                    <!-- for simplicity assume that only image files are uplaoded -->

                    <h4>Edit Media File</h4>
                    <hr/>

                    <div class="form-group">
                        <label for="inputTitle" class="col-sm-2 control-label">Title</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputTitle"  name="title" value="<s:property value="title" />" >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFilename" class="col-sm-2 control-label">Filename</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputFilename" value="<s:property value="filename" />" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLink" class="col-sm-2 control-label">Link</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputLink" value="<s:property value="link" />" disabled >
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputMediaType" class="col-sm-2 control-label">Media Type</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control" id="inputMediaType" value="<s:property value="mediaType" />" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <button type="submit" class="btn btn-primary">Save Changes</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

</s:iterator>

<%@include file="./template/_footer.jsp" %>
