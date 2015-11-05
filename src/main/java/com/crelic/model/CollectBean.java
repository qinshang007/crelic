package com.crelic.model;

import java.io.Serializable;

public class CollectBean implements Serializable{
	
	private String id;				//id
	private String userid;			//用户id
	private String culid;			//文物id
	private String cultype;			//文物类别
	private String time;			//收藏时间
	private String biaoyin;			//标引
	
	
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
	public String getCulid() {
		return culid;
	}
	public void setCulid(String culid) {
		this.culid = culid;
	}
	public String getCultype() {
		return cultype;
	}
	public void setCultype(String cultype) {
		this.cultype = cultype;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getBiaoyin() {
		return biaoyin;
	}
	public void setBiaoyin(String biaoyin) {
		this.biaoyin = biaoyin;
	}
	
}
