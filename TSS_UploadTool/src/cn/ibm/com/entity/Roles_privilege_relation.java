package cn.ibm.com.entity;

import java.util.Date;

/**
 * FndBasicinfo.java, Created on 2012-02-22 Title: info <br/>
 * Description: <br/>
 * Copyright: Copyright (c) 2011 <br/>
 * 
 * @author leic
 * @version Revision: 1.0, Date: 2012-02-22 13:34:52
 */
public class Roles_privilege_relation {

	private long id;
	private String role_id;
	private String privilege_id;
	private int type; // 0: effective; 1: invalid

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRole_id() {
		return role_id;
	}

	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}

	public String getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(String privilege_id) {
		this.privilege_id = privilege_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

}
