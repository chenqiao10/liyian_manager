package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.DataClientFall.UserDaoClientFallBack;
import com.yijie.manager.client.model.User;

/**
 * 用户数据接口
 * 
 * @author chenqiao yijie.zuul.api
 */
@FeignClient(name = "yijie.zuul.api",fallback = UserDaoClientFallBack.class)
public interface UserDao {
	@RequestMapping("/yilianData/user/userLogin")
	public User userLogin(User user);

	@RequestMapping("/yilianData/user/userTable")
	public List<User> userTable(User user);

	@RequestMapping("/yilianData/user/userRegist")
	public Integer userRegist(User user);

	@RequestMapping("/yilianData/user/userUpdate")
	public Integer userUpdate(User user);
	
	//  用户信息删除
	@RequestMapping("/yilianData/user/userDelete")
	public Integer userDelete(User user);
	
	// 用户信息条数
	@RequestMapping("/yilianData/user/UserCount")
	public Integer userCount(User user);

}
