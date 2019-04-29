package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.SafeLog;

/**
 * 安全日志接口
 * @author sunzhu
 *
 */
public interface SafeLogService {
	
	//添加安全日志记录
	public Integer safeLogAdd(SafeLog safeLog);
	
	//积分安全日志记录
	public List<SafeLog> safeLogTable(SafeLog safeLog);
	
	//积分安全日志记录
	public Integer safeLogUpdate(SafeLog safeLog);
	
	//积分安全日志记录
	public Integer safeLogDelete(SafeLog safeLog);

}
