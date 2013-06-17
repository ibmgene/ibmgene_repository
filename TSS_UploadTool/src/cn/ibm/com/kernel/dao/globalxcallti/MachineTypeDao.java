package cn.ibm.com.kernel.dao.globalxcallti;



import java.util.List;
import java.util.Map;



import cn.ibm.com.common.util.Response;
import cn.ibm.com.entity.Globalxcallti;
import cn.ibm.com.entity.MachineType;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.dao.BaseDao;
/**
 * FndBasicinfo.java, Created on  2012-02-22
 * Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c)  2011 <br/>
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22  13:34:52 
 */
public interface MachineTypeDao extends BaseDao<MachineType>{


	
	/**
	 * add user
	 * @return
	 */
	
	int addUser(Users users);
	
	public List listUsers(Map param);

	int getCountOfUser(Map<String, Object> param);

	Users getUsers(Map param);

	List<Map> getUserRoleByLoginname(Map<String, Object> param);

	int insertNewUserRoleByDefault(Map<String, Object> param);
	
}
