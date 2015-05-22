<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Recover Password"/>
<%@include file="templates/header.jsp" %>

<div class="float-left">
    
    <fieldset>
        
        <legend class="text-center">Recover Password</legend>
        <form method="post" action="recover" id="form1"  role="form">
            <p class="row">
                <label for="userEmail">User Email</label>
                <input type="email" id="userEmail" name="userEmail" class="form-control" />
            </p>
             
            <p class="text-danger text-center">${message}</p>
            <p class="row center">
                <input type="submit" name="cmd" value="Recover" class="btn btn-info float-right mrg-r-100"/>
            </p>
        </form>
    </fieldset>
</div>

<script src="js/jquery-2.1.3.min.js"></script>
<script>
    $("#registration").hide();
   function showReg(){
       console.log("clicked");
       $("#registration").toggle(500);
   }
   $("#form1").validate();
</script>
<%@include file="templates/footer.jsp" %>