<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="desc" content="">
    <meta name="author" content="">
    <link rel="icon" href="/favicon.ico">

    <title>${site.title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${basePath }/static/libs/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${basePath }/static/css/login.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
    <script src="${basePath }/static/bootstrap/js/ie/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="${basePath }/static/libs/bootstrap/js/ie/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">
    <form class="form-signin" action="login.html" method="post">
        <h2 class="form-signin-heading">${site.title}</h2>
        <label for="inputUserName" class="sr-only">账号</label>
        <input type="text" id="inputUserName" name="userName" class="form-control" placeholder="请输入您的登录帐号" required
               autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="请输入您的登录密码" required>
        <div class="text-center">${error}</div>
        <div class="checkbox">
            <label>
                <input type="checkbox" name="rememberMe" checked="${isRemembered}"> 记住密码
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="/static/libs/bootstrap/js/ie/ie10-viewport-bug-workaround.js"></script>
</body>
</html>