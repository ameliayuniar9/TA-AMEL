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

    <title>Tambah Akun Admin</title>

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
            <div id="responsive-nav">
                <!-- category nav -->
<!--                <div class="category-nav show-on-click">
                    <span class="category-header">E-COMMERCE</span>
                </div>-->
                <!-- /category nav -->

                <!-- menu nav -->
              <c:url var="home" value="/menuOwner.htm"/>
                    <c:url var="admin" value="/tabelAdmin.htm"/>
                    <c:url var="produk" value="/tabelProdukForOwner.htm"/>
                    <c:url var="pengeluaran" value="/tabelPengeluaranForOwner.htm"/>
                    <div class="menu-nav">
                        <span class="menu-header">Menu <i class="fa fa-bars"></i></span>
                        <ul class="menu-list">
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="#"></a></li>
                            <li><a href="${home}">Home</a></li>
                            <li><a href="${admin}">Akun Admin</a></li>
                            <li><a href="${produk}">Data Produk</a></li>
                            <li><a href="${pengeluaran}">Data Pengeluaran</a></li>
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
    <!--<div class="col-md-3 col-sm-6 col-xs-6">-->
        
            <h3 align="center">UBAH DATA AKUN ADMIN</h3>
            <form:form id="adminUpdate" action="updateAdmin.htm" modelAttribute="adminDto" method="POST">
            <form:hidden path="id_login" value="${adminDto.id_login}" />
            <center><table>
                    <tr>
                        <td>NAMA LENGKAP</td>
                        <td>&nbsp;&nbsp;</td>
                        <td><div class="form-group">
                                <form:input path="nama_lengkap" class="input" value="${adminDto.nama_lengkap}"/>
                            </div></td>
                    </tr>
                    <tr>
                        <td>USERNAME</td>
                        <td>&nbsp;&nbsp;</td>
                        <td><div class="form-group">
                                <form:input path="username" class="input" value="${adminDto.username}"/>
                            </div></td>
                    </tr>
                    <tr>
                        <td>PASSWORD</td>
                        <td>&nbsp;&nbsp;</td>
                        <td><div class="form-group">
                                <form:input path="password" class="input" value="${adminDto.password}"/>
                            </div></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="3">
                            <form:button class="primary-btn" type="submit"><b>SIMPAN DATA</b></form:button>
                        </td>
                    </tr>
                </form:form>
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
