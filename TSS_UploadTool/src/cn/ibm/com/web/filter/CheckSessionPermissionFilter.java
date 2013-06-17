package cn.ibm.com.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ibm.com.web.controller.AdminController;

public class CheckSessionPermissionFilter implements Filter{
	
	private static final Log log = LogFactory.getLog(CheckSessionPermissionFilter.class);
	protected FilterConfig filterConfig = null;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hsrq = (HttpServletRequest) request;
		HttpServletResponse hsrp = (HttpServletResponse) response;
		
		HttpSession session = hsrq.getSession();
		
		String requestPath = hsrq.getServletPath();
		String loginname = (String) session.getAttribute("loginSession4UploadTool");
		String loginUserUrls = (String) session.getAttribute("loginSession4UploadTool_url");
		String currentURL = hsrq.getRequestURI();
		
		System.out.println("requestPath: "+requestPath);
		System.out.println("loginname: "+loginname);
		System.out.println("loginUserUrls: "+loginUserUrls);
		System.out.println("currentURL: "+currentURL);
		
		if(!(requestPath.indexOf("login.do")>=0 || requestPath.indexOf("loginOut.do")>=0)){
			if(loginname == null || "".equals(loginname)){
				hsrp.sendRedirect("login.jsp");
				return;
			}else{
				//the user login in, we have the session , we check the permission now
				String requestPath_new = requestPath.substring(1);
				if(!loginUserUrls.contains(requestPath_new)){
					log.error("the user does not have the url privilege.");
					hsrp.sendRedirect("login.jsp");
					return;
				}
				
			}
		}
		
		
		filterChain.doFilter(request, response);
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.filterConfig = filterConfig;
		
	}

}
