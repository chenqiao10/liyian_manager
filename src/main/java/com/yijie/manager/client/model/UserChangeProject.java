package com.yijie.manager.client.model;

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
	
	// 项目名称
	private String title;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UserChangeProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "UserChangeProject [id=" + id + ", pro_uuid=" + pro_uuid + ", user_uuid=" + user_uuid + ", title="
				+ title + "]";
	}

	public UserChangeProject(Integer id, String pro_uuid, String user_uuid, String title) {
		super();
		this.id = id;
		this.pro_uuid = pro_uuid;
		this.user_uuid = user_uuid;
		this.title = title;
	}

}
