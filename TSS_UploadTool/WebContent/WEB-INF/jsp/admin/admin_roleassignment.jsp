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

.warning_div {
	color: #DD4B39;
	padding-left: 30px;
}

.warning_table {
	border: 1px solid #4D90FE;
	width: 800px;
}

.warning_table td {
	border: 1px solid #F1F1F1;
	padding: 5px;
}

.data_table {
	width: 100%;
	border: 1px solid #4D90FE;
}

.data_table td {
	border: 1px solid #F1F1F1;
	padding: 2px;
}

.warning_table input[type="button"] { /*
				-moz-user-select: none;
				*/
	background-color: #F5F5F5;
	/*
				background-image: -moz-linear-gradient(center top , #F5F5F5, #F1F1F1);
				*/
	border: 1px solid #C6C6C6;
	/*
				border-radius: 2px 2px 2px 2px;
				*/
	color: #666666;
	cursor: pointer;
	font-family: arial, sans-serif;
	font-size: 11px;
	font-weight: bold;
	height: 29px;
	line-height: 27px;
	margin: 0px 0px;
	min-width: 54px;
	padding: 0 8px;
	text-align: center;
}

.warning_table input[type="button"]:hover {
	background-color: #F8F8F8;
	background-image: -moz-linear-gradient(center top, #F8F8F8, #F1F1F1);
	border: 1px solid #C6C6C6;
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
	color: #333333;
}

.warning_table input[type="button"]:focus {
	border: 1px solid #4D90FE;
	outline: medium none;
}

.modifyUserRole_table td {
	padding: 5px;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>
<script type="text/javascript">
	$(function() {
		$("#loginOut_button").click(function() {
			window.location.href = "loginOut.do";
		});

		$("input[name='cancel_button']").click(function() {
			$.unblockUI();
		});

		var loginname = getCookie("loginname");
		$("#loginname_span").html(loginname);

		$("#returnAdminHomePage").click(function() {
			window.location.href = "admin.do";
		});
		
		$("#success_MachineType").click(function() {
			$.unblockUI();
			window.location.href = "admin_roleassignment.do";
		});

		$("#modifyRole_button")
				.click(
						function() {
							var checked_username_role = $(
									'input:radio[name="username_role"]:checked')
									.val();
							if (typeof (checked_username_role) == "undefined") {
								alert("You need to choose one user to change the user's role");
							} else {
								$.blockUI({
									/**
									
									css : {
										border : 'none',
										padding : '15px',
										backgroundColor : '#000',
										'-webkit-border-radius' : '10px',
										'-moz-border-radius' : '10px',
										opacity : .5,
										color : '#fff'
									},
									 */
									css : {
										width : '400px',
										height : '230px'

									},
									message : $('#updateUserRoleDialog')
								});

								$("#updateUserRole_username").attr("value",
										checked_username_role);
								$("#updateUserRole_username").attr("disabled",
										true);
							}

						});

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
	
	
	function updateUserRoleAjax() {
		var updateUserRole_username = $("#updateUserRole_username").val();
		var updateUserRole_role = $("#updateUserRole_roleSelect").find("option:selected").text();
			$.ajax({
				type : "POST",
				url : "updateUserRoleAjax.do",
				data : {
					updateUserRole_username : updateUserRole_username,
					updateUserRole_role : updateUserRole_role
				},
				dataType : "text",
				success : function(data) {
					// alert(data);
					$.unblockUI();
					$.blockUI({
						message : $('#SuccessDialog')
					});

				},
				error : function(e) {
					alert("something wrong...oops");
				},
				beforeSend : function() {
					$.unblockUI();
					$.blockUI({
						css : {
							border : 'none',
							padding : '15px',
							backgroundColor : '#000',
							'-webkit-border-radius' : '10px',
							'-moz-border-radius' : '10px',
							opacity : .5,
							color : '#fff'
						}
					});
				}
			});
	}
</script>
</head>
<body>
	<div id="header">
		<table class="header_table">
			<tr>
				<td style="width: 90%;"><span style="font-size: 20px;">welcome</span>&nbsp&nbsp&nbsp&nbsp
					<span id="loginname_span" style="font-size: 13px; color: #4D90FE;">jingpeng@cn.ibm.com</span>
				</td>
				<td style="width: 10%;"><input id="loginOut_button"
					type="button" value="Sign out"></input></td>
			</tr>
		</table>
	</div>


	<center>
		<p>You can modify the user role</p>
		<table class="warning_table">
			<tr>
				<td width="30%" style="background: #DD4B39; text-align: center;">
					User Name</td>
				<td width="70%" style="text-align: right;"><input
					id="modifyRole_button" style="width: 150px;" type="button"
					value="Modify Role"></input></td>

			</tr>
			<c:if test="${fn:length(listOfRoleName)==0}">
				<tr>
					<td style="text-align: center;" scope="col" colspan="2">---No
						Records---</td>
				</tr>
				<c:set var="total" value="19"></c:set>
			</c:if>

			<c:forEach items="${listOfRoleName}" var="news" varStatus="st"
				begin="0">

				<tr>
					<td width="20%" style="background: #F9EDBE;"><input
						name="username_role" type="radio" value="${news.loginname}" />${news["loginname"]}
					</td>
					<td width="80%" style="text-align: right;">
						${news["role_name"]}</td>

				</tr>
			</c:forEach>
		</table>

		<div id="updateUserRoleDialog" style="display: none; align: center;">
			<center>
				<p>Modify User Role</p>

				<table class="modifyUserRole_table">
					<tr>
						<td colspan=2><span
							style="font-size: 13px; font-weight: bold;">Username:</span><br />
							<input type="text" name="updateUserRole_username"
							id="updateUserRole_username"></input></td>
					</tr>
					<tr>
						<td colspan=2><span
							style="font-size: 13px; font-weight: bold;">Role:</span><br /> 
						<select id="updateUserRole_roleSelect">
								<option value="user" selected="selected">user</option>
								<option value="admin">admin</option>
						</select></td>
					</tr>
					<tr>
						<td><input name="cancel_button" type="button" value="cancel"
							style="width: 100px;"></input></td>
						<td><input id="updateMachineType_submit" type="button"
							value="submit" style="width: 100px;"
							onclick="updateUserRoleAjax();"></input></td>
					</tr>
				</table>
			</center>
		</div>
		
	<div id="SuccessDialog" style="display: none; align: center;">
		<p>Success!</p>
		<input id="success_MachineType" style="width: 150px;"
			type="button" value="Yes"></input>
	</div>

		<div>
			<input id="returnAdminHomePage" style="width: 350px;" type="button"
				value="Return back to admin HOME page"></input>
		</div>
		
		
	</center>

	<div class="footer">@2013 IBM</div>
</body>
</html>