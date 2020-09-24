<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" media="screen" href="js/validation/css/validationEngine.jquery.css">
<script type="text/javascript" src="js/validation/jquery.validationEngine-en.js"></script>
<script type="text/javascript" src="js/validation/jquery.validationEngine.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta charset="utf-8">
        <title>Register E-Commerce</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

        <!-- STYLE CSS -->
        <link rel="stylesheet" href="css/style.css">
        <style type="text/css">
	.bak{
		background-repeat: no-repeat;
		background-image: url(images/wheel-2000.jpg);
		position: fixed;
		width: 100%;
		height: 100%;
		background-size: 100%;
        }
        
        
        #modalContainer {
	background-color:rgba(0, 0, 0, 0.3);
	position:absolute;
  top:0;
	width:100%;
	height:100%;
	left:0px;
	z-index:10000;
	background-image:url(tp.png); /* required by MSIE to prevent actions on lower z-index elements */
}

#alertBox {
	position:relative;
	width:33%;
	min-height:100px;
        max-height:400px;
	margin-top:50px;
	border:1px solid #fff;
	background-color:#fff;
	background-repeat:no-repeat;
        top:30%;
}

#modalContainer > #alertBox {
	position:fixed;
}

#alertBox h1 {
	margin:0;
	font:bold 1em Raleway,arial;
	background-color:#FF69B4;
	color:white;
	border-bottom:1px solid #f97352;
	padding:10px 0 10px 5px;
}

#alertBox p {
	height:50px;
	padding-left:5px;
  padding-top:30px;
  text-align:center;
  vertical-align:middle;
}

#alertBox #closeBtn {
	display:block;
	position:relative;
	margin:10px auto 10px auto;
	padding:7px;
	border:0 none;
	width:70px;
	text-transform:uppercase;
	text-align:center;
	color:#FFF;
	background-color:#FF69B4;
	border-radius: 0px;
	text-decoration:none;
  outline:0!important;
}

/* unrelated styles */

#mContainer {
	position:relative;
	width:600px;
	margin:auto;
	padding:5px;
	border-top:2px solid #fff;
	border-bottom:2px solid #fff;
}

h1,h2 {
	margin:0;
	padding:4px;
}

code {
	font-size:1.2em;
	color:#069;
}

#credits {
	position:relative;
	margin:25px auto 0px auto;
	width:350px; 
	font:0.7em verdana;
	border-top:1px solid #000;
	border-bottom:1px solid #000;
	height:90px;
	padding-top:4px;
}

#credits img {
	float:left;
	margin:5px 10px 5px 0px;
	border:1px solid #000000;
	width:80px;
	height:79px;
}

.important {
	background-color:#F5FCC8;
	padding:2px;

}

@media (max-width: 600px) 
{
  #alertBox {
	position:relative;
	width:90%;
        top:30%;
  }</style>
   </head>

    <body>
        <div class="wrapper">
            <div class="image-holder">
                <img src="images/registration-form-8.jpg" alt="">
            </div>
            <div class="form-inner">
                <form  id="pembeli" action="savePembeli.htm" modelAttribute="formDto" method="POST">
                    <div class="form-header">
                        <h3>REGISTER</h3>
                        <img src="images/sign-up.png" alt="" class="sign-up-icon">
                    </div>
                    <div class="form-group">
                        <label for="">
                    </div>
                    <div class="form-group">
                        <label for="">Nama Lengkap</label>
                        <input type="text"  name="nama" path="nama" class="form-control validate validate[required,maxSize[100],custom[onlyLetter]]"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <div class="form-group">
                        <label for="">Email</label>
                        <input type="text"  name="email" path="email" class="form-control validate validate[required,maxSize[100],custom[onlyLetter]]"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <div class="form-group">
                        <label for="">Nomor Telepon</label>
                        <input type="text"  name="no_telp" path="no_telp" class="form-control validate validate[required,custom[onlyNumberSp],maxSize[14],custom[noSpace]]"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <div class="form-group">
                        <label for="">Alamat</label>
                        <input type="text"  name="alamat" path="alamat" class="form-control validate validate[required,maxSize[100],custom[onlyLetter]]"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <div class="form-group">
                        <label for="">Username</label>
                        <input type="text"  name="username" path="username" class="form-control validate validate[required,maxSize[100],custom[onlyLetter]]"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <div class="form-group">
                        <label for="">Password</label>
                        <input type="password"  name="password" path="password" class="form-control"/> <!--data-validation="length" data-validation-length="min8"-->
                    </div>
                    <button id="save" type="submit">Registrasi</button>
                </form>
            </div>

        </div>

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/jquery.form-validator.min.js"></script>
        <script src="js/main.js"></script>
    </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
<script type="text/javascript">
    $(document).ready(
            function (){
                $("#save").click(
                    function(evt){ //id tombol submit
                        evt.preventDefault();
                        var validate=$('#pembeli').validationEngine('validate'); //id form
                        if(validate){
                            $('#pembeli').submit();
                        }else{
                            return false;
                        }
                    }
                );
            }
    ); 
</script>
