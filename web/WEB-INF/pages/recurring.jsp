<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Recurring Account"/>
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
                        Account & Ledger
                    </div>
                </div>
                <div class="panel-body">
                    <table class="table table-bordered">
                        <tr>
                            <td>${model.gender eq 'male' ? 'Mr.' : 'Miss.' } ${model.firstName} ${model.middleName} ${model.lastName}</td>
                            <td>
                                ${model.address} ${model.cityName} - ${model.stateName}
                                <br/>Phone: ${model.phone}
                            </td>
                            <td>${model.typeName} ${model.created}</td>

                        </tr>
                    </table>
                    <form method="post" action="recurring">
                        <input type="hidden" name="ledgerId" value="${ledger.ledgerId}"/>
                        <table class="table">
                            <tr>
                                <td>Ledger Name</td>
                                <td>Current Year</td>
                                <td>Deleted?</td>
                                <td>Closed?</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" class="form-control" name="ledgerName" value="${ledger.ledger.ledgerName}" required/>
                                </td>
                                <td>
                                    <input type="text" class="form-control" name="currentAcYer" value="${ledger.ledger.currentAcYear}" required/>
                                </td>
                                <td>
                                    <input type="checkbox" name="isDeleted" value="true" ${ledger.ledger.isDeleted ? "checked" : ""} />
                                </td>
                                <td>
                                    <input type="checkbox" name="isClosed" value="true" ${ledger.ledger.isClosed ? "checked" : ""} />
                                </td>
                            </tr>
                            <tr>
                                <td>Starts</td>
                                <td>Ends</td>
                                <td>Frequency</td>
                                <td>Term</td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="date" class="form-control" name="startDate"
                                           value="<fmt:formatDate value="${ledger.startDate}" pattern="yyyy-MM-dd" />" required/>
                                </td>

                                <td>
                                    <input type="date" class="form-control" name="endDate" 
                                           value="<fmt:formatDate value="${ledger.endDate}" pattern="yyyy-MM-dd"/>" required/>
                                </td>
                                <td>
                                    <select name="frequency" class="form-control" required>
                                        <c:forEach var="i" items="Daily,Weekly,Monthly" varStatus="loop">
                                            <option ${ledger.frequency eq loop.index ? 'selected':''} value="${loop.index}">${i}</option>
                                        </c:forEach>
                                    </select>
                                </td>

                                <td>
                                    <input type="number" class="form-control" name="term" value="${ledger.term}" required/>
                                </td>
                            </tr>
                            <tr>
                                <td>Amount Rs.</td>
                                <td>Interest Rate %</td>
                                <td></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td>
                                    <input type="number" class="form-control" name="amount" value="${ledger.amount}" required/>
                                </td>
                                <td>
                                    <input type="number" class="form-control" name="interestRate" value="${ledger.interestRate}" required/>
                                </td>
                                <td colspan="2">
                                    <button name="cmd" class="btn btn-default" value="Update">Update Ledger</button>
                                    <button name="cmd" class="btn btn-default" value="Delete">Delete Ledger</button>
                                    <a href="account" class="btn btn-default">Back</a>
                                </td>

                            </tr>
                        </table>
                        <p class="alert-success">${message}</p>

                    </form>
                </div>
            </div>
        </div>
    </div>
</fieldset>
<script>
    $("#form1").validate();
</script>
<jsp:include page="/${role}/templates/footer.jsp" />