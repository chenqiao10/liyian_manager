package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.MessageDaoClientFallBack;
import com.yijie.manager.client.model.Message;

/**
 * @ 推送消息接口
 * 
 * @author sunzhu
 *
 */
@FeignClient(name = "yijie.zuul.api", fallback = MessageDaoClientFallBack.class)
public interface MessageDao {
	// 推送消息查询
	@RequestMapping("/yilianData/admin/messageSelect")
	public List<Message> messageTable(Message message);

	// 推送消息删除
	@RequestMapping("/yilianData/admin/messageDelete")
	public Integer messageDelete(Message message);

	// 推送消息修改
	@RequestMapping("/yilianData/admin/messageUpdate")
	public Integer messageUpdate(Message message);

	// 推送消息添加
	@RequestMapping("/yilianData/admin/messageInsert")
	public Integer messageInsert(Message message);
	@RequestMapping("/yilianData/admin/messageCount")
	public Integer messageCount(Message message);

}
