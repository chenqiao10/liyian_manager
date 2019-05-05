package com.yijie.manager.client.model;

import java.util.Date;
import java.util.List;

/**
 * @描述 项目信息
 * @author Lucifer
 *
 */
public class Projects {

	// 自增ID
	private Integer id;

	// 系统生成UUID
	private String uuid;

	// 对应发布用户UUID
	private String user_uuid;

	// 项目名称
	private String title;

	// 项目信息
	private String message;

	// 区域
	private String area;

	// 工期
	private Integer days;

	// 最小预算
	private Double min_budget;

	// 最大预算
	private Double max_budget;

	// 联系电话
	private String phone;

	// 联系微信
	private String oicq;

	// 项目类型
	private String type;

	// 项目兑换所需积分
	private Integer price;

	// 是否通过审核（1.通过，0.未通过，2.审核中）
	private Integer audit;
	//点击量
	private Integer click_count;
	//交换次数
	private Integer cha_count;
	//提交时间
	private Date date;
	// 项目对应附件
	
	
	private List<ProjectDesign> designs;
	
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public Double getMin_budget() {
		return min_budget;
	}

	public void setMin_budget(Double min_budget) {
		this.min_budget = min_budget;
	}

	public Double getMax_budget() {
		return max_budget;
	}

	public void setMax_budget(Double max_budget) {
		this.max_budget = max_budget;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOicq() {
		return oicq;
	}

	public void setOicq(String oicq) {
		this.oicq = oicq;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAudit() {
		return audit;
	}

	public void setAudit(Integer audit) {
		this.audit = audit;
	}

	public Integer getClick_count() {
		return click_count;
	}

	public void setClick_count(Integer click_count) {
		this.click_count = click_count;
	}

	public Integer getCha_count() {
		return cha_count;
	}

	public void setCha_count(Integer cha_count) {
		this.cha_count = cha_count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ProjectDesign> getDesigns() {
		return designs;
	}

	public void setDesigns(List<ProjectDesign> designs) {
		this.designs = designs;
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
		return "Projects [id=" + id + ", uuid=" + uuid + ", user_uuid=" + user_uuid + ", title=" + title + ", message="
				+ message + ", area=" + area + ", days=" + days + ", min_budget=" + min_budget + ", max_budget="
				+ max_budget + ", phone=" + phone + ", oicq=" + oicq + ", type=" + type + ", price=" + price
				+ ", audit=" + audit + ", click_count=" + click_count + ", cha_count=" + cha_count + ", date=" + date
				+ ", designs=" + designs + ", begin=" + begin + ", handle_name=" + handle_name + ", handle_id="
				+ handle_id + "]";
	}

	public Projects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Projects(Integer id, String uuid, String user_uuid, String title, String message, String area, Integer days,
			Double min_budget, Double max_budget, String phone, String oicq, String type, Integer price, Integer audit,
			Integer click_count, Integer cha_count, Date date, List<ProjectDesign> designs, Integer begin,
			String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.user_uuid = user_uuid;
		this.title = title;
		this.message = message;
		this.area = area;
		this.days = days;
		this.min_budget = min_budget;
		this.max_budget = max_budget;
		this.phone = phone;
		this.oicq = oicq;
		this.type = type;
		this.price = price;
		this.audit = audit;
		this.click_count = click_count;
		this.cha_count = cha_count;
		this.date = date;
		this.designs = designs;
		this.begin = begin;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}
	
	
}
