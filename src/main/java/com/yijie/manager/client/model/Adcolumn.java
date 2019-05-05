package com.yijie.manager.client.model;

/**
 * 广告轮播模块
 * 
 * @author sunzhu
 *
 */
public class Adcolumn {
	
	//广告轮播id
	private Integer id;
	
	//广告轮播uuid
	private String uuid;
	
	//图片地址
	private String imgurl;
	
	//广告标题
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
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
		return "Adcolumn [id=" + id + ", uuid=" + uuid + ", imgurl=" + imgurl + ", title=" + title + ", handle_name="
				+ handle_name + ", handle_id=" + handle_id + "]";
	}

	public Adcolumn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adcolumn(Integer id, String uuid, String imgurl, String title, String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.imgurl = imgurl;
		this.title = title;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}

}
