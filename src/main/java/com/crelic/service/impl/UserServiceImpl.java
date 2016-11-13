package com.crelic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.UserBean;
import com.crelic.service.BaseService;
import com.crelic.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService{

	public boolean checkUser(UserBean ub) {
		// TODO Auto-generated method stub
		return getUserDao().checkUser(ub);
	}

	public boolean collectCul(CollectBean cb) {
		// TODO Auto-generated method stub
		return getUserDao().collectCul(cb);
	}

	public boolean delCollect(CollectBean cb) {
		// TODO Auto-generated method stub
		return getUserDao().delCollect(cb);
	}

	public boolean checkCollect(CollectBean cb) {
		// TODO Auto-generated method stub
		return getUserDao().checkCollect(cb);
	}

	public boolean saveBy(CollectBean cb) {
		// TODO Auto-generated method stub
		return getUserDao().saveBy(cb);
	}

	public void batchBy(ArrayList<Biaoyin> list) {
		// TODO Auto-generated method stub
		getUserDao().batchBy(list);
	}

	public List<String> getBy(String userid) {
		// TODO Auto-generated method stub
		return getUserDao().getBy(userid);
	}

	public String getIdByName(String userName) {
		// TODO Auto-generated method stub
		return getUserDao().getIdByName(userName);
	}

	public boolean addUser(UserBean ub) {
		// TODO Auto-generated method stub
		String userName = ub.getUserName();
		UserBean user = getUserDao().getUserByName(userName);
		if(user != null)
			return false;
		else{
			ub.setLevel(0);
			ub.setEmail("");
			ub.setPhone("");
			return getUserDao().addUser(ub);
		}
	}

}
