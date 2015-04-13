<%-- 
    Document   : accounts
    Created on : Jan 1, 2002, 9:11:43 AM
    Author     : Viram
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Manage Employees"/>
<%@include file="templates/header.jsp" %>

<fieldset>
    <legend>Manage Employees</legend>
    <div class="row">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Employee
                </div>
                <div class="panel-body">
                    <form method="post" id="form1" action="employees">
                        <table class="table">
                            <tr>
                                <td>Email</td>
                                <td>
                                    <input type="email" name="userEmail" value="${emp.userEmail}" required class="form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td>
                                    <input type="text" name="userPass" value="${emp.userPass}" required class="form-control"/>
                                </td>
                            </tr>
                            <tr>
                                <td>Deleted</td>
                                <td>
                                    <input ${emp.isDeleted ? "checked" : ""} type="checkbox" name="isDeleted" value="${emp.isDeleted ? "1" : "0"}"  />
                                </td>
                            </tr>
                            <tr>
                                <td>Activate</td>
                                <td>
                                    <input ${emp.isActivate ? "checked" : ""} type="checkbox" name="isActivate" value="${emp.isActivate ? "1" : "0"}"  />
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <c:if test="${not empty isFound}">
                                        <button name="cmd" value="Update">Update</button>
                                        <button name="cmd" value="Delete">Hard Delete</button>
                                        <button name="cmd" value="Update">Delete</button>
                                        <button name="cmd" value="Update">Cancel</button>
                                    </c:if>
                                    <c:if test="${empty isFound}">
                                        <button name="cmd" value="Add">Add</button>
                                    </c:if>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Employee User Accounts
                </div>
                <div class="panel-body">
                   
                    <table class="table">
                        <tr>
                            <th>Email</th>
                            <th>Deleted?</th>
                            <th>Activated?</th>
                            <th>Last Login</th>
                        </tr>
                        <c:forEach var="e" items="${employees}">
                            <tr>
                                <td>${e.userEmail}</td>
                                <td>${e.isDeleted ? "Yes" : "No"}</td>
                                <td>${e.isActivate ? "Yes" : "No"}</td>
                                <td>${e.lastLogin}</td>
                                <td>
                                    <form method="post" action="employees">
                                        <input type="hidden" name="userId" value="${e.userId}"/>
                                        <button name="cmd" value="Edit">Edit</button>
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</fieldset>

<%@include file="templates/footer.jsp" %>