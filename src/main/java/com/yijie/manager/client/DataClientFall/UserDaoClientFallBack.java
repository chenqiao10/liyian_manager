package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.UserDao;
import com.yijie.manager.client.model.User;


@Component
public class UserDaoClientFallBack implements UserDao{

	@Override
	public User userLogin(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> userTable(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer userRegist(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer userUpdate(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer userDeleteAll(List<User> userList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer userCount(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
