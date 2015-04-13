<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Cities & States"/>
<jsp:include page="/${role}/templates/header.jsp" />

<fieldset>
    <legend>Cities & States</legend>
    <div class="row">
        <div class="col-md-8">
            <form method="post" 
                  id="form1"
                  action="city">
                <table class="table">
                    <tr>

                        <td>
                            <select name="stateId" 
                                    required
                                    class="form-control"
                                    onchange="form1.submit()">
                                <option value="">State</option>
                                <c:forEach var="state" items="${states}">
                                    <option ${state.stateId eq model.stateId ? 'selected' : '' } value="${state.stateId}">${state.stateName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="stateName" required value="${model.stateName}" class="form-control"/>
                        </td>
                        <td>
                            <c:if test="${model.stateId eq 0}">
                                <button name="cmd" value="AddState">Add</button>
                            </c:if>
                            <c:if test="${model.stateId ne 0}">
                                <button name="cmd" value="UpdateState">Update</button>
                                <button name="cmd" value="DeleteState">Delete</button>
                                <button name="cmd" formnovalidate value="ClearState">Clear</button>
                            </c:if>

                        </td>
                    </tr>
                    <tr>

                        <td>
                            <select name="cityId" 
                                    class="form-control"
                                    onchange="form1.submit()">
                                <option value="">City</option>
                                <c:forEach var="city" items="${cities}">
                                    <option ${city.cityId eq model.cityId ? 'selected' : '' } value="${city.cityId}">${city.cityName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <input type="text" name="cityName" ${model.stateId ne 0 ? 'required' : ''} value="${model.cityName}" class="form-control"/>
                        </td>
                        <td>
                            <c:if test="${model.cityId eq 0}">
                                <button name="cmd" value="AddCity">Add</button>
                            </c:if>
                            <c:if test="${model.cityId ne 0}">
                                <button name="cmd" value="UpdateCity">Update</button>
                                <button name="cmd" value="DeleteCity">Delete</button>
                                <button name="cmd" formnovalidate value="ClearCity">Clear</button>
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