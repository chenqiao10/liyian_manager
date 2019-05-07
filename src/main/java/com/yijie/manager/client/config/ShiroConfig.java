package com.yijie.manager.client.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @描述 Shiro配置类
 * @author Lucifer
 *
 */
@Configuration
public class ShiroConfig {
	
	//创建ShiroFilterFactory
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager securityManager){
		ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
		
		//关联SecurityManager
		bean.setSecurityManager(securityManager);
		
		Map<String,String> filterMap = new LinkedHashMap<>();
//		
//		//认证过滤器
//		//默认拦截
//		filterMap.put("/**", "authc");
//		//项目模块开放
//		filterMap.put("/project/**", "anon");
//		//城市列表请求开放
//		filterMap.put("/city/**", "anon");
//		//流量数据记录请求开放
//		filterMap.put("/visit/**", "anon");
//		//用户申请操作开放
//		filterMap.put("/userHandle/**", "anon");
//		
//		//修改登录请求
//		bean.setLoginUrl("/userHandle/toLogin");
		
		//添加Shiro过滤器
		bean.setFilterChainDefinitionMap(filterMap);
		
		
		return bean;
	}
	
	
	//创建SecurityManager
	@Bean
	public DefaultWebSecurityManager defaultWebSecurityManager(MyRealm realm){
		DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
		
		//关联Realm
		manager.setRealm(realm);
		
		return manager;
	}
	
	
	@Bean
	public MyRealm myRealm(){
		MyRealm realm = new MyRealm();
		return realm;
	}

}
