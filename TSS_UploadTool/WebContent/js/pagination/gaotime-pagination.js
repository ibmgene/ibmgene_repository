$.fn.pagination = function(totalProperty,opts){
	opts = $.extend({
		perPage:10,
 		currPage:0,
		callback:function(){
		}
	},opts||{});
		
	return this.each(function(){
		function numPages(){
			return Math.ceil(totalProperty/opts.perPage);
		}
 
		
		function selectPage(page){
			return function(){
				opts.currPage = page;
				if (page<0) opts.currPage = 0;
				if (page>=numPages()) opts.currPage = numPages()-1;
				//render();
 				
				
				opts.callback(opts.currPage+1,opts.perPage);
				$('img.page-wait',panel).attr('src','images/pagination/wait.gif');
				return false;
			}
		}
		
		function render(){
			var html = '<div class=\'pagination\'><table style=\'margin-left:40px\'><tbody><tr>' 
				+'<td><a href="#nogo"><img class="page-first"></a></td>'
				+'<td><a href="#nogo"><img class="page-prev"></a></td>'
				+'<td><span class=\'pagepad\'>第'+'<font style=\'font-weight:bold\' color=#2C59D7>'+(opts.currPage+1)+'</font>'+'页/共'+'<font style=\'font-weight:bold\' color=#2C59D7>'+numPages()+'</font>'+'页</span></td>'
				+'<td><a href="#nogo"><img class="page-next"></a></td>'
				+'<td><a href="#nogo"><img class="page-last"></a></td>'
				+'<td><img src="images/pagination/nowait.gif" class="page-wait"></td>'
				+'<td><span style="padding-left:10px; color:#333">每页'+ opts.perPage +'条,共'+totalProperty+'条</span></td>'
				+'<td><span style="padding-left:10px;"><input id="page-num" type="text" class="page-num"></span></td>'
				+'<td><img id="page-goto" style="cursor:pointer; margin:0 5px 0 5px" src="images/pagination/page-goto.gif"/></td>'
				+'</tr></tbody></table></div>';
			panel.empty();
			panel.append(html);
			var imgFirst = 'images/pagination/page-first-disabled.gif';
			var imgPrev = 'images/pagination/page-prev-disabled.gif';
			var imgNext = 'images/pagination/page-next-disabled.gif';
			var imgLast = 'images/pagination/page-last-disabled.gif';
			if (opts.currPage > 0){
				imgFirst = 'images/pagination/page-first.gif';
				imgPrev = 'images/pagination/page-prev.gif';
				$('img.page-first',panel).bind('click',selectPage(0));
				$('img.page-prev',panel).bind('click',selectPage(opts.currPage-1));	
			}
			if (opts.currPage < numPages()-1){
				imgNext = 'images/pagination/page-next.gif';
				imgLast = 'images/pagination/page-last.gif';
				$('img.page-next',panel).bind('click',selectPage(opts.currPage+1));	
				$('img.page-last',panel).bind('click',selectPage(numPages()-1));
			}
			$('img.page-first',panel).attr('src',imgFirst);	
			$('img.page-prev',panel).attr('src',imgPrev);	
			$('img.page-next',panel).attr('src',imgNext);	
			$('img.page-last',panel).attr('src',imgLast);
			$('input.page-num',panel).val(opts.currPage+1);
			$('#page-goto').click(function(){
				gotoPage();
			});	
		}
		
		function gotoPage(){
			var page = $("#page-num").val();
			var strP=/^\d+$/;
  			if(!strP.test(page)){
  				selectPage(0)();
  			}else{
  				selectPage(page-1)();
  			};
		}
		var panel = $(this);
		render();
 
	});
}