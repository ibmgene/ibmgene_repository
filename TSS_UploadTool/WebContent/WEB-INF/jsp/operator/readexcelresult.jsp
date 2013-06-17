<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>财经新闻</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	background-color: #e8e8e8;
	_width: expression(this.parentNode.offsetHeight >       
		   this.parentNode.scrollHeight ?           '100%' :          
		parseInt(this.parentNode.clientWidth)+         'px' );
	height: 100%;
}

-->
.back {
	background: #000099;
	color: #FFFFFF
}

.trnnnn0 {
	background-color: #ffffff;
}

.trnnnn1 {
	background-color: #E7F0FB;
}
</style>

<link href="css/css.css" rel="stylesheet" type="text/css" />
<link href="css/mesg.css" type=text/css rel=stylesheet />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	function subsel(type) {
		if (check()) {
			if (type == 'flfg') {
				document.form1.action = "financialnews_lawright.do?code="
						+ type;
			} else {
				document.form1.action = "financialnews_right.do?code=" + type;
			}
			document.form1.submit();
		}

	}
	function subsel_all(type) {
		if (check()) {
			document.form1.action = "financialnews_right.do?flag=ok&code="
					+ type;
			document.form1.submit();
		}
	}
	function check() {
		var startTime = document.getElementById("beginDate").value
		var endTime = document.getElementById("endDate").value
		if (startTime.length > 0 && endTime.length > 0) {
			var startTmp = startTime.split("-");
			var endTmp = endTime.split("-");
			var sd = new Date(startTmp[0], startTmp[1], startTmp[2]);
			var ed = new Date(endTmp[0], endTmp[1], endTmp[2]);
			if (sd.getTime() > ed.getTime()) {
				alert("开始日期不能大于结束日期");
				return false;
			}
		}
		return true;
	}
	function init() {

		var divwidth = window.screen.width;

		if (divwidth > 1200) {
			document.getElementById("main").style.width = (window.screen.width - 201)
					+ "px";

		} else {
			document.getElementById("main").style.width = (1200 - 201) + "px";
		}
	}
	
	
	function test(){
	//	alert("${loginname}");
		var temp = "${loginname}";
		alert("Do you want import the Data to Database, Are you sure?");
	//	window.open('importToDatabase.do?loginname=hellotest','','height=500,width=700,top=0, left=0, toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, status=no');
		window.location.href='importToDatabase.do?loginname='+"${loginname}"+'&generate_excell_base_dir='+"${generate_excell_base_dir}"+'&fileName='+"${fileName}";
	}
</script>
</head>

<body>
	<div class="ie6-out">
		<div class="ie6-in">
			<div id="min-width">

				<div id="main">
					<div class="contentTop">
						<table border="0" cellspacing="0" bgcolor="" cellpadding="0"
							width="730px">

						</table>
					</div>
					<div class="contentMiddle" id="contentMiddle1">
						<div class="contentMiddle_div" id="contentMiddle2">
							<table width="100%" border="0" cellpadding="0" cellspacing="0"
								id="contenttable">
								<%-- 
								<tr>
									<td class="text-title02" scope="col" width="4%">序号</td>
									<td class="text-title02" scope="col" width="10%">日期</td>
									<td class="text-title02" scope="col" width="50%">标题</td>
									<td class="text-title02" scope="col" width="8%">来源</td>
									<td class="text-title02" scope="col" width="14%">类别</td>
								</tr>
								--%>
								<c:set var="total" value="20"></c:set>
								<c:if test="${fn:length(list)==0}">
									<tr>
										<td class="text-title02" scope="col" colspan="5">---无记录---</td>
									</tr>
									<c:set var="total" value="19"></c:set>
								</c:if>
								<c:forEach items="${list}" var="news" varStatus="st" begin="1">
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
									<td class="text01">&nbsp;${news["22"]}${news["23"]}</td>
									</tr>
								</c:forEach>
								
								<tr>
								<td colspan=23>
								
								<input type="button" value="confirm" onclick="test();"></input>

								<div id=admin_login>${loginname}</div>
								<div id=admin_login>${generate_excell_base_dir}</div>
								<div id=admin_login>${fileName}</div>
					</td>
					
								</tr>
							</table>
						</div>
					</div>

					<%-- 
					<div class="contentBottom">
						<gazx:pageSplit pageNo="${pageNo}" url="${pageURL}"
							count="${recordsCount}" pageSize="${pageSize}" />
					</div>
--%>

					
				</div>


			</div>
		</div>
	</div>
</body>
</html>




