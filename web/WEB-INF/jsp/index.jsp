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
        <title>Login E-Commerce</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!-- MATERIAL DESIGN ICONIC FONT -->
        <link rel="stylesheet" href="fonts/material-design-iconic-font/css/material-design-iconic-font.min.css">

        <!-- STYLE CSS -->
        <link rel="stylesheet" href="css/style.css">
        <style type="text/css">
            .bak{
                background-repeat: no-repeat;
                
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

        <body onload="cek();">
            <div class="wrapper">
                <div class="image-holder">
                    <img src="images/mostly.png" alt="">
                </div>
                <div class="form-inner">
                    <form  action="doLogin.htm" modelAttribute="formDto" method="POST">
                        <div class="form-header">
                            <h3>LOGIN</h3>
                            <img src="images/sign-up.png" alt="" class="sign-up-icon">
                        </div>
                        <div class="form-group">
                            <label for="">Username:</label>
                            <input type="text" name="username" path="username" class="form-control" /><!--data-validation="length alphanumeric" data-validation-length="3-12"/>-->
                        </div>
                        <div class="form-group">
                            <label for="">
                        </div>
                        <div class="form-group">
                            <label for="">Password:</label>
                            <input type="password"  name="password" path="password" class="form-control"/> <!--data-validation="length" data-validation-length="min8"-->
                        </div>
                        <div class="form-group" >
                            <input type="checkbox"/>Remember me <!--data-validation="length" data-validation-length="min8"-->
                        </div>

                        <button type="submit">Login</button>
                         <c:url var="registrasi" value="/doTambahDataPembeli.htm"/>
                         <c:url var="loginPembeli" value="/loginPembeli.htm"/>
                        <div class="socials">
                            <p><a href="${registrasi}">Registrasi</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        </div>
                    </form>

                </div>

            </div>

            <script src="js/jquery-3.3.1.min.js"></script>
            <script src="js/jquery.form-validator.min.js"></script>
            <script src="js/main.js"></script>
        </body><!-- This templates was made by Colorlib (https://colorlib.com) -->
    </html>

    <script type="text/javascript">
            function cek() {
                var we = '${notivDto.sukses}';
                if (we != "")
                    alert(we);
            }
            $(document).ready(
                    function () {
                        $("#save").click(
                                function (evt) { //id tombol submit
                                    evt.preventDefault();
                                    var validate = $('#loginform').validationEngine('validate'); // id form
                                    if (validate) {
                                        $("#loginform").submit();
                                    } else {
                                        return false;
                                    }
                                }
                        );
                    }
            );


            var ALERT_TITLE = "Error Message";
            var ALERT_BUTTON_TEXT = "Ok";

            if (document.getElementById) {
                window.alert = function (txt) {
                    createCustomAlert(txt);
                }
            }

            function createCustomAlert(txt) {
                d = document;

                if (d.getElementById("modalContainer"))
                    return;

                mObj = d.getElementsByTagName("body")[0].appendChild(d.createElement("div"));
                mObj.id = "modalContainer";
                mObj.style.height = d.documentElement.scrollHeight + "px";

                alertObj = mObj.appendChild(d.createElement("div"));
                alertObj.id = "alertBox";
                if (d.all && !window.opera)
                    alertObj.style.top = document.documentElement.scrollTop + "px";
                alertObj.style.left = (d.documentElement.scrollWidth - alertObj.offsetWidth) / 2 + "px";
                alertObj.style.visiblity = "visible";

                h1 = alertObj.appendChild(d.createElement("h1"));
                h1.appendChild(d.createTextNode(ALERT_TITLE));

                msg = alertObj.appendChild(d.createElement("p"));
                //msg.appendChild(d.createTextNode(txt));
                msg.innerHTML = txt;

                btn = alertObj.appendChild(d.createElement("a"));
                btn.id = "closeBtn";
                btn.appendChild(d.createTextNode(ALERT_BUTTON_TEXT));
                btn.href = "#";
                btn.focus();
                btn.onclick = function () {
                    removeCustomAlert();
                    return false;
                }

                alertObj.style.display = "block";

            }

            function removeCustomAlert() {
                document.getElementsByTagName("body")[0].removeChild(document.getElementById("modalContainer"));
            }
            function ful() {
                alert('Alert this pages');
            }
    </script>
