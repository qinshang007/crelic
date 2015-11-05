package com.crelic.model;

import java.io.Serializable;

public class Biaoyin implements Serializable{
	
	private String id;			//id
	private String userid;		//用户id
	private String biaoyin;		//标引
	private String time;		//时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBiaoyin() {
		return biaoyin;
	}
	public void setBiaoyin(String biaoyin) {
		this.biaoyin = biaoyin;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
