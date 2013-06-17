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

.trnnnn0 {
	background-color: #DDDDDD;
}

.trnnnn1 {
	color: red;
	background: #000000;
}
</style>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.blockUI.js"></script>
<script type="text/javascript">
	$(function() {

		$("#Machine_Type_table tr:even").addClass("trnnnn0");

		$("#loginOut_button").click(function() {
			window.location.href = "loginOut.do";
		});

		var loginname = getCookie("loginname");
		$("#loginname_span").html(loginname);

		$("#success_MachineType").click(function() {
			$.unblockUI();
			window.location.href = "admin_machinetype.do";
		});
		
		$("#returnAdminHomePage").click(function(){
			window.location.href = "admin.do";
		});
		
		
		$("input[name='cancel_button']").click(function(){
			$.unblockUI();
		});
		
		
		//add Machine Type
		$("#addMachineType_button").click(function() {
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
				message : $('#addMachineTypeDialog')
			});
		});

	});

	function checkAddMachineTypeForm(){
		if($("#machineType").val()==""){
			alert("please input Machine Type");
			$("#machineType").focus();
			return false;
		}else if(isNaN($("#machineType").val())){
			alert("please input the Number type");
			$("#machineType").focus();
			return false;
		}else if($("#machineType").val().length>4){
			alert("No more than four digits");
			$("#machineType").focus();
			return false;
		}
		return true;
	}
	
	function checkUpdateMachineTypeForm(){
		if($("#updateMachineType").val()==""){
			alert("please input Machine Type");
			$("#updateMachineType").focus();
			return false;
		}else if(isNaN($("#updateMachineType").val())){
			alert("please input the Number type");
			$("#updateMachineType").focus();
			return false;
		}else if($("#updateMachineType").val().length>4){
			alert("No more than four digits");
			$("#updateMachineType").focus();
			return false;
		}
		return true;
	}
	
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

	function deleteMachineTypeAjax(machine_type) {
		if(window.confirm("Are you sure to delete it?")){
			var machine_type = machine_type;
			
			$.ajax({
				type : "POST",
				url : "deleteMachineTypeAjax.do",
				data : {
					machine_type : machine_type
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
	}
	
	function addMachineTypeAjax() {
		var machine_type = $("#machineType").val();
		
		
		if(checkAddMachineTypeForm()){
			$.ajax({
				type : "POST",
				url : "addMachineTypeAjax.do",
				data : {
					machine_type : machine_type
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
	}
	
	var oldMachineType = null;
	function updateMachineType_buttonClick(machine_type) {
		oldMachineType = machine_type;
		
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
			message : $('#updateMachineTypeDialog')
		});
	}
	
	function updateMachineTypeAjax() {
		var machine_type = $("#updateMachineType").val();
		if(checkUpdateMachineTypeForm()){
			$.ajax({
				type : "POST",
				url : "updateMachineTypeAjax.do",
				data : {
					machine_type : machine_type,
					old_machine_type : oldMachineType
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
		<p>You can add , delete, update, check the Machine Type</p>
		<table id="Machine_Type_table" class="warning_table">
			<tr>
				<td width="20%" style="background: #DD4B39;">Machine Type</td>
				<td width="20%" style="background: #DD4B39;">Create User</td>
				<td width="20%" style="background: #DD4B39;">Create Time</td>
				<td width="40%" style="text-align: right; background: #DD4B39;">
					<input id="addMachineType_button" style="width: 50px;"
					type="button" value="Add"></input>
				</td>

			</tr>


			<c:if test="${fn:length(listOfMachineType)==0}">
				<tr>
					<td style="text-align: center;" scope="col" colspan="4">---No
						Records---</td>
				</tr>
				<c:set var="total" value="19"></c:set>
			</c:if>
			<c:forEach items="${listOfMachineType}" var="news" varStatus="st"
				begin="0">

				<tr>

					<td width="20%">${news["machine_type"]}</td>
					<td width="20%">${news.create_user}</td>
					<td width="20%"><fmt:formatDate value="${news.create_time}" type="date"/></td>
					<td width="40%" style="text-align: right;">
					<input id="updateMachineType_button" style="width: 50px;" type="button" value="Modify" onclick="updateMachineType_buttonClick('${news.machine_type}');"></input> 
						<input style="width: 50px;" type="button" value="Delete"
						onclick="deleteMachineTypeAjax('${news.machine_type}');"></input>
					</td>

				</tr>
			</c:forEach>

		</table>



		<div>
			<input id="returnAdminHomePage" style="width: 350px;" type="button"
				value="Return back to admin HOME page"></input>
		</div>
	</center>


	<div id="SuccessDialog" style="display: none; align: center;">
		<p>Success!</p>
		<input id="success_MachineType" style="width: 150px;"
			type="button" value="Yes"></input>
	</div>


	<div id="addMachineTypeDialog" style="display: none; align: center;">
		<center><p>Add Machine Type</p>

			<table class="login_table">
				<tr>
					<td colspan=2><span
						style="font-size: 13px; font-weight: bold;">Machine Type:</span><br />
						<input type="text" name="machineType" id="machineType"></input></td>
				</tr>
				<tr>
					<td><input  name="cancel_button" type="button" value="cancel" style="width:100px;"></input></td>
					<td><input id="addMachineType_submit" type="button" value="submit" style="width:100px;" onclick="addMachineTypeAjax();"></input></td>
				</tr>
			</table>
		</center>
	</div>
	
	<div id="updateMachineTypeDialog" style="display: none; align: center;">
		<center><p>Modify Machine Type</p>

			<table class="login_table">
				<tr>
					<td colspan=2><span
						style="font-size: 13px; font-weight: bold;">Machine Type:</span><br />
						<input type="text" name="updateMachineType" id="updateMachineType"></input></td>
				</tr>
				<tr>
					<td><input  name="cancel_button" type="button" value="cancel" style="width:100px;"></input></td>
					<td><input id="updateMachineType_submit" type="button" value="submit" style="width:100px;" onclick="updateMachineTypeAjax();"></input></td>
				</tr>
			</table>
		</center>
	</div>

<br />
	<div class="footer">@2013 IBM</div>
</body>
</html>