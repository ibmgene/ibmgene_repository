<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
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
}

.warning_table td {
	border: 1px solid #F1F1F1;
	padding: 10px;
}

.data_table {
	width: 100%;
	border: 1px solid #4D90FE;
	font-size: 10px;
}

.data_table td {
	border: 1px solid #F1F1F1;
	padding: 2px;
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
		$("input[name='returnToUpload']").click(function() {
			var userrole = getCookie("userrole");
			if (userrole == "admin") {
				window.location.href = "admin_panel_operate.do";
			} else {
				window.location.href = "operator_panel.do";
			}

		});
		
		$("#returnToUpload_toCheck").click(function(){
			$.unblockUI();
		});

		$("#readExcelResult tr").mouseover(function() {
			$(this).addClass("trnnnn1");
		});

		$("#readExcelResult tr").mouseout(function() {
			$(this).removeClass("trnnnn1");
		});

		$("#readExcelResult tr:even").addClass("trnnnn0");

		$("#success_returnToUpload").click(function() {
			window.location.href = "operator_panel.do";
		});

		$("#success_confirmDataToDatabase").click(function() {
			$.unblockUI();
		});

		$("#loginOut_button").click(function() {
			window.location.href = "loginOut.do";
		});

		var loginname = getCookie("loginname");
		$("#loginname_span").html(loginname);
		
		$("#confirmDataToDatabase_alert").click(function() {
			var __widowWidth = $(window).width(); 
			var __popWidth = $("#alertBeforeDataToDatabase").width(); //Loading为要显示的div 
			var __left = (__widowWidth - __popWidth)/2 + 'px'; 
			var __windowHeight = $(window).height(); 
			var __popHeight = $("#alertBeforeDataToDatabase").height(); 
			var __top = (__windowHeight-__popHeight)/2 + 'px'; 
			
			$.blockUI({
				css : {
					width: '800px',
					height: '300px',
					left: __left,
					top: __top,
					position: 'fixed'
				},
				message : $('#alertBeforeDataToDatabase')
			});
		});

		$("#confirmDataToDatabase")
				.click(
						function() {
							if (window
									.confirm("Last time to confirm! Are you sure to do it?")) {
								//window.location.href='importToDatabase.do?loginname='+"${loginname}"+'&generate_excell_base_dir='+"${generate_excell_base_dir}"+'&fileName='+"${fileName}";

								$.unblockUI();
								
								var loginname = "${loginname}";
								var generate_excell_base_dir = "${generate_excell_base_dir}";
								var fileName = "${fileName}";
								var year = "${year}";
								var month = "${month}";

								$
										.ajax({
											type : "POST",
											url : "importToDatabase.do",
											data : {
												loginname : loginname,
												generate_excell_base_dir : generate_excell_base_dir,
												fileName : fileName,
												year : year,
												month : month
											},
											dataType : "text",
											success : function(data) {
												$.unblockUI();
												//alert(data);
												$
														.blockUI({
															message : $('#successDialog')
														});

											},
											error : function(e) {
												alert("something wrong....ops.");
											},
											beforeSend : function() {
												$
														.blockUI({
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

	<div class="warning_div">
		<p>Warning! please take care the notice below. If you confirm the
			data is correct and insert data to database, it can not be changed!</p>
	</div>

	<center>
		<table class="warning_table">
			<tr>
				<td width="20%" style="background: #DD4B39;">Missing column(s)</td>
				<td width="80%">${s_lackColumn}</td>

			</tr>
			<%-- 
			<tr>
				<td style="background: #DD4B39;">Can not be empty</td>
				<td></td>
			</tr>
			--%>
			<tr>
				<td style="background: #DD4B39;">MachineType(s) NOT in database</td>
				<td>${s_moreMachineType}</td>
			</tr>
			<tr>
				<td style="background: #F9EDBE;">Missing MachineType(s)</td>
				<td>${s_lackMachineType}</td>
			</tr>
		</table>

		<br /> <br />
		<div>
			<span>The data below will be insert into database, check it
				please.</span>
			<p>
				<span style="color: #DD4B39;">YYMM: ${year}${month}</span>
			</p>
		</div>
		<br />
		<table id="readExcelResult" class="data_table">
			<c:if test="${fn:length(list)==0}">
				<tr>
					<td class="text-title02" scope="col" colspan="5">---无记录---</td>
				</tr>
				<c:set var="total" value="19"></c:set>
			</c:if>
			<c:forEach items="${list}" var="news" varStatus="st" begin="1">

				<tr>
					<%-- 
					<tr onmouseout="this.className='trnnnn0'"
					onmousemove="this.className='trnnnn1'">
										<td class="text-number" scope="row">${st.index+1 }</td>
										<td class="text01-time"><c:if test="${code eq 'flfg'}">
												<fmt:formatDate value="${news.pubdate}" dateStyle="full"
													pattern="yyyy-MM-dd" />
											</c:if> <c:if test="${code ne 'flfg'}">
												<fmt:formatDate value="${news.pubdate}" dateStyle="full"
													pattern="yyyy-MM-dd HH:mm:ss" />
											</c:if></td>
										<td class="text01-1" title="${news.reporttitle}">&nbsp;<a
											href='#' onclick="OpenDetail('${(code eq 'flfg')?"
											financiallaw_view.do?id=":"
											financialnews_view.do?id="}${news.id}');">&nbsp;&nbsp;${gazx:getLimitLenStr(news.reporttitle,35,null)}</a></td>
											
											--%>
					<td class="text01">&nbsp;${news["0"]}</td>
					<td class="text01">&nbsp;${news["1"]}</td>
					<td class="text01">&nbsp;${news["2"]}</td>
					<td class="text01">&nbsp;${news["3"]}</td>
					<td class="text01">&nbsp;${news["4"]}</td>
					<td class="text01">&nbsp;${news["5"]}</td>
					<td class="text01">&nbsp;${news["6"]}</td>
					<td class="text01">&nbsp;${news["7"]}</td>
					<td class="text01">&nbsp;${news["8"]}</td>
					<td class="text01">&nbsp;${news["9"]}</td>
					<td class="text01">&nbsp;${news["10"]}</td>
					<td class="text01">&nbsp;${news["11"]}</td>
					<td class="text01">&nbsp;${news["12"]}</td>
					<td class="text01">&nbsp;${news["13"]}</td>
					<td class="text01">&nbsp;${news["14"]}</td>
					<td class="text01">&nbsp;${news["15"]}</td>
					<td class="text01">&nbsp;${news["16"]}</td>
					<td class="text01">&nbsp;${news["17"]}</td>
					<td class="text01">&nbsp;${news["18"]}</td>
					<td class="text01">&nbsp;${news["19"]}</td>
					<td class="text01">&nbsp;${news["20"]}</td>
					<td class="text01">&nbsp;${news["21"]}</td>
					<%-- 
					<td class="text01">&nbsp;${news["22"]}${news["23"]}</td>
					--%>
				</tr>
			</c:forEach>


		</table>

		<div>
			<input id="returnToUpload" name="returnToUpload" style="width: 350px;" type="button"
				value="Return back to choose Excel file"></input> <input
				id="confirmDataToDatabase_alert" style="width: 350px; color: #DD4B39;"
				type="button" value="Confirm! Insert data to database now"></input>
		</div>
	</center>
	<br />
	<br />


	<div id="alertBeforeDataToDatabase" style="display: none;">
	<table class="warning_table" style="width:800px; height:300px;">
			<tr>
				<td width="20%" style="background: #DD4B39;">Missing column(s)</td>
				<td width="80%" style="text-align:left;">${s_lackColumn}</td>

			</tr>
			<%-- 
			<tr>
				<td style="background: #DD4B39;">Can not be empty</td>
				<td></td>
			</tr>
			--%>
			<tr>
				<td style="background: #DD4B39;">MachineType(s) NOT in database</td>
				<td style="text-align:left;">${s_moreMachineType}</td>
			</tr>
			<tr>
				<td style="background: #F9EDBE;">Missing MachineType(s)</td>
				<td style="text-align:left;">${s_lackMachineType}</td>
			</tr>
			<tr>
			<td colspan="2" ><input id="returnToUpload_toCheck" name="returnToUpload_toCheck" style="width: 350px;" type="button"
				value="Return back to check"></input> 
				
				<input
				id="confirmDataToDatabase" style="width: 350px; color: #DD4B39;"
				type="button" value="Confirm! Insert data to database now"></input></td>
			</tr>
		</table>
	</div>

	<div id="successDialog" style="display: none; align: center;">
		<p>success!</p>
		<input id="success_returnToUpload" style="width: 150px;" type="button"
			value="Return to Upload"></input> <input
			id="success_confirmDataToDatabase" style="width: 150px;"
			type="button" value="Yes"></input>
	</div>

	<div class="footer">@2013 IBM</div>
</body>
</html>
