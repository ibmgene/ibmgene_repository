package cn.ibm.com.kernel.service.globalxcallti.impl;




import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;


import cn.ibm.com.common.constants.Constants;
import cn.ibm.com.common.util.ConfigurationHelper;
import cn.ibm.com.common.util.Response;
import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.dao.fnd.FndBasicinfoDao;
import cn.ibm.com.kernel.dao.globalxcallti.GlobalxcalltiDao;
import cn.ibm.com.kernel.dao.globalxcallti.UsersDao;
import cn.ibm.com.kernel.service.globalxcallti.GlobalxcalltiService;
import cn.ibm.com.kernel.service.globalxcallti.MachineTypeService;
import cn.ibm.com.kernel.service.globalxcallti.UsersService;
import cn.ibm.com.kernel.service.impl.BaseServiceImpl;




/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public class UsersServiceImpl extends BaseServiceImpl<Users,UsersDao> implements UsersService{

	ConfigurationHelper helper = new ConfigurationHelper();
	
    private UsersDao usersDao;
	public void setUsersDao(UsersDao usersDao) {
		this.usersDao = usersDao;
	}
	
	public Response addUser(Users users) {
		Response response = new Response();
		String reCode = null;
		String reMessage = null;
		int result = Constants.CODE_DEFAULT_RESULT;
		try {
			  result = usersDao.addUser(users);
			if (result == Constants.CODE_DAO_SUCCESS) {
				reCode = Constants.CODE_SUCCESS;
				reMessage = helper.getProperty("code." + reCode);
			} else {
				reCode = Constants.CODE_PARAMETER_ERROR;
				reMessage = helper.getProperty("code." + reCode);
			}		
		} catch (DataAccessException e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_DATABASE_ACCESS_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		} catch (Exception e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_UNKNOWN_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		}
		response.setReturnInt(result);
		response.setReturnCode(reCode);
		response.setReturnMessage(reMessage);
		return response;
	}
	
	public Response getUsers(Map param) {
		Response response = new Response();
		String reCode = null;
		String reMessage = null;
		Users user = null;
		try {
			user = usersDao.getUsers(param);
			if (user == null) {
				reCode = Constants.CODE_PARAMETER_ERROR;
				reMessage = helper.getProperty("code." + reCode);
			} else {
				reCode = Constants.CODE_SUCCESS;
				reMessage = helper.getProperty("code." + reCode);				
			}
		} catch (DataAccessException e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_DATABASE_ACCESS_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		} catch (Exception e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_UNKNOWN_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		}
		response.setReturnObject(user);
		response.setReturnCode(reCode);
		response.setReturnMessage(reMessage);
		return response;
	}
	
	 
	public Response listUsers(Map param) {
		Response response = new Response();
		
		/**
		 * 
		String reCode = null;
		String reMessage = null;
		List amAccountDiagnosisStrategyList = null;
		try {
		    amAccountDiagnosisStrategyList = usersDao.listUsers(param);			
			reCode = Constants.CODE_SUCCESS;
			reMessage = helper.getProperty("code." + reCode);
		} catch (DataAccessException e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_DATABASE_ACCESS_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		} catch (Exception e) {
			log.error("error: " + e.toString());
			reCode = Constants.CODE_UNKNOWN_ERROR;
			reMessage = helper.getProperty("code." + reCode);
		}
		response.setReturnObject(amAccountDiagnosisStrategyList);
		response.setReturnCode(reCode);
		response.setReturnMessage(reMessage);
		
		*/
		return response;
	}

	public int getCountOfUser(Map<String, Object> param) {
		return this.getBaseDao().getCountOfUser(param);
	}

	public List<Map> getUserRoleByLoginname(Map<String, Object> param) {
		return this.getBaseDao().getUserRoleByLoginname(param);
	}

	public int insertNewUserRoleByDefault(Map<String, Object> param) {
		return this.getBaseDao().insertNewUserRoleByDefault(param);
	}

	public List<Map> getListOfUserRole(Map param) {
		return this.getBaseDao().getListOfUserRole(param);
	}

	public int updateUserRoleRelation(Map param) {
		return this.getBaseDao().updateUserRoleRelation(param);
	}

	public List<Map> getUserPrivilegeUrlByLoginname(Map<String, Object> param) {
		return this.getBaseDao().getUserPrivilegeUrlByLoginname(param);
	}

}

