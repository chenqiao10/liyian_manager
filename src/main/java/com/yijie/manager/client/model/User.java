package com.yijie.manager.client.model;

/**
 * @描述 用户账户
 * @author Lucifer
 *
 */
public class User {
	
	//自增ID
	private Integer id;
	
	//系统生成uuid
	private String uuid;
	
	//账户微信登录对应openID
	private String openid;
	
	//账户QQ登录对应UID
	private String qquid;
	
	//账户电话号码（登录账号）
	private String num;
	
	//账户密码
	private String password;
	
	//账户名称（个人/公司）
	private String name;
	
	//账户积分余额
	private Integer balance;
	
	//账户级别（0.个人,1.企业）
	private Integer level;
	
	//企业级别账户对应营业执照
	private String license;
	
	//是否通过审核(1.通过，2.审核中那个0.未通过)
	private Integer audit;
	//注册渠道(直接注册0账户升级1)
	private Integer registtype;
	// 分页数据（初始条数）
	private Integer begin;
	
	//邀请码
	private String  inviteUUid;

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

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getQquid() {
		return qquid;
	}

	public void setQquid(String qquid) {
		this.qquid = qquid;
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

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public Integer getRegisttype() {
		return registtype;
	}

	public void setRegisttype(Integer registtype) {
		this.registtype = registtype;
	}

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public String getInviteUUid() {
		return inviteUUid;
	}

	public void setInviteUUid(String inviteUUid) {
		this.inviteUUid = inviteUUid;
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
		return "User [id=" + id + ", uuid=" + uuid + ", openid=" + openid + ", qquid=" + qquid + ", num=" + num
				+ ", password=" + password + ", name=" + name + ", balance=" + balance + ", level=" + level
				+ ", license=" + license + ", audit=" + audit + ", registtype=" + registtype + ", begin=" + begin
				+ ", inviteUUid=" + inviteUUid + ", handle_name=" + handle_name + ", handle_id=" + handle_id + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String uuid, String openid, String qquid, String num, String password, String name,
			Integer balance, Integer level, String license, Integer audit, Integer registtype, Integer begin,
			String inviteUUid, String handle_name, Integer handle_id) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.openid = openid;
		this.qquid = qquid;
		this.num = num;
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.level = level;
		this.license = license;
		this.audit = audit;
		this.registtype = registtype;
		this.begin = begin;
		this.inviteUUid = inviteUUid;
		this.handle_name = handle_name;
		this.handle_id = handle_id;
	}
	
	
}
