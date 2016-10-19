<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>	
<%@taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<title>相册</title>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5">
		<link rel="stylesheet" href="image/style.css">
	</HEAD>
		<body leftMargin="0" topMargin="0" MS_POSITIONING="GridLayout">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<form action="photoUpload.action" method="post" enctype="multipart/form-data">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<table cellspacing="5" align="center">
						<tr>
						<s:iterator value="#request.photoList" id="photo" status="stu">
								<td>
									<img src='photo/${sessionScope.username}/<s:property value="photo"/>' width="100" height="120">
								</td>
								<s:if test="(#stu.index + 1) % 6 == 0">
									</tr>
									<tr>
								</s:if>
						</s:iterator>
						</tr>
					</table>
				</tr>
				<TR>
					<TD>
						<div align="center">
						<s:fielderror></s:fielderror>
						<input type="file" name="myFile">
						<input type="submit" value="上传图片"> 
						</div>
					</TD>
				</TR>
			</TABLE>
		</form>
	</body>
</HTML>

