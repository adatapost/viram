<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fieldset>
    <legend>
        ${not isFound ? 'New Account' : 'Edit Account'}
    </legend>
    <div class="row">
        <div class="col-md-11">
            <form enctype="multipart/form-data" method="post"
                  action="customer" 
                  name="regForm1" role="form">
                <input type="hidden" name="userId" value="${account.userId}"/>
                <table class="table">
                    <caption><h4>Personal Information</h4></caption>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" id="firstName" name="firstName" class="form-control" placeholder="first name" required value="${account.firstName}"></td>
                        <td><input type="text" id="middleName" name="middleName" class="form-control" placeholder="middle name" required value="${account.middleName}"></td>
                        <td><input type="text" id="lastName" name="lastName" class="form-control" placeholder="last name" required value="${account.lastName}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label for="Gender">Gender</label></td>
                        <td><label for="State">State</label></td>
                        <td><label for="City">City</label></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="radio" id="gender" name="gender" value="male" ${(account.gender eq "male") ? "checked" : ""}/>Male
                            <input type="radio" id="gender" name="gender" value="female" ${(account.gender eq "female") ? "checked" : ""}/>Female</td>
                        <td>
                            <select id="stateId" name="stateId" class="form-control" onchange="regForm1.submit()" required>
                                <option value="0">***Select***</option>
                                <c:forEach var="s" items="${states}">
                                    <option ${account.stateId eq s.stateId ? 'selected' : ''} value="${s.stateId}">${s.stateName}</option>
                                </c:forEach>                        
                            </select>
                        </td>
                        <td>
                            <select class="form-control" id="cityId" name="cityId" required>
                                <option value="0">***Select***</option>
                                <c:forEach var="s" items="${cities}">
                                    <option  ${account.cityId eq s.cityId ? 'selected' : ''} value="${s.cityId}">${s.cityName}</option>
                                </c:forEach>   
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Address</label></td>
                        <td colspan="4">
                            <textarea rows="4" id="address" name="address" class="form-control" required>${account.address}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label for="Phone">Phone</label></td>
                        <td><label for="BirthDate">Birth Date</label></td>
                        <td><label for="AccountType">Account Type</label></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="text" id="phone" name="phone" class="form-control" required value=${account.phone}></td>
                        <td><input type="date" id="birthDate" name="birthDate" class="form-control" placeholder="mm/dd/yyyy" required value=${account.birthDate}></td>
                        <td>
                            <select class="form-control" id="typeId" name="typeId" required>
                                <option value="0">***Select***</option>
                                <c:forEach var="s" items="${accTypes}">
                                    <option ${account.typeId eq s.typeId ? 'selected' : ''} value="${s.typeId}">${s.typeName}</option>
                                </c:forEach>    
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label>Reference A/C</label></td>
                        <td>
                            <select name="referenceUserId" class="form-control" required>
                                <c:forEach var="a" items="${refAccounts}">
                                    <option ${account.referenceUserId eq a.referenceUserId ? 'selected' : ''} value="${a.referenceUserId}">${a.firstName} ${a.middleName} ${a.lastName}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td><label>Deleted</label></td>
                        <td>
                            <input type="checkbox" name="isDeleted" value="1" ${account.isDeleted ? 'checked' : ''}/>
                        </td>
                    </tr>
                </table>

                <table class="table">
                    <caption><h4>Login</h4></caption>
                    <tr>
                        <td><label>Credentails</label></td>
                        <td><input type="text"   name="userEmail" class="form-control" placeholder="Email" required value="${account.userEmail}"></td>
                        <td><input type="text"   name="userPass" class="form-control" placeholder="Password" required value="${account.userPass}"></td>
                        <td></td>
                    </tr>
                </table>

                <table class="table">
                    <caption><h4>Nominee</h4></caption>
                    <tr>
                        <td><label>Name</label></td>
                        <td><input type="text" name="noFirstName" class="form-control" placeholder="first name" required value="${account.noFirstName}"></td>
                        <td><input type="text" name="noMiddleName" class="form-control" placeholder="middle name" required value="${account.noMiddleName}"></td>
                        <td><input type="text" name="noLastName" class="form-control" placeholder="last name" required value="${account.noLastName}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><label for="Gender">Gender</label></td>
                        <td><label for="BirthDate">Birth Date</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="radio" name="noGender" value="male" ${(account.noGender eq "male") ? "checked" : ""}/>Male
                            <input type="radio" name="noGender" value="female" ${(account.noGender eq "female") ? "checked" : ""}/>Female</td>
                        <td>
                            <input type="date"   name="noBirthDate" class="form-control" placeholder="mm/dd/yyyy" required value=${account.noBirthDate}>
                        </td>
                        <td>

                        </td>
                    </tr>
                </table>                        
                <div class="center text-center">
                    <p class="alert-success">${message}</p>

                    <c:if test="${not empty isFound}">
                        <button name="cmd" value="Update" 
                                class="btn btn-default">Update Account</button>
                        <button name="cmd" value="Delete" 
                                class="btn btn-default">Delete Account</button>
                        <a class="btn btn-default" href="account">Back</a>

                    </c:if>
                    <c:if test="${empty isFound}">
                        <button name="cmd" value="Add" class="btn btn-default">Create Account</button>
                        <a class="btn btn-default" href="account">Back</a>
                    </c:if>  
                </div>
            </form>
        </div>
    </div>        
</fieldset>
