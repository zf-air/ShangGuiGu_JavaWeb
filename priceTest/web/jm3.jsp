<%
    String path = request.getContextPath();
    String basePath = null;
    basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    int port = request.getServerPort();

    if (port == 80) {
        basePath = request.getScheme() + "://" + request.getServerName() + path;

    } else {
        basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;

    }
    request.setAttribute("basePath", basePath);
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/favicon.ico">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/jumbotron/">
    <style>
        .form-group {
            padding: 80px 25px;
        }
    </style>
    <title>城市房价分析系统</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/css/ie10-viewport-bug-workaround.css"
          rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/examples/jumbotron/jumbotron.css"
          rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie8-responsive-file-warning.js"></script>
    <![endif]-->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body background="picture/jm1-1.jpg"
      style="background-repeat:no-repeat;background-size:100% 100%;background-attachment:fixed;">
<div class='ban'>
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">HOMELESS宝典</a>
                <button type="submit" class="btn btn-default" onClick="history.go( -1 );return true">返回</button>
            </div>

        </div>
    </nav>

    <!-- Main jumbotron for a primary marketing message or call to action -->


    <div class="span4">
        <center><img src="picture/logo1.png" width=200 height=185 border=0 alt="fengmian"></center>
        <h2>
            <center><font color="white">您的房价预估结果为</font></center>
        </h2>
        <h1>
            <center><font color=white>${price}</font></center>
        </h1>
    </div>

    <div class="container">
        <!-- Example row of columns -->

        <div class="form-group">
            <div align="CENTER" class="neirong">
                <!-- Example row of columns -->
                <p><font color=white>城市： ${city}</font></p>
                <p><font color=white>区域： ${district}</font></p>
                <p><font color=white>面积： ${area}</font></p>
                <p><font color=white>朝向： ${chaoxiang}</font></p>
                <p><font color=white>装修状态： ${zhuangtai}</font></p>
                <p><font color=white>楼层： ${height}</font></p>


            </div><!--/.navbar-collapse -->
        </div>
        <hr>

        <footer>
            <p><font color="white">&copy; 2021 sprout, Inc.</font></p>
        </footer>
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"
            integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
            crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/dist/js/bootstrap.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.10/assets/js/ie10-viewport-bug-workaround.js"></script>
</div>
</body>
</html>




    
