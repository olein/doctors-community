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
                            <th>Visiting Hours</th>
                            <th>Visiting Days</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbod>
                        <s:iterator value="dataOut">
                        <tr>
                            <td><s:property value="id"/></td>
                            <td><s:property value="name"/></td>
                            <td><s:property value="address"/></td>
                            <td><s:property value="telephone"/></td>
                            <td><s:property value="fees"/></td>
                            <td><s:property value="visitingHour"/></td>
                            <td><s:property value="visitingDays"/></td>
                            <td>
                                <a href="edit-chamber?id=<s:property value="id"/>" class="btn btn-default">Edit</a>
                                <a href="delete-chamber?id=<s:property value="id"/>"class="btn btn-default">Delete</a>
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