package com.crelic.model;

public class UserBean 
{
	private String userId;				//�û�id
	
	private String userName;		//�û���
	
	private String password;		//����
	
	private int level;				//�û��ȼ���0Ϊ��ͨ�û���1Ϊ����Ա��2Ϊ��������Ա
	
	private String email;			//����
	
	private String phone;			//�绰
	
	private String regTime;			//ע��ʱ��

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRegTime() {
		return regTime;
	}

	public void setRegTime(String regTime) {
		this.regTime = regTime;
	}
	
}
