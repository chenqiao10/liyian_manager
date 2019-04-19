package com.yijie.manager.client.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yijie.manager.client.daoClient.UserBiddingDao;
import com.yijie.manager.client.model.UserBidding;
import com.yijie.manager.client.service.UserBiddingService;

@Service
public class UserBiddingServiceImpl implements UserBiddingService {
	@Autowired
	private UserBiddingDao userBiddingDao;

	@Override
	public List<UserBidding> biddingTable(UserBidding userBidding) {
		// TODO Auto-generated method stub
		return userBiddingDao.userBiddingSelect(userBidding);
	}

	@Override
	public UserBidding biddingMessage(UserBidding userBidding) {
		// TODO Auto-generated method stub
		List<UserBidding> list = userBiddingDao.userBiddingSelect(userBidding);
		if(list.size()!=0) {
			return list.get(0);
		}else {
			return null;
		}
	}

	@Override
	public Integer biddingBuild(UserBidding userBidding) {
		// TODO Auto-generated method stub
		return userBiddingDao.userBiddingInsert(userBidding);
	}

	@Override
	public Integer biddingUpdate(UserBidding userBidding) {
		// TODO Auto-generated method stub
		return userBiddingDao.userBiddingUpdate(userBidding);
	}

}
