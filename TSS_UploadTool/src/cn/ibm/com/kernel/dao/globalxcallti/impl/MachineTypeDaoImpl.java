package cn.ibm.com.kernel.dao.globalxcallti.impl;

import java.util.List;
import java.util.Map;


import cn.ibm.com.common.constants.Constants;
import cn.ibm.com.entity.MachineType;
import cn.ibm.com.entity.Users;
import cn.ibm.com.kernel.dao.globalxcallti.MachineTypeDao;
import cn.ibm.com.kernel.dao.globalxcallti.UsersDao;
import cn.ibm.com.kernel.dao.impl.BaseDaoImpl;

/**
 * FndBasicinfo.java, Created on 2012-02-22 Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2011 <br/>
 * 
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22 13:34:52
 */
public class MachineTypeDaoImpl extends BaseDaoImpl<MachineType> implements MachineTypeDao {

	public int addUser(Users users) {
		this.getSqlMapClientTemplate().insert("addUser", users);
		return Constants.CODE_DAO_SUCCESS;
	}
	
	public Users getUsers(Map param) {
		return (Users) this.getSqlMapClientTemplate().queryForObject("getUsers",param);
	}
	
	public List listUsers(Map param) {
		return this.getSqlMapClientTemplate().queryForList("listUsers", param);
	}

	public int getCountOfUser(Map<String, Object> param) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject("getCountOfUser", param);
	}

	public List<Map> getUserRoleByLoginname(Map<String, Object> param) {
		return this.getSqlMapClientTemplate().queryForList("getUserRoleByLoginname", param);
	}

	public int insertNewUserRoleByDefault(Map<String, Object> param) {
		this.getSqlMapClientTemplate().insert("insertNewUserRoleByDefault", param);
		return 1;
	}


}
