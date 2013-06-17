package cn.ibm.com.kernel.service.globalxcallti;



import java.util.List;
import java.util.Map;

import cn.ibm.com.common.util.Response;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.service.BaseService;



/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */

public interface UsersService extends BaseService<Users> {   
	
	Response addUser(Users users);

	public Response getUsers(Map param);
	
	public Response listUsers(Map param);	
	
	int getCountOfUser(Map<String, Object> param);

	List<Map> getUserRoleByLoginname(Map<String, Object> param);

	int insertNewUserRoleByDefault(Map<String, Object> param);

	List<Map> getListOfUserRole(Map param);

	int updateUserRoleRelation(Map param);

	List<Map> getUserPrivilegeUrlByLoginname(Map<String, Object> param);
  
}

