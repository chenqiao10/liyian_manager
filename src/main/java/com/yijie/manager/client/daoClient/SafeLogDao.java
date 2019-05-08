package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.SafeLogDaoClientFallBack;
import com.yijie.manager.client.model.SafeLog;

/**
 * 安全日志接口
 * 
 * @author sunzhu
 *
 */
@FeignClient(name = "yijie.zuul.api" ,fallback = SafeLogDaoClientFallBack.class)
public interface SafeLogDao {
	//积分记录查询
	@RequestMapping("/yilianData/admin/logSelect")
	public List<SafeLog> safeLogSelect(SafeLog safeLog);
	
	//积分记录添加
	@RequestMapping("/yilianData/admin/logInsert")
	public Integer safeLogInsert(SafeLog safeLog);
	
	//积分记录更新
	@RequestMapping("/yilianData/admin/logUpdate")
	public Integer safeLogUpdate(SafeLog safeLog);
	
	//积分记录删除
	@RequestMapping("/yilianData/admin/logDelete")
	public Integer safeLogDelete(SafeLog safeLog);

}
