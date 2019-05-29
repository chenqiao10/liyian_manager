package com.yijie.manager.client.model;

/**
 * 广告栏位
 * 
 * @author chenqiao
 *
 */
public class Adcolumn {

	// 广告自增id
	private Integer id;

	// 广告轮播uuid
	private String uuid;

	// 广告标题
	private String title;

	// 图片地址
	private String imgurl;

	// 启用禁用
	private Integer status;

	// 图片跳转路径
	private String weburl;

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getWeburl() {
		return weburl;
	}

	public void setWeburl(String weburl) {
		this.weburl = weburl;
	}

	@Override
	public String toString() {
		return "Adcolumn [id=" + id + ", uuid=" + uuid + ", title=" + title + ", imgurl=" + imgurl + ", status="
				+ status + ", weburl=" + weburl + "]";
	}

	public Adcolumn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adcolumn(Integer id, String uuid, String title, String imgurl, Integer status, String weburl) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.title = title;
		this.imgurl = imgurl;
		this.status = status;
		this.weburl = weburl;
	}

}
