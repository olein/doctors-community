<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
    String  update = Tools.get("update"),
            delete = Tools.get("delete"),
            error  = Tools.get("error");
%>

<!-- upload modal -->
<div class="modal fade" id="upload-file-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="upload" method="post" enctype="multipart/form-data">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">Upload a new file</h4>
                </div>
                <div class="modal-body">
                    <p>
                        <label>
                            Choose a file to upload:
                            <input type="file" name="uploadFile">
                        </label>
                    </p>
                    <p class="alert alert-info">
                        <em>File type allowed are: <b>.jpg</b>, <b>.png</b>, <b>.bmp</b>, <b>.zip</b>, <b>.pdf</b></em><br>
                        <em>Maximum file size can be: <b>5MB</b></em>
                    </p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Upload</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!-- upload modal -->

<div class="row profile">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h3 class="panel-title">Media Library
                    <button type="button" class="btn btn-primary pull-right" data-toggle="modal" data-target="#upload-file-modal"><span class="fa fa-plus"> Upload New</span></button>
                </h3>
            </div>
            <div class="panel-body">

                <% if( update != null && update.equals("true") ) { %>
                <p class="alert alert-success">Updated successfully!</p>
                <% } %>
                <% if( delete != null && delete.equals("true") ) { %>
                <p class="alert alert-success">File deleted successfully!</p>
                <% } %>
                <% if( error != null && error.equals("true") ) { %>
                <p class="alert alert-danger">Error! something went wrong!</p>
                <% } %>

                <!-- filter & pagination -->
                <%--<div class="clearfix">--%>
                    <%--<div class="pull-left">--%>
                        <%--<div class="form-group">--%>
                            <%--<input type="text" class="form-control" placeholder="Filter by title">--%>
                        <%--</div>--%>
                    <%--</div>--%>
                    <%--<div class="pull-right text-right">--%>
                        <%--<ul class="pagination">--%>
                            <%--<li class="disabled"><a href="#"><span aria-hidden="true">&laquo;</span><span class="sr-only">Previous</span></a></li>--%>
                            <%--<li class="active"><a href="#">1 <span class="sr-only">(current)</span></a></li>--%>
                            <%--<li class=""><a href="#">2 </a></li>--%>
                            <%--<li class=""><a href="#">3 </a></li>--%>
                            <%--<li class=""><a href="#">4 </a></li>--%>
                            <%--<li ><a href="#"><span aria-hidden="true">&raquo;</span><span class="sr-only">Next</span></a></li>--%>
                        <%--</ul>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <div class="table-responsive">
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr class="alert-warning">
                                <th width="80">Thumb</th>
                                <th>Title</th>
                                <th>Author</th>
                                <th>Date</th>
                                <th width="160" class="text-center">Action</th>
                            </tr>
                        </thead>
                        <tbody>
                        <s:iterator value="dataOut">
                            <tr>
                                <td><a href="edit-media?action=edit&mid=<s:property value="id" />" ><img src="<s:property value="link" />" width="50" /></a></td>
                                <td><a href="edit-media?action=edit&mid=<s:property value="id" />" ><s:property value="title" /></a></td>
                                <td><s:property value="@com.jonak.model.User@getDisplayName(userId)" /></td>
                                <td><s:date name="createdAt" format="yyyy-MM-dd" /></td>
                                <td>
                                    <a href="edit-media?action=edit&mid=<s:property value="id" />" class="btn btn-default btn-sm"><span class="fa fa-edit"> Edit</span></a>
                                    <a href="delete-media?mid=<s:property value="id" />" onclick="return confirm('Are you sure want to delete \'<s:property value="title" />\' ?')" class="btn btn-default btn-sm"><span class="fa fa-trash"> Delete</span></a>
                                </td>
                            </tr>
                        </s:iterator>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="./template/_footer.jsp" %>