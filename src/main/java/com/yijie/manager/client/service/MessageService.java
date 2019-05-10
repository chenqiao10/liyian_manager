package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.Message;
/**
 * @ 推送消息模块
 * 
 * @author sunzhu
 *
 */
public interface MessageService {
	
	//推送消息查询
	public List<Message> messageTable(Message message);
	
	//推送消息删除
	public Integer messageDelete(Message message);
	
	//推送消息修改
	public Integer messageUpdate(Message message);
	
	//推送消息添加
	public Integer messageInsert(Message message);
//推送条数
	public Integer messageCount(Message message);

}
