package com.yijie.manager.client.model;
/**
 * 管理账号
 * 
 * @author sunzhu
 *
 */
public class Admin {
	
	//主键id
	private Integer id;
	
	//管理员uuid
	private String uuid;
	
	//账号电话号码（登录账号）
	private String num;
	
	//账号密码
	private String password;
	
	//账号名称
	private String name;
	
	//状态0停用 1正常
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return "Admin [id=" + id + ", uuid=" + uuid + ", num=" + num + ", password=" + password + ", name=" + name
				+ ", status=" + status + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(Integer id, String uuid, String num, String password, String name, Integer status, String handle_name,
			Integer handle_id) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.num = num;
		this.password = password;
		this.name = name;
		this.status = status;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}

	
}
