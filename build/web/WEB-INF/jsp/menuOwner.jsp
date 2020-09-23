<%-- 
    Document   : menuAdmin
    Created on : Jun 30, 2019, 12:29:06 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>

<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <title>Menu Pemilik Perusahaan</title>

        <!-- Google font -->
        <link href="https://fonts.googleapis.com/css?family=Hind:400,700" rel="stylesheet">

        <!-- Bootstrap -->
        <link type="text/css" rel="stylesheet" href="a/css/bootstrap.min.css" />

        <!-- Slick -->
        <link type="text/css" rel="stylesheet" href="a/css/slick.css" />
        <link type="text/css" rel="stylesheet" href="a/css/slick-theme.css" />

        <!-- nouislider -->
        <link type="text/css" rel="stylesheet" href="a/css/nouislider.min.css" />

        <!-- Font Awesome Icon -->
        <link rel="stylesheet" href="a/css/font-awesome.min.css">

        <!-- Custom stlylesheet -->
        <link type="text/css" rel="stylesheet" href="a/css/style.css" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
                  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
                  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
                <![endif]-->

    </head>

    <body>
        <!-- HEADER -->
        <header>
            <!-- top Header -->
            <!--            <div id="top-header">
                            <div class="container">
                                <div class="pull-left">
                                    <span>Welcome to E-shop!</span>
                                </div>
                                <div class="pull-right">
                                    <span>Welcome</span>
                                </div>
                            </div>
                        </div>-->
            <!-- /top Header -->

            <!-- header -->
            <div id="header">
                <div class="container">
                    <div class="pull-left">
                        <!-- Logo -->
                        <div class="header-logo">
                            <a class="logo" href="#">
                                <img src="./a/img/logo mostly.png" alt="">
                            </a>
                        </div>
                        <!-- /Logo -->

                        <!-- Search -->
                        <!--                        <div class="header-search">
                                                    <form>
                                                        <input class="input search-input" type="text" placeholder="Enter your keyword">
                                                        <select class="input search-categories">
                                                            <option value="0">All Categories</option>
                                                            <option value="1">Category 01</option>
                                                            <option value="1">Category 02</option>
                                                        </select>
                                                        <button class="search-btn"><i class="fa fa-search"></i></button>
                                                    </form>
                                                </div>-->
                        <!-- /Search -->
                    </div>
                    <div class="pull-right">
                        <ul class="header-btns">
                            <!-- Account -->
                            <li class="header-account dropdown default-dropdown">
                                <div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
                                    <div class="header-btns-icon">
                                        <i class="fa fa-user-o"></i>
                                    </div>
                                    <c:url var="login" value="/index.htm"></c:url>
                                    <a href="${login}" class="text-uppercase"><strong>LOGOUT</strong></a>
                                </div>
                                <!--<a href="#" class="text-uppercase">Login</a> / <a href="#" class="text-uppercase">Join</a>
                                <ul class="custom-menu">
                                    <li><a href="#"><i class="fa fa-user-o"></i> My Account</a></li>
                                    <li><a href="#"><i class="fa fa-heart-o"></i> My Wishlist</a></li>
                                    <li><a href="#"><i class="fa fa-exchange"></i> Compare</a></li>
                                    <li><a href="#"><i class="fa fa-check"></i> Checkout</a></li>
                                    <li><a href="#"><i class="fa fa-unlock-alt"></i> Login</a></li>
                                    <li><a href="#"><i class="fa fa-user-plus"></i> Create An Account</a></li>
                                </ul>-->
                            </li>
                            <!-- /Account -->

                            <!-- Cart -->
                            <li class="header-cart dropdown default-dropdown">
                                <!--                                <a class="dropdown-toggle" data-toggle="dropdown" aria-expanded="true">
                                                                    <div class="header-btns-icon">
                                                                        <i class="fa fa-shopping-cart"></i>
                                                                        <span class="qty">3</span>
                                                                    </div>
                                                                    <strong class="text-uppercase">My Cart:</strong>
                                                                    <br>
                                                                    <span>35.20$</span>
                                                                </a>-->
                                <div class="custom-menu">
                                    <div id="shopping-cart">
                                        <div class="shopping-cart-list">
                                            <div class="product product-widget">
                                                <div class="product-thumb">
                                                    <img src="./a/img/thumb-product01.jpg" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
                                                    <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                                                </div>
                                                <button class="cancel-btn"><i class="fa fa-trash"></i></button>
                                            </div>
                                            <div class="product product-widget">
                                                <div class="product-thumb">
                                                    <img src="./a/img/thumb-product01.jpg" alt="">
                                                </div>
                                                <div class="product-body">
                                                    <h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
                                                    <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                                                </div>
                                                <button class="cancel-btn"><i class="fa fa-trash"></i></button>
                                            </div>
                                        </div>
                                        <div class="shopping-cart-btns">
                                            <button class="main-btn">View Cart</button>
                                            <button class="primary-btn">Checkout <i class="fa fa-arrow-circle-right"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </li>
                            <!-- /Cart -->

                            <!-- Mobile nav toggle-->
                            <li class="nav-toggle">
                                <button class="nav-toggle-btn main-btn icon-btn"><i class="fa fa-bars"></i></button>
                            </li>
                            <!-- / Mobile nav toggle -->
                        </ul>
                    </div>
                </div>
                <!-- header -->
            </div>
            <!-- container -->
        </header>
        <!-- /HEADER -->

        <!-- NAVIGATION -->
        <div id="navigation">
            <!-- container -->
            <div class="container">
                <div id="responsive-nav" class="text-center">
<!--                <div id="responsive-nav">-->
                    <!-- category nav -->
                    <!--                    <div class="category-nav">
                                            <span class="category-header">E-COMMERCE</span>
                                        </div>-->
                    <!-- /category nav -->

                    <!-- menu nav -->
                    <c:url var="home" value="/menuOwner.htm"/>
                    <c:url var="admin" value="/tabelAdmin.htm"/>
                    <c:url var="produk" value="/tabelProdukForOwner.htm"/>
                    <c:url var="pengeluaran" value="/tabelPengeluaranForOwner.htm"/>
                    <c:url var="laporan" value="/doSelectTahunLaporanOwner.htm"/>
                    <div class="menu-nav">
                        <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                        <ul class="menu-list">
                            <li><a href="${home}">Home</a></li>
                            <li><a href="${admin}">Akun Admin</a></li>
                            <li><a href="${produk}">Data Produk</a></li>
                            <li><a href="${pengeluaran}">Data Pengeluaran</a></li>
                            <li><a href="${laporan}">Laporan</a>
                        </ul>
                    </div>
                </div>
                    <!-- menu nav -->
                </div>
            </div>
        <!-- /NAVIGATION -->

        <!-- HOME -->
        <div id="home">
            <!-- container -->
            <div class="container">
                <!-- home wrap -->
                <!--<div class="home-wrap">-->
                    <!-- home slick -->
                    <!--<div id="home-slick">-->
                        <!-- banner -->
                        <div class="banner banner-1">
                            <c:set var="indexCek" value="0"/>
                            <c:forEach var="listPengeluaran" items="${listPengeluaranCek}">                   
                                <c:set var="indexCek" value="${indexCek+1}"/>
                            </c:forEach>
                            <c:if test = "${indexCek >0}">
                                <div class="alert alert-info">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                                    <h3 class="text-info"><i class="fa fa-exclamation-circle"></i> Information</h3> ${indexCek} Permintaan Pengeluaran Baru
                                </div>
                            </c:if>
                            <br><br>
                            <!--<div class="row">-->
                                <center><div class="col-md-9">
                                    <canvas id="chart2" height="150" ></canvas>
                                    </div></center>
                            <!--</div>-->
                            <!--</div>-->
                        <!-- /banner -->
                    <!--</div>-->
                    <!-- /home slick -->
                <!--</div>-->
                <!-- /home wrap -->
            </div>
            </div>
        </div>
            <!-- /container -->
        </div>
        <!-- /HOME -->

        <!-- jQuery Plugins -->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/slick.min.js"></script>
        <script src="js/nouislider.min.js"></script>
        <script src="js/jquery.zoom.min.js"></script>
        <script src="js/main.js"></script>

        <script data-cfasync="false" src="https://www.wrappixel.com/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
        <script src="https://www.wrappixel.com/demos/admin-templates/monster-admin/assets/plugins/jquery/jquery.min.js"></script>

        <script src="https://www.wrappixel.com/demos/admin-templates/monster-admin/assets/plugins/Chart.js/Chart.min.js"></script>


        <script>
            $(document).ready(function () {
                $.ajax({
                    url: 'getGrafik.htm',
                    type: 'GET',
                    success: function (response1) {
                        var data1 = JSON.parse(response1);
                        let data = [];
                        let datajum = [];
                        for (let a = 0; a < data1.length; a++) {
                            data[a] = data1[a].nama_produk + " " + data1[a].warna;
                            datajum[a] = data1[a].kuantitas;
                        }
                        new Chart(document.getElementById("chart2"),
                                {
                                    "type": "bar",
                                    "data": {"labels": data,
                                        "datasets": [{
                                                "label": "My First Dataset",
                                                "data": datajum,
                                                "fill": false,
                                                "backgroundColor": ["rgba(255, 99, 132, 0.2)", "rgba(255, 159, 64, 0.2)", "rgba(255, 205, 86, 0.2)", "rgba(75, 192, 192, 0.2)", "rgba(54, 162, 235, 0.2)", "rgba(153, 102, 255, 0.2)", "rgba(201, 203, 207, 0.2)"],
                                                "borderColor": ["rgb(239, 83, 80)", "rgb(255, 159, 64)", "rgb(255, 178, 43)", "rgb(86, 192, 216)", "rgb(57, 139, 247)", "rgb(153, 102, 255)", "rgb(201, 203, 207)"],
                                                "borderWidth": 1}
                                        ]},
                                    "options": {
                                        "scales": {"yAxes": [{"ticks": {"beginAtZero": true}}]}
                                    }
                                });
                    }
                });

            });

        </script>


    </body>

</html>