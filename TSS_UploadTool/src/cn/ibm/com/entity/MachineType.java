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
public class MachineType {

	private long id;
	private String machine_type;
	private String old_machine_type;
	private Date create_time;
	private String create_user;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMachine_type() {
		return machine_type;
	}

	public void setMachine_type(String machine_type) {
		this.machine_type = machine_type;
	}

	public String getOld_machine_type() {
		return old_machine_type;
	}

	public void setOld_machine_type(String old_machine_type) {
		this.old_machine_type = old_machine_type;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getCreate_user() {
		return create_user;
	}

	public void setCreate_user(String create_user) {
		this.create_user = create_user;
	}

}
