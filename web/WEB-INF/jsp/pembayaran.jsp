<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Home</title>
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
        <style type="text/css">
            .table1 {
    font-family: sans-serif;
    color: #444;
    border-collapse: collapse;
    width: 50%;
    height: 50%;
    border: 1px solid #f2f5f7;
}
 
.table1 tr th{
    background: #FF69B4;
    color: #fff;
    font-weight: normal;
}
 
.table1, th, td {
    padding: 30px 20px;
}
 
.table1 tr:hover {
    background-color: #f5f5f5;
}
 
.table1 tr:nth-child(even) {
    background-color: #f2f2f2;
}
        </style>
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
                    <a href="index.html"><img src="./a/img/logo mostly.png" alt="IMG-LOGO"></a>
                </div>

                <!-- Icon header -->
                <div class="wrap-icon-header flex-w flex-r-m m-r-15">
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-r-11 js-show-modal-search">
                        <i class="zmdi zmdi-search"></i>
                    </div>

                    <c:set var="listCart" value="${listCartDto}"/>
                    <div class="icon-header-item cl2 hov-cl1 trans-04 p-l-22 p-r-11 icon-header-noti js-show-cart" data-notify="${listCart.size()}">
                        <i class="zmdi zmdi-shopping-cart"></i>
                    </div>
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
                            Selamat datang di Mostly Hijab. Selamat Berbelanja
                        </div>
                    </li>

                    <li>
                        <div class="right-top-bar flex-w h-full">
                            <c:url var="logout" value="/index.htm"></c:url>
                            <a href="${logout}" class="flex-c-m trans-04 p-lr-25">
                                LOGOUT
                            </a>
                        </div>
                    </li>
                </ul>

                <c:url var="home" value="/home.htm"/>
                <c:url var="produk" value="/menuBaru.htm"/>
                <c:url var="tentang" value="/tentang.htm"/>
                <c:url var="kontak" value="/kontak.htm"/>
                <ul class="main-menu-m">
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
                        <a href="${kontak}">Kontak</a>
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
                        Keranjang
                    </span>

                    <div class="fs-35 lh-10 cl2 p-lr-5 pointer hov-cl1 trans-04 js-hide-cart">
                        <i class="zmdi zmdi-close"></i>
                    </div>
                </div>

                <c:set var="total" value="${0}"></c:set>
                    <div class="header-cart-content flex-w js-pscroll">
                        <ul class="header-cart-wrapitem w-full">
                        <c:forEach var="listCart" items="${listCartDto}">
                            <li class="header-cart-item flex-w flex-t m-b-12">
                                <div class="header-cart-item-img">
                                    <img src="b/img/${listCart.gambar}" alt="IMG">
                                </div>

                                <div class="header-cart-item-txt p-t-8">
                                    <a href="#" class="header-cart-item-name m-b-18 hov-cl1 trans-04">
                                        ${listCart.nama_produk}
                                    </a>

                                    <span class="header-cart-item-info">
                                        ${listCart.kuantitas} x <fmt:formatNumber type="number" groupingUsed="true" value="${listCart.harga_jual}" />
                                    </span>
                                    <c:set var="jml" value="${listCart.kuantitas*listCart.harga_jual}"></c:set>
                                    <c:set var="total" value="${total+jml}"></c:set>
                                    </div>
                                </li>
                        </c:forEach>
                    </ul>

                    <div class="w-full">
                        <div class="header-cart-total w-full p-tb-40">
                            Total : Rp.<fmt:formatNumber type="number" groupingUsed="true" value="${total}"/>

                        </div>
                        <c:url var="detailCart" value="/detailKeranjang.htm"></c:url>
                            <div class="header-cart-buttons flex-w w-full">
                                <a href="${detailCart}" class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10">
                                Lihat Keranjang
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <!-- Title page -->
        <section class="bg-img1 txt-center p-lr-15 p-tb-92" style="background-image: url('b/images/bg-02.jpg');">
            <h2 class="ltext-105 cl0 txt-center">
                Pembayaran
            </h2>
        </section>	


        <!-- Content page -->
        <section class="bg0 p-t-75 p-b-120">
            <!--<div class="container">-->
                <!--<div class="row p-b-148">-->
                    <!--<div class="col-md-7 col-lg-8">-->
                        <!--<div class="p-t-7 p-r-85 p-r-15-lg p-r-0-md">-->
                            <center/> <h3 class="mtext-111 cl2 p-b-16">
                                Pembayaran Pesanan
                            </h3>


                            <form:form id="pesanan" action="updatePesanan.htm" modelAttribute="pesananDto" method="POST" enctype="multipart/form-data">
                                <center><form:hidden path="kode_pesanan" value="${pesananDto.kode_pesanan}"></form:hidden></center>
                                    <form:hidden path="id_pembeli" value="${pesananDto.id_pembeli}"></form:hidden>
                                    <form:hidden path="total_pesanan" value="${pesananDto.total_pesanan}"></form:hidden>
                                    <form:hidden path="tanggal_pesan" value="${pesananDto.tanggal_pesan}"></form:hidden>
                                    <form:hidden path="status" value="${pesananDto.status}"></form:hidden>
                                    <form:hidden path="id_penerima" value="${pesananDto.id_penerima}"></form:hidden>
                                        <table  class="table1">
                                            <tr>
                                                <th colspan="3" style="text-align:center;">KONFIRMASI PEMBAYARAN KODE PESANAN : ${pesananDto.kode_pesanan}</th>
                                            </tr>
                                            <tr>
                                                <td style="text-align:center;">TOTAL PESANAN</td>
                                                <td>:</td>
                                                <td>${pesananDto.total_pesanan}</td>
                                            </tr>
                                            <tr>
                                                <td style="text-align:center;">BUKTI TRANSFER</td>
                                                <td>:</td>
                                                <td><div class="form-group">
                                                    <form:input type="file" path="file" id="input-file-now" class="dropify"  name="file" />
                                                </div></td>
                                            </tr>
                                            <tr>
                                                <td colspan="3">
                                                <center/><form:button class="flex-c-m stext-101 cl0 size-107 bg3 bor2 hov-btn3 p-lr-15 trans-04 m-r-8 m-b-10" type="submit"><b>SIMPAN DATA</b></form:button>
                                            </td>
                                            </tr></table>
                                    </form:form>
                        <!--</div>-->
                    <!--</div>-->
                <!--</div>-->
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
        <script src="b/vendor/MagnificPopup/jquery.magnific-popup.min.js"></script>
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