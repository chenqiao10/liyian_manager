package com.yijie.manager.client.model;

import java.util.Date;

/**
 * @描述 用户已交换项目
 * @author Lucifer
 *
 */
public class UserChangeProject {

	// 自增ID
	private Integer id;

	// 对应项目UUID
	private String pro_uuid;

	// 交换项目用户UUID
	private String user_uuid;
	
	// 联系电话
	private String phone;
	
	// 项目名称
	private String title;
	
	// 交换时间
	private Date date;
	
	// 项目 类型
	private String type;

	// 分页数据
	private Integer begin;

	public Integer getId() {
		return id;
	}

	public String getPro_uuid() {
		return pro_uuid;
	}

	public void setPro_uuid(String pro_uuid) {
		this.pro_uuid = pro_uuid;
	}

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "UserChangeProject [id=" + id + ", pro_uuid=" + pro_uuid + ", user_uuid=" + user_uuid + ", phone="
				+ phone + ", title=" + title + ", date=" + date + ", type=" + type + ", begin=" + begin + "]";
	}

	public UserChangeProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserChangeProject(Integer id, String pro_uuid, String user_uuid, String phone, String title, Date date,
			String type, Integer begin) {
		super();
		this.id = id;
		this.pro_uuid = pro_uuid;
		this.user_uuid = user_uuid;
		this.phone = phone;
		this.title = title;
		this.date = date;
		this.type = type;
		this.begin = begin;
	}

	
}
