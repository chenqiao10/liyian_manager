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
import com.yijie.manager.client.model.Message;
import com.yijie.manager.client.model.Projects;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.model.User;
import com.yijie.manager.client.service.MessageService;
import com.yijie.manager.client.service.SafeLogService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/admin")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private SafeLogService safeLogService;

	/**
	 * @ 添加推送消息
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping("/messageInsert")
	public Map<String, Object> messageInsert(@RequestBody Message message) {
		Map<String, Object> map = new HashMap<String, Object>();
		Integer code;
		try {
			StringBuffer sb = new StringBuffer();
			message.setDate(new Date());
			code = messageService.messageInsert(message);
			sb.append("管理员账户   ");
			sb.append(message.getAdmin_num());// 添加管理员账户num
			if (code == 0) {
				sb.append(" 添加推送消息失败");
			} else if (code == 1) {
				sb.append(" 添加推送消息成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(message.getHandle_name());
			safeLog.setHandle_id(message.getHandle_id());
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
	 * @ 推送消息删除
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping("messageDelete")
	public Map<String, Object> messageDelete(@RequestBody Message message) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = messageService.messageDelete(message);
			sb.append("管理员账户   ");
			sb.append(message.getAdmin_num());// 添加管理员账户num
			if (code == 0) {
				sb.append(" 删除推送消息失败");
			} else if (code == 1) {
				sb.append(" 删除推送消息成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(message.getHandle_name());
			safeLog.setHandle_id(message.getHandle_id());
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
	 * @ 推送消息修改
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping("messageUpdate")
	public Map<String, Object> messageUpdate(@RequestBody Message message) {
		Map<String, Object> map = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer();
		try {
			Integer code = messageService.messageUpdate(message);
			sb.append("管理员账户   ");
			sb.append(message.getAdmin_num());// 添加管理员账户num
			if (code == 0) {
				sb.append(" 需改推送消息失败");
			} else if (code == 1) {
				sb.append(" 修改推送消息成功");
			}
			SafeLog safeLog = new SafeLog();
			safeLog.setHandle_name(message.getHandle_name());
			safeLog.setHandle_id(message.getHandle_id());
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
	 * @ 推送消息列表
	 * 
	 * @param message
	 * @return
	 */
	@RequestMapping("/messageTable")
	public Map<String, Object> messageTable(@RequestBody Message message) {
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

	@RequestMapping("/messageCount")
	public Map<String, Object> messageCount(@RequestBody Message message) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Integer count = messageService.messageCount(message);
			map.put("count", count);
			map.put("code", 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("code", 0);
			map.put("msg", "系统出错");
		}
		return map;
	}

	/**
	 * @ 项目批量删除
	 * 
	 * @param projects
	 * @return
	 */
	@RequestMapping("/messageInsertAll")
	public Map<String, Object> messageInsertAll(@RequestBody JSONObject json) {
		Map<String, Object> result = new HashMap<String, Object>();
		JSONArray jsonArray = json.getJSONArray("messageList");
		List<Message> messagetsList = (List<Message>) jsonArray.toCollection(jsonArray, Message.class);
		try {
			for (int i = 0; i < messagetsList.size(); i++) {
				System.out.println(messagetsList.get(i));
				StringBuffer sb = new StringBuffer();
				messagetsList.get(i).setDate(new Date());
				Integer code = messageService.messageInsert(messagetsList.get(i));
				sb.append("管理员账户   ");
				sb.append(messagetsList.get(i).getAdmin_num());// 添加管理员账户num
				if (code == 0) {
					sb.append(" 添加推送消息失败");
				} else if (code == 1) {
					sb.append(" 添加推送消息成功");
				}
				SafeLog safeLog = new SafeLog();
				safeLog.setHandle_name(messagetsList.get(i).getHandle_name());
				safeLog.setHandle_id(messagetsList.get(i).getHandle_id());
				safeLog.setHandle(sb.toString());
				safeLog.setHandle_date(new Date());
				safeLogService.safeLogAdd(safeLog);
				result.put("code", code);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result.put("code", 0);
		}
		return result;
	}
}
