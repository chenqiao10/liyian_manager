package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.AdminDaoClientFallBack;
import com.yijie.manager.client.model.Admin;

/**
 * 管理账户模块接口
 * 
 * @author sunzhu
 *
 */
@FeignClient(name = "yijie.zuul.api",fallback = AdminDaoClientFallBack.class)
public interface AdminDao {
	
	//管理账户信息查询
	@RequestMapping("/yilianData/admin/adminSelect")
	public List<Admin> adminTable(Admin admin);
	
	//管理账户登录
	@RequestMapping("/yilianData/admin/adminLogin")
	public Admin adminLogin(Admin admin);
	
	//管理账户信息删除
	@RequestMapping("/yilianData/admin/adminDelete")
	public Integer adminDelete(Admin admin);
	
	//管理账户信息修改
	@RequestMapping("/yilianData/admin/adminUpdate")
	public Integer adminUpdate(Admin admin);
	
	//添加管理账户信息
	@RequestMapping("/yilianData/admin/adminInsert")
	public Integer adminInsert(Admin admin);

}
