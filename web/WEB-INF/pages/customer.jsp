<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Accounts"/>
<jsp:include page="/${role}/templates/header.jsp">
    <jsp:param name="title" value="${title}"/>
</jsp:include>

<jsp:include page="/WEB-INF/pages/manage-customer.jsp" />
<script>
  $("#form1").validate();
</script>
<jsp:include page="/${role}/templates/footer.jsp" />