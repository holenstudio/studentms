<%@ page language="java" import="java.util.*,com.example.studentms.entity.Student"
         pageEncoding="utf-8" %>
<%@ page import="com.example.studentms.dao.impl.*" %>
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
    <title>显示用户信息</title>
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script src="<%=basePath%>/js/studentms.js"></script>
    <style type="text/css">
        input[type="text"] {
            height: auto;
            margin-bottom: 15px;
            padding: 3px 9px;
        }
    </style>
</head>

<body>

<form action="searchById" method="post">
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    学生姓名：<input type="text" name="searchId" placeholder="学生姓名...">
    <i class="icon-search"></i>&nbsp;<button type="submit" class="btn btn-inverse"> 查找</button>
</form>
<table class="table table-hover table-condensed">
    <tr>
        <td align="center">
            <strong>姓名</strong>
        </td>
        <td align="center">
            <strong>性别</strong>
        </td>

        <td align="center">
            <strong>地址</strong>
        </td>
        <td align="center">
            <strong>余额</strong>
        </td>
    </tr>
    <c:forEach items="${students}" var="student">
        <tr>
            <td>
                    ${student.name}
            </td>
            <td>
                    ${student.gender}
            </td>
            <td>
                    ${student.address}
            </td>
            <td>
                    ${student.balance}
            </td>
            <td>
                <div class="btn-group">
                    <button type="button" onclick="update(${student.id})" class="btn btn-default">更新</button>
                    <button type="button" onclick="delete(${student.id})" class="btn btn-default">删除</button>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

<hr>
<a href="/home/index.jsp" class="btn btn-success">返回主菜单</a>
<hr>

</body>
</html>
