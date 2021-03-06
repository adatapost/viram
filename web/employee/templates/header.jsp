<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8084/CreditSocApp/employee/"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="icon" type="image/jpg" href="../images/favicon.jpg" sizes="16*16">
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
    <body>
        <div class="container">
            <header class="page-header">
                <p class="float-left"><img src="../images/logoHead.png"/></p>
                <h1 class="text-center text-head">Co-operative Credit Society
                    <img src="../images/logoHead.png" class="float-right"/><br/><br/><br/>
                </h1>
            </header>
            <nav class="navbar clear">
                <ul class="nav nav-tabs bg-info menubar">
                    <li><a href="/CreditSocApp/employee/"  class="glyphicon glyphicon-home" title="Home"></a></li>
                    <li><a href="account">Accounts</a></li>
                    <li><a href="journal">Journals</a></li>
                    


                    <ul class="nav nav-tabs float-right text-success">
                        <li><a href="AdminProfile" class="glyphicon glyphicon-user" title="Profile"></a></li>
                        <li><a href="../index.jsp" class="w-auto glyphicon glyphicon-off" title="Logout"></a></li>
                    </ul>
                </ul>
            </nav>
            <!--<div class="splash">
                <img class="pic" src="../images/pic01.jpg" width="870" height="230" alt="" />
            </div>-->
            <div class="content"> 
                <script src="../js/jquery-2.1.3.min.js"></script>
                <script src="../js/bootstrap.min.js"></script>
                <script src="../js/jquery.validate.min.js"></script>
                <script src="../js/moment.min.js"></script>