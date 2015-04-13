<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
    <head>
        <base href="http://localhost:8084/CreditSocApp/customer/">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="icon" type="image/ico" href="favicon.ico" sizes="16*16">
        <link rel="stylesheet" href="../css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../css/style.css"/>
    </head>
    <body>
        <div class="container bg-aaa">
            <header class="page-header">
                <p class="float-left"><img src="../images/logoHead.png"/></p>
                <h1 class="text-center text-head">Co-operative Credit Society
                    <img src="../images/logoHead.png" class="float-right"/><br/><br/><br/>
                </h1>
            </header>
            <nav class="navbar clear">
                <ul class="nav nav-tabs bg-info menubar">
                    <li><img src="../images/side_home.gif" class="float-left" style="margin-top: 15px;"/><a href="index.jsp">Home</a></li>
                    <li><a href="#">Login</a></li>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Contact Us</a></li>

                    <ul class="nav nav-tabs float-right text-success">
                        <!--<li><a href="open_new_acc.jsp">Open New Account</a></li>-->
                    </ul>
                </ul>
            </nav>
            <nav class="">
                <ul class="nav sidebar float-left bg-info">
                    <li><a href="#">What's New</a></li>
                    <li><a href="#">Schemes and Offers</a></li>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Press Releases</a></li>
                    <li><a href="#">Feedback</a></li>
                </ul>
            </nav>
            <div class="splash">
		<img class="pic" src="../images/pic01.jpg" width="870" height="230" alt="" />
            </div>
            <div class="content"> 
                <script src="../js/jquery-2.1.3.min.js"></script>
                <script src="../js/bootstrap.min.js"></script>