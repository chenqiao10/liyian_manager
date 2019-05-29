package com.yijie.manager.client.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.yijie.manager.client.model.Admin;
import com.yijie.manager.client.model.SuperAdmin;
import com.yijie.manager.client.service.AdminService;
import com.yijie.manager.client.service.SuperAdminService;

public class MyRealm extends AuthorizingRealm{
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private SuperAdminService superAdminService;
	

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;
		Admin admin = new Admin();
		admin.setNum(token.getUsername());
		Admin a = adminService.adminLogin(admin);
		if(a == null){
			// 用户不存在
			SuperAdmin sadmin = new SuperAdmin();
			sadmin.setNum(token.getUsername());
			SuperAdmin b = superAdminService.superAdminLogin(sadmin);
			if(b == null) {
				//超级管理员查询为空
				return null;
			}
			return new SimpleAuthenticationInfo(b,b.getPassword(),"");
		}
		//返回密码
		return new SimpleAuthenticationInfo(a,a.getPassword(),"");
	}

}
