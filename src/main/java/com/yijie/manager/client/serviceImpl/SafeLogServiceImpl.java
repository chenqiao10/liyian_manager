package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.SafeLogDao;
import com.yijie.manager.client.model.SafeLog;
import com.yijie.manager.client.service.SafeLogService;

@Service
public class SafeLogServiceImpl implements SafeLogService{
	
	@Autowired
	private SafeLogDao safeLogDao;

	@Override
	public Integer safeLogAdd(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return safeLogDao.safeLogInsert(safeLog);
	}

	@Override
	public List<SafeLog> safeLogTable(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return safeLogDao.safeLogSelect(safeLog);
	}

	@Override
	public Integer safeLogUpdate(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return safeLogDao.safeLogUpdate(safeLog);
	}

	@Override
	public Integer safeLogDelete(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return safeLogDao.safeLogDelete(safeLog);
	}

	@Override
	public Integer logCount(SafeLog safeLog) {
		// TODO Auto-generated method stub
		return safeLogDao.safelogCount(safeLog);
	}

}
