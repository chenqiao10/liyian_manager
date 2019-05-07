package com.yijie.manager.client.daoClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.model.User;

/**
 * 用户数据接口
 * 
 * @author chenqiao yijie.zuul.api
 */
@FeignClient("yijie.zuul.api")
public interface UserDao {
	@RequestMapping("/yilianData/user/userLogin")
	public User userLogin(User user);

	@RequestMapping("/yilianData/user/userTable")
	public List<User> userTable(User user);

	@RequestMapping("/yilianData/user/userRegist")
	public Integer userRegist(User user);

	@RequestMapping("/yilianData/user/userUpdate")
	public Integer userUpdate(User user);

}
