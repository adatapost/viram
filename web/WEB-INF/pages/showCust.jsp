<%-- 
    Document   : showCust
    Created on : Jan 1, 2002, 3:10:35 AM
    Author     : Viram
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<p class="text-center text-info">${msg}</p>
<div class="row">
    <div class="col-md-5">
        <form method="post" action="Customer?action=showCust" 
              enctype="multipart/form-data"
              id="frmType">

            <div class="form-group">
                <label>Account Type</label>
                <select name="typeId" class="form-control" onchange="frmType.submit()" >
                    <option value="">Select</option>
                    <c:forEach var="type" items="${accTypes}">
                        <option ${type.typeId eq param.typeId ? "selected" : ""}  value="${type.typeId}">${type.typeName}</option>
                    </c:forEach>
                </select>
            </div>
        </form>
    </div>
</div>
<h3 class="text-center text-success">Accounts</h3>
<table class="table table-bordered table-striped">
    <thead>
        <tr class="bg-primary">        
            <th>#</th>
            <th>A/C No</th>
            <th>Name</th>
            <th>Address</th>
            <th>Open</th>
            <th>Closed?</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="a" items="${accounts}" varStatus="loop" >
            <tr>
                <td>${loop.index+1}</td>

                <td>${a.accountId}</td>
                <td>
                    <img src="../images/Customers/${a.accountId}"
                         class="img img-small"
                         title="Click to View Customer"
                         data-toggle="modal" data-target="#myModal${a.accountId}"/><br/>
                    ${a.firstName} ${a.middleName} ${a.lastName}
                    (${a.gender})<br/>
                    Birth Date : <fmt:formatDate value="${a.birthDate}" pattern="dd-MM-yy" />
                </td>
                
                <%----------------------Modal Window ---------------------------%>
        <div class="modal fade" id="myModal${a.accountId}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header bg-info">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true"> &times; </button> 
                        <h3><strong class="modal-title text-info text-capitalize"> ${a.firstName} ${a.middleName} ${a.lastName}</strong></h3>
                    </div>
                    <div class="modal-body text-primary"> 
                        <div height='100%'><img src="../images/Customers/${a.accountId}" style='padding: 15px;' width="200" height="220" class="float-left"/></div>
                        <p>Account Id: ${a.accountId}</p>
                        <p>${a.accountType.typeName} </p>
                        <p><span class="glyphicon glyphicon-phone"></span> ${a.phone}</p>
                        <p><span class="glyphicon glyphicon-envelope"></span>
                            <a href="mailto:#">${a.userAccountByUserId.userEmail}</a>
                        </p>
                        <p>State: ${a.city.state.stateName}</p>
                        <p>City: ${a.city.cityName}</p>
                        <p>Address: ${a.address}</p>
                        <p>Created On: <fmt:formatDate value="${a.created}" pattern="dd-MM-yy" /></p>
                        <h4><span class="glyphicon glyphicon-hand-down"></span> Nominee's Detail <span class="glyphicon glyphicon-hand-down"></span></h4>
                            <c:forEach var="n" items="${a.nominees}">
                            <p>Name: ${n.firstName} ${n.middleName} ${n.lastName}</p>
                            <p>Gender: ${n.gender}</p>
                        </c:forEach>
                    </div>
                    <div class="modal-footer bg-info"> 
                        <form method="post" enctype="multipart/form-data"  action="Customer?action=manageCust">
                            <button type="button" class="btn btn-warning" data-dismiss="modal">Close </button> 
                            <input type="hidden" name="userId" value="${a.accountId}"/>
                            <input type="submit" name="cmd" value="Edit" class="btn btn-success"/>
                        </form> 
                    </div>
                </div><!-- /.modal-content --> 
            </div><!-- /.modal -->
        </div>
        <%-----------------End Modal Window ---------------------------%>
        <td>
            ${a.address}<br/>
            ${a.city.cityName}</br>

            <span class="glyphicon glyphicon-phone"></span> ${a.phone}<br/>
            <span class="glyphicon glyphicon-envelope"></span> ${a.userAccountByUserId.userEmail} <br/>
        </td>
        <td>
            <fmt:formatDate value="${a.created}" pattern="dd-MM-yy" />
        </td>
        <td>
            ${a.isDeleted ? "Yes" : "No"}
        </td>
        <td>
            <form method="post" enctype="multipart/form-data"  action="Customer" name="form1">
                <input type="hidden" name="userId" value="${a.accountId}"/>
                <input type="submit" name="cmd" value="Edit" class="btn btn-success">
                <button name="cmd" value="X" class="btn ${a.isDeleted ? 'btn-warning' : 'btn-danger'}">${a.isDeleted ? "Undo" : "Delete"}</button>
            </form>
        </td>
    </tr>

</c:forEach> 
</tbody>    

</table>

