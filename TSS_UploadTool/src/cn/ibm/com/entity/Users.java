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
public class Users {

	private long id;
	private String user_id;
	private String loginname;
	private String password;
	private Date create_time;
	private Date login_time;
	private Date last_login_time;
	private int login_count;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getLogin_time() {
		return login_time;
	}

	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	public Date getLast_login_time() {
		return last_login_time;
	}

	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}

	public int getLogin_count() {
		return login_count;
	}

	public void setLogin_count(int login_count) {
		this.login_count = login_count;
	}

}
