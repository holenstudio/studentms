<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生信息管理系统主界面</title>
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script type="text/javascript">
        function check() {
            if (confirm("您确定要退出吗?")) {
                window.location.href = "login.jsp"
            }
        }
    </script>
</head>

<body>
<div class="container">
    <h6>欢迎!</h6>
    <nav class="navbar navbar-light bg-faded">
        <ul class="nav navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<%=basePath%>main">Home <span class="sr-only">首页</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=basePath%>student/add">添加学生信息</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=basePath%>student/display">学生信息查看</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="<%=basePath%>updatePsw">修改密码</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#" onclick="check()">退出系统</a>
            </li>
        </ul>
        <form class="form-inline navbar-form pull-right">
            <input class="form-control" type="text" placeholder="Search">
            <button class="btn btn-success-outline" type="submit">Search</button>
        </form>
    </nav>
    <br/><br/><br/><br/><br/><br/>
    <p>
    <center><font size="+2" color="red">欢迎使用学生信息管理系统！</font></center>
    </p>
</div>

</body>
</html>
