<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
    String contextPath = request.getContextPath();
%>
<html>
<head>
    <title>详情</title>
</head>
<script src="<%=contextPath%>/static/jquery-3.1.1.js"></script>
<script src="https://cdn.bootcss.com/showdown/1.3.0/showdown.min.js"></script>
<%--<script>
      $(function () {
        //  document.write(1111);

          var content ='${articles.content}'; //使用el表达式获取后台返回的markdown内容
          var converter = new showdown.Converter(); //初始化转换器
          var htmlcontent  = converter.makeHtml(content); //将MarkDown转为html格式的内容
          alert(htmlcontent);
          $("#container").html(htmlcontent);//添加到 div 中 显示出来

      })


</script>--%>
<body>
<jsp:include page="comm/top.jsp"/>
<%--<c:forEach items="${article}" var="a">--%>
<div class="container" id="container">
    <div class="panel panel-info">
        <div class="panel-heading">
            <h3 class="panel-title">${title}</h3>
        </div>
        <div class="panel-body">

            <span>${articles}</span>
        </div>
    </div>
</div>
<%--</c:forEach>--%>
</body>
</html>