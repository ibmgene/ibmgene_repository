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
</style>

<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">

$(function(){
	$("#downloadExcelTemplate").click(function(){
		window.location.href="./templatefile/template_2013-06-05.xls";
	});
	
	$("#uploadExcelFile").click(function(){
		if($("#textfield4").val()==""){
			alert("You need to choose one Excel file");
		}else if(checkInputYearAndMonth()){
			$("#form4UploadExcell").submit();
		}
	});
	
	$("#loginOut_button").click(function(){
		window.location.href="loginOut.do";
	});
	
	var loginname = getCookie("loginname");
	$("#loginname_span").html(loginname);
});


function checkInputYear(){
	var year = $("#input_text_year").val();
	if(year==""){
		alert("Please input the Year , format by : YYYY");
		$("#input_text_year").focous();
		return false;
	}else if(isNaN(year)){
		alert("Please input the Year , format by : YYYY");
		$("#input_text_year").focous();
		return false;
	}else if(year.length!=4){
		alert("Please input the Year , format by : YYYY");
		$("#input_text_year").focous();
		return false;
	}
	return true;
}

function checkInputYearAndMonth(){
	var month = $("#input_text_month").val();
	if(checkInputYear()){
		if(month==""){
			alert("Please input the Month");
			$("#input_text_month").focous();
			return false;
		}else if(isNaN(month)){
			alert("Please input the Month");
			$("#input_text_month").focous();
			return false;
		}
	}
	return true;
}


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


</script>

</head>
<body>
	<div id="header">
		<table class="header_table">
			<tr>
				<td style="width: 90%;"><span style="font-size: 20px;">welcome</span>&nbsp&nbsp&nbsp&nbsp
					<span id="loginname_span" style="font-size: 13px; color: #4D90FE;">${loginname}</span>
				</td>
				<td style="width: 10%;"><input id="loginOut_button" type="button" value="Sign out"></input>
				</td>
			</tr>
		</table>
	</div>

	<center>
		<form id="form4UploadExcell" name="form4UploadExcell"
		action="readXLS.do" method="post" enctype="multipart/form-data">
		<br />
		<br />
		<div id="divtextfield4" style="position: relative;">
			<span style="font-size: 12px; ">Please input the year and month:</span>
			<input id="input_text_year" name ="input_text_year" type="text" style="width: 70px; height:20px; "/><span style="font-size: 12px; ">Year (format: YYYY)</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<select id="input_text_month" name="input_text_month" style="width:100px; height:20px;">
					<option value="01" selected="selected">01</option>
					<option value="02">02</option>
					<option value="03">03</option>
					<option value="04">04</option>
					<option value="05">05</option>
					<option value="06">06</option>
					<option value="07">07</option>
					<option value="08">08</option>
					<option value="09">09</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select><span style="font-size: 12px; ">Month</span>
			<br />
		</div>
		
		<div id="divtextfield4" style="position: relative;">
			<input id="textfield4" name="textfield4" type="text"
				style="width: 800px;"> </input> <input type="file"
				name="textfield4submit"
				style="position: absolute; filter: alpha(opacity :     0); opacity: 0; width: 50px; height: 50px;"
				id="fileField" size="40"
				onchange="document.getElementById('textfield4').value=this.value" />
			<input name="input" type="button" value="Browse"></input>
		</div>

		<div>
			<input id="downloadExcelTemplate" style="width: 350px;" type="button"
				value="Download the last version TEMPLATE"></input> 
			<input id="uploadExcelFile" style="width: 350px; color: #DD4B39;" type="button"
				value="Upload the Excel File"></input>
		</div>
</form>
		<br />
		<br />
		<br />
		<br />
		<table>
			<tr>
				<td>
					<p style="font-size: 20px; color: #DD4B39;">Description:</p>
				</td>
				<td style="background: #F9EDBE;">
					<p style="font-size: 20px; color: #DD4B39;">Notice:</p>
				</td>
			</tr>

			<tr>
				<td>
					<div class="upload_desc">
						<p style="font-size: 20px; color: #DD4B39;">Welcome !</p>

						<p>
							Please read the notice right side.
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
				<td style="background: #F9EDBE;">
					<div class="upload_notice">

						<p>
							you just can input the Text and Number type data .<br />
						</p>

						<div class="notice_div">
							<p style="font-size: 20px; color: #DD4B39;"></p>
							<p>
								
							</p>
						</div>

					</div>
				</td>
			</tr>
		</table>
	</center>

	<div class="footer">@2013 IBM</div>
</body>
</html>
