<%-- 
    Document   : index
    Created on : Jan 1, 2002, 8:47:27 AM
    Author     : Viram
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Welcome Admin"/>
<%@include file="templates/header.jsp"%>
<div class="jumbotron">
    <h1>Welcome Admin</h1><h3>(${userEmail})</h3>
    <p><a href="../index.jsp">Logout</a></p><br/>
</div> 
<%@include file="templates/footer.jsp" %>
