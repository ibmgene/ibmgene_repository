package cn.ibm.com.web.controller;



import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import cn.ibm.com.common.util.Utils;




public abstract class DefaultController extends MultiActionController {

	protected static final Log log = LogFactory.getLog("marketerrorlog");

	/**
	 * 获取页面传来的所有参数
	 */
	protected String getParameter(HttpServletRequest request, String name) {
		return Utils.trim(request.getParameter(name));
	}
	
}
