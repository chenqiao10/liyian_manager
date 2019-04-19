package com.yijie.manager.client.service;

import java.util.List;

import com.yijie.manager.client.model.UserBidding;


/**
 * @描述 用户竞标模块
 * @author Lucifer
 *
 */
public interface UserBiddingService {
	
	//用户竞标列表
	public List<UserBidding> biddingTable(UserBidding userBidding);
	
	//用户竞标详细信息
	public UserBidding biddingMessage(UserBidding userBidding);
	
	//用户竞标创建
	public Integer biddingBuild(UserBidding userBidding);
	
	//用户竞标信息修改
	public Integer biddingUpdate(UserBidding userBidding);

}
