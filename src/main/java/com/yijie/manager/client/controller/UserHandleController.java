package com.yijie.manager.client.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.User;
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
	
	/**
	 * @描述 用户登录
	 * @param user
	 * @return
	 */
	@RequestMapping("/userLogin")
	public Map<String,Object> userLogin(@RequestBody User user){
		Map<String,Object> result = new HashMap<String,Object>();
		String msg = null;
		if(user.getNum()!=null&&user.getPassword()!=null) {//根据电话号登录
			user.setAudit(1);//1是审核通过得账号
			User u = userHandleService.userLogin(user);
			if(u == null){
				result.put("code", 0);
				msg = "账户不存在或密码错误！";
			}else if(u.getAudit() == 2){
				result.put("code", 0);
				msg = "审核中！";
			}else{
				result.put("code", 1);
				msg = "登录成功！";
			}
			result.put("user", u);
			result.put("msg", msg);
			return result;
		}else {
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
	public Map<String,Object> userRegistForOwn(@RequestBody User user){
		Map<String,Object> result = new HashMap<String,Object>();
		//个人账户默认审核通过
		user.setUuid(Uuid.getUuid());
		user.setAudit(1);
		Integer code = userHandleService.userRegist(user);
		//注册给积分积分
		if(code!=0) {
		User  user1 = new User();
		user1.setUuid(user.getInviteUUid());
		userHandleService.scoreAdd(user1, 10);
		}
		result.put("code", code);
		return result;
	}
	
	/**
	 * @描述 用户注册（企业）
	 * @param user
	 * @return
	 */
	@RequestMapping("/userRegistForComplane")
	public Map<String,Object> userRegistForComplane(@RequestBody User user){
		Map<String,Object> result = new HashMap<String,Object>();
		//企业账户默认审核中
		user.setAudit(2);
		user.setUuid(Uuid.getUuid());
		Integer code = userHandleService.userRegist(user);
		//注册给积分积分
		if(code!=0) {
		User  user1 = new User();
		user1.setUuid(user.getInviteUUid());
		userHandleService.scoreAdd(user1, 10);
		}
		result.put("code", code);
		return result;
	}
	
	
	/**
	 * @描述 验证用户账号是否已注册（如果已存在返回错误编码0，不存在返回成功编码1）
	 * @param num
	 * @return 0为存在1不存在
	 */
	@RequestMapping("/userPhoneExist")
	public Map<String,Object> userPhoneExist(@RequestBody String num){
		Map<String,Object> result = new HashMap<String,Object>();
		User user = userHandleService.userPhoneExist(num);
		if(user==null) {
		result.put("code", 1);
		
		}else {
			result.put("code", 0);
			result.put("msg", "号码已经存在");
		}
		return result;
	
	}
	
	/**
	 * 企业注册审核通过
	 * @param user
	 * @return
	 */
	@RequestMapping("/complaneAuditPass")
	public Map<String, Object> complaneAudit(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		user.setAudit(1);//1审核通过
		System.out.println(user);
		Integer code = userHandleService.userUpdate(user);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 企业注册未通过
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/complaneAuditNo")
	public Map<String, Object> complaneAuditNo(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		user.setAudit(0);//0审核未通过
		System.out.println(user);
		Integer code = userHandleService.userUpdate(user);
		map.put("code", code);
		return map;
	}
	
	/**
	 * 账户升级为企业账户
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/complaneUpgrade")
	public Map<String, Object> complaneUpgrade(@RequestBody User user){
		Map<String, Object> map = new HashMap<String, Object>();
		user.setLevel(1);//1升级为企业账户
		System.out.println(user);
		Integer code = userHandleService.userUpdate(user);
		map.put("code", code);
		return map;
	}
}
