<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/include/includes.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>upload the Excell</title>
<link href="css/newspage.css" rel="stylesheet" type="text/css" />

<script src="js/jquery.js" type="text/javascript"></script>


<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
	_width: expression(this.parentNode.offsetHeight >    
		this.parentNode.scrollHeight ?     '100%' :     parseInt(this.parentNode.clientWidth
		)+   'px' );
}
-->
</style>

<script type="text/javascript">
function submitForm(){
	$("#form4UploadExcell").submit();
}
</script>

</head>

<body>
<div>
Welcome! ${username }
</div>

<div>notice: you only can input the Number, not "--" or not char.</div>
	<form id="form4UploadExcell" name="form4UploadExcell"
		action="readXLS.do" method="post" enctype="multipart/form-data">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td bgcolor="#FFFFFF">
					<table width="100%" border="0" cellspacing="10" cellpadding="0">
						
						<tr>
							<td align="right" valign="top" class="font_tit">Excell file：</td>
							<td bgcolor="#FFFFFF">

								<div id="zjfj" name="zjfj" class="zjfj">
									<div id="divtextfield4" style="position: relative;">
										<input id="textfield4" name="textfield4" type="text"
											style="width: 565px;"></input> 
									<input type="file"
											name="textfield4submit"
											style="position: absolute; filter: alpha(opacity :         0); opacity: 0; width: 15px"
											id="fileField" size="28"
											onchange="document.getElementById('textfield4').value=this.value" />
										<input name="input" type="button" class="btn" value="浏  览"></input>
									</div>

								</div> 
								<input name="input" type="button" class="btn" value="删  除"></input>
								<input name="input" type="button" class="btn" value="增加附件"
								onclick="addChooseFile();"></input> <input name="input"
								type="button" class="btn" value="提  交"
								onclick="javascript:submitForm();"></input>

							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</form>


</body>
</html>
