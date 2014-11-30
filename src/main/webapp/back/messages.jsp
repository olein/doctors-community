<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>

<div class="row messages">
    <!--inbox start-->
    <div class="col-md-4">
        <ul class="list-group inbox">
        <s:if test="dataOut[0].size==0">
            <li class="list-group-item">No message yet!</li>
        </s:if>
        <s:iterator value="dataOut[0]">
            <li class="list-group-item">
                <a href="messages?action=view&fuid=<s:property value="fromUserId"/>">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <h5><s:property value="@com.jonak.model.User@getDisplayName(fromUserId)" /></h5>
                    <%--<h5><s:property value="fromUserId" />:<s:property value="@com.demo.bean.ContactsBean@getCount()" /></h5>--%>
                    <p><s:property value="msg" /></p>
                </a>
            </li>
        </s:iterator>
        </ul>
    </div>
    <!--inbox end-->

    <!--message start-->
    <div class="col-md-6 message-list">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <s:if test="dataOut[1].size > 0">
                <h3 class="panel-title pull-left">Messages From: <s:property value="@com.jonak.model.User@getDisplayName(dataOut[2])" /></h3>
                </s:if>
                <a href="messages?action=new" class="btn btn-default pull-right">New Message</a>
            </div>
            <div class="panel-body">
                <!-- message send form -->
                <form role="form" action="new-message" method="post">
                    <input type="hidden" name="to_user_id" value="<s:property value="dataOut[2]" />" />
                    <input type="hidden" name="from_user_id" value="<% out.print(SessionLib.getUserID()); %>" />
                    <div class="form-group">
                        <textarea class="form-control" rows="3" name="msg"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Send</button>
                </form>
            <%--</div>--%>
            <%--<div class="panel-body">--%>
                <!-- message list -->
                <table class="table no-border">
                    <s:iterator value="dataOut[1]">
                        <tr>
                            <td width="64px"><img src="http://placehold.it/64" alt="..." class="img-rounded"></td>
                            <td>
                                <h5><s:property value="@com.jonak.model.User@getDisplayName(fromUserId)" /></h5>
                                <p><s:property value="msg" /></p>
                            </td>
                        </tr>
                    </s:iterator>
                </table>
            </div>
        </div>
    </div>
    <!--message end-->
</div>

<%@include file="./template/_footer.jsp" %>