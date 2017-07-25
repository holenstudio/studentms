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
    <script src="<%=basePath%>js/jquery-1.9.1.min.js"></script>
    <%--<link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">--%>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=basePath%>css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=basePath%>js/bootstrap.js"></script>
    <script src="<%=basePath%>js/studentms.js"></script>
    <style type="text/css">
        input[type="text"] {
            height: auto;
            margin-bottom: 15px;
            padding: 3px 9px;
        }
        .horizontal-center {
            width: 900px;
            margin: 0 auto;
        }
    </style>
</head>

<body>
<form class="form-search horizontal-center" action="student/search.do" method="get">
    学生姓名：
    <input type="text" class="input-medium search-query" name="name">
    <button type="submit" class="btn">查找</button>
</form>

<table class="table table-hover table-condensed horizontal-center" style="width: 900px;margin: 0 auto;">
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
            <td align="center">
                    ${student.name}
            </td>
            <td align="center">
                    ${student.gender}
            </td>
            <td align="center">
                    ${student.address}
            </td>
            <td align="center">
                    ${student.balance}
            </td>
            <td align="center">
                <div class="btn-group">
                    <button type="button" onclick="window.location.href = 'student/update?id=${student.id}'" class="btn btn-default">更新</button>
                    <button type="button" onclick="window.location.href = 'student/delete?id=${student.id}'" class="btn btn-default">删除</button>
                </div>
            </td>
        </tr>
    </c:forEach>
</table>

<div class = "horizontal-center">
<a href="<%=basePath%>main" class="btn btn-success">返回主菜单</a>
</div>

</body>
</html>
