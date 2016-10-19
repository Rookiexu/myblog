<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.fckeditor.net" prefix="FCK"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>留言板</title>
		<link rel="stylesheet" href="image/style.css" />
	</head>

	<body topmargin="0" leftmargin="0" bgcolor="#F3F3F3">
		<jsp:include page="include/MainHeader.jsp"></jsp:include>
		<table width="1000" border="0" cellpadding="0" cellspacing="0"
			align="center">
			<tr height="30" valign="bottom">
				<td class="title">
					&nbsp;&nbsp;留言板
				</td>
			</tr>
			<tr>
				<td colspan="2" valign="top">
					<table cellpadding="4" cellspacing="1">
						<tr>
							<td>
								<table width="1000" cellpadding="6" cellspacing="1"
									bgcolor="#CCCCCC">

										<!-- 显示留言 -->
												<s:set name="loushu" value="#request.page.beginIndex"></s:set>
												<s:iterator value="#request.note" id="cri">
												<s:set name="loushu" value="#loushu + 1"></s:set>
													<tr>
														<td height="20"></td>
													</tr>
													<tr>
													<td bgcolor="#FFFFFF">
														<p align="right"><s:property value="#loushu"/>楼</p>
														<font class="chinesefont105main">
														<s:property value="#cri.content" escape="false"/>
															<hr size='1' noshade color='#CCCCCC'> <br>
													<div align='right' class='smalltxt' height='32px'>
														<!-- 发表时间 -->
														发表于:
														<s:date name="#cri.date"/>
														<!-- 作者 -->
														<p align="right">作者:<s:property value="#cri.nickname"/></p>
													</div> 
													</font>
													</td>
													</tr>
												</s:iterator>
										<tr>
											<td align="center">
												<s:if test="#request.page.hasPrePage">
													<a href="showUserAllNote.action?currentPage=1">首页</a>
													<a href="showUserAllNote.action?currentPage=${page.currentPage -1 }">上一页</a>
												</s:if>
												<s:else>
													首页
													上一页
												</s:else>
												
												<s:if test="#request.page.hasNextPage">
													<a href="showUserAllNote.action?currentPage=${page.currentPage + 1 }">下一页</a>
													<a href="showUserAllNote.action?currentPage=${page.totalPage }">尾页</a>			
												</s:if>
												<s:else>
													下一页
													尾页
												</s:else>
											</td>
										</tr>
								</table>
								
		<form action="addNote.action" method="post">
			<TABLE WIDTH="1000" BORDER="0" CELLPADDING="0" CELLSPACING="0" align="center">
				<tr height="20">
					<td height="24" colspan="2">&nbsp;</td>
				</tr>
				<TR>
					<td valign="top">
						
						<br>
		
					</td>
					<TD COLSPAN="2" align="center" valign="top">
						<table width="1000" style="BORDER-RIGHT:#cccccc 1px solid; BORDER-TOP:#cccccc 1px solid; BORDER-LEFT:#cccccc 1px solid; BORDER-BOTTOM:#cccccc 1px solid; BACKGROUND-COLOR:#f5f5f5"
							CellPadding="0" CellSpacing="0">
							<tr height="30">
							<form action="addNote.action"> <input type=hidden name="load" value="s"></form>
								<td background="image/l-bg1.jpg">&nbsp;&nbsp;&nbsp;<font color="black"><b>我的留言</b></font></td>
							</tr>
							<tr>
								<td>
									&nbsp;&nbsp;&nbsp;内容：
									<FCK:editor instanceName="content" basePath="/user/fckeditor" toolbarSet="myToolbar" height="200"></FCK:editor>
								</td>
							</tr>
							<tr height="20">
								<td>
									<input type="submit"  value="添加" Style="ButtonCss" />
									<input type="button" name="cancelButton" value="取消" onClick="history.back()" Class="ButtonCss">
								</td>
							</tr>
						</table>
					</TD>
				</TR>
			</TABLE>
		</form>
								<table id="noCount" runat="server" width="1000" cellpadding="6"
									cellspacing="1" bgcolor="#cccccc">
									<tr bgcolor="#ffffff" height="50">
										<td align="center">
											Rookiex的博客
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>