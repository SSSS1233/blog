<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="app">
<head>
    <meta charset="utf-8"/>
    <title>后台登录页面模板</title>
    <meta name="description"
          content="app, web app, responsive, admin dashboard, admin, flat, flat ui, ui kit, off screen nav"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <link rel="stylesheet" href="../static/adminlogin/css/bootstrap.css" type="text/css"/>
    <link rel="stylesheet" href="../static/adminlogin/css/simple-line-icons.css" type="text/css"/>
    <link rel="stylesheet" href="../static/adminlogin/css/app.css" type="text/css"/>
    <script src="../static/jquery-3.1.1.js"></script>
    <script>
        $(function () {
         /*   $("#username").blur(function () {
                var name = $("#username").val();
                if(name==""||name.trim()=="")
                {
                      $("#name").css("color","red").text("不能为空")
                }else
                {
                    $("#name").css("color","red").text("")
                }
            })*/
            $("#validate-submit").click(function () {
                var name = $("#username").val();
                var pass = $("#password").val();
                alert(name+" "+pass)
                var user={username:name,password:pass};
                $.ajax({
                    url: "login.do",
                    type:"post",
                    data:user,
                    dataType:"json",
                    success:function (data) {
                       // alert(data.message)
                        if(data.message=='ok')
                        {
                            $("#Form").submit();
                        }
                        else {
                            $("#pass").css("color","red").text(data.message)
                        }
                    }
                })
            })
        })
    </script>
</head>
<body background="../static/adminlogin/images/bodybg.jpg">
<section id="content" class="m-t-lg wrapper-md animated fadeInUp ">
    <div class="container aside-xl" style="margin-top: 48px;">
        <a class="navbar-brand block"><span class="h1 font-bold" style="color: #ffffff">管理员后台登录</span></a>
        <section class="m-b-lg">
            <header class="wrapper text-center">
                <strong class="text-sucess">管理员登录</strong>
            </header>
            <form action="Adminselect.do" method="post" id="Form">
                <div class="form-group">
                      <input type="username" id="username" name="username" placeholder="用户名"
                           class="form-control  input-lg text-center no-border"><span id="name"></span>
                </div>
                <div class="form-group">
                    <input type="password" id="password" name="password" placeholder="密码"
                           class="form-control  input-lg text-center no-border"><nobr><span id="pass"></span></nobr>
                </div>

                <button type="button" class="btn btn-lg btn-danger lt b-white b-2x btn-block" id="validate-submit">
                    <i class="icon-arrow-right pull-right"></i><span class="m-r-n-lg">登录</span></button>
            </form>
        </section>
    </div>
</section>
<!-- footer -->
<footer id="footer">
    <div class="text-center padder">

    </div>
</footer>
</body>
</html>
