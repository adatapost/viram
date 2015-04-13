<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Manage Ledger Categories"/>
<jsp:include page="/${role}/templates/header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>

<fieldset>
    <legend>${title}</legend>
    <div class="row">
        <div class="col-md-8">
            <form method="post" 
                  id="form1"
                  action="ledger-type">
                <table class="table">
                    <tr>

                        <td>
                            <select name="ledgerTypeId" 
                                    class="form-control"
                                    onchange="form1.submit()">
                                <option value="">Account Type</option>
                                <c:forEach var="act" items="${ledgerTypes}">
                                    <option ${act.ledgerTypeId eq model.ledgerTypeId ? 'selected' : '' } value="${act.ledgerTypeId}">${act.ledgerTypeName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="ledgerTypeName" required value="${model.ledgerTypeName}" class="form-control"/>
                        </td>
                        <td>
                            <c:if test="${model.ledgerTypeId eq 0}">
                                <button name="cmd" value="Add">Add</button>
                            </c:if>
                            <c:if test="${model.ledgerTypeId ne 0}">
                                <button name="cmd" value="Update">Update</button>
                                <button name="cmd" value="Delete">Delete</button>
                                <button name="cmd" formnovalidate value="Clear">Clear</button>
                            </c:if>

                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <div class="alert-warning">${message}</div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</fieldset>
<script>
  $("#form1").validate();
</script>
<jsp:include page="/${role}/templates/footer.jsp" />