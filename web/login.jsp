<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Login"/>
<%@include file="templates/header.jsp" %>

<div class="float-left">
    <h5><p onclick="showReg()" class="btn btn-info"><span class="glyphicon glyphicon-log-in"></span>&nbsp;New User? Click To Register</p></h5>
    <fieldset>
        
        <legend class="text-center">Login</legend>
        <form method="post" action="login"  id="form1"  role="form">
            <p class="row">
                <label for="userEmail">User Email</label>
                <input type="email" required id="userEmail" name="userEmail" class="form-control" />
            </p>
            <p class="row">
                <label for="userPass">User Password</label>
                <input type="password" required id="userPass" name="userPass" class="form-control" />
            </p>
            <p class="text-danger text-center">${message}</p>
            <p class="row center">
                <input type="submit" name="cmd" value="Login" class="btn btn-info float-right mrg-r-100"/>
            </p>
        </form>
        <h6><a href="recover">Forgot your password?</a></h6>
    </fieldset>
</div>
<div class="float-right mrg-r-100" id="registration">
    <fieldset class="">
        <legend class="text-center">Registration</legend>
        <form method="post" action="login" class="form-inline"  role="form">
            <p class="row">
                <label for="userEmail">User Email</label>
                <input type="email" id="userEmail" name="userEmail" class="form-control" required/>
            </p>
            <p class="row">
                <label for="userPass">User Password</label>
                <input type="password" id="userPass" name="userPass" class="form-control" required />
            </p>
            <p class="row">
                <label for="role">User Role</label>
                <select class="form-control" id="role" name="role">
                    <option value="0">***Select***</option>
                    <c:forEach var="u" items="${userRole}">
                        <option value="${u}">${u}</option>
                    </c:forEach>
                </select>
            </p>
            <p class="row">
                <label for="dateCreated">Join Date</label>
                <input type="date" id="dateCreated" name="dateCreated" class="form-control"/>
            </p>
            
            <p class="row center">
                <input type="submit" name="cmd" value="Register" class="btn btn-info float-right mrg-r-100"/>
            </p>
            <p class="text-info">${msg}</p>
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
</script>
<%@include file="templates/footer.jsp" %>