package cn.ibm.com.common.util.page.tag;



import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import cn.ibm.com.common.util.Utils;




/**
 * 分页标签
 */
public class PageSplitTag extends TagSupport {

	private String url = ""; // 页面指向地址

	private String pageNo = ""; // 当前页面，字符串型，由外面传入

	private String paramsStr = ""; // 组装后的参数字符串

	private int totalPages = 1; // 总页面数

	private int count = 0; // 总记录数

	private int intPageNo = 1; // 当前页面
	
	private String type ;

	private int pageSize = 20; // 每一页面显示的最大记录数

	public PageSplitTag() {
	}

	public int doStartTag() throws JspException {
		if (url == null) {
			url = "";
		}
		url = url.trim();

		HttpServletRequest request = (HttpServletRequest) pageContext
				.getRequest();
		Enumeration en = request.getParameterNames();
		StringBuffer param = new StringBuffer();
		while (en.hasMoreElements()) {
			String key = (String) en.nextElement();
			if ("pageNo".equals(key) || key.toLowerCase().startsWith("submit")||"pageSize".equals(key))
				continue;
			String value = Utils.trim(request.getParameter(key));
			if (value.equals(""))
				continue;
			param.append("&" + key + "=" + Utils.encodeStr(value));
		}
		paramsStr = param.toString();

		try {
			intPageNo = Utils.parseInt(pageNo, 1);
			if(intPageNo<1){
				intPageNo = 1;
			}
		} catch (Exception e) {
		}
		if (count % pageSize > 0) {
			totalPages = count / pageSize + 1;
		} else {
			totalPages = count / pageSize;
		}
		if (intPageNo > totalPages) {
			intPageNo = totalPages;
		}
		return (SKIP_BODY);
	}

	public int doEndTag() throws JspException {
		StringBuffer reStr = new StringBuffer();
		reStr.append("<form name='splitPageForm' method='post' ");
		reStr.append("action='" + url + addParams(paramsStr) + "'>");
		reStr.append("<table align=\"left\" class=\"tbl_splittag\"><tr>");
		reStr.append("<td>&nbsp;&nbsp;<font color='#003399'>第<b>" + intPageNo + "/"
				+ totalPages + "</b>页");
		reStr.append("共<b>" + count + "</b>条</font>");
		if (totalPages < 2) {
			reStr.append("【首页】");
			reStr.append("【上页】");
			reStr.append("【下页】");
			reStr.append("【尾页】");
		} else {
			if (intPageNo < 2) {
				reStr.append("【首页】");
				reStr.append("【上页】");
				reStr.append(getUrl(intPageNo + 1, "下页"));
				reStr.append(getUrl(totalPages, "尾页"));
			} else if (intPageNo == totalPages) {
				reStr.append(getUrl(1, "首页"));
				reStr.append(getUrl(intPageNo - 1, "上页"));
				reStr.append("【下页】");
				reStr.append("【尾页】");
			} else {
				reStr.append(getUrl(1, "首页"));
				reStr.append(getUrl(intPageNo - 1, "上页"));
				reStr.append(getUrl(intPageNo + 1, "下页"));
				reStr.append(getUrl(totalPages, "尾页"));
			}
		}
		/*reStr.append("<td><select id=\"slcpage\" class=\"slc_page_shift\" name='pageSize' onchange='document.forms[\"splitPageForm\"].submit()'>");
		if(pageSize==10){
			reStr.append("<option value=15 selected>10</option>");
		}else{
			reStr.append("<option value=15>15</option>");
		}
		if(pageSize==20){
			reStr.append("<option value=20 selected>20</option>");
		}
		else{
			reStr.append("<option value=20>20</option>");
		}
		if(pageSize==30){
			reStr.append("<option value=30 selected>30</option>");
		}
		else{
			reStr.append("<option value=30>30</option>");
		}
		if(pageSize==40){
			reStr.append("<option value=40 selected>40</option>");
		}else{
			reStr.append("<option value=40>40</option>");
		}	
		if(pageSize==50){
			reStr.append("<option value=50 selected>50</option>");
		}else{
			reStr.append("<option value=50>50</option>");
		}	
		reStr.append("</select></td>");*/
		
			reStr.append("&nbsp;&nbsp;到&nbsp;&nbsp;<input name='pageNo' align='absmiddle' size='3' type='text' class='splittag_input'");
			reStr.append("class='input_page_shift' ");
			reStr.append("value='"+pageNo+"' >&nbsp;&nbsp;");
			reStr.append("<button type='submit' class='splittag_button'>go</button> ");
		
		reStr.append("</td></tr></table></form>");
		JspWriter writer = pageContext.getOut();
		try {
			writer.println(new String(reStr.toString().getBytes()));
		} catch (Exception e) {
			throw new JspException(e.getMessage());
		}
		return (EVAL_PAGE);
	}

	private String getUrl(int pageNo, String name) {
		return "【<a href=\"" + dealUrl(url, pageNo)
				+ "\" class=\"splitPage\">" + name + "</a>】";
	}

	private String dealUrl(String url, int pageNo) {
		return url + "?pageNo=" + pageNo +"&pageSize="+pageSize+ paramsStr;
	}

	private String addParams(String params) {
		if (params == null || params.equals("")) {
			return "";
		}
		return "?" + params.substring(1);
	}

	public void release() {
		super.release();
	}

	public void setPageNo(String pageNo) {
		this.pageNo = pageNo;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
