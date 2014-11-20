<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>
<%
    String  update = Tools.get("update");
%>
<s:iterator value="dataOut">

<div class="row profile">
    <div class="col-md-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                Profile <s:property value="firstName" /> <s:property value="lastName" />
            </div>
            <div class="panel-body">

                <% if( update != null && update.equals("true") ) { %>
                <p class="alert alert-success">Updated successfully!</p>
                <% } %>

                <form class="form-horizontal" role="form" method="post" action="saveprofile">
                    <div class="form-group">
                        <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                        <div class="col-sm-4">
                            <input type="email" class="form-control" id="inputEmail3" placeholder="Email" name="email" value="<s:property value="email" />">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                        <div class="col-sm-4">
                            <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputFirstname" class="col-sm-2 control-label">Firstname</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="inputFirstname" placeholder="Firstname" name="firstName" value="<s:property value="firstName" />">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputLastname" class="col-sm-2 control-label">Lastname</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="inputLastname" placeholder="Lastname" name="lastName" value="<s:property value="lastName" />">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputAddress" class="col-sm-2 control-label">Address</label>
                        <div class="col-sm-4">
                            <textarea class="form-control" id="inputAddress" placeholder="Address" rows="3" name="address"><s:property value="address" /></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDistrict" class="col-sm-2 control-label">District</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="inputDistrict" placeholder="District" name="district" value="<s:property value="district" />">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputDateOfBirth" class="col-sm-2 control-label">Date of Birth</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" id="inputDateOfBirth" placeholder="ex: dd-mm-yyyy" name="dateOfBirth" value="<s:date name="dateOfBirth" format="dd-MM-yyyy" />">

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Gender</label>
                        <div class="col-sm-4">
                            <div class="radio">
                                <label>
                                    <input type="radio" name="gender" value="1" <s:if test="gender==1">checked</s:if> > Male
                                </label>
                            </div>
                            <div class="radio">
                                <label>
                                    <input type="radio" name="gender" value="2" <s:if test="gender==2">checked</s:if> > Female
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Allow Message</label>
                        <div class="col-sm-4">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" name="allowMessage" <s:if test="allowMessage==1">checked</s:if> value="allow" > Allow others to message me?
                                </label>
                            </div>
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

</s:iterator>
<%@include file="./template/_footer.jsp" %>