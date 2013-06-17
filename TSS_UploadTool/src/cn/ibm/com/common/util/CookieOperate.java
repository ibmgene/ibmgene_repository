package cn.ibm.com.common.util;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cn.ibm.com.web.controller.AdminController;

public class CookieOperate {
	private static final Log log = LogFactory.getLog(CookieOperate.class);
	
	/**
	 * addCookie
	 * @param args
	 */

	public static void addCookie(HttpServletResponse response, String cookieName, String cookieValue, int maxAge){
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setPath("/");
		if(maxAge>0){
			cookie.setMaxAge(maxAge);
		}
		response.addCookie(cookie);
		log.info("addCookie SUCCESS!");
	}
	
	/**
	 * getCookie
	 * @param args
	 */
	public static Cookie getCookieByName(HttpServletRequest request, String cookieName){
		Map<String,Cookie> cookieMap = ReadCookieMap(request);
		if(cookieMap.containsKey(cookieName)){
			Cookie cookie = (Cookie)cookieMap.get(cookieName);
			return cookie;
		}else{
			return null;
		}
	}
	
	
	/**
	 * read Cookies to Map
	 * @param args
	 */
	
	private static Map<String, Cookie> ReadCookieMap(HttpServletRequest request){
		Map<String,Cookie> cookieMap = new HashMap<String,Cookie>();
		Cookie[] cookies = request.getCookies();
		if(null!=cookies){
			for(Cookie cookie : cookies){
				cookieMap.put(cookie.getName(), cookie);
			}
		}
		return cookieMap;
	}
	
	// 测试、
	public static void main(String[] args) {

 		 
		

	}
}
