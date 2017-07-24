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

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
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
            padding: 19px 29px 29px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #e5e5e5;
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

<form class="form-signin" action="<%=basePath%>student/update.do" method="post" onSubmit="return checkstAge() &&
		checkstSex() && checkstTel() && checkstDept() && 
		checkstAddress() && checkstName()">
    <input type="hidden" name="id" value="${student.id }" />
    姓名：
    <input class="input" type="text" name="name" value="${student.name }"
           onblur="checkstName()" onFocus="clearstName()">
    <br>
    性别：
    <select name="gender">
        <c:if test="${student.gender == 1}">
            <option value="1" selected="selected">男</option>
            <option value="2">女</option>
        </c:if>
        <c:if test="${student.gender == 2}">
            <option value="1">男</option>
            <option value="2" selected="selected">女</option>
        </c:if>
    </select>
    <br>
    收入：
    <input class="input" type="text" name="balance" value="${student.balance }">
    <br>
    地址：
    <input class="input" type="text" name="address" value="${student.address }">
    <input type="submit" value="提交" class="btn btn-primary">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="button" class="btn btn-success" onclick="window.location.href='/WEB-INF/views/index.jsp'" value="返回">
</form>
</body>
</html>
