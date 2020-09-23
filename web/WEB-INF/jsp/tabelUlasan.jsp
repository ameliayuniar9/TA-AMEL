<%-- 
    Document   : tabelUlasan
    Created on : Jul 7, 2019, 12:45:44 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" a href="js/validation/css/validationEngine.jquery.css">
<script type="text/javascript" src="js/validation/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="js/validation/jquery.validationEngine.js"></script>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Tabel Ulasan</title>

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
            width: 50%;
            border-collapse: collapse;
            border: 1px solid #f2f5f7;
            align-content: center;
        }

        .table1 tr th{
            background: #FF69B4;
            color: #fff;
            font-weight: normal;
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
                                <div class="header-btns-icon">
                                    <i class="fa fa-user-o"></i>
                                </div>
                                <c:url var="login" value="/index.htm"></c:url>
                                <a href="${login}" class="text-uppercase">LOGOUT</a>
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
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <c:url var="tambahDataUlasan" value="/doTambahDataUlasan.htm">        
    </c:url>
    <p align="center" style = "font-family:courier;"><u><a href="${tambahDataUlasan}">Tambah</a></u></p>
    <!--<div class="col-md-3 col-sm-6 col-xs-6">-->
    <form>
        <center><input class="searchNama" type="text" id="search" placeholder="Search berdasarkan Keterangan"/><br><br></center>
    </form>
    <table  align="center" class="table1" border="1">
        <thead><tr>
                <th>No</th> 
                <th>Kode Ulasan</th>            
                <th>Video</th>            
                <th>Keterangan</th>
                <th colspan="2">action</th>
            </tr></thead>
        <tbody>
            <c:set var="index" value="1"/>
            <c:forEach var="listUlasan" items="${listUlasanDto}">
                <c:url var="deleteUlasan" value="/deleteDataUlasan.htm">
                    <c:param name="kode_ulasan" value="${listUlasan.kode_ulasan}"/>
                </c:url>
                <c:url var="updateUlasan" value="/getDataUpdateUlasan.htm">
                    <c:param name="kode_ulasan" value="${listUlasan.kode_ulasan}"/>
                </c:url>
                <tr>  
                    <td>${index}</td>
                    <td>${listUlasan.kode_ulasan}</td>
                    <td><video controls width="200" height="200px">
                            <source src="b/img/video/${listUlasan.video}" type="video/mp4">
                        </video></td>
                    <td>${listUlasan.keterangan}</td>
                    <td><a href="${deleteUlasan}"><img src="./b/images/icons/icon hapus.png" alt="" width="20px" height="20px"></a></td>
                    <td><a href="${updateUlasan}"><img src="./b/images/icons/icon edit.png" alt="" width="20px" height="20px"></a></td>
                </tr>            
                <c:set var="index" value="${index+1}"/>
            </c:forEach>
        </tbody>
    </table>
    <!--</div>-->
</div>

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>

</html>