package com.yijie.manager.client.model;

public class SuperAdmin {
	
	//主键id
	private Integer id;
	
	//超管姓名
	private String name;
	
	//账号电话号
	private String num;
	
	//登录密码
	private String password;
	
	//表uuid
	private String uuid;
	
	//状态
	private Integer status;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
		return "SuperAdmin [id=" + id + ", name=" + name + ", num=" + num + ", password=" + password + ", uuid=" + uuid
				+ ", status=" + status + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public SuperAdmin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SuperAdmin(Integer id, String name, String num, String password, String uuid, Integer status,
			String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.password = password;
		this.uuid = uuid;
		this.status = status;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}
	
}
