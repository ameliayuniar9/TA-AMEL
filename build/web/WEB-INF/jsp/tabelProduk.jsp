<%-- 
    Document   : tabelProduk
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

    <title>Tabel Produk</title>

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
    <script type="text/javascript">
        $(document).ready(function () {
            // Activate tooltips
            $('[data-toggle="tooltip"]').tooltip();

            // Filter table rows based on searched term
            $("#search").on("keyup", function () {
                var term = $(this).val().toLowerCase();
                $("table tbody tr").each(function () {
                    $row = $(this);
                    var name = $row.find("td:nth-child(4)").text().toLowerCase();
                    console.log(name);
                    if (name.search(term) < 0) {
                        $row.hide();
                    } else {
                        $row.show();
                    }
                });
            });
        });
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
            width: 90%;
            border: 1px solid #f2f5f7;
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
                        </li>
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
    <c:url var="tambahDataProduk" value="/doTambahDataProduk.htm">        
    </c:url>
    <p align="center" style = "font-family:courier;"><u><a href="${tambahDataProduk}">Tambah</a></u></p>
    <form>
        <center><input class="searchNama" type="text" id="search" placeholder="Search berdasarkan Nama Produk"/><br><br></center>
    </form>
    <!--<div class="col-md-3 col-sm-6 col-xs-6">-->
    <table  align="center" class="table1" border="1">
        <thead> <tr>
                <th>No</th> 
                <th>Kode Produk</th>            
                <th>Kode Kategori</th>            
                <th>Nama Produk</th>
                <th>Harga Jual</th>            
                <th>Berat</th>            
                <th width="500px">Keterangan Produk</th>
                <th colspan="2">action</th>
            </tr>
        </thead>
        <tbody>
            <c:set var="index" value="1"/>
            <c:forEach var="listProduk" items="${listProdukDto}">
                <c:url var="deleteProduk" value="/deleteDataProduk.htm">
                    <c:param name="kode_produk" value="${listProduk.kode_produk}"/>
                </c:url>
                <c:url var="updateProduk" value="/getDataUpdateProduk.htm">
                    <c:param name="kode_produk" value="${listProduk.kode_produk}"/>
                </c:url>
                <tr>  
                    <td>${index}</td>
                    <td>${listProduk.kode_produk}</td>
                    <td>${listProduk.kode_kategori}</td>
                    <td>${listProduk.nama_produk}</td>
                    <td>${listProduk.harga_jual}</td>
                    <td>${listProduk.berat}</td>
                    <td>${listProduk.keterangan_produk}</td>
                    <td><a href="${deleteProduk}"><img src="./b/images/icons/icon hapus.png" alt="" width="20px" height="20px"></a></td>
                    <td><a href="${updateProduk}"><img src="./b/images/icons/icon edit.png" alt="" width="20px" height="20px"></a></td>
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

