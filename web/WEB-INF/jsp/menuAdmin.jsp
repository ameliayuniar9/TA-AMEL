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

        <title>Home</title>


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

                                    <c:url var="login" value="/index.htm"></c:url>
                                    <a href="${login}" class="text-uppercase"><div class="header-btns-icon">
                                            <i class="fa fa-user-o"></i>
                                        </div><strong>LOGOUT</strong></a><br>

                                </div>
                                <div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true"><br>
                                </div>

                                <c:url var="changePassword" value="/getDataUpdateLogin.htm">
                                    <c:param name="id_login" value="${id_login}"/>
                                </c:url>
                                <br><a href="${changePassword}" style="color:blue">Change password</a>



                            </li>
                            <!-- /Account -->


                            <!-- Cart -->

                            <!-- /Cart -->

                            <!-- Mobile nav toggle-->

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
                    <!-- category nav -->
                    <!--                    <div class="category-nav">
                                            <span class="category-header">E-COMMERCE</span>
                                        </div>-->
                    <!-- /category nav -->

                    <!-- menu nav -->
                    <c:url var="home" value="/menuAdmin.htm"/>
                    <c:url var="produk" value="/tabelProduk.htm"/>
                    <c:url var="kategori" value="/tabelKategori.htm"/>
                    <c:url var="detail" value="/tabelDetail.htm"/>
                    <c:url var="pembeli" value="/tabelPembeli.htm"/>
                    <c:url var="ongkir" value="/tabelOngkir.htm"/>
                    <c:url var="ulasan" value="/tabelUlasan.htm"/>
                    <c:url var="pesanan" value="/tabelPesanan.htm"/>
                    <c:url var="akun" value="/tabelAkun.htm"/>
                    <c:url var="pengeluaran" value="/tabelPengeluaran.htm"/>
                    <c:url var="laporan" value="/doSelectTahunLaporan.htm"/>
                    <div class="menu-nav">
                        <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                        <ul class="menu-list">
                            <li><a href="${home}">Home</a></li>
                            <li><a href="${kategori}">Kategori</a></li>
                            <li><a href="${produk}">Produk</a></li>
                            <li><a href="${detail}">DetailProduk</a></li>
                            <li><a href="${pembeli}">Pembeli</a></li>
                            <li><a href="${ongkir}">Ongkir</a></li>
                            <li><a href="${ulasan}">Ulasan</a></li>
                            <li><a href="${pesanan}">Pesanan</a></li>
                            <li><a href="${akun}">Akun</a></li>
                            <li><a href="${pengeluaran}">Pengeluaran</a></li>
                            <li><a href="${laporan}">Laporan</a>
                            </li>
                        </ul>
                    </div>
                    <!-- menu nav -->
                </div>
            </div>
            <!-- /container -->
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
                            <c:forEach var="listPesanan" items="${listPesananDto}">                   
                                <c:set var="indexCek" value="${indexCek+1}"/>
                            </c:forEach>
                            <c:if test = "${indexCek >0}">
                                <div class="alert alert-info">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                                    <h3 class="text-info"><i class="fa fa-exclamation-circle"></i> Information</h3> ${indexCek} Permintaan Confirm Pembayaran Baru
                                </div>
                            </c:if>
                            <br><br>
                        </div>
                            <div class="col-md-9 pl-5">
                                <div class="ml-5">
                                    <canvas id="chart2" height="150" ></canvas>
                                </div>
                            </div>
                    <!--</div>-->
                    <!-- /banner -->
                <!--</div>-->
                <!-- /home slick -->
            </div>
            <!-- /home wrap -->
        </div>
        <!-- /container -->
   
    <!-- /HOME -->

    <!-- jQuery Plugins -->
    <!--        <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <script src="js/slick.min.js"></script>
            <script src="js/nouislider.min.js"></script>
            <script src="js/jquery.zoom.min.js"></script>
            <script src="js/main.js"></script>-->

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