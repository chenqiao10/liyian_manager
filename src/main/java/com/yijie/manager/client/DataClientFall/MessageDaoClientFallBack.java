package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.MessageDao;
import com.yijie.manager.client.model.Message;
@Component
public class MessageDaoClientFallBack implements MessageDao{

	@Override
	public List<Message> messageTable(Message message) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer messageDelete(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer messageUpdate(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Integer messageInsert(Message message) {
		// TODO Auto-generated method stub
		return 0;
	}

}
