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

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
</head>

<body>
	This is my JSP page.
	<br>
	<a href="./templatefile/template_2013-06-05.xls">open the last
		version of template</a>

	<form id="form4addCreative" name="form4addCreative"
		action="addCreative.do" method="post" enctype="multipart/form-data">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="10" cellpadding="0">
						<tr>
							<td width="80" align="right" class="font_tit">创意标题：</td>
							<td><input id="creativeTopic" name="creativeTopic"
								type="text" class="input" value=""></input></td>
						</tr>
						<tr>
							<td align="right" class="font_tit">创意描述：</td>
							<td><textarea id="creativeDesc" name="creativeDesc"
									class="input" cols="45" rows="5"></textarea></td>
						</tr>
						<tr>
							<td align="right" valign="top" class="font_tit">附件：</td>
							<td bgcolor="#FFFFFF">

								<div id="zjfj" name="zjfj" class="zjfj">
									<div id="divtextfield4" style="position: relative;">
										<input id="textfield4" name="textfield4" type="text"
											style="width: 565px;"></input> <input type="file"
											name="textfield4submit"
											style="position: absolute; filter: alpha(opacity :     0); opacity: 0; width: 15px"
											id="fileField" size="28"
											onchange="document.getElementById('textfield4').value=this.value" />
										<input name="input" type="button" class="btn" value="浏  览"></input>
									</div>

								</div> <input name="input" type="button" class="btn" value="删  除"></input>
								<input name="input" type="button" class="btn" value="增加附件"
								onclick="addChooseFile();"></input> <input name="input"
								type="button" class="btn" value="提  交"
								onclick="javascript:addCreative();"></input>

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>
