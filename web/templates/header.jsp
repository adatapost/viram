<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="icon" type="image/jpg" href="images/favicon.jpg" sizes="16*16">
        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>
    <body>
        <div class="container">
            <header class="page-header">
                <p class="float-left"><img src="images/logoHead.png"/></p>
                <h1 class="text-center text-head">Co-operative Credit Society
                    <img src="images/logoHead.png" class="float-right"/><br/><br/><br/>
                </h1>
            </header>
            <nav class="navbar clear">
                <ul class="nav nav-tabs bg-info menubar ">
                    <li><a href="index.jsp" class="glyphicon glyphicon-home" title="Home"></a></li>
                    <li><a href="login.jsp"  title="Login">Login</a></li>
                    <li><a href="about_us.jsp" title="About Us">About Us</a></li>


                    <ul class="nav nav-tabs float-right text-success">
                        <li><a href="contact_us.jsp" class="glyphicon glyphicon-earphone" title="Contact Us"></a></li>
                    </ul>
                </ul>
            </nav>
            <!--Left Sidebar navigation-->
            <nav class="">
                <ul class="nav nav-stacked nav-pills sidebar float-left bg-info">
                    <li><a href="index.jsp">What's New</a></li> 
                    <li><a href="login.jsp"> Schemes and Offers</a></li>
                    <li><a href="login.jsp">FAQ</a></li><li class="divider"></li>
                    <li><a href="#">Press Releases</a></li><li class="divider"></li>
                    <li><a href="feedback.jsp">Feedback</a></li>
                </ul>
            </nav>
            <%--<div class="splash">
                <img class="pic" src="images/pic01.jpg" width="870" height="230" alt="" />
</div>--%>
            <div id="myCarousel" class="splash carousel slide">
                <!-- Carousel indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>   
                <!-- Carousel items -->
                <div class="carousel-inner h230">
                    <div class="item active" style="background: url('images/img01.jpg');height: 230px; width: 100%">
                        <h3 class="mrg-l-100 text-success">Welcome To Our Site...</h3>
                    </div>
                    
                    <div class="item">
                        <img src="images/img02.jpg" alt="Second slide" class="">
                    </div>
                    <div class="item">
                        <img src="images/img02.jpg" alt="third slide" class="">
                    </div>
                </div>
                <!-- Carousel nav -->
                <a class="carousel-control left" href="#myCarousel" 
                   data-slide="prev">&lsaquo;</a>
                <a class="carousel-control right" href="#myCarousel" 
                   data-slide="next">&rsaquo;</a>
            </div> 
            <div class="content mrg-l-200"> 
                <script src="js/jquery-2.1.3.min.js"></script>
                <script src="js/bootstrap.min.js"></script>                