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
		return "UserChangeProject [id=" + id + ", pro_uuid=" + pro_uuid + ", user_uuid=" + user_uuid + ", title="
				+ title + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public UserChangeProject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserChangeProject(Integer id, String pro_uuid, String user_uuid, String title, String handle_name,
			Integer handle_id) {
		super();
		this.id = id;
		this.pro_uuid = pro_uuid;
		this.user_uuid = user_uuid;
		this.title = title;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}

	

}
