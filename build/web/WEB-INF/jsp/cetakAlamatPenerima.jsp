<%-- 
    Document   : tabelKategori
    Created on : Jul 7, 2019, 12:45:44 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Label Pengiriman Paket</title>

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
    <script>
        $(document).ready(function () {
            $("#print").click(function () {
                var mode = 'iframe'; //popup
                var close = mode == "popup";
                var options = {
                    mode: mode,
                    popClose: close
                };
                $("div.printableArea").printArea(options);
            });
        });
    </script>
    <script>
        function printContent(el) {
            var restorepage = document.body.innerHTML;
            var printcontent = document.getElementById(el).innerHTML;
            document.body.innerHTML = printcontent;
            window.print();
            document.body.innerHTML = restorepage;
        }
    </script>
    <style type="text/css">
        .searchNama{
            width: 130px;
            box-sizing: border-box;
            border: 2px solid #ccc;
            border-radius: 4px;
            font-size: 16px;
            background-color: white;
            background-image: url('./b/images/icons/search.png');
            background-position: 10px 10px; 
            background-repeat: no-repeat;
            background-size: 30px 30px;
            padding: 12px 20px 12px 40px;
            -webkit-transition: width 0.4s ease-in-out;
            transition: width 0.4s ease-in-out;
        }
        .searchNama:focus{
            width: 50%;
        }
        #tombol{
            padding: 15px 50px;
            background: red;
            color: white;
            display: table;
            transition: .3s ease-in;
        }
        #tombol:hover{
            background: black;
        }

        .table1 {
            font-family: sans-serif;
            color: #444;
            border-collapse: collapse;
            width: 50%;
            border: 1px solid #f2f5f7;
            margin-left:auto;margin-right:auto;
        }

        .table1 tr th{
            background: #FF69B4;
            color: #fff;
            font-weight: normal;
            width: 200px;
        }

        .table1, th, td {
            padding: 8px 20px;
            text-align: center;
        }

        .table1 tr:hover {
            background-color: #f5f5f5;
        }

        .table1 tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        #input1 {
            height: 20px;
            width: 200px;
            float: left;
        }
        #input2 {
            height: 30px;
            width: 200px;
            float: left;
        }
        #butcar{
            height: 30px;
            width: 100px;
            font-size: 15px;
            border-radius: 15px;
            background-color: greenyellow;
            vertical-align: bottom;
        }
        #butcar:hover{
            background-color: yellow;
        }
        .tengah{
            border:2px solid;
            width:500px;
            height: 250px;
            margin: 20px;
            margin-left:auto;
            margin-right:auto;
            margin-top:auto;
            margin-bottom:auto;
            left:0;
            right:0;
            top:0;
            bottom:0;
        }
    </style>

</head>

<body>
    <!-- HEADER -->
    <header>
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
                </div>
                <div class="pull-right">
                    <ul class="header-btns">
                        <!-- Account -->
                        <li class="header-account dropdown default-dropdown">
                                <div class="dropdown-toggle" role="button" data-toggle="dropdown" aria-expanded="true">
                                    
                                    <c:url var="login" value="/index.htm"></c:url>
                                    <a href="${login}" class="text-uppercase"><div class="header-btns-icon">
                                        <i class="fa fa-user-o"></i></div>
                                        <strong>LOGOUT</strong></a><br>
                                </div>      
                               
                            </li>
                        <!-- /Account -->

                        <!-- Cart -->
                        <li class="header-cart dropdown default-dropdown">
                            <div class="custom-menu">
                                <div id="shopping-cart">
                                    <div class="shopping-cart-list">
                                        <div class="product product-widget">
                                            <div class="product-thumb">
                                                <img src="./img/thumb-product01.jpg" alt="">
                                            </div>
                                            <div class="product-body">
                                                <h3 class="product-price">$32.50 <span class="qty">x3</span></h3>
                                                <h2 class="product-name"><a href="#">Product Name Goes Here</a></h2>
                                            </div>
                                            <button class="cancel-btn"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="product product-widget">
                                            <div class="product-thumb">
                                                <img src="./img/thumb-product01.jpg" alt="">
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
            <div id="responsive-nav">
                <!-- category nav -->
                <!--                <div class="category-nav show-on-click">
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
                        <li><a href="#">Laporan</a></li>
                    </ul>
                </div>
                <!-- menu nav -->
            </div>
        </div>
        <!-- /container -->
    </div>
    <!-- /NAVIGATION -->


    <!-- section -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /section -->

    <!-- FOOTER -->

    <!-- footer widget -->

    <!-- /footer widget -->

    <!-- footer subscribe -->
    <!--<div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">-->
                        <!--<div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">-->
                            
                          <div class="card card-body printableArea">
                              <div id="lap">
                                  <div class="tengah">
                                    <table align="center">
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td style="text-align: left;"></td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;font-family: sans-serif;">PENGIRIM</td>
                                            <td style="padding: 0px;font-family: sans-serif;">:</td>
                                            <td style="text-align: left; padding: 0px;font-family: sans-serif;">ITSMOSTLY</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;font-family: sans-serif;"></td>
                                            <td style="padding: 0px;font-family: sans-serif;"></td>
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">6285775996643,GANG H HAMBALI 1 N0 93B</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;"></td>
                                            <td></td>
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">KECAMATAN CICENDO,JAWA BARAT,BANDUNG</td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;font-family: sans-serif;">PENERIMA</td>
                                            <td style="padding: 0px;">:</td>
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;"><c:forEach var="listPenerima" items="${listPenerimaDto}">
                                                    ${listPenerima.nama_penerima}
                                                </td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;"></td>
                                            <td style="padding: 0px;"></td>
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">${listPenerima.no_telp},${listPenerima.alamat_lengkap}</td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;"></td>
                                            <td style="padding: 0px;"></td>
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">${listPenerima.kecamatan},${listPenerima.kabupaten},${listPenerima.provinsi}</td>
                                        </tr>
                                        </c:forEach>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td style="text-align: left;"></td>
                                        </tr>
                                        <tr>
                                            <td style="padding: 0px;font-family: sans-serif;">PRODUK</td>
                                            <td style="padding: 0px;">:</td><c:forEach var="listProduk" items="${listProdukDto}" begin = "0" end = "0">
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">${listProduk.nama_produk}&nbsp;&nbsp;&nbsp;${listProduk.kuantitas}</td>
                                        </tr>
                                        </c:forEach>
                                        
                                        <tr>
                                            <td style="padding: 0px;"</td>
                                            <td style="padding: 0px;"></td><c:forEach var="listProduk" items="${listProdukDto}" begin = "1">
                                            <td style="text-align: left;padding: 0px;font-family: sans-serif;">${listProduk.nama_produk}&nbsp;&nbsp;&nbsp;${listProduk.kuantitas}</td>
                                        </tr>
                                         </c:forEach>
                                        <tr>
                                            <td></td>
                                            <td></td>
                                            <td style="text-align: left;"></td>
                                        </tr>
                                    </table>

                                  </div>
                                </div>

                                <center><br><br><button id="print" class="btn btn-default btn-outline" type="button" onclick="printContent('lap')"> <span><i class="fa fa-print"></i> Print</span> </button></center>
                            </div>
<!--</div>-->
                    <!--</div>-->
    <!--</div>-->
<!--</div>-->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>

</html>

