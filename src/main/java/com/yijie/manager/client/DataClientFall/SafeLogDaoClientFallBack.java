package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.SafeLogDao;
import com.yijie.manager.client.model.SafeLog;
@Component
public class SafeLogDaoClientFallBack implements SafeLogDao{

	@Override
	public List<SafeLog> safeLogSelect(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer safeLogInsert(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer safeLogUpdate(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer safeLogDelete(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return null;
	}

}
