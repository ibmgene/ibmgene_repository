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
public class Privilege {

	private long id;
	private String privilege_id;
	private String parent_privilege_id;
	private String privilege_name;
	private Date creat_time;
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(String privilege_id) {
		this.privilege_id = privilege_id;
	}

	public String getParent_privilege_id() {
		return parent_privilege_id;
	}

	public void setParent_privilege_id(String parent_privilege_id) {
		this.parent_privilege_id = parent_privilege_id;
	}

	public String getPrivilege_name() {
		return privilege_name;
	}

	public void setPrivilege_name(String privilege_name) {
		this.privilege_name = privilege_name;
	}

	public Date getCreat_time() {
		return creat_time;
	}

	public void setCreat_time(Date creat_time) {
		this.creat_time = creat_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
