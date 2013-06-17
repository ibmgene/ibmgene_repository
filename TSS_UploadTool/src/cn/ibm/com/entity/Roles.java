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
public class Roles {

	private long id;
	private String role_id;
	private String parent_role_id;
	private String role_name;
	private Date creat_time;
	private String description;

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

	public String getParent_role_id() {
		return parent_role_id;
	}

	public void setParent_role_id(String parent_role_id) {
		this.parent_role_id = parent_role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
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
