<%-- 
    Document   : accounts
    Created on : Jan 1, 2002, 9:11:43 AM
    Author     : Viram
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Loan"/>
<%@include file="templates/header.jsp" %>
<div class="center-block w400">
    <form method="post" action="Loan" class="form-inline" name="loanForm" id="loanForm">

        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="ledgerId">Ledger ID</label></span>
                <input type="text" onblur="loanForm.submit()" class="form-control" name="ledgerId" value="${loan.ledgerId}">
            </p>
        </div>
        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="name">Name</label></span>
                <input type="text" disabled class="form-control" value="${ledger.ledgerName}">
            </p> 
        </div>
        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="amount">Loan Amount</label></span>
                <input type="text" class="form-control" name="amount" value="${loan.amount}">
            </p> 
        </div>
        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="interestRate">Interest Rate</label></span>
                <input type="text" class="form-control" name="interestRate" value="${loan.interestRate}">
                <span class="input-group-addon">%</span>
            </p>
        </div>
        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="startDate">Start Date</label></span>
                <input type="date" class="form-control" name="startDate" value="${loan.startDate}" placeholder="mm/dd/yyyy">
            </p>
        </div>
        <div class="row">
            <p class="input-group">
                <span class="input-group-addon"><label for="endDate">End Date</label></span>
                <input type="date" class="form-control" name="endDate" value="${loan.endDate}" placeholder="mm/dd/yyyy">
            </p>
        </div>
        <p>
            <input type="submit" name="cmd" value="Apply" title="Apply for Loan" class="center-block btn btn-info w200">
        </p>
    </form>
</div>
<%@include file="templates/footer.jsp" %>