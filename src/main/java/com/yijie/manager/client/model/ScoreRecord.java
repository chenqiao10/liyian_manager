package com.yijie.manager.client.model;

import java.sql.Date;

/**
 * 积分记录表
 * 
 * @author sunzhu
 *
 */
public class ScoreRecord {
	
	//自增id
	private int id;
	
	//系统生成的UUID
	private String uuid;
	
	//领取时间
	private Date date;
	
	//积分类型(0签到 1邀请 2发布 3兑换 4注册)
	private String type;
	
	//用户id
	private String user_uuid;
	
	//领取积分
	private String score;
	
	// 分页数据（初始条数）
	private Integer begin;
	
	//操作人名字
	private String handle_name;
	
	//操作人id
	private Integer handle_id;

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

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
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
		return "ScoreRecord [id=" + id + ", uuid=" + uuid + ", date=" + date + ", type=" + type + ", user_uuid="
				+ user_uuid + ", score=" + score + ", begin=" + begin + ", handle_name=" + handle_name + ", handle_id="
				+ handle_id + "]";
	}

	public ScoreRecord() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreRecord(int id, String uuid, Date date, String type, String user_uuid, String score, Integer begin,
			String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.date = date;
		this.type = type;
		this.user_uuid = user_uuid;
		this.score = score;
		this.begin = begin;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}

	
	
}
