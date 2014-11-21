<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
    String  update = Tools.get("update"),
            addnew = Tools.get("addnew");
%>

<div class="row chambers">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                All Chambers
                <a href="new-chamber" class="btn btn-default pull-right">Add New</a>
            </div>
            <div class="panel-body">

                <% if( update != null && update.equals("true") ) { %>
                <p class="alert alert-success">Chamber updated successfully!</p>
                <% } %>
                <% if( addnew != null && addnew.equals("true") ) { %>
                <p class="alert alert-success">New Chamber added successfully!</p>
                <% } %>

                <table class="table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Name</th>
                            <th>Address</th>
                            <th>Telephone</th>
                            <th>Fees</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbod>
                        <tr>
                            <td>1</td>
                            <td>The Madan Tech Chamber</td>
                            <td>Pabna, Chipagoli, Bangladesh</td>
                            <td>+321456987</td>
                            <td>-500=/</td>
                            <td>
                                <a href="edit-chamber?id=1" class="btn btn-default">Edit</a>
                                <a href="delete-chamber?id=1"class="btn btn-default">Delete</a>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>The New Madan Tech Chamber</td>
                            <td>Pabna, Chipagoli, Bangladesh</td>
                            <td>+3214569878</td>
                            <td>-200=/</td>
                            <td>
                                <a href="edit-chamber?id=2" class="btn btn-default">Edit</a>
                                <a href="delete-chamber?id=2"class="btn btn-default">Delete</a>
                            </td>
                        </tr>
                    </tbod>
                </table>

            </div>
        </div>
    </div>
</div>

<%@include file="./template/_footer.jsp" %>