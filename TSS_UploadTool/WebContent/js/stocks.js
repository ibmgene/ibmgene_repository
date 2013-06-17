if(null == window.document.getElementById("divSelectControl")){
	writeSelectControlDiv();
}
var g_objExport;
var stockInfokeycode;
var g_AutoComplete = new inxite_AutoComplete();
/*
 * Control define
*/
function inxite_AutoComplete(){
	this.objExport = null;
	this.objExportValue = null;
    this.eventSrc = null;
    this.divSelect = window.document.getElementById("divSelectControl");    
    this.selectedRowIndex = null;
    this.rowCount = 0;
    this.deepBgColor = "#DFE8F6";
    this.lightBgColor = "#ffffff";
    this.itemList = window.document.getElementById("tbItemList");
}

function stockInfofetchList(key,stockInfoInput){
	var value = key;
	if(value==null||value==''){
		return;
	}
	stockInfokeycode = window.event.keyCode; 
	var reg = /^\d+$/;
	if(reg.test(value)){
		$.ajax({
			type: "GET",
			url: "choose_stockbytradingcode.do",
			data: "tradingcode="+value,
			dataType:"json",
			success: function(obj){
				var arrValue = new Array(); 
				if(obj!=null&&obj!=''){
					afterGetDataList(obj,arrValue);
				}else{
					return false;
				}
				fillItemDataList(stockInfoInput,arrValue,stockInfokeycode); 
			}
		});
	}else{
		$.ajax({
			type: "GET",
			url: "choose_stockbyword.do",
			data: "word="+encodeURIComponent(value),
			dataType:"json",
			success: function(obj){
				var arrValue = new Array(); 
				if(obj!=null&&obj!=''){
					afterGetDataList(obj,arrValue);
				}else{
					return false;
				} 
				fillItemDataList(stockInfoInput,arrValue,stockInfokeycode); 
			}
		});
	}
} 
			
function writeSelectControlDiv(){
	document.write("<div id=\"divSelectControl\" style=\"width:136px; height:200px;FONT-FAMILY: Arial, Helvetica, sans-serif; COLOR: #000000; FONT-SIZE: 12px; border:1px #61A3D4 solid; padding:2px;position:absolute; z-index: 9999; display:none; BACKGROUND:#ffffff\" >\n");
	document.write("<table id=\"tbItemList\" style=\"width:100%;border-collapse:collapse;border:1px; padding:0; text-align:left\"></table>");
	document.write("</div>\n");
}

function hide(){
 	g_AutoComplete.divSelect.style.display = "none";
 	g_AutoComplete.selectedRowIndex = null;
}

function fillItemDataList(ctl,valueList,keycode){
	var e = ctl;
	g_AutoComplete.eventSrc = e;
	g_AutoComplete.objExport = e;
	g_objExport = e;
	
	var name = e.name;
	var valueName = e.name + "Value";
	var valuecontrol = window.document.getElementById(valueName);
	if (null != valuecontrol){
		g_AutoComplete.objExportValue = window.document.getElementById(valueName);
	}
	
	show();
	
	// delete line
	g_AutoComplete.clear();
	
	for(var i=0; i< valueList.length; i=i+1){
        // add line
        var row=g_AutoComplete.itemList.insertRow();

        var text = valueList[i].substring((valueList[i].indexOf(" ")+1));
        var value = valueList[i].substring(0,valueList[i].indexOf(" "));
        
        var cell1 = row.insertCell(0);
        cell1.innerHTML = text;
		cell1.style.borderColor = "#EAEAEA";
		cell1.style.borderStyle = "solid";
		cell1.style.borderWidth = "0 0 1px 0"; 
		cell1.style.height = "22px";
		cell1.style.font.size = "2";
		cell1.style.font.color = "#E0302A";
		cell1.style.cursor = "hand";
		
		
		var cell2 = row.insertCell(1);
		cell2.style.display = "none";
		cell2.innerHTML = value;

		
        
        row.onmouseover = function(){g_AutoComplete.selected(this.rowIndex);};
        row.onclick = function(){g_AutoComplete.getSelectedData(this.rowIndex);};
	}
	
	g_AutoComplete.rowCount = g_AutoComplete.itemList.rows.length;

	var width = e.style.width;
	var content = window.document.getElementById("divSelectControl");
	if (null != width && "" != width){
		if (content !== null){
			content.style.width = width;
		}
	}
	if (content !== null){
		content.style.height = (g_AutoComplete.rowCount + 1) * 22;
	}

	if (null == g_AutoComplete.selectedRowIndex){
		if (g_AutoComplete.rowCount>0){
			g_AutoComplete.selectedRowIndex = 0;
			
			g_AutoComplete.itemList.rows(g_AutoComplete.selectedRowIndex).style.background = g_AutoComplete.deepBgColor;
		}
	}

	if (keycode == 38){
		g_AutoComplete.upMoveSelectedRow();
		//g_AutoComplete.getSelectedData(g_AutoComplete.selectedRowIndex);
	}
	
	if (keycode == 40){
		g_AutoComplete.downMoveSelectedRow();
		//g_AutoComplete.getSelectedData(g_AutoComplete.selectedRowIndex);
	}
	
	if (keycode == 13){ //enter
		g_AutoComplete.getSelectedData(g_AutoComplete.selectedRowIndex);
	}
	
	if (keycode == 27){
		hide();
	}
}



inxite_AutoComplete.prototype.selected = function(rowIndex){
	for(var i=0; i<g_AutoComplete.rowCount; i=i+1){
		g_AutoComplete.itemList.rows(i).style.background = g_AutoComplete.lightBgColor;
	}
	
	g_AutoComplete.itemList.rows(rowIndex).style.background = g_AutoComplete.deepBgColor;
	g_AutoComplete.selectedRowIndex = rowIndex;
	}

inxite_AutoComplete.prototype.upMoveSelectedRow = function(){
	if (g_AutoComplete.selectedRowIndex == 0)
		g_AutoComplete.selectedRowIndex = g_AutoComplete.rowCount - 1;
	else
		g_AutoComplete.selectedRowIndex = g_AutoComplete.selectedRowIndex - 1;
		
	g_AutoComplete.selected(g_AutoComplete.selectedRowIndex);
}

inxite_AutoComplete.prototype.downMoveSelectedRow = function(){
	if (g_AutoComplete.selectedRowIndex == g_AutoComplete.rowCount - 1)
		g_AutoComplete.selectedRowIndex = 0;
	else
		g_AutoComplete.selectedRowIndex = g_AutoComplete.selectedRowIndex + 1;
		
	g_AutoComplete.selected(g_AutoComplete.selectedRowIndex);
}

inxite_AutoComplete.prototype.getSelectedData = function(rowIndex){

	if(g_objExport){
		var tr = g_AutoComplete.itemList.rows(rowIndex);
		for(var i = 0; i < tr.childNodes.length; i=i+1){
			if (null != g_AutoComplete.objExportValue){
				g_AutoComplete.objExportValue.value = tr.childNodes[1].innerText;		
			}
			
			g_objExport.value = tr.childNodes[0].innerText;
		}
	}

	try{
		afterFinishSelect(g_objExport.value);
	}catch(e){}
		

	hide();
}

inxite_AutoComplete.prototype.clear = function(){
	g_AutoComplete.rowCount = g_AutoComplete.itemList.rows.length;
	if (g_AutoComplete.rowCount > 0)
	{
		for(var i = (g_AutoComplete.rowCount)-1;i>=0;i=i-1){
			g_AutoComplete.itemList.deleteRow(i);
		}
	}
}

function show(){
	
	var t = g_AutoComplete.objExport.offsetTop;
	var h = g_AutoComplete.objExport.clientHeight;
	var l = g_AutoComplete.objExport.offsetLeft;
	var p = g_AutoComplete.objExport.type;
	
	while (g_AutoComplete.objExport = g_AutoComplete.objExport.offsetParent){
		t += g_AutoComplete.objExport.offsetTop; 
		l += g_AutoComplete.objExport.offsetLeft;
	}
	
	var o = g_AutoComplete.divSelect.style;
	o.display = "";

	var cw = g_AutoComplete.divSelect.clientWidth; 
	var ch = g_AutoComplete.divSelect.clientHeight;
    var dw = document.body.clientWidth;
    var dl = document.body.scrollLeft;
    var dt = document.body.scrollTop;
    
	if (document.body.clientHeight + dt - t - h >= ch){
		o.top = t + h + 2;
	}
	else{
		o.top  = (t - dt < ch) ? t + h + 2: t - ch;
	}
	
	if (dw + dl - l >= cw) {
		o.left = l;
	}
	else{
		o.left = (dw >= cw) ? dw - cw + dl : dl;
	}
}

document.onclick = function()
{
    if(g_AutoComplete.eventSrc != null && g_AutoComplete.eventSrc != window.event.srcElement){
    	hide();
    }
}
