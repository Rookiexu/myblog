<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>无标题文档</title>
<script language="javascript">
<!--
function mhEnter()
{
window.event.srcElement.className="lt1";
}
function mhLeave()
{
window.event.srcElement.className="lt0";
}
//-->
</script>
<link rel="stylesheet" href="include/style.css" media="screen" />
<style type="text/css">
<!--
.blogtitle {
	font-size: 18px;
	font-weight: bold;
}
.idiograph {
	position: relative;
	left: 50px;
}

-->
</style>
</head>

<body>
<div id="logo">
		<h1><em>Rookiex  </a></em></h1>
		<p><em> 辣子鸡和千页豆腐 </a></em></p>
	</div>
	<hr />
	<!-- end #logo -->
	<div id="header">
		<div id="menu">
			<ul>
				<li class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="index.jsp">Rookiex</a></li>
				<li class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="login.jsp">登陆</a></li>
				<li class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="register.jsp">注册</a></li>
				<li class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllArticle.action">日志</a></li>
				<li class="lt0" onmouseenter="mhEnter()" onmouseleave="mhLeave()"><a href="showAllNote.action">留言板</a></li>
			</ul>
		</div>
		<!-- end #menu -->
	
		<!-- end #search -->
	</div>
</body>
</html>