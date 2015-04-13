<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : accounts
    Created on : Jan 1, 2002, 9:11:43 AM
    Author     : Viram
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Admin Profile"/>
<%@include file="templates/header.jsp" %>
<br/>
<h1>Welcome ${userEmail}</h1><br/><br/>

<div class="row">
    <p class="btn btn-lg btn-default center-block w200" data-toggle="modal" data-target="#changePwd">Edit Profile</p>
    <%----------------------Modal Window ---------------------------%>
    <div class="modal fade" id="changePwd" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header bg-info">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button> 
                    <h4 class="modal-title text-info text-capitalize text-head" id="myModalLabel">Edit Profile</h4>
                </div>
                <div class="modal-body text-primary"> 
                    <form action="AdminProfile" method="post" class="form-inline">
                        <div class="input-group">
                            <span class="input-group-addon">Email</span>
                            <input type="email" id="userEmail" name="userEmail"  class="form-control" required value=${userEmail}>
                        </div><br/><br/>
                        <div class="input-group">
                            <span class="input-group-addon">Current Password</span>
                            <input type="password" id="pass" name="pass" class="form-control" required >
                        </div><br/><br/>
                        <div class="input-group">
                            <span class="input-group-addon">New Password</span>
                            <input type="password" id="userPass" name="userPass" class="form-control" required >
                            <span class="input-group-btn"> <button id="pwdShow" class="btn btn-default" type="button" onclick="show()"> Show </button> </span>
                        </div><br/><br/>
                        <div class="input-group">
                            <span class="input-group-addon">Re-Enter Password</span>
                            <input type="password" id="RePass" name="RePass" class="form-control" onkeyup="matchPwd()" required />
                            <span id="pwdErr"></span>
                        </div>
                    </form>
                </div>
                <div class="modal-footer bg-info"> 
                    <form method="post" action="AdminProfile">
                        <button type="button" class="btn btn-warning" data-dismiss="modal">Close</button> 
                        <input type="hidden" name="userId" value="${userId}"/>
                        <input type="submit" name="cmd" value="Save" class="btn btn-success"/>
                    </form> 
                </div>
            </div><!-- /.modal-content --> 
        </div><!-- /.modal -->
    </div>
    <%-----------------End Modal Window ---------------------------%>
</div><br/><br/>

<div class="center-block">
    <p class="btn btn-lg btn-success w200 center-block" data-toggle="modal" data-target="#changePwd">Create New Admin</p>
</div>

<form action="AdminProfile" method="post" class="form-inline">

</form>
<%@include file="templates/footer.jsp" %>