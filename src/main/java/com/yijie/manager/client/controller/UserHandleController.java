package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.User;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserHandleService;
import com.yijie.manager.client.utils.Uuid;

/**
 * @描述 用户功能块
 * @author Lucifer
 *
 */
@RestController
@RequestMapping("/userHandle")
public class UserHandleController {

	@Autowired
	private UserHandleService userHandleService;
	@Autowired
	private SafeLogService safeLogService;

	/**
	 * @描述 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/userLogin")
	public Map<String, Object> userLogin(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		String msg = null;
		if (user.getNum() != null && user.getPassword() != null) {// 根据电话号登录
			user.setAudit(1);// 1是审核通过得账号
			User u = userHandleService.userLogin(user);
			if (u == null) {
				result.put("code", 0);
				msg = "账户不存在或密码错误！";
			} else if (u.getAudit() == 2) {
				result.put("code", 0);
				msg = "审核中！";
			} else {
				result.put("code", 1);
				msg = "登录成功！";
			}
			result.put("user", u);
			result.put("msg", msg);
			return result;
		} else {
			result.put("code", 0);
			msg = "账户不存在或密码错误！";
			return result;
		}
	}

	/**
	 * @描述 用户注册（个人）
	 * @param user
	 * @return
	 */
	@RequestMapping("/userRegistForOwn")
	public Map<String, Object> userRegistForOwn(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 个人账户默认审核通过
		user.setUuid(Uuid.getUuid());
		user.setAudit(1);
		user.setLevel(0);
		Integer code = userHandleService.userRegist(user);
		// 注册给积分积分
		if (code != 0) {
			User user1 = new User();
			user1.setUuid(user.getInviteUUid());
			userHandleService.scoreAdd(user1, 10);
		}
		String msg = "";
		if (code == 0) {
			msg = " 用户注册（个人）失败";
		} else if (code == 1) {
			msg = "用户注册（个人）成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(user.getHandle_name());
		safeLog.setHandle_id(user.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		result.put("code", code);
		return result;
	}

	/**
	 * @描述 用户注册（企业）
	 * @param user
	 * @return
	 */
	@RequestMapping("/userRegistForComplane")
	public Map<String, Object> userRegistForComplane(@RequestBody User user) {
		Map<String, Object> result = new HashMap<String, Object>();
		// 企业账户默认审核中
		user.setAudit(2);
		user.setLevel(1);
		user.setUuid(Uuid.getUuid());
		Integer code = userHandleService.userRegist(user);
		// 注册给积分积分
		// 添加日志
		String msg = "";
		if (code == 0) {
			msg = " 用户注册（企业）失败";
		} else if (code == 1) {
			msg = "用户注册（企业）成功";
		}
		User user1 = new User();
		user1.setUuid(user.getInviteUUid());
		userHandleService.scoreAdd(user1, 10);
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(user.getHandle_name());
		safeLog.setHandle_id(user.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		result.put("code", code);
		return result;
	}

	/**
	 * @描述 验证用户账号是否已注册（如果已存在返回错误编码0，不存在返回成功编码1）
	 * @param num
	 * @return 0为存在1不存在
	 */
	@RequestMapping("/userPhoneExist")
	public Map<String, Object> userPhoneExist(@RequestBody String num) {
		Map<String, Object> result = new HashMap<String, Object>();
		User user = userHandleService.userPhoneExist(num);
		if (user == null) {
			result.put("code", 1);

		} else {
			result.put("code", 0);
			result.put("msg", "号码已经存在");
		}
		return result;

	}

	/**
	 * @企业注册审核
	 * @param user
	 * @return
	 */
	@RequestMapping("/complaneAuditExamine")
	public Map<String, Object> complaneAudit(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
//		user.setAudit(user.getAudit());// (1.通过，2.审核中那个0.未通过)
		System.out.println(user);
		Integer code = userHandleService.userUpdate(user);
		// 添加日志
		String msg = "";
		if (user.getAudit() == 2) {
			msg = "企业注册审核中";
		} else if (user.getAudit() == 1) {
			msg = "企业注册审核通过";
		} else if (user.getAudit() == 0) {
			msg = "拒绝企业注册";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(user.getHandle_name());
		safeLog.setHandle_id(user.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		map.put("code", code);
		return map;
	}

	/**
	 * @账户升级为企业账户
	 * @param user
	 * @return
	 */
	@RequestMapping("/complaneUpgrade")
	public Map<String, Object> complaneUpgrade(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = userHandleService.userUpdate(user);
		// 添加日志
		String msg = "";
		if (user.getAudit() == 2) {
			msg = "账户升级为企业账户审核中";
		} else if (user.getAudit() == 1) {
			msg = "账户升级为企业账户审核通过";
		} else if (user.getAudit() == 0) {
			msg = "拒绝账户升级为企业账户";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(user.getHandle_name());
		safeLog.setHandle_id(user.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 用户列表
	 * @param user
	 * @return
	 */
	@RequestMapping("/userTable")
	public Map<String, Object> userTable(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<User> userlist = userHandleService.userSelect(user);
			map.put("userlist", userlist);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "系统出错");
			map.put("code", 0);
		}
		return map;
	}
	
	/**
	 * @ 用户信息条数
	 * @param user
	 * @return
	 */
	@RequestMapping("/userCount")
	public Map<String, Object> userCount(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer count = userHandleService.userCount(user);
			map.put("count", count);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "系统出错");
			map.put("code", 0);
		}
		return map;
	}
	
	/**
	 * @ 用户信息批量删除
	 * @param user
	 * @return
	 */
	@RequestMapping("/userDeleteAll")
	public Map<String, Object> userDeleteAll(@RequestBody List<User> userList){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer code = userHandleService.userDeleteAll(userList);
			String msg = "";
			if (code == 0) {
				msg = "用户信息批量删除失败";
			} else if (code == 1) {
				msg = "用户信息批量删除成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(userList.get(0).getHandle_name());
			safeLog.setHandle_id(userList.get(0).getHandle_id());
			safeLog.setHandle(msg);
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "系统出错");
			map.put("code", 0);
		}
		return map;
	}
}
