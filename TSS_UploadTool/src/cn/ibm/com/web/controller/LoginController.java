package cn.ibm.com.web.controller;



import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.security.auth.login.LoginException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ibm.com.common.ibmUtils.SecurityServiceImpl;
import cn.ibm.com.common.util.ConfigurationHelper;
import cn.ibm.com.common.util.CookieOperate;
import cn.ibm.com.common.util.MD5;
import cn.ibm.com.common.util.Response;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.service.globalxcallti.GlobalxcalltiService;
import cn.ibm.com.kernel.service.globalxcallti.UsersService;



/**
 * TSS Entry
 * Login Controller
 * @author johnny
 *
 */
@Controller
public class LoginController extends DefaultController {
	
	private static final Log log = LogFactory.getLog(LoginController.class);
	
	@Autowired
	private ConfigurationHelper ibmConfigurationHelper;
	
	@Autowired
	private UsersService usersService; // users
	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/welcome.do")
	private String welcomeController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		
        
		return "login/login";
	}
	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/login.do")
	private String LoginController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		
		if (!"POST".equalsIgnoreCase(request.getMethod())) {
			/*
			String message = "{\"result\":\"false\",\"info\":\"不是post方式传递参数！\"}";
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().write(message);
			*/
			String message_detail = "The way is not POST method";
			request.setAttribute("message", "error");
			request.setAttribute("message_detail", message_detail);
			return "login/login";
		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username==null || username.equals("")){
			String message_detail = "Enter your IntrantID";
			request.setAttribute("message", "error");
			request.setAttribute("message_detail", message_detail);
			return "login/login";
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("loginname", username);
		
		int userCount = usersService.getCountOfUser(param);
		
		SecurityServiceImpl securityService = new SecurityServiceImpl();
		
		if(userCount == 0){
			//if count is 0 , means the user first time login in the web site;
			
			
			try {
				if(securityService.authenticateUser(username, password)){
					
					
					
					Users user = new Users();
					UUID uuid = UUID.randomUUID();
					user.setUser_id(uuid.toString());
					user.setLoginname(username);
					
					String md5_password = MD5.MD5Encode(password);
					user.setPassword(md5_password);
					
					Date tempDate = new Date();
					user.setLogin_time(tempDate);
					user.setLast_login_time(tempDate);
					
					user.setCreate_time(tempDate);
					
					user.setLogin_count(1);
					
					usersService.insert(user);   //insert a new user to database;
					
					
					// default, new user has the operator role
					param.clear();
					param.put("user_id", uuid.toString());
					param.put("role_id", "000003"); //operator role_id is 000002 by default;
					
					int insertNewUserOperatorRole = usersService.insertNewUserRoleByDefault(param);
					if(insertNewUserOperatorRole !=1){
						log.error("there is an error in inserting the new user operator role.....");
					}
					
					request.setAttribute("loginname", username);
					
					//set cookie for login user
					CookieOperate.addCookie(response, "loginname", username, -1);
					
					//set session for login user
					HttpSession session = request.getSession();
					session.setAttribute("loginSession4UploadTool", username);
					
//					return "operator/upload_excel";
					return "operator/first_login_user_notice";
				}
			} catch (LoginException e) {
				e.printStackTrace();
				
//				StringWriter sw = new StringWriter(); 
//				PrintWriter pw = new PrintWriter(sw); 
//				e.printStackTrace(pw);
//				System.out.println(sw.toString());
				
				String error_detail = e.toString();
				String message_detail[] = error_detail.split(":");  
				
				log.error(e.toString());
				
				
//				String message = "<script type=\"text/javascript\">alert(\""+error+"\");</script>";
//				String message = "<script>alert(\"提交成功！\"); </script>";
//				response.setContentType("text/html;charset=UTF-8");
//				response.getWriter().write(message);
//				return "login/login";
				
				request.setAttribute("message", "error");
				request.setAttribute("message_detail", message_detail[1].toString());
				return "login/login";
			}
		}else if(userCount == 1){
//			List<AmAccountDiagnosisStrategy>	dataList = (List<AmAccountDiagnosisStrategy>)amAccountDiagnosisStrategyService.listAmAccountDiagnosisStrategy(param).getReturnObject();
			
			param.clear();
			param.put("loginname", username);
			Users user = (Users) usersService.getUsers(param).getReturnObject();
			
			String temp_MD5_password = MD5.MD5Encode(password);
			if(temp_MD5_password.equals(user.getPassword())){
				
				
				
				Users user_update = new Users();
				
				user_update.setUser_id(user.getUser_id());  //needed by update, to locate sql, but user_id does not update;
								
				Date tempDate = new Date();
				user_update.setLogin_time(tempDate);
				user_update.setLast_login_time(user.getLogin_time());
				
				user_update.setLogin_count(user.getLogin_count()+1);
				
				usersService.update(user_update);
				request.setAttribute("loginname", username);
				
				//check user's role
				param.clear();
				param.put("loginname", username);
				List<Map> role_name = usersService.getUserRoleByLoginname(param);
				
				//get the user permisseion urls , and change them to string
				List<Map> urlListMap = usersService.getUserPrivilegeUrlByLoginname(param);
				
				JSONArray urlJson = JSONArray.fromObject(urlListMap);
				String urlString = urlJson.toString();
				
				
				if("viewer".equals(role_name.get(0).get("role_name"))){
					//set cookie for login user
					CookieOperate.addCookie(response, "loginname", username, -1);
					
					//set session for login user
					HttpSession session = request.getSession();
					session.setAttribute("loginSession4UploadTool", username);
					
					return "operator/first_login_user_notice";
					
				}else if("user".equals(role_name.get(0).get("role_name"))){
					
					//set cookie for login user
					CookieOperate.addCookie(response, "loginname", username, -1);
					
					//set session for login user
					HttpSession session = request.getSession();
					session.setAttribute("loginSession4UploadTool", username);
					
					//set session for login user's permisson urls
					session.setAttribute("loginSession4UploadTool_url", urlString);
					
					return "redirect:operator_panel.do";
				}else if("admin".equals(role_name.get(0).get("role_name"))){
					
					//set cookie for login user
					CookieOperate.addCookie(response, "loginname", username, -1);
					CookieOperate.addCookie(response, "userrole", role_name.get(0).get("role_name").toString(), -1);
					
					//set session for login user
					HttpSession session = request.getSession();
					session.setAttribute("loginSession4UploadTool", username);
					
					//set session for login user's permisson urls
					session.setAttribute("loginSession4UploadTool_url", urlString);
					
					return "redirect:admin.do";
				}else{
					String message_detail = "The user has no role";
					request.setAttribute("message", "error");
					request.setAttribute("message_detail", message_detail);
					return "login/login";
				}
				
				
			}else{
				try {
					if(securityService.authenticateUser(username, password)){
						Users user_update = new Users();
						
						user_update.setUser_id(user.getUser_id()); //needed by update, to locate sql, but user_id does not update;
						
//						user_update.setLoginname(username);
						
						String md5_password = MD5.MD5Encode(password);
						user_update.setPassword(md5_password);
						
						Date tempDate = new Date();
						user_update.setLogin_time(tempDate);
						user_update.setLast_login_time(user.getLogin_time());
						
						user_update.setLogin_count(user.getLogin_count()+1);
						
						usersService.update(user_update);
						request.setAttribute("loginname", username);
						
						//check user's role
						param.clear();
						param.put("loginname", username);
						List<Map> role_name = usersService.getUserRoleByLoginname(param);
						
						
						//get the user permisseion urls , and change them to string
						List<Map> urlListMap = usersService.getUserPrivilegeUrlByLoginname(param);
						
						JSONArray urlJson = JSONArray.fromObject(urlListMap);
						String urlString = urlJson.toString();
						
						
						if("viewer".equals(role_name.get(0).get("role_name"))){
							//set cookie for login user
							CookieOperate.addCookie(response, "loginname", username, -1);
							
							//set session for login user
							HttpSession session = request.getSession();
							session.setAttribute("loginSession4UploadTool", username);
							
							return "operator/first_login_user_notice";
							
						}else if("user".equals(role_name.get(0).get("role_name"))){
							//set cookie for login user
							CookieOperate.addCookie(response, "loginname", username, -1);
							
							//set session for login user
							HttpSession session = request.getSession();
							session.setAttribute("loginSession4UploadTool", username);
							
							//set session for login user's permisson urls
							session.setAttribute("loginSession4UploadTool_url", urlString);
							
							return "redirect:operator_panel.do";
						}else if("admin".equals(role_name.get(0).get("role_name"))){
							//set cookie for login user
							CookieOperate.addCookie(response, "loginname", username, -1);
							CookieOperate.addCookie(response, "userrole", role_name.get(0).get("role_name").toString(), -1);
							
							//set session for login user
							HttpSession session = request.getSession();
							session.setAttribute("loginSession4UploadTool", username);
							
							//set session for login user's permisson urls
							session.setAttribute("loginSession4UploadTool_url", urlString);
							
							return "redirect:admin.do";
						}else{
							String message_detail = "The user has no role";
							request.setAttribute("message", "error");
							request.setAttribute("message_detail", message_detail);
							return "login/login";
						}
					}
				} catch (LoginException e) {
					String error_detail = e.toString();
					String message_detail[] = error_detail.split(":");  
					
					log.error(e.toString());
					
					request.setAttribute("message", "error");
					request.setAttribute("message_detail", message_detail[1].toString());
					return "login/login";
					
				}
			}
			
			
		}else{
			
			log.error("something wrong is happening......");
			
			request.setAttribute("message", "error");
			request.setAttribute("message_detail", "something wrong is happening......");
			return "login/login";
		}
		
		
        
		return "login/login";
	}

	
	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/loginOut.do")
	private String loginOutController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {
		        
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie2 = cookies[i];
				String sname = cookie2.getName();
				if ("loginname".equals(sname)){
					cookie2.setValue(null);
					cookie2.setMaxAge(0);
					cookie2.setPath("/");
					response.addCookie(cookie2);
				}else if ("userrole".equals(sname)){
					cookie2.setValue(null);
					cookie2.setMaxAge(0);
					cookie2.setPath("/");
					response.addCookie(cookie2);
				}
			}
		}
		

		log.info("delete cookies succuss");
		
		//清除session
		HttpSession session = request.getSession();
		session.invalidate();
		log.info("delete session succuss");
		
		return "login/login";
	}
	


}
