package com.yijie.manager.client.model;

/**
 * @描述 用户竞标信息
 * @author Lucifer
 *
 */
public class UserBidding {
	
	//自增ID
	private Integer id;
	
	//对应竞标用户UUID
	private String user_uuid;
	
	//对应竞标用户联系方式
	private String user_phone;
	
	//对应标书项目UUID
	private String tender_uuid;
	
	//标书名称
	private String title;
	
	//标书项目类型
	private String type;
	
	//竞标价格
	private Double price;
	
	//相关证件URL
	private String license;
	
	//是否通过审核（1.通过，0.未通过，2.审核中）
	private Integer audit;
	
	// 分页数据（初始条数）
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

	public String getUser_uuid() {
		return user_uuid;
	}

	public void setUser_uuid(String user_uuid) {
		this.user_uuid = user_uuid;
	}

	public String getUser_phone() {
		return user_phone;
	}

	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}

	public String getTender_uuid() {
		return tender_uuid;
	}

	public void setTender_uuid(String tender_uuid) {
		this.tender_uuid = tender_uuid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
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
		return "UserBidding [id=" + id + ", user_uuid=" + user_uuid + ", user_phone=" + user_phone + ", tender_uuid="
				+ tender_uuid + ", title=" + title + ", type=" + type + ", price=" + price + ", license=" + license
				+ ", audit=" + audit + ", begin=" + begin + ", handle_name=" + handle_name + ", handle_id=" + handle_id
				+ "]";
	}

	public UserBidding() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserBidding(Integer id, String user_uuid, String user_phone, String tender_uuid, String title, String type,
			Double price, String license, Integer audit, Integer begin, String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.user_uuid = user_uuid;
		this.user_phone = user_phone;
		this.tender_uuid = tender_uuid;
		this.title = title;
		this.type = type;
		this.price = price;
		this.license = license;
		this.audit = audit;
		this.begin = begin;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}
	
	
}
