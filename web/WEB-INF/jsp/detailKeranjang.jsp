<%-- 
    Document   : detailProduk
    Created on : Aug 30, 2019, 9:34:32 AM
    Author     : HP
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<script type="text/javascript">
    // Get the checkboxs
    
    function getCheckbox() {
        var checkBox = document.getElementById("myCheck");
        var label = document.getElementById("myTotal");
        // Get the output text


        // If the checkbox is checked, display the output text
        if (checkBox.checked == true) {
            label.value = "GHHGH";
        }
    }

    var kodeCartList = [];
    var kodeDetailList =[];
    var jumlahBelanjaList =[];
    var totalHarga = [];
    var tamp = 0;
    var xxx;
    var yyy;
    var zzz;
    var vvv;
    var beratbarang=0;
    var ongkosKirim=0;
   
    function getKodeCart(kode_cart, total,kode_detail,jumlah_belanja,berat,kuantitas) {
        var xD= document.getElementById("ongkirz");
        var xD1= document.getElementById("ongkirz1");
        var CD= document.getElementById("a123");
        var yy= document.getElementById("beratBarangz");
        var checkBox = document.getElementById(kode_cart);
        var label = document.getElementById("myTotal");
        var labelPs = document.getElementById("totalPesanan");
        var kodeChart = document.getElementById("kodeCharts");
        var kodeDetail= document.getElementById("kode_details");
        var jumlahBelanja= document.getElementById("jumlahbelanjas");
        var harga= document.getElementById("hargas");
        if (checkBox.checked == true) {
            if (kodeCartList.length == 0)
                kodeCartList[0] = kode_cart;
            else
                kodeCartList[kodeCartList.length] = kode_cart;
            if (totalHarga.length == 0) {
                totalHarga[0] = total.toString();
            } else
                totalHarga[totalHarga.length] = total.toString();
            if (kodeDetailList.length == 0) {
                kodeDetailList[0] = kode_detail;
            } else
                kodeDetailList[kodeDetailList.length] = kode_detail;
            if (jumlahBelanjaList.length == 0) {
                jumlahBelanjaList[0] = jumlah_belanja;
            } else
                jumlahBelanjaList[jumlahBelanjaList.length] = jumlah_belanja;
            tamp += total;
            beratbarang+=(berat*kuantitas);
        } else {
            for (let i = 0; i < kodeCartList.length; i++) {
                if (kodeCartList[i] == kode_cart) {
                    tamp -= total;
                    kodeDetailList.splice(i, 1);
                    kodeCartList.splice(i, 1);
                    jumlahBelanjaList.splice(i, 1);
                    totalHarga.splice(i, 1);
                    beratbarang-=(berat*kuantitas);
                }
            }
            
        }
        
        console.log("berat barang "+berat+"ass "+kuantitas);
        vvv=totalHarga.toString();
        xxx=kodeCartList.toString();
        yyy=kodeDetailList.toString();
        zzz=jumlahBelanjaList.toString();
        label.value = tamp;
        labelPs.value = tamp;
        kodeChart.value = xxx;
        kodeDetail.value = yyy;
        jumlahBelanja.value = zzz;
        var barangberat=(beratbarang/1000).toFixed(0);
        harga.value=vvv*barangberat;
        
        console.log("berat barang  "+barangberat);
        
        console.log("ongkir "+ongkosKirim);
        CD.value=barangberat*ongkosKirim;
        console.log(CD.value);
        xD1.value=CD.value.toString();
        yy.value=barangberat;
        var z= document.getElementById("z");
        var y= document.getElementById("hargaBarangz").value;
        z.value=parseInt(xD.value)+parseInt(y);
        return kodeCartList;
    }
    var accept=false;
    function getAlamat(id_penerima,ongkir,berat) {
        if(ongkir!=0 && ongkir!=-1){
            ongkosKirim=ongkir;
        }
        var xD= document.getElementById("ongkirz");
        var xD1= document.getElementById("ongkirz1");
        console.log("getAlamat"+ongkosKirim);
        document.getElementById("id_penerima").value = id_penerima;
        var y= document.getElementById("hargaBarangz");
        var z= document.getElementById("z");
        var labelPs = document.getElementById("totalPesanan");
        var barangberat=(beratbarang/1000).toFixed(0);
        xD.value=ongkosKirim*barangberat;
        y.value=tamp;
        
        z.value=parseInt(tamp)+parseInt(xD.value);
        labelPs.value=tamp+ongkir;
    }
</script>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Detail Cart</title>
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
                        Keranjang
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
                        <input tytype="label" id="a123" hidden/>
                    <div class="w-full">
                        <div class="header-cart-total w-full p-tb-40">
                            Total : Rp.<fmt:formatNumber type="number" groupingUsed="true" value="${total}" />
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

        <!-- Shoping Cart -->
        <form class="bg0 p-t-75 p-b-85">
            <div class="container">
                <div class="row">
                    <c:set var="total1" value="${0}"></c:set>
                        <div class="col-lg-10 col-xl-7 m-lr-auto m-b-50">
                            <div class="m-l-25 m-r--38 m-lr-0-xl">
                                <div class="wrap-table-shopping-cart">
                                    <table class="table-shopping-cart">
                                        <tr class="table_head">
                                            <th class="column-1"></th>
                                            <th class="column-2">Produk</th>
                                            <th class="column-3"></th>
                                            <th class="column-4">Harga</th>
                                            <th class="column-5">Kuantitas</th>
                                            <th class="column-5">Total</th>
                                        </tr>
                                    <c:set var="totalCart" value="${0}"></c:set>
                                    <c:forEach var="listCart" items="${listCartDto}">
                                        <tr class="table_row">
                                            <c:set var="jumlah" value="${listCart.kuantitas*listCart.harga_jual}"></c:set>

                                                <td class="column-1">
                                                    <input type="checkbox" class="input" id="${listCart.kode_cart}" onclick="getKodeCart('${listCart.kode_cart}',${listCart.kuantitas*listCart.harga_jual},'${listCart.kode_detail}','${listCart.kuantitas}',${listCart.berat},${listCart.kuantitas});getAlamat(value,0,${listCart.berat});"/>
                                            </td>
                                            <td class="column-2">
                                                <div class="how-itemcart1">
                                                    <img src="b/img/${listCart.gambar}" alt="IMG">
                                                </div>
                                            </td>
                                            <td class="column-3">${listCart.nama_produk}</td>
                                            <td class="column-4"><fmt:formatNumber type="number" groupingUsed="true" value="${listCart.harga_jual}"/></td>
                                            <td class="column-5">${listCart.kuantitas}</td>
                                            <td class="column-5"><fmt:formatNumber type="number" groupingUsed="true" value="${jumlah}"/></td>

                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-10 col-lg-7 col-xl-5 m-lr-auto m-b-50">
                        <div class="bor10 p-lr-40 p-t-30 p-b-40 m-l-63 m-r-40 m-lr-0-xl p-lr-15-sm">
                            <h4 class="mtext-109 cl2 p-b-30">
                                TOTAL KERANJANG
                            </h4>

                            <!--<form action="/saveList.htm" method="POST">-->
                            <div class="flex-w flex-t p-t-27 p-b-33">
                                <div class="size-208">
                                    <span class="mtext-110 cl2">
                                        <input type="text"  type="text" value="0" id="myTotal" name="total">
                                    </span>
                                </div>
                            </div>



                            <%--<form:input path="nama_kategori" class="input"/>--%>
                            <%--<c:url var="address" value="/settingAddress.htm"></c:url>--%>
                            <!--<a href="${address}" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">-->
                            <!--</a>-->

                            <!--<input type="submit" value="PESAN" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"/></p>-->
                            <!--</form>-->
                        </div>
                    </div>
                </div>
            </div>
        </form>	
        <script>
            function isikota()
            {
                var idProvinsi = document.getElementById("id_provinsi").value;
                var content;
                if (idProvinsi == 0) {
                    content = '<option value="0" name="idKota" disabled="true">-- Pilih Kota --</option>';
                    $('#id_kota').html(content);
                } else {
                    $.ajax({
                        url: 'getDataKotaByProvinsi.htm',
                        data: "id_provinsi=" + idProvinsi,
                        type: 'GET',
                        success: function (response) {
                            var data = JSON.parse(response);
                            var len = data.length;
                            content = '<option value="0" name="idKota" disabled="true">-- Pilih Kabupaten/Kota --</option>';
                            for (var i = 0; i < len; i++) {
                                content += '<option value="' + data[i].id_kota + '" name="idKota">' + data[i].nama + '</option>';
                                $('#id_kota').html(content);
                            }
                        }
                    });
                }

            }

            function ok() {
                var isiProv;
                var isiKota;
                var idProv = document.getElementById("id_provinsi").value;
                var idKota = document.getElementById("id_kota").value;

                if (idProv == 0) {
                    $('#hasilProv').html("SEMUA PROVINSI");
                    $('#hasilKota').html("SEMUA KABUPATEN/KOTA");
                } else {
                    $.ajax({
                        url: 'getKota2.htm',
                        data: {
                            prov: idProv,
                            kota: idKota
                        },
                        type: 'GET',
                        success: function (response) {
                            var data = JSON.parse(response);
                            $('#hasilProv').html(data[0].nama);
                            $('#hasilKota').html(data[1].nama);
                        }
                    });
                }
            }
            
            function isikecamatan()
            {
                var idKota = document.getElementById("id_kota").value;
                var content;
                if (idKota == 0) {
                    content = '<option value="0" name="idKecamatan" disabled="true">-- Pilih Kecamatan --</option>';
                    $('#id_kecamatan').html(content);
                } else {
                    $.ajax({
                        url: 'getDataKecamatanByKota.htm',
                        data: "id_kota=" + idKota,
                        type: 'GET',
                        success: function (response) {
                            var data = JSON.parse(response);
                            var len = data.length;
                            content = '<option value="0" name="idKecamatan" disabled="true">-- Pilih Kecamatan --</option>';
                            for (var i = 0; i < len; i++) {
                                content += '<option value="' + data[i].id_kecamatan + '" name="idKecamatan">' + data[i].nama + '</option>';
                                $('#id_kecamatan').html(content);
                            }
                        }
                    });
                }

            }

            function ok() {
                var idKota = document.getElementById("id_kota").value;
                var idKec = document.getElementById("id_kecamatan").value;

                if (idProv == 0) {
                    $('#hasilKota').html("SEMUA KOTA");
                    $('#hasilKec').html("SEMUA KECAMATAN");
                } else {
                    $.ajax({
                        url: 'getKecamatan2.htm',
                        data: {
                            kota: idKota,
                            kec: idKec
                        },
                        type: 'GET',
                        success: function (response) {
                            var data = JSON.parse(response);
                            $('#hasilKota').html(data[0].nama);
                            $('#hasilKec').html(data[1].nama);
                        }
                    });
                }
            }
        </script>

        <section class="bg0 p-t-104 p-b-116">
            <div class="container">
                <div class="flex-w flex-tr">
                    <div class="size-210 bor10 p-lr-70 p-t-55 p-b-70 p-lr-15-lg w-full-md">
                        <form:form id="penerima" action="savePenerima.htm" modelAttribute="penerimaDto" method="POST">
                            <h4 class="mtext-105 cl2 txt-center p-b-30">
                                Tambah Alamat
                            </h4>

                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" path="nama_penerima" placeholder="Nama Penerima/Nama Toko"/>
                            </div>
                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" path="no_telp" placeholder="Nomor Telepon"/>
                            </div>
                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:select  path="provinsi" name="provinsi_filter" id="id_provinsi" onchange="isikota()" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30">
                                    <form:option value="0">-- Pilih Provinsi --</form:option>
                                    <c:forEach var="prov"  items="${listProvinsi}">
                                        <form:option  value="${prov.id_provinsi}">${prov.nama}</form:option>
                                    </c:forEach>
                                </form:select>
                                    
                            </div>
                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:select path="kabupaten" name="kota_filter" id="id_kota" onchange="isikecamatan()" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30">
                                    <form:option value="0" disabled="true" selected="true">-- Pilih Kabupaten/Kota --</form:option>
                                </form:select>
                            </div>
                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:select name="kecamatan_filter" id="id_kecamatan" class="stext-111 cl2 plh3 size-116 p-l-62 p-r-30" path="kecamatan">
                                    <form:option value="0" disabled="true" selected="true">-- Pilih Kecamatan --</form:option>
                                </form:select>
                            </div>
                            <div class="bor8 m-b-20 how-pos4-parent">
                                <form:input class="stext-111 cl2 plh3 size-116 p-l-62 p-r-25" path="alamat_lengkap" placeholder="Alamat Lengkap"/>
                            </div>

                            <form:button class="flex-c-m stext-101 cl0 size-121 bg3 bor1 hov-btn3 p-lr-15 trans-04 pointer" type="submit">
                                SIMPAN
                            </form:button>
                        </form:form>
                    </div>
                    <h3 id="hasilProv" style="text-decoration: blink;"></h3>
        <h3 id="hasilKota"></h3>

                    <div class="size-210 bor10 flex-w flex-col-m p-lr-93 p-tb-30 p-lr-15-lg w-full-md">
                        <div class="flex-w w-full p-b-42">
                            <!--                            <span class="fs-18 cl5 txt-center size-211">
                                                            <span class="lnr lnr-map-marker"></span>
                                                        </span>-->

                            <c:forEach var="listPenerima" items="${listPenerimaDto}">
                                <div class="size-212 p-t-2">
                                    <table>
                                        <tr>
                                            <td><input type="radio" name="alamat" onclick="getAlamat(value,${listPenerima.harga},-1);" value="${listPenerima.id_penerima}" checked></td>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td>
                                                <strong>${listPenerima.nama_penerima}</strong>
                                            </td>
                                            <c:url var="deletePenerima" value="/deleteDataPenerima.htm">
                                                <c:param name="id_penerima" value="${listPenerima.id_penerima}"/>
                                            </c:url>
                                            <c:url var="updatePenerima" value="/getDataUpdatePenerima.htm">
                                                <c:param name="id_penerima" value="${listPenerima.id_penerima}"/>
                                            </c:url>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td><a href="${deletePenerima}"><img src="./b/images/icons/icon hapus.png" alt="" width="20px" height="20px"></a></td>
                                            <td><a href="${updatePenerima}"><img src="./b/images/icons/icon edit.png" alt="" width="20px" height="20px"></a></td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td>${listPenerima.no_telp}<td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td>${listPenerima.alamat_lengkap} , ${listPenerima.kabupaten}<td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td>&nbsp;&nbsp;&nbsp;</td>
                                            <td>${listPenerima.provinsi}<td>
                                        </tr>
                                    </table>
                                </div>
                            </c:forEach>
                            
                            <table>
                                <tr>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td>    </td>
                                    <td>  </td>
                                    <td>   </td>
                                    
                                </tr>
                                <tr>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                </tr>
                                <tr>
                                    <td>Berat Produk</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td>:</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td><input type="label" id="beratBarangz" value=""/></td>
                                    <td>&nbsp;&nbsp;Kg</td>
                                    
                                </tr>
                                <tr>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                </tr>
                                <tr>
                                    <td>Subtotal Produk</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td>:</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td><input type="label" id="hargaBarangz" value=""/></td>
                                    
                                </tr>
                                 <tr>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                </tr>
                                <tr>
                                    <td>Subtotal pengiriman</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td>:</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td><input type="label" id="ongkirz" value="" style="display: block"/><input type="label" id="ongkirz1" value="" style="display: none"/></td>
                                    
                                </tr>
                                 <tr>
                                    <td>&nbsp;&nbsp;&nbsp;</td>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    
                                </tr>
                                <tr>
                                    <td>Total Pembayaran</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td>:</td>
                                    <td>&nbsp;&nbsp;</td>
                                    <td><input type="label" id="z" value="" /></td>
                                    
                                </tr>
                            </table>
                        </div>
                        <form:form id="pesanan" action="savePesanan.htm" modelAttribute="pesananDto" method="POST">
                            <form:hidden path="total_pesanan" id="totalPesanan"></form:hidden>
                            <form:hidden path="kodeChart" id="kodeCharts"></form:hidden>
                            <form:hidden path="kode_detail" id="kode_details"></form:hidden>
                            <form:hidden path="jumlah_belanja" id="jumlahbelanjas"></form:hidden>
                            <form:hidden path="harga" id="hargas"></form:hidden>
                            <form:hidden path="id_penerima" id="id_penerima"></form:hidden>
                            <form:button class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer"  type="submit"><b>PESAN</b></form:button>
                        </form:form>
                        <%--<c:url var="savePesanan" value="/settingAddress.htm"></c:url>--%>
                        <!--<a href="${savePesanan}" class="flex-c-m stext-101 cl0 size-116 bg3 bor14 hov-btn3 p-lr-15 trans-04 pointer">-->
                        <!--Pesan-->
                        <!--</a>-->

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
                                                        swal(nameProduct, "is added to cart !", "success");
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
