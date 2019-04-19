package com.yijie.manager.client.model;
/**
 * 管理账号
 * 
 * @author sunzhu
 *
 */
public class Admin {
	
	//主键id
	private int id;
	
	//管理员uuid
	private String uuid;
	
	//账号电话号码（登录账号）
	private String num;
	
	//账号密码
	private String password;
	
	//账号名称
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "Admin [id=" + id + ", uuid=" + uuid + ", num=" + num + ", password=" + password + ", name=" + name
				+ "]";
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int id, String uuid, String num, String password, String name) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.num = num;
		this.password = password;
		this.name = name;
	}
	
}
