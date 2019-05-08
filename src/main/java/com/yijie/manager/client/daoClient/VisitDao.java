package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.VisitDaoClientFallBack;
import com.yijie.manager.client.model.Visit;

/**
 * @访问量模块
 * @author sunzhu
 *
 */
@FeignClient(name = "yijie.zuul.api",fallback = VisitDaoClientFallBack.class)
public interface VisitDao {
	
	//积分记录查询
	@RequestMapping("/yilianData/Visit/VisitSelect")
	public List<Visit> visitSelect(Visit visit);
	
	//积分记录添加
	@RequestMapping("/yilianData/Visit/VisitInsert")
	public Integer visitInsert(Visit visit);
	
	//积分记录更新
	@RequestMapping("/yilianData/Visit/VisitUpdate")
	public Integer visitUpdate(Visit visit);

}
