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
import com.yijie.manager.client.model.UserChangeProject;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserChangeProjectService;

/**
 * 用户交互的项目
 * 
 * @author chenqiao
 *
 */
@RestController
@RequestMapping("/user")
public class UserChangeProjectController {
	@Autowired
	private UserChangeProjectService userChangeProjectService;
	@Autowired
	private SafeLogService safeLogService;

	// 用户已交换项目列表
	@RequestMapping("/userCheProTable")
	public Map<String, Object> userCheProTable(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			List<UserChangeProject> list = userChangeProjectService.userCheProTable(userChangeProject);
			result.put("list", list);
			result.put("code", 1);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}

	}

	/**
	 * 
	 * 项目添加
	 * 
	 * @param userChangeProject
	 * @return
	 */
	@RequestMapping("/userCheProAdd")
	public Map<String, Object> userCheProAdd(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = userChangeProjectService.userCheProAdd(userChangeProject);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	/**
	 * 
	 * 用户交换项目删除
	 * 
	 * @param userChangeProject
	 * @return
	 */
	@RequestMapping("/userCheProDelete")
	public Map<String, Object> userCheProDelete(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer code = userChangeProjectService.userCheProDelete(userChangeProject);
			result.put("code", code);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
			return result;
		}
	}

	
	/**
	 * @ 交换项目条数
	 * @param userChangeProject
	 * @return
	 */
	@RequestMapping("/userCheProCount")
	public Map<String, Object> userCheProCount(@RequestBody UserChangeProject userChangeProject) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer count = userChangeProjectService.userCheProCount(userChangeProject);
			result.put("count", count);
			result.put("code", 1);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("code", 0);
			result.put("msg", "系统出错");
		}
		return result;

	}
}
