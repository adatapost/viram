<%-- 
    Document   : feedback
    Created on : Jan 1, 2002, 2:14:47 AM
    Author     : Viram
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Feedback"></c:set>
<%@include file="templates/header.jsp" %>
<form class="">
    <br/>
    <textarea placeholder="Enter Your Response..." class="form-control" title="if any Response, write here"></textarea>
    <br/>
    <input type="email" required placeholder="example@mail.com" class="form-control" title="enter your mail here"/>
    <br/>
    <input type="text" required placeholder="enter 10 digit mobile no." maxlength="10" class="form-control" title="enter your mail here"/>
    <br/>
    <input type="submit" value="Submit Response" class="form-control btn-info"/>
</form>
<%@include file="templates/footer.jsp" %>