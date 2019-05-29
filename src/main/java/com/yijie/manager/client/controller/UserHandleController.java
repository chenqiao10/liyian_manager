package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.User;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserHandleService;
import com.yijie.manager.client.utils.Uuid;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

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
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
		}
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
		try {
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
		}
		return result;
	}

	/**
	 * @描述 验证用户账号是否已注册（如果已存在返回错误编码0，不存在返回成功编码1）
	 * @param num
	 * @return 0为存在1不存在
	 */
	@RequestMapping("/userPhoneExist")
	public Map<String, Object> userPhoneExist(@RequestBody String num) {
		System.err.println(num);
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
		StringBuffer sb = new StringBuffer();
		System.out.println(user);
		try {
			// 添加日志
			sb.append("账户	");
			sb.append(user.getNum());
			if (user.getAudit() == 1) {
				sb.append("	企业注册审核通过");
			} else if (user.getAudit() == 0) {
				sb.append("	企业注册不通过");
				user.setLicense("无");
			}
			Integer code = userHandleService.userUpdate(user);
			if (code == 0) {
				sb.append("失败");
			} else {
				sb.append("成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(user.getHandle_name());
			safeLog.setHandle_id(user.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
		}
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
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("账户	");
			// 添加日志
			if (user.getAudit() == 1) {
				sb.append("	升级为企业账户审核通过");
			} else if (user.getAudit() == 0) {
				sb.append("	升级为企业账户不通过");
				user.setLevel(0);
				user.setAudit(1);

			}
			Integer code = userHandleService.userUpdate(user);
			if (code == 0) {
				sb.append("失败");
			} else {
				sb.append("成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(user.getHandle_name());
			safeLog.setHandle_id(user.getHandle_id());
			safeLog.setHandle(sb.toString());
			safeLog.setHandle_date(new Date());
			safeLogService.safeLogAdd(safeLog);
			map.put("code", code);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * @ 用户列表
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/userTable")
	public Map<String, Object> userTable(@RequestBody User user) {
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
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/userCount")
	public Map<String, Object> userCount(@RequestBody User user) {
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
	 * @ 用户信息批量启用禁用
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/userUpdateAll")
	public Map<String, Object> userUpdateAll(@RequestBody JSONObject json) {
		Map<String, Object> map = new HashMap<String, Object>();
		JSONArray jsonArray = json.getJSONArray("adminList");
		List<User> userList = (List<User>) jsonArray.toCollection(jsonArray, User.class);
		try {
			for (int i = 0; i < userList.size(); i++) {
				StringBuffer sb = new StringBuffer();
				Integer code = userHandleService.userUpdate(userList.get(i));
				if (userList.get(i).getAudit() == 3) {
					sb.append("批量禁用账户	");
				} else if (userList.get(i).getAudit() == 1) {
					sb.append("	批量启用账户   ");
				}
				sb.append(userList.get(i).getNum());
				if (code == 0) {
					sb.append("	失败");
				} else if (code == 1) {
					sb.append("	成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(userList.get(i).getHandle_name());
				safeLog.setHandle_id(userList.get(i).getHandle_id());
				safeLog.setHandle(sb.toString());
				safeLog.setHandle_date(new Date());
				safeLogService.safeLogAdd(safeLog);
				map.put("code", code);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg", "系统出错");
			map.put("code", 0);
		}
		return map;
	}

	/**
	 * @ 用户信息修改
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/userUpdate")
	public Map<String, Object> userUpdate(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer code = userHandleService.userUpdate(user);
			String msg = "";
			if (code == 0) {
				msg = "修改用户信息失败";
			} else if (code == 1) {
				msg = "修改用户信息成功";
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(user.getHandle_name());
			safeLog.setHandle_id(user.getHandle_id());
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
