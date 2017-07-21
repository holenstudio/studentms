<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>Student manage system</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <style type="text/css">
        span {
            color: red;
        }

        body {
            margin: 0;
            padding: 0;
            background-color: #f5f5f5;
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

        table { /* max-width: 100%; */
            background-color: transparent;
            border-collapse: collapse;
            border-spacing: 0;
        }

        .table {
            width: 40%;
            margin-bottom: 20px;
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

        .labelError {
            line-height: 9px;
            font-size: 10pt;
            color: #f40000;
            border: 1px #ffb8b8 solid;
            padding: 8px 8px 8px 35px;
            background-color: #fef2f2;
        }
    </style>
</head>
<body>

<form class="form-signin" action="<%=basePath%>student/add.do" method="post"
      onSubmit="return checkstName() &&
   checkstAge() && checkstSex() && checkstTel() && checkstDept() && checkstAddress()">
    <table>
        <tr>
            <td>
                姓名：
            </td>
            <td>
                <input class="input" type="text" name="name" onblur="checkstName()"
                       onFocus="clearstName()">
                <span id="stName1"></span>
            </td>
        </tr>
        <tr>
            <td>
                性别：
            </td>
            <td>
                <select name="gender">
                    <option value="1" selected="selected">男</option>
                    <option value="2">女</option>
                </select>
                <span id="stSex1"></span>
            </td>
        </tr>
        <tr>
            <td>
                收入：
            </td>
            <td>
                <input class="input" type="text" name="balance" onblur="checkstAge()"
                       onFocus="clearstAge()">
                <span id="stAge1"></span>
            </td>
        </tr>
        <tr>
            <td>
                地址：
            </td>
            <td>
                <input class="input" type="text" name="address" onblur="checkstAddress()"
                       onFocus="clearstAddress()">
                <span id="stAddress1"></span>
            </td>
        </tr>
    </table>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="submit" value="提交" class="btn btn-primary">
    &nbsp;&nbsp;&nbsp;
    <input type="button" onclick="window.location.href='/WEB-INF/views/index.jsp'"
           value="返回" class="btn btn-success">
</form>

</body>
</html>
