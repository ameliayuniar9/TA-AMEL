<%-- 
    Document   : detailProduk
    Created on : Aug 30, 2019, 9:34:32 AM
    Author     : HP
--%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Product Detail</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--===============================================================================================-->	
        <link rel="icon" type="image/png" href="b/images/icons/favicon.png"/>
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/fonts/linearicons-v1.0.0/icon-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/animate/animate.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="b/vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/select2/select2.min.css">
        <!--===============================================================================================-->	
        <link rel="stylesheet" type="text/css" href="b/vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/slick/slick.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/MagnificPopup/magnific-popup.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/vendor/perfect-scrollbar/perfect-scrollbar.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="b/css/util.css">
        <link rel="stylesheet" type="text/css" href="b/css/main.css">
        <!--===============================================================================================-->
    </head>
    <body class="animsition">

        <!-- Header -->
        <header class="header-v4">
            <!-- Header desktop -->
            <div class="container-menu-desktop">
                <!-- Topbar -->
                <div class="top-bar">
                    <div class="content-topbar flex-sb-m h-full container">
                        <div class="left-top-bar">
                            Selamat datang di Mostly Hijab. Selamat Berbelanja
                        </div>

                        <div class="right-top-bar flex-w h-full">
                            <c:url var="logout" value="/index.htm"></c:url>
                            <a href="${logout}" class="flex-c-m trans-04 p-lr-25">
                                LOGOUT
                            </a>
                        </div>
                    </div>
                </div>

                <div class="wrap-menu-desktop how-shadow1">
                    <nav class="limiter-menu-desktop container">

                        <!-- Logo desktop -->		
                        <a href="#" class="logo">
                            <img src="./a/img/logo mostly.png" alt="IMG-LOGO">
                        </a>

                        <!-- Menu desktop -->
                       <c:url var="home" value="/home.htm"/>
                        <c:url var="produk" value="/menuBaru.htm"/>
                        <c:url var="tentang" value="/tentang.htm"/>
                        <c:url var="kontak" value="/kontak.htm"/>
                        <c:url var="billings" value="/pesananPembeli.htm"/>
                        <!-- Menu desktop -->
                        <div class="menu-desktop">
                            <ul class="main-menu">
                                <li>
                                    <a href="blog.html"></a>
                                </li>
                                <li>
                                    <a href="blog.html"></a>
                                </li>
                                <li>
                                    <a href="blog.html"></a>
                                </li>
                                <li>
                                    <a href="${home}">Home</a>
                                </li>
                                <li>
                                    <a href="${produk}">Belanja</a>
                                </li>
                                <li>
                                    <a href="${tentang}">Tentang</a>
                                </li>

                                <li>
                                    <a href="#">Kontak</a>
                                    <ul class="sub-menu">
                                        <li><a href="https:wa.me/6285892166671" target="_blank"><image src="./b/images/icons/wa.png" width="30px" height="30px"> P. Jawa</a></li>
                                        <li><a href="https:wa.me/6285871109169" target="_blank"><image src="./b/images/icons/wa.png" width="30px" height="30px"> Luar P. Jawa</a>
                                    </ul>
                                </li>
                                <li>
                                    <a href="${billings}">Pesanan</a>
                                </li>
                            </ul>
                        </div>		

                        <!-- Icon header -->
                        <div class="wrap-icon-header flex-w flex-r-m">
                            <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 js-show-modal-search">
                                <i class="zmdi zmdi-search"></i>
                            </div>

                            <c:set var="listCart" value="${listCartDto}"/>
                            <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="${listCart.size()}">
                                <i class="zmdi zmdi-shopping-cart"></i>
                            </div>
                        </div>
                    </nav>
                </div>	
            </div>

            <!-- Header Mobile -->
            <div class="wrap-header-mobile">
                <!-- Logo moblie -->		
                <div class="logo-mobile">
                    <a href="index.html"><img src="images/icons/logo-01.png" alt="IMG-LOGO"></a>
                </div>

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>

                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti js-show-cart" data-notify="2">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </div>

                    <a href="#" class="dis-block icon-header-item cl2 hov-cl1 trans-04 p-r-11 p-l-10 icon-header-noti" data-notify="0">
                        <i class="zmdi zmdi-favorite-outline"></i>
                    </a>
                </div>

                <!-- Button show menu -->
                <div class="btn-show-menu-mobile hamburger hamburger--squeeze">
                    <span class="hamburger-box">
                        <span class="hamburger-inner"></span>
                    </span>
                </div>
            </div>


            <!-- Menu Mobile -->
            <div class="menu-mobile">
                <ul class="topbar-mobile">
                    <li>
                        <div class="left-top-bar">
                            Free shipping for standard order over $100
                        </div>
                    </li>

                    <li>
                        <div class="right-top-bar flex-w h-full">
                            <a href="#" class="flex-c-m p-lr-10 trans-04">
                                Help & FAQs
                            </a>

                            <a href="#" class="flex-c-m p-lr-10 trans-04">
                                My Account
                            </a>

                            <a href="#" class="flex-c-m p-lr-10 trans-04">
                                EN
                            </a>
                            <c:url var="logout" value="/index.htm"></c:url>
                            <a href="${logout}" class="flex-c-m trans-04 p-lr-25">
                                LOGOUT
                            </a>
                        </div>
                    </li>
                </ul>

                <ul class="main-menu-m">
                    <li>
                        <a href="index.html">Home</a>
                        <ul class="sub-menu-m">
                            <li><a href="index.html">Homepage 1</a></li>
                            <li><a href="home-02.html">Homepage 2</a></li>
                            <li><a href="home-03.html">Homepage 3</a></li>
                        </ul>
                        <span class="arrow-main-menu-m">
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                        </span>
                    </li>

                    <li>
                        <a href="product.html">Shop</a>
                    </li>

                    <li>
                        <a href="shoping-cart.html" class="label1 rs1" data-label1="hot">Features</a>
                    </li>

                    <li>
                        <a href="blog.html">Blog</a>
                    </li>

                    <li>
                        <a href="about.html">About</a>
                    </li>

                    <li>
                        <a href="contact.html">Contact</a>
                    </li>
                </ul>
            </div>

            <!-- Modal Search -->
            <div class="modal-search-header flex-c-m trans-04 js-hide-modal-search">
                <div class="container-search-header">
                    <button class="flex-c-m btn-hide-modal-search trans-04 js-hide-modal-search">
                        <img src="b/images/icons/icon-close2.png" alt="CLOSE">
                    </button>

                    <form class="wrap-search-header flex-w p-l-15">
                        <button class="flex-c-m trans-04">
                            <i class="zmdi zmdi-search"></i>
                        </button>
                        <input class="plh3" type="text" name="search" placeholder="Search...">
                    </form>
                </div>
            </div>
        </header>

        <!-- Cart -->
        <div class="wrap-header-cart js-panel-cart">
            <div class="s-full js-hide-cart"></div>

            <div class="header-cart flex-col-l p-l-65 p-r-25">
                <div class="header-cart-title flex-w flex-sb-m p-b-8">
                    <span class="mtext-103 cl2">
                        Your Cart
                    </span>

                    <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
                        <i class="zmdi zmdi-close"></i>
                    </div>
                </div>

                <c:set var="total" value="${0}"></c:set>
                    <div class="header-cart-content flex-w js-pscroll">
                        <ul class="header-cart-wrapitem w-full">
                        <c:forEach var="cart" items="${listCartDto}">
                            <li class="header-cart-item flex-w flex-t m-b-12">
                                <div class="header-cart-item-img">
                                    <img src="b/img/${cart.gambar}" alt="IMG">
                                </div>

                                <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                        ${cart.nama_produk}
                                    </a>

                                    <span class="header-cart-item-info">
                                        ${cart.kuantitas} x Rp. <fmt:formatNumber type="number" groupingUsed="true" value="${cart.harga_jual}"/>
                                    </span>
                                    <c:set var="jml" value="${cart.kuantitas*cart.harga_jual}"></c:set>
                                    <c:set var="total" value="${total+jml}"></c:set>
                                    </div>
                                </li>
                        </c:forEach>
                    </ul>

                    <div class="w-full">
                        <div class="header-cart-total w-full p-tb-40">
                            Total : Rp.<fmt:formatNumber type="number" groupingUsed="true" value="${total}" />
                        </div>
                        <c:url var="detailCart" value="/detailKeranjang.htm"></c:url>
                            <div class="header-cart-buttons flex-w w-full">
                                <a href="${detailCart}" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
                                View Cart
                            </a>

                            <a href="shoping-cart.html" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-b-10">
                                Check Out
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- breadcrumb -->
        <div class="container">
            <div class="bread-crumb flex-w p-l-25 p-r-15 p-t-30 p-lr-0-lg">
                <a href="index.html" class="stext-109 cl8 hov-cl1 trans-04">
                    Home
                    <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
                </a>

                <a href="product.html" class="stext-109 cl8 hov-cl1 trans-04">
                    Men
                    <i class="fa fa-angle-right m-l-9 m-r-10" aria-hidden="true"></i>
                </a>
                <c:set var="prod" value="${produkDto}"/>
                <span class="stext-109 cl4">
                    <c:out value="${prod.nama_produk}"/>
                </span>

            </div>
        </div>
        <c:set var="produk" value="${detailDto}"/>

        <!-- Product Detail -->
        <section class="sec-product-detail bg0 p-t-65 p-b-60">
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-lg-7 p-b-30">
                        <div class="p-l-25 p-r-30 p-lr-0-lg">
                            <div class="wrap-slick3 flex-sb flex-w">
                                <div class="wrap-slick3-dots"></div>
                                <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>
                                        <div class="wrap-pic-w pos-relative">
                                            <img src="b/img/<c:out value='${produk.gambar}'/>" alt="IMG-PRODUCT">

                                            <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="b/img/<c:out value='${produk.gambar}'/>">
                                                <i class="fa fa-expand"></i>
                                            </a>
                                        </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-6 col-lg-5 p-b-30"> 
                        <div class="p-r-50 p-t-5 p-lr-0-lg">
                            <h4 class="mtext-105 cl2 js-name-detail p-b-14">
                                <c:out value="${produk.nama_produk}"/>
                            </h4>

                            <span class="mtext-106 cl2">
                                Rp <c:out value="${produk.harga_jual}"/>
                            </span>

                            <p class="stext-102 cl3 p-t-23">
                                <c:out value="${produk.keterangan_produk}"/>
                            </p>

                            <!--  -->
                            <div class="p-t-33">
                                <div class="flex-w flex-r-m p-b-10">
                                    <div class="size-203 flex-c-m respon6">
                                        Stok
                                    </div>

                                    <div class="size-204 respon6-next">
                                        <c:out value="${produk.stok}"/>
                                    </div>
                                </div>

                                <div class="flex-w flex-r-m p-b-10">
                                    <div class="size-203 flex-c-m respon6">
                                        Warna
                                    </div>

                                    <div class="size-204 respon6-next">
                                        <c:out value="${produk.warna}"/>
                                    </div>
                                </div>

                                <div class="flex-w flex-r-m p-b-10">
                                    <div class="size-204 flex-w flex-m respon6-next">
                                        <div class="wrap-num-product flex-w m-r-20 m-tb-10">


                                            <form:form id="keranjang" action="saveKeranjang.htm" modelAttribute="cartDto"  method="POST">
                                                <form:input type="number" path="kuantitas" class="input"/>

                                            </div>


                                            <form:button class="flex-c-m stext-101 cl0 size-101 bg1 bor1 hov-btn1 p-lr-15 trans-04 js-addcart-detail">
                                                Tambah ke Keranjang
                                            </form:button>
                                        </form:form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>

        <!-- Footer -->
        <footer class="bg3 p-t-75 p-b-32">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-lg-3 p-b-50">
                        <h4 class="stext-301 cl0 p-b-30">
                            Mostly Official
                        </h4>

                        <p class="stext-107 cl7 size-201">
                            YOUR MOST LOVELY HIJAB✨ <br>
                            ------ <br>
                            📍 BANDUNG <br>
                            📱WA 085892166671 ( P. JAWA ) <br>
                            📱WA 085871109169 ( LUAR P. JAWA& INTERNASIONAL )<br>
                            SHOPEE : MostlyOfficial <br>
                            or click👇🏻 <br>
                            <a href="https://l.instagram.com/?u=https%3A%2F%2Flinktr.ee%2FItsmostly&e=ATMR9MRX7Esrh2ifdimIcEwzEr6EYHRRJbz5CQuth9MknuyEN67JUldb1K2oNYe-3S_BoBt5iS9eH4sbXFT7jQ&s=1" target="_blank">
                                linktr.ee/Itsmostly
                            </a>
                        </p>
                    </div>
                    <div class="col-sm-6 col-lg-3 p-b-50">
                        <h4 class="stext-301 cl0 p-b-30">
                            MOSTLY OFFICIAL
                        </h4>

                        <p class="stext-107 cl7 size-201">
                            Mostly Official merupakan akun resmi dari Mostly yang berafiliasi dengan platform Shopee.
                            Disini kami menyediakan beragam pilihan hijab mulai dari pashmina,  Hijab Square, Inner,
                            dan Accecories yang up-to-date dengan kualitas terbaik untuk Mostlies semua✨
                            Pengiriman dilakukan setiap hari kerja. <br>

                        </p>
                    </div>
                    <div class="col-sm-6 col-lg-3 p-b-50">
                        <h4 class="stext-301 cl0 p-b-30">

                        </h4>
                        <br>

                        <ul class="stext-107 cl7 size-201">
                            - Silakan pilih warna langsung dari variasi &nbsp;&nbsp;&nbsp;pilihan <br>
                            - Request warna via chat/komentar/ &nbsp;&nbsp;&nbsp;catatan pembeli tidak akan kami &nbsp;&nbsp;&nbsp;terima<br>
                            - Komplain mengenai kesalahan warna
                        </ul>

                    </div>
                    <div class="col-sm-6 col-lg-3 p-b-50">
                        <h4 class="stext-301 cl0 p-b-30">
                            JAM OPERASIONAL
                        </h4>

                        <p class="stext-107 cl7 size-201">
                            Senin - Sabtu 10.00 - 15.00 WIB
                        </p>
                    </div>
                </div>
            </div>
        </footer>

        <!-- Back to top -->
        <div class="btn-back-to-top" id="myBtn">
            <span class="symbol-btn-back-to-top">
                <i class="zmdi zmdi-chevron-up"></i>
            </span>
        </div>

        <!-- Modal1 -->
        <div class="wrap-modal1 js-modal1 p-t-60 p-b-20">
            <div class="overlay-modal1 js-hide-modal1"></div>

            <div class="container">
                <div class="bg0 p-t-60 p-b-30 p-lr-15-lg how-pos3-parent">
                    <button class="how-pos3 hov3 trans-04 js-hide-modal1">
                        <img src="b/images/icons/icon-close.png" alt="CLOSE">
                    </button>

                    <div class="row">
                        <div class="col-md-6 col-lg-7 p-b-30">
                            <div class="p-l-25 p-r-30 p-lr-0-lg">
                                <div class="wrap-slick3 flex-sb flex-w">
                                    <div class="wrap-slick3-dots"></div>
                                    <div class="wrap-slick3-arrows flex-sb-m flex-w"></div>

                                    <div class="slick3 gallery-lb">
                                        <div class="item-slick3" data-thumb="b/images/product-detail-01.jpg">
                                            <div class="wrap-pic-w pos-relative">
                                                <img src="b/images/product-detail-01.jpg" alt="IMG-PRODUCT">

                                                <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/product-detail-01.jpg">
                                                    <i class="fa fa-expand"></i>
                                                </a>
                                            </div>
                                        </div>

                                        <div class="item-slick3" data-thumb="b/images/product-detail-02.jpg">
                                            <div class="wrap-pic-w pos-relative">
                                                <img src="b/images/product-detail-02.jpg" alt="IMG-PRODUCT">

                                                <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="images/product-detail-02.jpg">
                                                    <i class="fa fa-expand"></i>
                                                </a>
                                            </div>
                                        </div>

                                        <div class="item-slick3" data-thumb="b/images/product-detail-03.jpg">
                                            <div class="wrap-pic-w pos-relative">
                                                <img src="b/images/product-detail-03.jpg" alt="IMG-PRODUCT">

                                                <a class="flex-c-m size-108 how-pos1 bor0 fs-16 cl10 bg0 hov-btn3 trans-04" href="b/images/product-detail-03.jpg">
                                                    <i class="fa fa-expand"></i>
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!--===============================================================================================-->	
        <script src="b/vendor/jquery/jquery-3.2.1.min.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/animsition/js/animsition.min.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/bootstrap/js/popper.js"></script>
        <script src="b/vendor/bootstrap/js/bootstrap.min.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/select2/select2.min.js"></script>
        <script>
            $(".js-select2").each(function () {
                $(this).select2({
                    minimumResultsForSearch: 20,
                    dropdownParent: $(this).next('.dropDownSelect2')
                });
            })
        </script>
        <!--===============================================================================================-->
        <script src="b/vendor/daterangepicker/moment.min.js"></script>
        <script src="b/vendor/daterangepicker/daterangepicker.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/slick/slick.min.js"></script>
        <script src="b/js/slick-custom.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/parallax100/parallax100.js"></script>
        <script>
            $('.parallax100').parallax100();
        </script>
        <!--===============================================================================================-->
        <script src="b/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
        <script>
            $('.gallery-lb').each(function () { // the containers for all your galleries
                $(this).magnificPopup({
                    delegate: 'a', // the selector for gallery item
                    type: 'image',
                    gallery: {
                        enabled: true
                    },
                    mainClass: 'mfp-fade'
                });
            });
        </script>
        <!--===============================================================================================-->
        <script src="b/vendor/isotope/isotope.pkgd.min.js"></script>
        <!--===============================================================================================-->
        <script src="b/vendor/sweetalert/sweetalert.min.js"></script>
        <script>
            $('.js-addwish-b2, .js-addwish-detail').on('click', function (e) {
                e.preventDefault();
            });

            $('.js-addwish-b2').each(function () {
                var nameProduct = $(this).parent().parent().find('.js-name-b2').html();
                $(this).on('click', function () {
                    swal(nameProduct, "is added to wishlist !", "success");

                    $(this).addClass('js-addedwish-b2');
                    $(this).off('click');
                });
            });

            $('.js-addwish-detail').each(function () {
                var nameProduct = $(this).parent().parent().parent().find('.js-name-detail').html();

                $(this).on('click', function () {
                    swal(nameProduct, "is added to wishlist !", "success");

                    $(this).addClass('js-addedwish-detail');
                    $(this).off('click');
                });
            });

            /*---------------------------------------------*/

            $('.js-addcart-detail').each(function () {
                var nameProduct = $(this).parent().parent().parent().parent().find('.js-name-detail').html();
                $(this).on('click', function () {
                    swal(nameProduct, "berhasil ditambahkan !", "success");
                });
            });

        </script>
        <!--===============================================================================================-->
        <script src="b/vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
        <script>
            $('.js-pscroll').each(function () {
                $(this).css('position', 'relative');
                $(this).css('overflow', 'hidden');
                var ps = new PerfectScrollbar(this, {
                    wheelSpeed: 1,
                    scrollingThreshold: 1000,
                    wheelPropagation: false,
                });

                $(window).on('resize', function () {
                    ps.update();
                })
            });
        </script>
        <!--===============================================================================================-->
        <script src="b/js/main.js"></script>

    </body>
</html>
