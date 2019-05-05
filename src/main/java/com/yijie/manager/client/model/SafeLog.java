package com.yijie.manager.client.model;

import java.util.Date;

public class SafeLog {
	
	//主键id
	private Integer id;	
	
	//操作人姓名
	private String handle_name;
	
	//操作人id
	private Integer handle_id;
	
	//具体操作
	private String handle;
	
	//操作时间
	private Date handle_date;
	
	//分页起始数据
	private Integer begin;
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHandle_name() {
		return handle_name;
	}

	public void setHandle_name(String handle_name) {
		this.handle_name = handle_name;
	}

	public Integer getHandle_id() {
		return handle_id;
	}

	public void setHandle_id(Integer handle_id) {
		this.handle_id = handle_id;
	}

	public String getHandle() {
		return handle;
	}

	public void setHandle(String handle) {
		this.handle = handle;
	}

	public Date getHandle_date() {
		return handle_date;
	}

	public void setHandle_date(Date handle_date) {
		this.handle_date = handle_date;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	@Override
	public String toString() {
		return "SafeLog [id=" + id + ", handle_name=" + handle_name + ", handle_id=" + handle_id + ", handle=" + handle
				+ ", handle_date=" + handle_date + ", begin=" + begin + "]";
	}

	public SafeLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SafeLog(Integer id, String handle_name, Integer handle_id, String handle, Date handle_date, Integer begin) {
		super();
		this.id = id;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
		this.handle = handle;
		this.handle_date = handle_date;
		this.begin = begin;
	}
}
