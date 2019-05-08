package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.AdminDao;
import com.yijie.manager.client.model.Admin;

@Component
public class AdminDaoClientFallBack implements AdminDao{

	@Override
	public List<Admin> adminTable(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin adminLogin(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adminDelete(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adminUpdate(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer adminInsert(Admin admin) {
		// TODO Auto-generated method stub
		return null;
	}

}
