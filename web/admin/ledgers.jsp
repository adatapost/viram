<%-- 
    Document   : accounts
    Created on : Jan 1, 2002, 9:11:43 AM
    Author     : Viram
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Ledgers"/>
<%@include file="templates/header.jsp" %>
<form action="Ledgers" method="post" class="form-inline" name="form1">
    <p class="row">
        <label for="ledgerTypeId">Ledger Type:</label>
        <select id="ledgerTypeId" name="ledgerTypeId" onchange="form1.submit()" class="form-control">
            <option value="">***Select***</option>
            <c:forEach var="l" items="${ledgerType}">
                <option ${l.ledgerTypeId eq param.ledgerTypeId ? "selected" : ""} value="${l.ledgerTypeId}">${l.ledgerTypeName}</option>
            </c:forEach>
        </select>
    </p>
</form> 
<h3 class="text-center text-success">Ledger</h3>
<!--<div class="alert alert-danger alert-dismissable">
    <button type="button" class="close" data-dismiss="alert" aria-hidden="true"> &times; </button> 
    Error ! Change few things. 
</div>-->

<table class="table table-bordered table-striped">
    <thead class="bg-primary">
    <th>LedgerId</th>
    <th>AccountId</th>
    <th>Name</th>
    <th>Address</th>
    <th>Loan Detail</th>

</thead>
<tbody>
    <c:forEach var="l" items="${ledgers}">
        <tr>
            <td>${l.ledgerId}</td>
            <td>${l.account.accountId}</td>
            <td>
                <img src="../images/Customers/${l.account.accountId}"
                     class="img img-small"
                     data-toggle="modal" data-target="#myModal${a.accountId}"/><br/>
                ${l.ledgerName}
                (${l.account.gender})<br/>
                Birth Date : <fmt:formatDate value="${l.account.birthDate}" pattern="dd-MM-yy" />
</td>
<td>
            ${l.account.address}<br/>
            ${l.account.city.cityName}</br>

            <span class="glyphicon glyphicon-phone"></span> ${l.account.phone}<br/>
            <span class="glyphicon glyphicon-envelope"></span> ${l.account.userAccountByUserId.userEmail} <br/>
        </td>
<td></td>


</tr>
</c:forEach> 
</tbody>    

</table>


<%@include file="templates/footer.jsp" %>