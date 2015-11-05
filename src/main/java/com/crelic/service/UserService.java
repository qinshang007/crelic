package com.crelic.service;

import java.util.ArrayList;
import java.util.List;

import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.UserBean;

public interface UserService {

	/*验证用户登录*/
	public boolean checkUser(UserBean ub);
	
	/*收藏文物*/
	public boolean collectCul(CollectBean cb);
	
	/*取消收藏文物*/
	public boolean delCollect(CollectBean cb);
	
	/*判断某个文物是否为该用户收藏*/
	public boolean checkCollect(CollectBean cb);
	
	/*添加用户对文物的标引*/
	public boolean saveBy(CollectBean cb);
	
	/*批量加入标引*/
	public void batchBy(ArrayList<Biaoyin> list);
	
	/*获取用户的所有标引*/
	public List<String> getBy(String userid);
	
	/*根据用户姓名返回用户id*/
	public String getIdByName(String userName);
	
}
