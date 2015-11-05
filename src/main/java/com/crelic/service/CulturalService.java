package com.crelic.service;

import java.util.List;

import com.crelic.model.CulturalBean;
import com.crelic.model.UploadFile;

public interface CulturalService {

	/*�������������������*/
	public List<CulturalBean> getHotSearch();
	
	/*����������µ��������*/
	public List<CulturalBean> getLatestCul();
	
	/*�ڷ����Ƽ����������.label=0,��ȫ����Ƽ�;label=1�����ݴ����Ƽ�;label=2,����С���Ƽ�*/
	public List<CulturalBean> getRecommCul(String type,int label);
	
	/*������������*/
	public CulturalBean getCultural(String culId);
	
	/*��������ͼƬ*/
	public List<UploadFile> getCulturalPic(String culId);
	
	/*������𷵻ز�ѯ����������*/
	public List<CulturalBean> getCulByType(String type, String time, String color,int pageNow);
	
	/*���������Ĺؼ��ʷ��ز�ѯ������*/
	public List<CulturalBean> search(String keyWord, String time, String color,int pageNow);
	
	/*�����û�id���������ղص�����*/
	public List<CulturalBean> getCulByUserId(String userId,String time,String color,String biaoyin,int pageNow);
	
	/*����ĳ�����������زĵ�����*/
	public int getRowCountByType(String type,String time,String color);
	
	/*���ݲ�ѯ�ؼ��ַ��������زĵ�����*/
	public int getRowCountBySer(String keyWord,String time,String color);
	
	/*�����û����ղط��������زĵ�����*/
	public int getRowCountByUserId(String userId,String time,String color,String biaoyin);
	
	/* ����ҳ��*/
	public int getPageCount(int rowCount);

}
