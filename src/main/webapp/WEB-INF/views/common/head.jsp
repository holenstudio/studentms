<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	</head>

	<body>
		<div class="row-fluid">
			<div class="span12">
				<div class="head">
					<div class="headRight">
						欢迎管理员：
						<font color="red"><%=request.getAttribute("username")%></font>&nbsp;&nbsp;&nbsp;
						 <i class="icon-time"></i>&nbsp;&nbsp;<font id="today"></font>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-light bg-faded">
			<a class="navbar-brand" href="#">Navbar</a>
			<ul class="nav navbar-nav">
				<li class="nav-item active">
					<a class="nav-link" href="#">Home <span class="sr-only">首页</span></a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">添加学生信息</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">学生信息查看</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">修改密码</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="#">退出系统</a>
				</li>
			</ul>
			<form class="form-inline navbar-form pull-right">
				<input class="form-control" type="text" placeholder="Search">
				<button class="btn btn-success-outline" type="submit">Search</button>
			</form>
		</nav>

		<div class="row-fluid">
			<div class="span12">
				<div class="navbar">
					<div class="navbar-inner">
					   <a class="brand" href="<%=basePath%>main"><i class="icon-home"></i>&nbsp;首页</a>
						<ul class="nav">
							<li><a href="<%=basePath%>student/add"><i class="icon-pencil"></i>&nbsp;添加学生信息 </a></li>
							<li><a href="<%=basePath%>student/display"><i class="icon-book"></i>&nbsp;学生信息查看 </a></li>
							<li><a href="<%=basePath%>updatePsw"><i class=" icon-cog"></i>&nbsp;修改密码</a></li>
							<li><a onclick="check()"><i class="icon-user"></i>&nbsp;退出系统</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
