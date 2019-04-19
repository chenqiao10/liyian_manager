package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.model.Adcolumn;

/**
 * 广告轮播模块
 * 
 * @author sunzhu
 *
 */
@FeignClient("ylmanager.zuul.api")
public interface AdcolumnDao {
	
	//管理账户信息查询
	@RequestMapping("/yilianData/admin/adcolumnSelect")
	public List<Adcolumn> adcolumnTable(Adcolumn adcolumn);
	
	//管理账户信息删除
	@RequestMapping("/yilianData/admin/adcolumnDelete")
	public Integer adcolumnDelete(Adcolumn adcolumn);
	
	//管理账户信息修改
	@RequestMapping("/yilianData/admin/adcolumnUpdate")
	public Integer adcolumnUpdate(Adcolumn adcolumn);
	
	//添加管理账户信息
	@RequestMapping("/yilianData/admin/adcolumnInsert")
	public Integer adcolumnInsert(Adcolumn adcolumn);

}
