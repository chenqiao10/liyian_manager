package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.MessageDao;
import com.yijie.manager.client.model.Message;
import com.yijie.manager.client.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{
	
	@Autowired
	private MessageDao messageDao;

	@Override
	public List<Message> messageTable(Message message) {
		// TODO Auto-generated method stub
		return messageDao.messageTable(message);
	}

	@Override
	public Integer messageDelete(Message message) {
		// TODO Auto-generated method stub
		return messageDao.messageDelete(message);
	}

	@Override
	public Integer messageUpdate(Message message) {
		// TODO Auto-generated method stub
		return messageDao.messageUpdate(message);
	}

	@Override
	public Integer messageInsert(Message message) {
		// TODO Auto-generated method stub
		return messageDao.messageInsert(message);
	}

	@Override
	public Integer messageCount(Message message) {
		// TODO 自动生成的方法存根
		return messageDao.messageCount(message);
	}

}
