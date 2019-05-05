package com.yijie.manager.client.model;

import java.util.Date;

public class Visit {
	
	//主键id
	private Integer id;
	
	//每日访问量
	private Integer visit;
	
	//访问日期
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVisit() {
		return visit;
	}

	public void setVisit(Integer visit) {
		this.visit = visit;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", visit=" + visit + ", date=" + date + "]";
	}

	public Visit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visit(Integer id, Integer visit, Date date) {
		super();
		this.id = id;
		this.visit = visit;
		this.date = date;
	}
}
