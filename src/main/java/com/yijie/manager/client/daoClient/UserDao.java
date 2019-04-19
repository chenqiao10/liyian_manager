package com.yijie.manager.client.daoClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yijie.manager.client.model.User;

/**
 * 用户数据接口
 * @author chenqiao
 *
 */
@FeignClient("yijie.zuul.api")
public interface UserDao {
	@RequestMapping("/yilianData/user/userLogin")
	public User userLogin(User user);
	@RequestMapping("/yilianData/user/userTable")
	public User userTable(User user);
	@RequestMapping("/yilianData/user/userRegist")
	public Integer userRegist(User user);
	@RequestMapping("/yilianData/user/userUpdate")
	public Integer userUpdate(User user);
   
}
