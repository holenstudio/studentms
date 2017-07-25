<%@ page language="java" import="java.util.*,com.example.studentms.entity.Student" pageEncoding="utf-8" %>
<%@ page import="com.example.studentms.dao.StudentDao" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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

    <title>更新学生信息</title>

    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <%--<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/studentms.js"></script>
    <!--
<link rel="stylesheet" type="text/css" href="styles.css">
-->
    <script type="text/javascript" src="js/stupdate.js"></script>
    <style type="text/css">
        span {
            color: red;
        }

        .form-signin .form-signin-heading, .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin input[type="text"], .form-signin input[type="password"] {
            font-size: 16px;
            height: auto;
            margin-bottom: 15px;
            padding: 7px 9px;
        }

        .form-signin {
            max-width: 550px;
            padding: 19px 20px 29px;
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
<form class="form-signin" action="<%=basePath%>student/update.do" method="post">
    <input type="hidden" name="id" value="${student.id }"/>
    <div class="form-group">
        <label class="col-sm-2 control-label">姓名</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="name" value="${student.name }">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">性别</label>
        <div class="col-sm-10">
            <select name="gender" class="form-control">
                <c:if test="${student.gender == 1}">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </c:if>
                <c:if test="${student.gender == 2}">
                    <option value="1">男</option>
                    <option value="2" selected="selected">女</option>
                </c:if>
            </select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">收入</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="balance" value="${student.balance }">
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">地址</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" name="address" value="${student.address }">
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-2">
            <button type="submit" class="btn btn-success">提交</button>
        </div>
        <div class="col-sm-offset-2 col-sm-2">
            <button type="button" class="btn btn-primary" onclick="window.location.href = '<%=basePath%>main'">返回
            </button>
        </div>
    </div>
</form>


</body>
</html>
