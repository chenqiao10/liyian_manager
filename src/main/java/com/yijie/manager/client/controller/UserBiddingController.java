package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.UserBidding;
import com.yijie.manager.client.service.SafeLogService;
import com.yijie.manager.client.service.UserBiddingService;

/**
 * @描述 用户竞标模块
 * @author Lucifer
 *
 */
@RestController
@RequestMapping("/UserBidding")
public class UserBiddingController {

	@Autowired
	private UserBiddingService userBiddingService;
	@Autowired
	private SafeLogService safeLogService;

	// 用户竞标列表
	@RequestMapping("/UserBiddingTable")
	@ResponseBody
	public Map<String, Object> biddingTable(@RequestBody UserBidding userBidding) {
		Map<String, Object> result = new HashMap<String, Object>();
		List<UserBidding> list = userBiddingService.biddingTable(userBidding);
		result.put("list", list);
		result.put("code", 1);
		return result;
	}

	// 用户竞标详细信息
	@RequestMapping("/biddingMessage")
	@ResponseBody
	public Map<String, Object> biddingMessage(@RequestBody UserBidding userBidding) {
		Map<String, Object> result = new HashMap<String, Object>();
		UserBidding bidding = userBiddingService.biddingMessage(userBidding);
		result.put("bidding", bidding);
		result.put("code", 1);
		return result;
	}

	// 用户竞标创建
	@RequestMapping("/UserBiddingBuild")
	@ResponseBody
	public Map<String, Object> biddingBuild(@RequestBody UserBidding userBidding) {
		Map<String, Object> result = new HashMap<String, Object>();
		Integer code = userBiddingService.biddingBuild(userBidding);
		String msg = "";
		if (code == 0) {
			msg = "创建用户竞标失败";
		} else if (code == 1) {
			msg = "创建用户竞标成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(userBidding.getHandle_name());
		safeLog.setHandle_id(userBidding.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		result.put("code", code);
		return result;
	}

	// 用户竞标信息修改
	@RequestMapping("/UserBiddingUpdate")
	@ResponseBody
	public Map<String, Object> biddingUpdate(@RequestBody UserBidding userBidding) {
		Map<String, Object> result = new HashMap<String, Object>();
		Integer code = userBiddingService.biddingUpdate(userBidding);
		String msg = "";
		if (code == 0) {
			msg = "用户竞标信息修改失败";
		} else if (code == 1) {
			msg = "用户竞标信息修改成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(userBidding.getHandle_name());
		safeLog.setHandle_id(userBidding.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		result.put("code", code);
		return result;
	}

}
