package com.yijie.manager.client.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yijie.manager.client.model.Message;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.service.MessageService;
import com.yijie.manager.client.service.SafeLogService;

@RestController
@RequestMapping("/admin")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private SafeLogService safeLogService;
	
	/**
	 * @ 添加推送消息
	 * @param message
	 * @return
	 */
	@RequestMapping("/messageInsert")
	public Map<String, Object> messageInsert(@RequestBody Message message){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = messageService.messageInsert(message);
		String msg = "";
		if (code == 0) {
			msg = "添加推送消息失败";
		} else if (code == 1) {
			msg = "添加推送消息成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(message.getHandle_name());
		safeLog.setHandle_id(message.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 推送消息删除
	 * @param message
	 * @return
	 */
	@RequestMapping("messageDelete")
	public Map<String, Object> messageDelete(@RequestBody Message message){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = messageService.messageDelete(message);
		String msg = "";
		if (code == 0) {
			msg = "推送消息删除失败";
		} else if (code == 1) {
			msg = "推送消息删除成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(message.getHandle_name());
		safeLog.setHandle_id(message.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 推送消息修改
	 * @param message
	 * @return
	 */
	@RequestMapping("messageUpdate")
	public Map<String, Object> messageUpdate(@RequestBody Message message){
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code = messageService.messageUpdate(message);
		String msg = "";
		if (code == 0) {
			msg = "推送消息删除失败";
		} else if (code == 1) {
			msg = "推送消息删除成功";
		}
		SafeLog safeLog = new SafeLog();
		safeLog.setHandle_name(message.getHandle_name());
		safeLog.setHandle_id(message.getHandle_id());
		safeLog.setHandle(msg);
		safeLog.setHandle_date(new Date());
		safeLogService.safeLogAdd(safeLog);
		map.put("code", code);
		return map;
	}
	
	/**
	 * @ 推送消息列表
	 * @param message
	 * @return
	 */
	@RequestMapping("/messageTable")
	public Map<String, Object> messageTable(@RequestBody Message message){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<Message> msglist = messageService.messageTable(message);
			map.put("msglist", msglist);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "系统出错");
		}
		return map;
	}
}
