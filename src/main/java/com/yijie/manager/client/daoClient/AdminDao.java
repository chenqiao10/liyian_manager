package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.model.Admin;

/**
 * 管理账户模块接口
 * 
 * @author sunzhu
 *
 */
@FeignClient("test.data.client")
public interface AdminDao {
	
	//管理账户信息查询
	@RequestMapping("/admin/adminSelect")
	public List<Admin> adminTable(Admin admin);
	
	//管理账户登录
	@RequestMapping("/admin/adminLogin")
	public Admin adminLogin(Admin admin);
	
	//管理账户信息删除
	@RequestMapping("/admin/adminDelete")
	public Integer adminDelete(Admin admin);
	
	//管理账户信息修改
	@RequestMapping("/admin/adminUpdate")
	public Integer adminUpdate(Admin admin);
	
	//添加管理账户信息
	@RequestMapping("/admin/adminInsert")
	public Integer adminInsert(Admin admin);

}
