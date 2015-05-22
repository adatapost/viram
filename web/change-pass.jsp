<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Change password"/>
<%@include file="templates/header.jsp" %>

<div class="float-left">
    <fieldset>
        
        <legend class="text-center">Change Password</legend>
        <form method="post" action="change-pass" id="form1"  role="form">
            <p class="row">
                <label for="userEmail">User Email</label>
                <input type="email" id="userEmail"  required name="userEmail" class="form-control" />
            </p>
            <p class="row">
                <label for="userPass">Existing Password</label>
                <input type="password" id="userPass" required name="userPass" class="form-control" />
            </p>
            <p class="row">
                <label for="newPass">New Password</label>
                <input type="password" id="newPass" required name="newPass" class="form-control" />
            </p>
            <p class="row">
                <label for="confPass">Reenter new Password</label>
                <input type="password" id="confPass" required name="confPass" class="form-control" />
            </p>
            <p class="text-danger text-center">${message}</p>
            <p class="row center">
                <input type="submit" name="cmd" value="Change Password" class="btn btn-info float-right mrg-r-100"/>
            </p>
        </form>
        <h6><a href="recover">Forgot your password?</a></h6>
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