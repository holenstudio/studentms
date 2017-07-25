<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>新增学生</title>

    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <%--<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/studentms.js"></script>

    <style type="text/css">
        .form-add {
            max-width: 550px;
            padding: 19px 29px 29px;
            margin: 0 auto;
            background-color: #fff;
            /*border: 1px solid #e5e5e5;*/
            -webkit-border-radius: 5px;
            -moz-border-radius: 5px;
            border-radius: 5px;
            -webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            -moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
            box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
        }
    </style>
</head>
<body>
<form class="form-add" action="<%=basePath%>student/add.do" method="post">
    <div class="form-group">
        <label class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" placeholder="姓名">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <select name="gender" class="form-control">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">收入</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="balance" placeholder="收入">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="address" placeholder="地址">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-2">
            <button type="submit" class="btn btn-success">新增</button>
        </div>
        <div class="col-sm-offset-2 col-sm-2">
            <button type="button" class="btn btn-primary" onclick="window.location.href = '<%=basePath%>main'">返回
            </button>
        </div>
    </div>
</form>

</body>
</html>
