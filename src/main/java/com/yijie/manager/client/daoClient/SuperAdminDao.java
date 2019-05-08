package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.SuperAdminDaoClientFallBack;
import com.yijie.manager.client.model.SuperAdmin;

@FeignClient(name = "yijie.zuul.api",fallback = SuperAdminDaoClientFallBack.class)
public interface SuperAdminDao {
	
	// 超管信息添加
	@RequestMapping("/yilianData/admin/superAdminInsert")
	public Integer superAdminInsert(SuperAdmin superAdmin);

	// 超管信息删除
	@RequestMapping("/yilianData/admin/superAdminDelete")
	public Integer superAdminDelete(SuperAdmin superAdmin);

	// 超管信息修改
	@RequestMapping("/yilianData/admin/superAdminUpdate")
	public Integer superAdminUpdate(SuperAdmin superAdmin);

	// 超管信息查询
	@RequestMapping("/yilianData/admin/superAdminSelect")
	public List<SuperAdmin> superAdminSelect(SuperAdmin superAdmin);
	
	//超级管理账户登录
	@RequestMapping("/yilianData/admin/superAdminLogin")
	public SuperAdmin superAdminLogin(SuperAdmin superAdmin);

}
