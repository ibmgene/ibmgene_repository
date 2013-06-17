<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<title></title>
<head>
<link href="css/base_main.css" rel="stylesheet" type="text/css" />
<style type="text/css">
.main_desc {
	margin: 20px 20px 20px 20px;
}

table {
	margin-left: auto;
	margin-right: auto;
}

.body_div {
	padding-top: 50px;
}

.login_table {
	background: #F1F1F1;
	width: 300px;
	height: 300px;
}

.login_table th,td {
	padding: 15px;
}

/*
			.login_table input {
				width: 100%;
				height: 30px;

			}
			*/
.login_button {
	width: 100px;
}

p {
	font-size: 13px;
}

.notice_div {
	background: #F9EDBE;
	width: 360px;
	height: 100px;
	padding: 10%;
}
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		$("#login_submit").click(function() {
			//var temp = $("#username").attr("value");
			//var temp = $("#username").val();
			if (checkLoginForm()) {
				$("#login_form").submit();
			}
		});
		
	    $("html").die().live("keydown",function(event){       
	        if(event.keyCode==13){      
	            //调用登陆方法;  
	        	$("#login_submit").click();     
	         }       
	  	});
		
		if("${message}" =="error"){
			alert("${message_detail}");
		}
		
		
	});

	function checkLoginForm() {
		if ($("#username").val() == "") {
			alert("please input your IntrantID");
			$("#username").focus();
			return false;
		} else if ($("#password").val() == "") {
			alert("please input your password");
			$("#password").focus();
			return false;

		}
		return true;
	}
</script>
</head>
<body>
	<div id="header" class="header">
		<span>Welcome to TSS Entry </span>
	</div>
	<div class="body_div">
		<table style="width: 1000px; align: center;">
			<tr>
				<td width="60%">
					<div class="main_desc">
						<p style="font-size: 20px; color: #DD4B39;">Welcome !</p>

						<p>
							At first , need you to login in .<br /> Please input your
							Intrant ID and your password.
						</p>

						<div class="notice_div">
							<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
							<p>
								This is IBM website, you must be an IBMer <br /> If you have
								any questions, please contant us.
							</p>
						</div>

					</div>
				</td>
				<td width="40%">
					<div class="login">
						<form id="login_form" action="login.do" method="post">
							<table class="login_table">
								<tr>
									<td><span>Sing in</span></td>
									<td style="text-align: right;"><span>IBM</span></td>
								</tr>
								<tr>
									<td colspan=2><span
										style="font-size: 13px; font-weight: bold;">Username:</span><br />
										<input type="text" name="username" id="username"></input></td>
								</tr>

								<tr>
									<td colspan=2><span
										style="font-size: 13px; font-weight: bold;">Password:</span><br />
										<input type="password" name="password" id="password"></input></td>
								</tr>
								<tr>
									<td><input class="login_button" type="reset" value="reset"></input></td>
									<td><input id="login_submit" class="login_button"
										type="button" value="submit"></input></td>
								</tr>
							</table>
						</form>
					</div>
				</td>
			</tr>
		</table>
	</div>

<%-- 
	<div id="loginResult" style="display: none;">${message}</div>
	--%>
	
	<div class="footer">@2013 IBM</div>
</body>
</html>
