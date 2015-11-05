package com.crelic.dao;

import java.util.ArrayList;
import java.util.List;

import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.UserBean;

public interface UserDao {
	
	/*��֤�û���¼*/
	public boolean checkUser(UserBean ub);
	
	/*�ղ�����*/
	public boolean collectCul(CollectBean cb);
	
	/*ȡ���ղ�����*/
	public boolean delCollect(CollectBean cb);
	
	/*�ж�ĳ�������Ƿ�Ϊ���û��ղ�*/
	public boolean checkCollect(CollectBean cb);
	
	/*����û�������ı���*/
	public boolean saveBy(CollectBean cb);
	
	/*�����������*/
	public void batchBy(List<Biaoyin> bylist);
	
	/*��ȡ�û������б���*/
	public List<String> getBy(String userid);
	
	/*�����û����������û�id*/
	public String getIdByName(String userName);
	
}
