<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Welcome Employee"/>
<%@include file="templates/header.jsp" %>
<h1 class="badge">Welcome ${userEmail}</h1>
<a href="../home">Logout</a>
<%@include file="templates/footer.jsp" %>