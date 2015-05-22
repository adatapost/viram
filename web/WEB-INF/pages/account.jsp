<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Accounts"/>
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

                          action="account">
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
                        <a href="customer" class="btn btn-default">New Account</a>
                        <c:if test="${model.userId ne 0}">
                            <a target="_blank" href="../show-report?cmd=ledgers&accountId=${model.userId}" class="btn btn-default">Print</a>
                        </c:if>
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
                                <td>
                                    <form method="post" 
                                          enctype="multipart/form-data"
                                          action="customer">
                                        <input type="hidden" name="userId" value="${model.userId}"/>
                                        <button name="cmd" value="Edit">Edit</button>
                                    </form>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="4">
                                    <form method="post" action="account" id="form2">
                                        <input type="hidden" name="userId" value="${model.userId}"/>
                                        <input type="hidden" name="ledgerId" value="${ledger.ledgerId}"/>
                                        <table class="table">
                                            <tr>
                                                <th>
                                                    <select class="form-control" onchange="form2.submit()" name="ledgerTypeId" required>
                                                        <option value="">Select</option>
                                                        <c:forEach var="t" items="${ledgerTypes}">
                                                            <option ${t.ledgerTypeId eq ledger.ledgerTypeId ? 'selected' : '' } value="${t.ledgerTypeId}">${t.ledgerTypeName}</option>
                                                        </c:forEach>
                                                    </select>
                                                </th>
                                                <th>
                                                    <input type="text" name="ledgerName" class="form-control" required value="${ledger.ledgerName}" />
                                                </th>
                                                <th>
                                                    Is deleted 
                                                    <input type="checkbox" name="isDeleted" value="1" ${ledger.isDeleted ? 'checked':''} />
                                                    Is closed 
                                                    <input type="checkbox" name="isClosed" value="1" ${ledger.isClosed ? 'checked':''} />
                                                </th>
                                                <th>
                                                    <button name="cmd" value="AddLedger" class="btn btn-default">Add</button>
                                                </th>
                                            </tr>
                                        </table>
                                    </form>
                                    <p class="alert-success">${message}</p>
                                    <table class="table table-bordered">
                                        <tr>
                                            <th>Ledger</th>
                                            <th>Created</th>
                                            <th>Closed?</th>
                                            <th>Deleted?</th>
                                            <th></th>
                                        </tr>
                                        <c:forEach var="a" items="${ledgers}">
                                            <tr>
                                                <td>${a.ledgerName}</td>
                                                <td>${a.created}</td>
                                                <td>${a.isClosed ? "Yes" : "No"}</td>
                                                <td>${a.isDeleted ? "Yes" : "No"}</td>
                                                <td>
                                                    <c:if test="${a.ledgerTypeId ne 2}">
                                                        <form method='get' action='${a.ledgerTypeId eq 6 ? 'deposit' : a.ledgerTypeId eq 5 ? 'recurring' : 'loan'}'>
                                                            <input type="hidden" name="userId" value="${model.userId}"/>
                                                            <input type="hidden" name="ledgerId" value="${a.ledgerId}"/>
                                                            <button name="cmd" value='Edit' class='btn btn-default'>Edit</button>
                                                        </form>
                                                    </c:if>
                                                    <a class="btn btn-default" target="_blank" href="show-report?cmd=ledger&accountId=${a.ledgerId}">Print</a>
                                                </td>
                                            </tr>
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