SearchStock = function (config){
	var _this = this;
	this.id;
	this.input;
	this.inputDefaultValue;
	this.form;
	this.url;
	this.types = "";
	if (config && typeof config == 'object') {
		for (var property in config) {
			this[property] = config[property];
		}
	}
	$(this.input).val(this.inputDefaultValue);
	var pageNo_old = 1;
	function loadData(code,pageNo,keyCode){
		$.ajax({
			type : "GET",
			url : _this.url,
			cache:true,
			data:{
				tradingcode:encodeURI(code),
				pageNo:pageNo,
				types:_this.types
			}, 
			dataType :"json",
			success: function(data, textStatus){
				if (data && data.length > 0){
					if(pageNo > 0){
						pageNo_old = pageNo;
					}
					var html = appendHtml(data,code);
					$("#"+_this.id).remove();
					$(document.body).append(html);
					$("#"+_this.id).css("top",$(_this.input).position().top+$(_this.input).outerHeight() + "px");
					$("#"+_this.id).css("left",$(_this.input).position().left+ "px");
					registerListEvent();
					$("#"+_this.id).find("tr").addClass("search_div_tr");
					if(!keyCode){
						$("#"+_this.id).find("tr:first").removeClass("search_div_tr");
						$("#"+_this.id).find("tr:first").addClass("search_div_tr_show");
					}
				} else {
					if(pageNo == 1){
						$("#"+_this.id).remove();	
					}
				}
				if(keyCode){
					if(keyCode == 40){
						$("#"+_this.id).find("tr:first").removeClass("search_div_tr");
						$("#"+_this.id).find("tr:first").addClass("search_div_tr_show");	
					}else if(keyCode == 38){
						$("#"+_this.id).find("tr:last").removeClass("search_div_tr");
						$("#"+_this.id).find("tr:last").addClass("search_div_tr_show");
					}
				}
			}
		});
	}
	var lastValue;
	function registerInputEvent() {
		$(this.input).keyup(function(event){
			var value = $(this).val();
			if(event.which == 40){
				var list = $("#"+_this.id);
				if($(list).length > 0){
					var list_show = $(list).find("tr.search_div_tr_show");
					if($(list_show).length ==0){
						$(list).find("tr:first").removeClass("search_div_tr");
						$(list).find("tr:first").addClass("search_div_tr_show");
					} else {
						$(list_show).removeClass("search_div_tr_show");
						$(list_show).addClass("search_div_tr");
						if($(list_show).next("tr").length == 0){
							loadData(value, pageNo_old + 1,40);
						} else {
							$(list_show).next("tr").removeClass("search_div_tr");
							$(list_show).next("tr").addClass("search_div_tr_show");
						}
					}
					return;
				}
			} else if (event.which == 38){
				var list = $("#"+_this.id);
				if($(list).length > 0){
					var list_show = $(list).find("tr.search_div_tr_show");
					if($(list_show).length ==0){
						$(list).find("tr:last").removeClass("search_div_tr");
						$(list).find("tr:last").addClass("search_div_tr_show");
					} else {
						$(list_show).removeClass("search_div_tr_show");
						$(list_show).addClass("search_div_tr");
						if($(list_show).prev("tr").length == 0){
							loadData(value, pageNo_old - 1,38);
						} else {
							$(list_show).prev("tr").removeClass("search_div_tr");
							$(list_show).prev("tr").addClass("search_div_tr_show");
						}
					}
					return;
				}
			}
			if(value == ''){
				$("#"+_this.id).remove();
			}else if (lastValue != value) {
				loadData(value,1);
			}
			lastValue = value;
		}).mousedown(function(){
			var value = $(this).val();
			if(value == _this.inputDefaultValue){
				$(this).val("");
				return;
			}
			if(value){
				loadData(value,1);
			}
		});
	}
	
	function registerListEvent(){
		$(_this.input).blur(function(event){
			var value = $(this).val();
			if(!value){
				$(this).val(_this.inputDefaultValue);
			}
			$("#"+_this.id).remove();
		})
		$("#"+_this.id).find("tr").hover(function(){
			$("#"+_this.id).find("tr.search_div_tr_show").removeClass("search_div_tr_show").addClass("search_div_tr");
			$(this).removeClass("search_div_tr");
			$(this).addClass("search_div_tr_show");
		},function(){
			$(this).removeClass("search_div_tr_show");
			$(this).addClass("search_div_tr");
		}).click(function(){
			var code=$(this).attr("symbol");
			var type=$(this).attr("stype");
			$(_this.input).val(code);
			lastValue = code;
			var list_show = $("#"+_this.id).find("tr.search_div_tr_show");
			if($(list_show).length > 0){
				var code=$(list_show).attr("symbol");
				var type=$(list_show).attr("stype");
				$(_this.input).val(code);
				var html="<input type='hidden' name='stocktype' value='"+type+"'>";
				$(_this.form).find("input:hidden[name=stocktype]").remove();
				$(_this.form).append(html);
				$("#"+_this.id).remove();
			}
			$(_this.form).submit();
			$(_this.form).find("input:hidden[name=stocktype]").remove();
		});
		$("#"+_this.id).hover(function(){
			$(_this.input).unbind("blur");
		},function(){
			$(_this.input).blur(function(event){
				$("#"+_this.id).remove();
			});
		})
	}
	
	function build() {
		registerInputEvent.call(this);
		$(_this.form).submit(function(){
			if(!$(_this.input).val()){
				return false;
			}
			var list_show = $("#"+_this.id).find("tr.search_div_tr_show");
			if($(list_show).length > 0){
				var code=$(list_show).attr("symbol");
				var type=$(list_show).attr("stype");
				$(_this.input).val(code);
				var html="<input type='hidden' name='stocktype' value='"+type+"'>";
				$(_this.form).find("input:hidden[name=stocktype]").remove();
				$(_this.form).append(html);
				$("#"+_this.id).remove();
			}
		});
	}
	
	function appendHtml(data,code){
		var html = "<table id='" + _this.id + "' border='0' cellpadding='0' cellspacing='0' class='search_div'>";
		for (var index in data) {
			var symbol = data[index].tradingcode;
			var sname = data[index].secuabbr;
			var sspell = data[index].chispelling;
			var stype = data[index].stype;
			html += "<tr symbol='" + symbol + "' sname='" + sname + "' sspell='" + sspell + "' stype='" + stype + "'>";
			if (symbol) {
				symbol = symbol.replace(code, "<b>"+ code +"</b>");
			}
			if (sname) {
				sname = sname.replace(code, "<b>"+ code +"</b>");
			}
			if (sspell) {
				sspell = sspell.replace(code, "<b>"+ code +"</b>");
			}
		    html += "<td class='search_div_td'>" + symbol + "</td>";
		    html += "<td class='search_div_td'>" + sname + "</td>";
		    html += "<td class='search_div_td'>" + sspell + "</td>";
			html += "</tr>";
		}			  
	    html += "</table>";
		return html;
	}
	build.call(this);
}