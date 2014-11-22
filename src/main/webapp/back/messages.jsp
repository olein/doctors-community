<%@ page import="java.util.Vector" %>
<%@ page import="com.jonak.model.User" %>
<%@ page import="com.jonak.controller.UserController" %>
<%@ include file="./template/_header.jsp" %>

<div class="row messages">
    <!--inbox start-->
    <div class="col-md-4">
        <ul class="list-group inbox">
            <li class="list-group-item">
                <a href="">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <h5>Name Here</h5>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
                </a>
            </li>
            <li class="list-group-item">
                <a href="">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <span class="label label-warning pull-right">New</span>
                    <h5>Name Here</h5>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
                </a>
            </li>
            <li class="list-group-item">
                <a href="">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <h5>Name Here</h5>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
                </a>
            </li>
            <li class="list-group-item">
                <a href="">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <h5>Name Here</h5>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
                </a>
            </li>
            <li class="list-group-item">
                <a href="">
                    <div class="pull-left">
                        <img src="http://placehold.it/64" alt="..." class="img-rounded">
                    </div>
                    <h5>Name Here</h5>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</p>
                </a>
            </li>
        </ul>
    </div>
    <!--inbox end-->

    <!--message start-->
    <div class="col-md-6 message-list">
        <div class="panel panel-default">
            <div class="panel-heading clearfix">
                <h3 class="panel-title pull-left">Messages From: lenin</h3>
                <a href="messages?action=new" class="btn btn-default pull-right">New Message</a>
            </div>
            <div class="panel-body">
                <!-- message send form -->
                <form role="form">
                    <div class="form-group">
                        <textarea class="form-control" rows="3"></textarea>
                    </div>
                    <button type="button" class="btn btn-primary">Send</button>
                </form>

                <!-- message list -->
                <table class="table no-border">
                    <tr>
                        <td><img src="http://placehold.it/64" alt="..." class="img-rounded"></td>
                        <td>
                            <h5>Name Here</h5>
                            <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.</p>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="http://placehold.it/64" alt="..." class="img-rounded"></td>
                        <td>
                            <h5>Name Here</h5>
                            <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.</p>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="http://placehold.it/64" alt="..." class="img-rounded"></td>
                        <td>
                            <h5>Name Here</h5>
                            <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.</p>
                        </td>
                    </tr>
                    <tr>
                        <td><img src="http://placehold.it/64" alt="..." class="img-rounded"></td>
                        <td>
                            <h5>Name Here</h5>
                            <p>Praesent dapibus, neque id cursus faucibus, tortor neque egestas augue, eu vulputate magna eros eu erat. Aliquam erat volutpat. Nam dui mi, tincidunt quis, accumsan porttitor, facilisis luctus, metus.</p>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    <!--message end-->
</div>

<%@include file="./template/_footer.jsp" %>