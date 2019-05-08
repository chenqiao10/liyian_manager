package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.User;

/**
 * @描述 用户功能执行模块
 * @author Lucifer
 *
 */
public interface UserHandleService {
	// 用户登录
	public User userLogin(User user);

	// 用户注册
	public Integer userRegist(User user);

	// 验证用户电话号码是否已使用
	public User userPhoneExist(String num);

	// 用户信息修改
	public Integer userUpdate(User user);

	// 用户添加积分
	public Integer scoreAdd(User user, Integer score);

	// 用户扣除积分
	public Integer scoreDel(User user, Integer score);
	
	public List<User> userSelect(User user);
	
	//  用户信息批量删除
	public Integer userDeleteAll(List<User> userList);
	
	// 用户信息条数
	public Integer userCount(User User);

}
