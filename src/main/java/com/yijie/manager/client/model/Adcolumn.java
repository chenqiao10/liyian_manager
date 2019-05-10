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

	@Override
	public String toString() {
		return "Adcolumn [id=" + id + ", uuid=" + uuid + ", imgurl=" + imgurl + ", title=" + title + "]";
	}

	public Adcolumn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adcolumn(Integer id, String uuid, String imgurl, String title) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.imgurl = imgurl;
		this.title = title;
	}
	
	

}
