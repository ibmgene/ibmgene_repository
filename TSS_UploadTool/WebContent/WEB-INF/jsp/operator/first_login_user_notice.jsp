<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<head>
<link href="css/base_main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.header_table {
	width: 100%;
	background: #F1F1F1;
	border-collapse: collapse;
	border-spacing: 0;
}

.header_table th,td {
	padding-left: 20px;
}

.upload_desc {
	margin: 20px 20px 20px 20px;
}

.upload_notice {
	margin: 20px 20px 20px 20px;
}

.infomation_table {
	width: 650px;
}

.infomation_table td {
	border: 1px solid #F1F1F1;
	padding: 2px;
}
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#downloadExcelTemplate").click(function() {
			window.location.href = "./templatefile/template_2013-06-05.xls";
		});

		$("#uploadExcelFile").click(function() {
			if ($("#textfield4").val() == "") {
				alert("You need to choose one Excel file");
			} else {
				$("#form4UploadExcell").submit();
			}
		});

		$("#loginOut_button").click(function() {
			window.location.href = "loginOut.do";
		});

		var loginname = getCookie("loginname");
		$("#loginname_span").html(loginname);
	});

	function getCookie(Name) {
		var search = Name + "=";
		if (document.cookie.length > 0) {
			offset = document.cookie.indexOf(search);
			if (offset != -1) {
				offset += search.length;
				end = document.cookie.indexOf(";", offset);
				if (end == -1)
					end = document.cookie.length;
				return unescape(document.cookie.substring(offset, end));
			} else
				return "";
		}
	}
</script>

</head>
<body>
	<div id="header">
		<table class="header_table">
			<tr>
				<td style="width: 90%;"><span style="font-size: 20px;">welcome</span>&nbsp&nbsp&nbsp&nbsp
					<span id="loginname_span" style="font-size: 13px; color: #4D90FE;">${loginname}</span>
				</td>
				<td style="width: 10%;"><input id="loginOut_button"
					type="button" value="Sign out"></input></td>
			</tr>
		</table>
	</div>

	<center>

		<p>Welcome , You are a new user for this tool</p>

		<p>
			you are the <span style="color: #DD4B39">VIEWER</span> role.<br />
		</p>
		<p>
			you need get the <span style="color: #DD4B39">USER</span> role.<br />
		</p>

		<div class="notice_div">
			<p>
				You can contact <span style="color: #2E8AF0">Mauro Solda (msolda@cn.ibm.com)</span> to
				get the <span style="color: #DD4B39">USER</span> role.
			</p>
		</div>
		<div style="background: #FFDD55; width: 650px;">
			<p>
				<span><a href="mailto:msolda@cn.ibm.com">Click here to
						send an Email to Mauro Solda</a></span>
			</p>
		</div>
		
		<br />
		<br />
		<br />
		<br />
		<table class="infomation_table">
			<tr>
				<td width="20%" style="background: #DD4B39; text-align: center">Role</td>
				<td width="80%" style="background: #DD4B39; text-align: center">
					Description</td>

			</tr>
			<tr>
				<td style="background: #F9EDBE;">Viewer</td>
				<td><span>The new user, need to get the operator role from
						Admin for using this tool.</span></td>
			</tr>
			<tr>
				<td style="background: #F9EDBE;">User</td>
				<td>Can use this tools, for example, upload data files.</td>
			</tr>
			<tr>
				<td style="background: #F9EDBE;">Admin</td>
				<td>Has all permissions.</td>
			</tr>
		</table>

	</center>

	<div class="footer">@2013 IBM</div>
</body>
</html>
