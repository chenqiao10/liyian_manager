package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.SuperAdminDao;
import com.yijie.manager.client.model.SuperAdmin;
import com.yijie.manager.client.service.SuperAdminService;

@Service   
public class SuperAdminServiceImpl implements SuperAdminService{
	
	@Autowired
	private SuperAdminDao superAdminDao;

	@Override
	public Integer superAdminInsert(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return superAdminDao.superAdminInsert(superAdmin);
	}

	@Override
	public Integer superAdminDelete(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return superAdminDao.superAdminDelete(superAdmin);
	}

	@Override
	public Integer superAdminUpdate(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return superAdminDao.superAdminUpdate(superAdmin);
	}

	@Override
	public List<SuperAdmin> superAdminSelect(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return superAdminDao.superAdminSelect(superAdmin);
	}

}
