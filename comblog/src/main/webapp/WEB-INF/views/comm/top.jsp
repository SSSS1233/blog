<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String contextPath = request.getContextPath();
%>
<script src="/static/jquery-3.1.1.js"></script>
<script src="/static/bootstrap/js/bootstrap.js"></script>
<link href="/static/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<link href="/static/bootstrap/css/bootstrap-theme.css" rel="stylesheet"/>
<script src="/static/myscript.js"></script>
<div class="row">
    <nav class="navbar navbar-inverse">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.do">SSSS的专栏</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" id="nv1">
                    <li class="active" id="firstPage"><a href="index.do">首页</a></li>
                    <li id="webPage"><a href="javascript:void(0)" id="java" onclick="select(1)" >JavaWeb专栏</a></li>
                    <li id="androidPage"><a href="javascript:void(0)" onclick="select(2)">Android专栏</a>
                    </li>
                    <li id="rnPage"><a href="javascript:void(0)" onclick="select(3)">React Native专栏</a>
                    </li>
                    <li id="ubuntuPage"><a href="javascript:void(0)" onclick="select(4)">Ubuntu专栏</a>
                    </li>
                </ul>
                <form class="navbar-form navbar-right" action="selectlike.do" method="post">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="搜索" name="title" id="title">
                        <span class="input-group-btn">
                <input class="btn btn-default" type="button" onclick="selects()" value="搜索">Go!</input>
      </span>
                    </div>
                </form>
            </div>
        </div>
    </nav>
</div>
<script>
    var href = location.href;
    var id = href.substring(href.lastIndexOf("/") + 1, href.length);
    if (id == "") {
        id = "firstPage";
    }
    var ids = ["firstPage", "webPage", "androidPage", "rnPage", "ubuntuPage"];
    for (var i = 0; i < ids.length; i++) {
        if (id == ids[i]) {
            $("#" + id).attr("class", "active");
        } else {
            $("#" + ids[i]).removeAttr("class");
        }
    }
</script>