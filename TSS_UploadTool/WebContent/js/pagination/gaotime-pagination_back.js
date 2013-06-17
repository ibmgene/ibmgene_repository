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
			var html = '<table><tbody><tr >'
				+'<td width=300>&nbsp;</td>' 
				+'<td width=43><a href="#"><img src=images/button-first2.gif></a></td>'
				+'<td width=43><a href="#"><img src=images/button-pre2.gif></a></td>'
				+'<td width=40><a href="#"><img src=images/button-next.gif></a></td>'
				+'<td width=126><a href="#"><img src=images/button-end.gif></a></td>'
				+'<td width=273><span style="padding-left:10px;">总条数:'+totalProperty+'    总页数:'+numPages()+'</span></td>'
				+'<td width=85><span>当前页:'+(opts.currPage+1)+'</span></td>'
				+'<td><span ><input id="page-num" type="text" style="border:#dadada 1px solid; width=55"></span></td>'
				+'<td><img id="page-goto" src=images/button-goto.gif width=42 height=20 border=0 /></td>'
				+'</tr></tbody></table>';
			panel.empty();
			panel.append(html);
			var imgFirst = 'images/button-first2.gif';
			var imgPrev = 'images/button-pre2.gif';
			var imgNext = 'images/button-next2.gif';
			var imgLast = 'images/button-end2.gif';
			if (opts.currPage > 0){
				imgFirst = 'images/button-first.gif';
				imgPrev = 'images/button-pre.gif';
				$('img.page-first',panel).bind('click',selectPage(0));
				$('img.page-prev',panel).bind('click',selectPage(opts.currPage-1));	
			}
			if (opts.currPage < numPages()-1){
				imgNext = 'images/button-next.gif';
				imgLast = 'images/button-end.gif';
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