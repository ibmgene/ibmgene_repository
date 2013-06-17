<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>收益率对比</title>
<script language="JavaScript" src="${fusioncharts_base_path!}/FusionCharts.js"></script>
<link rel="stylesheet" type="text/css" href="${css_base_path!}/newpage.css" />
<script type="text/javascript" src="${js_base_path!}/jquery.js"></script>
<script language="JavaScript" src="${js_base_path!}/common.js"></script>
</head>
<body>
<div id="box">   
    <div class="content_area">
        <div class="cwleft05" >
			<div id="divStockInfo">
				<div id="flashChart">
				</div>
				<script type="text/javascript">
				    var chartDaiyQuote = new FusionCharts("${fusioncharts_base_path!}/MSLine.swf", "ChartId", "100%", "260");
				    chartDaiyQuote.setDataURL("${dailyQuoteChartXmlUrl_hushen!}");		   
				    chartDaiyQuote.addParam("wmode","transparent");   
				    chartDaiyQuote.render("flashChart");
				</script>
			</div>
        </div>       
    </div>
</div>
</body>
</html>