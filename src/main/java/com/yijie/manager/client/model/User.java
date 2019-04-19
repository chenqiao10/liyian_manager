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
	private String QQuid;
	
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
	
	//是否通过审核(1.通过，0.未通过)
	private Integer audit;
	
	// 分页数据（初始条数）
	private Integer begin;
	
	//注册渠道(直接注册0账户升级1)
	private Integer registtype;
	
	//邀请码
	private String inviteUUid;
	
	//角色权限
	private String userrule;

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

	public String getQQuid() {
		return QQuid;
	}

	public void setQQuid(String qQuid) {
		QQuid = qQuid;
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

	public Integer getBegin() {
		return begin;
	}

	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	public Integer getRegisttype() {
		return registtype;
	}

	public void setRegisttype(Integer registtype) {
		this.registtype = registtype;
	}

	public String getInviteUUid() {
		return inviteUUid;
	}

	public void setInviteUUid(String inviteUUid) {
		this.inviteUUid = inviteUUid;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", uuid=" + uuid + ", openid=" + openid + ", QQuid=" + QQuid + ", num=" + num
				+ ", password=" + password + ", name=" + name + ", balance=" + balance + ", level=" + level
				+ ", license=" + license + ", audit=" + audit + ", begin=" + begin + ", registtype=" + registtype
				+ ", inviteUUid=" + inviteUUid + "]";
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String uuid, String openid, String qQuid, String num, String password, String name,
			Integer balance, Integer level, String license, Integer audit, Integer begin, Integer registtype,
			String inviteUUid) {
		super();
		this.id = id;
		this.uuid = uuid;
		this.openid = openid;
		QQuid = qQuid;
		this.num = num;
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.level = level;
		this.license = license;
		this.audit = audit;
		this.begin = begin;
		this.registtype = registtype;
		this.inviteUUid = inviteUUid;
	}

}
