package com.crelic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.crelic.dao.BaseDao;
import com.crelic.dao.UserDao;
import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.UserBean;

public class UserDaoImpl extends BaseDao implements UserDao{

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);
	
	public boolean checkUser(UserBean ub) {
		// TODO Auto-generated method stub
		int object = 0;
		try{
			object = (Integer)getSqlMapClientTemplate().queryForObject("checkUser",ub);
		}catch (Exception e) {
			logger.error("验证用户出错！" +  ",errMsg=" + e.getMessage());
		}
		if(object==1)
			return true;
		else
			return false;
	}

	public boolean collectCul(CollectBean cb) {
		// TODO Auto-generated method stub
		String object = null;
		boolean flag = false;
		try {
			object =(String) getSqlMapClientTemplate().insert("collectCul",cb);
		}catch (Exception e) {
			logger.error("收藏文物出错！" +  ",errMsg=" + e.getMessage());
			System.out.println(e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;

	}

	public boolean delCollect(CollectBean cb) {
		// TODO Auto-generated method stub
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("delCollect",cb);
		}catch (Exception e) {
			logger.error("删除收藏出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;

	}

	public boolean checkCollect(CollectBean cb) {
		// TODO Auto-generated method stub
		int object = 0;
		try{
			object = (Integer)getSqlMapClientTemplate().queryForObject("checkCollect",cb);
		}catch (Exception e) {
			logger.error("判断用户是否收藏某文物！" +  ",errMsg=" + e.getMessage());
		}
		if(object==1)
			return true;
		else
			return false;

	}

	public boolean saveBy(CollectBean cb) {
		// TODO Auto-generated method stub
		Object object = null;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().update("saveBy",cb);
		}catch (Exception e) {
			logger.error("保存标引信息！" +  ",errMsg=" + e.getMessage());
		}
		if (object != null) {
			flag = true;
		}
		return flag;

	}

	public void batchBy(List<Biaoyin> bylist) {
		// TODO Auto-generated method stub
		try{
			getSqlMapClientTemplate().update("addBatchBy",bylist);
		}catch (Exception e) {
			logger.error("批量添加标引信息！" +  ",errMsg=" + e.getMessage());
			System.out.println(e.getMessage());
		}
	}

	public List<String> getBy(String userid) {
		// TODO Auto-generated method stub
		List<String> bylist = null;
		try{
			bylist = getSqlMapClientTemplate().queryForList("getByList",userid);
		}catch (Exception e) {
			logger.error("获取用户的标引信息！" +  ",errMsg=" + e.getMessage());
		}
		return bylist;
	}

	public String getIdByName(String userName) {
		// TODO Auto-generated method stub
		String object = "";
		try{
			object = (String)getSqlMapClientTemplate().queryForObject("getIdByName",userName);
		}catch (Exception e) {
			logger.error("获取用户id获取用户名字！" +  ",errMsg=" + e.getMessage());
		}
		return object;
	}

	public boolean addUser(UserBean ub) {
		// TODO Auto-generated method stub
		int object = -1;
		boolean flag = false;
		try {
			object =(Integer) getSqlMapClientTemplate().insert("addUser",ub);
		}catch (Exception e) {
			logger.error("添加用户出错！" +  ",errMsg=" + e.getMessage());
		}
		if (object != -1) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 根据用户姓名获取用户
	 */
	public UserBean getUserByName(String userName) {
		// TODO Auto-generated method stub
		UserBean user = null;
		try{
			user = (UserBean)getSqlMapClientTemplate().queryForObject("getUserByName",userName);
		}catch (Exception e) {
			logger.error("根据用户名称获取用户出错！" +  ",errMsg=" + e.getMessage());
		}
		return user;

	}


}
