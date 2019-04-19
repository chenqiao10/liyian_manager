package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.UserCheProDao;
import com.yijie.manager.client.daoClient.UserDao;
import com.yijie.manager.client.model.UserChangeProject;
import com.yijie.manager.client.service.UserChangeProjectService;



@Service
public class UserChangeProjectServiceImpl implements UserChangeProjectService {
	@Autowired
	UserDao userdao;
	@Autowired
	UserCheProDao userCheProDao;
	
			
	@Override
	public List<UserChangeProject> userCheProTable(UserChangeProject userChangeProject) {
		/**
		 *
		 * 判断是否存在* 
		 * 存在就redis读取*不存在访问数据库数据然写入redis*
		 */
		return userCheProDao.userCheProTable(userChangeProject);
	}

	@Override
	public Integer userCheProAdd(UserChangeProject userChangeProject) {
		/**
		 *往数据写也往redis写
		 */
		return userCheProDao.userCheProAdd(userChangeProject);
	}

	@Override
	public Integer userCheProDelete(UserChangeProject userChangeProject) {
		/**
		 * 判断redis是否缓存
		 * 是就删除缓存并删除数据库数据
		 * 否就删除数据库数据
		 * 
		 */
		return userCheProDao.userCheProDelete(userChangeProject);
		

	}

}
