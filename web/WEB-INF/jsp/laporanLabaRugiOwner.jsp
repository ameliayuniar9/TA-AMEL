<%-- 
    Document   : tabelPesanan
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

    <title>Laporan Laba Rugi</title>

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
    <script type="text/javascript">
            $(document).ready(function () {
                // Activate tooltips
                $('[data-toggle="tooltip"]').tooltip();

                // Filter table rows based on searched term
                $("#search").on("keyup", function () {
                    var term = $(this).val().toLowerCase();
                    $("table tbody tr").each(function () {
                        $row = $(this);
                        var name = $row.find("td:nth-child(3)").text().toUpperCase();
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
    <style>
            #customers {
                font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
                border-collapse: collapse;
                width: 50%;
                padding-top: 5px;
            }

            #customers td, #customers th {
                border: 1px solid #FFFFFF;
                padding: 5px;
            }

            #customers tr:nth-child(even){background-color: #FFFFFF;}

            #customers tr:hover {background-color: #ddd; padding-top: 5px}

            #customers th {
                padding-top: 12px;
                padding-bottom: 12px;
                text-align: center;
                background-color: #FFFFFF;
                color: white;
            }
             #customers hr {
                padding-bottom: 12px;
                text-align: center;
                border: 1px solid #000000;
                padding: 100px;
                
            }
            p {
                text-indent: 280px;
                font-size: 13px;
                
            }
            
            h6 {
                text-indent: 300px;
                font-size: 13px;
                
            }
            h5{
                word-spacing: 5px;
                letter-spacing: 2px;
            }
        </style>
        <style type="text/css">
            .under { text-decoration: underline; }
            .over  { text-decoration: overline; }
            .line  { text-decoration: line-through; }
            .blink { text-decoration: blink; }
            .all   { text-decoration: underline overline line-through; }
            a      { text-decoration: none; }
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
    <!--<div class="col-md-3 col-sm-6 col-xs-6">-->
    <c:url var="tabelDetailPesanan" value="/tabelDetailPesanan.htm">        
    </c:url>
    <c:url var="tabelPesanan" value="/tabelPesanan.htm">        
    </c:url>
    <c:url var="tabelPesanan2" value="/tabelPesanan2.htm">        
    </c:url>
    <c:url var="tabelPesanan3" value="/tabelPesanan3.htm">        
    </c:url>
    <div class="row">
                        <div class="customers">
                          <div class="card card-body printableArea">
                              <div id="lap">
                                  <center>  
                                  
                                   <label style=" font-size: 20px">TOKO ONLINE HIJAB ITSMOSTLY</label><br>
                                  <label style="font-size: 18px">Gang H Hambali 1 No 93B Kecamatan Cicendo Kota Bandung</label><br>
                                  <label style="font-size: 20px">Laporan Laba Rugi Periode ${periodeBulan} ${periodeTahun}</label><br>
                                  </center>
                            <hr id="customers">
 
<!--                            <label style="margin-left: 50px;font-size: 18px">Pendapatan atas Penjualan : </label><br>-->
                                  <center>
                            <table style="margin-left: 80px" border="0">
                                <tr>
                                    <th width="20"></th>
                                    <th width="50"></th>
                                    <th width="200"></th>
                                    <th width="200"></th>
                                    <th width="100"></th>
                                    <th width="300"></th>
                                </tr>
                                <tr> 
                                    <td colspan="6"> <label style="font-size: 18px">Pendapatan atas Penjualan : </label></td>
                                </tr>
                                <c:set var="index" value="1"/>
                                <c:forEach var="listProduk" items="${listProdukDto}">
                                    <tr>  
                                        <td></td>
                                        <td  align="center"><label style="font-size: 18px">${index}</label></td>
                                        <td colspan="3" ><label style="font-size: 18px">${listProduk.nama_produk}</label></td>
                                        <td ><label style="font-size: 18px">Rp. ${listProduk.total_pesanan}</label></td>
                                    </tr>            
                                    <c:set var="index" value="${index+1}"/>
                                </c:forEach>
                                <tr>
                                    <td colspan="2"></td>
                                    <td colspan="3"><label style="margin-left: 25px;font-size: 18px">Total Penjualan</label></td>                                            
                                   <td ><label style="margin-left: 50px;font-size: 18px">Rp. ${totalPenjualan}</label></td>
                               </tr> 
                               <tr> 
                                   <td colspan="6"> <label style="font-size: 18px">Pengurangan atas Beban-beban : </label></td>
                               </tr>
                                <c:set var="index1" value="1"/>
                                <c:forEach var="listPengeluaran" items="${listPengeluaranDto}">
                                    <tr>
                                        <td></td>
                                        <td align="center"><label style="font-size: 18px">${index1}</label></td>
                                        <td colspan="3" ><label style="font-size: 18px">${listPengeluaran.nama_akun}</label></td>
                                        <td><label style="font-size: 18px">Rp. ${listPengeluaran.jumlah}</label></td>
                                    </tr>            
                                    <c:set var="index1" value="${index+1}"/>
                                </c:forEach>
                                 <tr>
                                    <td colspan="2"></td>
                                    <td colspan="3"><label style="margin-left: 25px;font-size: 18px">Total Beban-beban</label></td>                                            
                                   <td ><label style="margin-left: 50px;font-size: 18px">Rp. ${totalPengeluaran}</label></td>
                               </tr>
                                <tr> 
                                   <td colspan="5"> <label style="font-size: 18px">Laba / Rugi Perusahaan </label></td>                                                                         
                                   <td ><label style="margin-left: 50px;font-size: 18px" class="over">Rp. ${labaRugi}</label></td>
                               </tr> 
                                        
                            </table></center><br>
                               <c:url var="owner" value="/owner.htm">        
                                </c:url>
                          <center><button id="print" class="btn btn-default btn-outline" style="margin-left:250px " type="button" onclick="printContent('lap')"> <span><i class="fa fa-print"></i> Print</span> </button></center>
                          </div><br>
                                
                            

                          </div>
                        </div>

                    </div>
                    <!-- /. ROW  -->


                </div>
            
    <!--</div>-->
<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>
<script src="js/jquery.PrintArea.js" type="text/JavaScript"></script>                       
            <script>
                 $(document).ready(function() {
                    $("#print").click(function() {
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
                function printContent(el){
                        var restorepage = document.body.innerHTML;
                        var printcontent = document.getElementById(el).innerHTML;
                        document.body.innerHTML = printcontent;
                        window.print();
                        document.body.innerHTML = restorepage;
                }
	</script>
</body>

</html>

