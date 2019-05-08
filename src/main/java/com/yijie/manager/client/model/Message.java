package com.yijie.manager.client.model;

import java.util.Date;

public class Message {

	// 主键id
	private Integer id;

	// 消息类容
	private String content;

	// 消息标题
	private String title;

	// 用户id
	private Integer user_id;

	// 管理员id
	private Integer admin_id;

	// 消息时间
	private Date date;

	// 是否读取1已读 0未读
	private Integer status;

	// 用户名
	private String name;
	
	//分页起始条数
	private Integer begin;
	
	//操作人名字
	private String handle_name;
	
	//操作人id
	private Integer handle_id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(Integer admin_id) {
		this.admin_id = admin_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
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

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", title=" + title + ", user_id=" + user_id
				+ ", admin_id=" + admin_id + ", date=" + date + ", status=" + status + ", name=" + name + ", begin="
				+ begin + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(Integer id, String content, String title, Integer user_id, Integer admin_id, Date date,
			Integer status, String name, Integer begin, String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
		this.user_id = user_id;
		this.admin_id = admin_id;
		this.date = date;
		this.status = status;
		this.name = name;
		this.begin = begin;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}

	
}
