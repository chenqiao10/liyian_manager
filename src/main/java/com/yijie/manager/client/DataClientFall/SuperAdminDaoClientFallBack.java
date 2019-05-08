package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.SuperAdminDao;
import com.yijie.manager.client.model.SuperAdmin;
@Component
public class SuperAdminDaoClientFallBack implements SuperAdminDao{

	@Override
	public Integer superAdminInsert(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer superAdminDelete(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer superAdminUpdate(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SuperAdmin> superAdminSelect(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SuperAdmin superAdminLogin(SuperAdmin superAdmin) {
		// TODO Auto-generated method stub
		return null;
	}

}
