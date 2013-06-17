package cn.ibm.com.web.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.ibm.com.common.ajaxpage.PageList;
import cn.ibm.com.common.ajaxpage.PageProperty;
import cn.ibm.com.common.constants.GaotimeConstants;
import cn.ibm.com.common.util.ConfigurationHelper;
import cn.ibm.com.common.util.CookieOperate;
import cn.ibm.com.common.util.DateUtils;
import cn.ibm.com.common.util.JSONUtil;
import cn.ibm.com.common.util.PageUtil;
import cn.ibm.com.common.util.ReadConfig;
import cn.ibm.com.common.util.Utils;
import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.entity.MachineType;
import cn.ibm.com.entity.NwsLawsregulations;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.service.globalxcallti.GlobalxcalltiService;
import cn.ibm.com.kernel.service.globalxcallti.MachineTypeService;
import cn.ibm.com.kernel.service.globalxcallti.UsersService;
import cn.ibm.com.kernel.service.nws.NwsLawsregulationsService;

/**
 * TSS Entry Login Controller
 * 
 * @author johnny
 * 
 */
@Controller
public class AdminController extends DefaultController {

	private static final Log log = LogFactory.getLog(AdminController.class);
	
	@Autowired
	private UsersService usersService; // users
	
	@Autowired
	private MachineTypeService machineTypeService; // machine_type

	@Autowired
	private ConfigurationHelper ibmConfigurationHelper;

	/**
	 * Globalxcallti
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */

	@RequestMapping("/admin.do")
	private String adminController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
//
//		String loginname = "jingpeng@cn.ibm.com";
//		CookieOperate.addCookie(response, "loginname", loginname, -1);
//		
		Cookie cookie = CookieOperate.getCookieByName(request, "loginname");
		String loginname = cookie.getValue().toString();
		
		Map param = new HashMap();
		param.clear();
		param.put("loginname", loginname);
		List<Map> role_name = usersService.getUserRoleByLoginname(param);
		
		if("admin".equals(role_name.get(0).get("role_name"))){
			return "admin/admin_panel";
		}else{
			return "login/login";
		}
		
		
	}

	@RequestMapping("/admin_panel_operate.do")
	private String adminPanelOperateController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		return "admin/admin_upload_excel";
	}
	
	@RequestMapping("/admin_machinetype.do")
	private String adminMachineTypeController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		/*
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie2 = cookies[i];
				String sname = cookie2.getName();
				if ("CookieOfCompare".equals(sname)){
					cookie2.setValue(null);
					cookie2.setMaxAge(0);
					cookie2.setPath("/");
					response.addCookie(cookie2);
				}
			}
		}
		

		System.out.println("清除cookie完毕！");
		*/
		
		
		
		String loginname = null;
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				Cookie cookie = cookies[i];
				String sname = cookie.getName();
				if ("loginname".equals(sname))
					loginname = cookie.getValue();
			}
			System.out.println("this is a cookie include:*****"
					+ loginname);
		}

		List<MachineType> ListOfMachineType = machineTypeService.listAll();
		
		request.setAttribute("listOfMachineType", ListOfMachineType);
		
		return "admin/admin_machinetype";
	}
	
	@RequestMapping("/admin_roleassignment.do")
	private String adminRoleAssignmentController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {

		Map param = new HashMap();
		List<Map> list_role_name = usersService.getListOfUserRole(param);
		
		request.setAttribute("listOfRoleName", list_role_name);
		
		return "admin/admin_roleassignment";
	}
	
	@RequestMapping("/updateUserRoleAjax.do")
	private String updateUserRoleAjaxController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {

		String updateUserRole_username = request.getParameter("updateUserRole_username");
		String updateUserRole_role = request.getParameter("updateUserRole_role");
		
		Map param = new HashMap();
		param.put("loginname", updateUserRole_username);
		param.put("role_name", updateUserRole_role);
		param.put("type", 1);
		
		int result = usersService.updateUserRoleRelation(param);
		
		String message = "update user_role_relation success!";
		response.getWriter().write(message);
		
		return null;
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

	@RequestMapping("/deleteMachineTypeAjax.do")
	private String deleteMachineTypeAjaxController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {

		String machine_type = request.getParameter("machine_type");
		
		if(machine_type==null || machine_type.equals("")){
			return "redirect:admin_machinetype.do";
		}
		
		Map param = new HashMap();
		param.put("machine_type", machine_type);
		machineTypeService.delete(param);
		
		String message = "delete success!";
		response.getWriter().write(message);
		return null;
	}
	
	
	
	@RequestMapping("/addMachineTypeAjax.do")
	private String addMachineTypeAjaxController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {

		String machine_type = request.getParameter("machine_type");
		
		if(machine_type==null || machine_type.equals("")){
			return "redirect:admin_machinetype.do";
		}
		
		MachineType machineType = new MachineType();
		machineType.setMachine_type(machine_type);
		machineType.setCreate_time(new Date());
		machineType.setCreate_user(CookieOperate.getCookieByName(request, "loginname").getValue().toString());
		
		machineTypeService.insert(machineType);
		
		String message = "add success!";
		response.getWriter().write(message);
		return null;
	}
	

	@RequestMapping("/updateMachineTypeAjax.do")
	private String updateMachineTypeAjaxController(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) throws IOException {

		String machine_type = request.getParameter("machine_type");
		String old_machine_type = request.getParameter("old_machine_type");
		
		if(machine_type==null || machine_type.equals("")){
			return "redirect:admin_machinetype.do";
		}
		
		MachineType machineType = new MachineType();
		machineType.setMachine_type(machine_type);
		machineType.setCreate_time(new Date());
		machineType.setCreate_user(CookieOperate.getCookieByName(request, "loginname").getValue().toString());
		machineType.setOld_machine_type(old_machine_type);
		
		machineTypeService.update(machineType);
		
		String message = "update success!";
		response.getWriter().write(message);
		return null;
	}

}
