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
			.header_table{
				width: 100%;
				background: #F1F1F1;
				border-collapse:collapse;  
				border-spacing:0;

			}

			.header_table td{  
				padding-left:20px;  
			}  

			.admin_panel_table{
				border-collapse:separate;  
				border-spacing:10px 10px;  

			}

			.admin_panel_table td{
				padding: 20px;  

			}


			.admin_panel_mt{
				
				margin: 20px 20px 20px 20px;
			}

			.admin_panel_opreta{
				margin: 20px 20px 20px 20px;
			}
			.panel_box{
				border: 1px solid #F1F1F1;
			}
		</style>
		<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$("#loginOut_button").click(function(){
		deleteAllCookie();
		window.location.href="loginOut.do";
	});
	
	var loginname = getCookie("loginname");
	$("#loginname_span").html(loginname);
	
});


function getCookie(Name) 
{ 
    var search = Name + "=";
    if(document.cookie.length > 0) 
    { 
        offset = document.cookie.indexOf(search) ;
        if(offset != -1) 
        { 
            offset += search.length ;
            end = document.cookie.indexOf(";", offset) ;
            if(end == -1) end = document.cookie.length ;
            return unescape(document.cookie.substring(offset, end)) ;
        } 
        else return "" ;
    } 
} 

function deleteAllCookie(){  
	//获取 Cookie 字符串  
	var strCookie = document.cookie;  
	//将多 Cookie 切割为多个名、值对  
	var arrCookie = strCookie.split(";");  
	//遍历 Cookie 数据，处理每个 Cookie 对  
	var thisCookie;  
	for (var i=0;i<arrCookie.length;i++ ){  
 		//将每个 Cookie 对切割分为名和值  
		thisCookie = arrCookie[i];  
		var arrThisCookie = thisCookie.split("=");  
		//获取每个 Cookie 的变量名  
		var thisCookieName;thisCookieName=arrThisCookie[0];    
		document.cookie = thisCookieName + " =" +";expires=Thu, 01-Jan-1970 00:00:01 GMT"+";path=/";  
	}  
//	alert("Cookie清除完毕！");  
} 

</script>
	</head>
	<body>
		<div id="header" >
			<table class="header_table">
				<tr>
					<td style="width:90%;">
						<span style="font-size: 20px;">welcome</span>&nbsp&nbsp&nbsp&nbsp <span id="loginname_span" style="font-size: 13px; color: #4D90FE;">jingpeng@cn.ibm.com</span>
					</td>
					<td style="width:10%;">
						<input id="loginOut_button" type="button" value="Sign out"></input>
					</td>
				</tr>
			</table>
		</div>

		<br />
		<br />
		<center>
		
		<table class="admin_panel_table">


			<tr>
				<td class="panel_box" style="background: #00C0E4; width:300px; height:150px;">
					<a href="admin_machinetype.do">
					<div class="admin_panel_mt">
							<p style="font-size:20px; color: #DD4B39; ">Machine Type</p>

							<p> you can add,delete,modify the machine type here</p>

<%-- 
							<div class="notice_div">
								<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
								<p>This is IBM website, you must be an IBMer <br />
								If you have any questions, please contant us. </p>
							</div>
							--%>

						</div>
					</a>
				</td>
				<td style="background: #7658F8; width:300px;height:150px;">
					<a href="admin_panel_operate.do">
					<div class="admin_panel_operate">
							<p style="font-size:20px; color: #DD4B39; ">Upload Data file</p>
							<p> you can upload the Excel file<br />
							</p>
<%-- 
							<div class="notice_div">
								<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
								<p>This is IBM website, you must be an IBMer <br />
								If you have any questions, please contant us. </p>
							</div>
--%>
						</div>
					</a>
				</td>
			</tr>
			<tr>
				<td style="background: #EAC14D; width:300px;height:150px;">
					<a href="admin_roleassignment.do">
					<div class="admin_panel_ra">
							<p style="font-size:20px; color: #DD4B39; ">Role Assignment</p>
							<p> you can change people roles here<br />
							</p>
<%-- 
							<div class="notice_div">
								<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
								<p>This is IBM website, you must be an IBMer <br />
								If you have any questions, please contant us. </p>
							</div>
							--%>

						</div>
					</a>
				</td>
				<td class="panel_box" style="background: #CB70D7; width:300px;height:150px;">
					<a href="#">
					<div class="admin_panel_desc">
							<p style="font-size:20px; color: #DD4B39; ">Q&A</p>

							<p> you can contact us here</p>

<%-- 
							<div class="notice_div">
								<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
								<p>This is IBM website, you must be an IBMer <br />
								If you have any questions, please contant us. </p>
							</div>
--%>
						</div>
					</a>
				</td>
				
	</tr>
		</table>
</center>

		<div class="footer">
			@2013 IBM
		</div>
	</body>
</html>