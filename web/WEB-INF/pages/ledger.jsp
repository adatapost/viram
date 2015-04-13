<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Ledger Central"/>
<jsp:include page="/${role}/templates/header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>

<fieldset>
    <legend>${title}</legend>
    <div class="row">
        <div class="col-md-8">
            
        </div>
    </div>
</fieldset>
<script>
  $("#form1").validate();
</script>
<jsp:include page="/${role}/templates/footer.jsp" />