package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.UserCheProDao;
import com.yijie.manager.client.model.UserChangeProject;


@Component
public class UserCheProDaoClientFallBack implements UserCheProDao{
	@Override
	public List<UserChangeProject> userCheProTable(UserChangeProject userChangeProject) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer userCheProDelete(UserChangeProject userChangeProject) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer userCheProAdd(UserChangeProject userChangeProject) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public Integer userCheProCount(UserChangeProject userChangeProject) {
		// TODO Auto-generated method stub
		return 0;
	}
     
}
