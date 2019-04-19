package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.AdminDao;
import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.service.AdminService;
/**
 * 管理账户模块
 * 
 * @author sunzhu
 *
 */
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<Admin> adminTable(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminTable(admin);
	}

	@Override
	public Integer adminDelete(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminDelete(admin);
	}

	@Override
	public Integer adminUpdate(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminUpdate(admin);
	}

	@Override
	public Integer adminInsert(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminInsert(admin);
	}

	@Override
	public Admin adminLogin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.adminLogin(admin);
	}

}
