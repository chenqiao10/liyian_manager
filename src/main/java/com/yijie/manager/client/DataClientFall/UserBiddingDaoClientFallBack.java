package com.yijie.manager.client.DataClientFall;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yijie.manager.client.daoClient.UserBiddingDao;
import com.yijie.manager.client.model.UserBidding;



@Component
public class UserBiddingDaoClientFallBack implements UserBiddingDao{

	@Override
	public List<UserBidding> userBiddingSelect(UserBidding userBidding) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public UserBidding userBiddingMessage(UserBidding userBidding) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer userBiddingInsert(UserBidding userBidding) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer userBiddingUpdate(UserBidding userBidding) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Integer userBiddingDelete(UserBidding userBidding) {
		// TODO 自动生成的方法存根
		return null;
	}

}
