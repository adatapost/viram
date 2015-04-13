<%-- 
    Document   : contact_us
    Created on : Jan 1, 2002, 2:03:01 AM
    Author     : Viram
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Contact Us"></c:set>
<%@include file="templates/header.jsp" %>
<h2 class="text-center text-primary">Team Members</h2>
<table class="table" title="Team Members">
    <thead>
    <th>Name</th>
    <th>Mobile No.</th>
    <th>E-mail</th>
</thead>
<tbody>
    <tr>
        <td>Viram Desai</td>
        <td>9898721306</td>
        <td>viramdesai87@gmail.com</td>
    </tr>
    <tr>
        <td>Sani Patel</td>
        <td>9638355958</td>
        <td>sanipatel@gmail.com</td>
    </tr>
    <tr>
        <td>Ketul Patel</td>
        <td>9725960915</td>
        <td>ketulpatel@gmail.com</td>
    </tr>
</tbody>
</table>
<form>
    <textarea placeholder="any suggestions..." class="form-control" title="if any suggestions, write here"></textarea>
    <input type="email" required placeholder="example@mail.com" class="form-control" title="enter your mail here"/>
    <input type="submit" value="Submit" class="form-control btn-info"/>
</form>
</form>
<%@include file="templates/footer.jsp" %>