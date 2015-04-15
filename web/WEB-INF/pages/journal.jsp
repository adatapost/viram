<%@page buffer="10024kb" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Journals"/>
<jsp:include page="/${role}/templates/header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>

<fieldset>
    <legend>${title}</legend>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="panel-title">
                        Search Account
                    </div>
                </div>
                <div class="panel-body">
                    <form method="post" 
                          id="form1"
                          action="journal">
                        <datalist id="list">
                            <c:forEach var="c" items="${accounts}">
                                <option  ${model.userId eq param.userId ? 'selected' : ''}  value="${c.userId}">${c.firstName} ${c.middleName} ${c.lastName}</option>
                            </c:forEach>
                        </datalist>
                        <label>A/C : </label>
                        <input type="text" 
                               placeholder="Account Number"
                               list="list" 
                               name="userId" value="${model.userId}"/>
                        <button class="btn btn-default">Submit</button>
                    </form>
                    <c:if test="${model.userId ne 0}">
                        <table class="table table-bordered">
                            <tr>

                                <td>${model.gender eq 'male' ? 'Mr.' : 'Miss.' } ${model.firstName} ${model.middleName} ${model.lastName}</td>
                                <td>
                                    ${model.address} ${model.cityName} - ${model.stateName}
                                    <br/>Phone: ${model.phone}
                                </td>
                                <td>${model.typeName} ${model.created}</td>
                            </tr>
                            <tr>
                                <td colspan="3">
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Ledger</th>
                                            <th>Created</th>
                                            <th>Closed?</th>
                                            <th>Deleted?</th>
                                            <th></th>
                                        </tr>
                                        <c:forEach var="a" items="${ledgers}">
                                            <c:if test="${not a.isClosed and not a.isDeleted}">
                                                <tr class="${a.ledgerId eq ledger.ledgerId  ? 'bg-primary' :  ledger.ledgerId eq 0 ? '' : 'hide' }">
                                                    <td>${a.ledgerName}</td>
                                                    <td><fmt:formatDate value="${a.created}"/></td>
                                                    <td>${a.isClosed ? "Yes" : "No"}</td>
                                                    <td>${a.isDeleted ? "Yes" : "No"}</td>
                                                    <td>
                                                        <form method='post' action='journal'>
                                                            <input type="hidden" name="userId" value="${model.userId}"/>
                                                            <input type="hidden" name="ledgerId" value="${a.ledgerId}"/>
                                                            <button name="cmd" value="${ledger.ledgerId eq 0 ? 'Select' : 'Back'}" class='btn btn-default'>${ledger.ledgerId eq 0 ? 'Select' : 'Back'}</button>
                                                        </form>
                                                    </td>
                                                </tr>
                                            </c:if>
                                            <c:if test="${ledger.ledgerId eq a.ledgerId}">
                                                <tr>
                                                    <td colspan="5">
                                                        <form method='post' form="frmJour" action='journal'>
                                                            <input type="hidden" name="userId" value="${model.userId}"/>
                                                            <input type="hidden" name="ledgerId" value="${a.ledgerId}"/>
                                                            <table class="table table-bordered">
                                                                <tr>
                                                                    <td>
                                                                        <select name="jourType" required class="form-control">
                                                                            <option value="Cr">Cr</option>
                                                                            <option value="Dr">Dr</option>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <select name="jourTypeId" required class="form-control">
                                                                            <c:forEach var="j" items="${bankLedgers}">
                                                                                <option value="${j.ledgerId}">${j.ledgerName}</option>
                                                                            </c:forEach>
                                                                        </select>
                                                                    </td>
                                                                    <td>
                                                                        <input type="number" class="form-control" placeholder="Amount" name="amount"/>
                                                                    </td>
                                                                    <td>
                                                                        <input type="text" class="form-control" placeholder="Particular" name="particular"/>
                                                                    </td>
                                                                    <td>
                                                                        <button name="cmd" value="Add" class="btn btn-default">Add</button>
                                                                    </td>
                                                                </tr>
                                                            </table>
                                                            <p class="alert-success">${message}</p>
                                                        </form>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td colspan="5">
                                                        <table class="table table-bordered">
                                                            <c:set var="total" value="0" />
                                                            <c:forEach var="t" items="${journals}">
                                                                <c:if test="${t.ledgerByDrLedgerId eq a.ledgerId}">
                                                                    <c:set var="total" value="${total - t.amount}" />
                                                                </c:if>
                                                                <c:if test="${t.ledgerByDrLedgerId ne a.ledgerId}">
                                                                    <c:set var="total" value="${total + t.amount}" />
                                                                </c:if>
                                                                <tr>
                                                                    <td><fmt:formatDate value="${t.docDate}" /></td>
                                                                    <td>
                                                                        Cr, ${t.ledgerByCrLedgerName} <br/>
                                                                        Dr, ${t.ledgerByDrLedgerName}
                                                                    </td>
                                                                    <td class="text-right"><fmt:formatNumber value="${t.amount}" type="number" minFractionDigits="2"/></td>
                                                                    <td>
                                                                        ${t.particular}
                                                                    </td>
                                                                    <td>
                                                                        <form method="post" action="journal">
                                                                            <input type="hidden" name="userId" value="${model.userId}"/>
                                                                            <input type="hidden" name="ledgerId" value="${a.ledgerId}"/>
                                                                            <input type="hidden" name="docId" value="${t.docId}"/>
                                                                            <button name="cmd" value="Delete" class="btn btn-default">Delete</button>

                                                                        </form>
                                                                    </td>
                                                                </tr>
                                                            </c:forEach>
                                                                <tr>
                                                                    <td colspan="2">Total</td>
                                                                    <td class="text-right"><fmt:formatNumber value="${total}" type="number" minFractionDigits="2"/></td>
                                                                    <td></td>
                                                                    <td></td>
                                                                </tr>
                                                        </table>
                                                    </td>
                                                </tr>
                                            </c:if>
                                        </c:forEach>
                                    </table>
                                </td>    
                            </tr>
                        </table>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<script>
    $("#form1").validate();
</script>
<jsp:include page="/${role}/templates/footer.jsp" />