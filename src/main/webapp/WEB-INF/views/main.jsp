<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<%
//    String name=(String)session.getAttribute("name");
//    if (name==null){
//        response.sendRedirect(path + "/index.jsp");
//    }
    String mainPage=(String)request.getAttribute("mainPage");
    if(mainPage==null || mainPage.equals("")){
        mainPage="common/default.jsp";
    }
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>学生信息管理系统主界面</title>
    <link href="<%=basePath%>css/bootstrap.css" rel="stylesheet">
    <link href="<%=basePath%>/css/bootstrap-responsive.css" rel="stylesheet">
    <script src="<%=basePath%>/js/jquery-1.9.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap.js"></script>
    <script type="text/javascript">
        function check() {
            if(confirm("您确定要退出吗?")){
                window.location.href = "logout.jsp"
            }
        }
    </script>
    <script type="text/javascript">
        function setDateTime() {
            var date = new Date();
            var day = date.getDay();
            var week;
            switch (day) {
                case 0:
                    week = "星期日";
                    break;
                case 1:
                    week = "星期一";
                    break;
                case 2:
                    week = "星期二";
                    break;
                case 3:
                    week = "星期三";
                    break;
                case 4:
                    week = "星期四";
                    break;
                case 5:
                    week = "星期五";
                    break;
                case 6:
                    week = "星期六";
                    break;
            }
            var today = date.getFullYear() + "年" + (date.getMonth() + 1) + "月"
                + date.getDate() + "日  " + week + " " + date.getHours() + ":"
                + date.getMinutes() + ":" + date.getSeconds();
            document.getElementById("today").innerHTML = today;
        }
        window.setInterval("setDateTime()", 1000);
    </script>
</head>

<body>
<div class="container">
    <jsp:include page="common/head.jsp"></jsp:include>
    <jsp:include page="<%=mainPage %>"></jsp:include>
</div>
</body>
</html>
