package com.crelic.dao;

import java.util.List;

import com.crelic.model.CulturalBean;
import com.crelic.model.UploadFile;

public interface CulturalDao {
	
	/*返回五个检索最多的文物*/
	public List<CulturalBean> getHotSearch();
	
	/*返回最近更新的五件文物*/
	public List<CulturalBean> getLatestCul();
	
	/*于返回推荐的五件文物.label=0,完全随机推荐;label=1，根据大类推荐;label=2,根据小类推荐*/
	public List<CulturalBean> getRecommCul(String type,int label);
	
	/*返回文物详情*/
	public CulturalBean getCultural(String culId);
	
	/*返回文物图片*/
	public List<UploadFile> getCulturalPic(String culIdb);
	
	/*根据类别返回查询的所有文素*/
	public List<CulturalBean> getCulByType(String type, String time, String color,int pageNow);
	
	/*根据搜索的关键词返回查询的文物*/
	public List<CulturalBean> search(String keyword, String time, String color,int pageNow);
	
	/*根据用户id，返回他收藏的文物*/
	public List<CulturalBean> getCulByUserId(String userId,String time,String color,String biaoyin,int pageNow);
	
	/*返回某分类下所有素材的总数*/
	public int getRowCountByType(String type,String time,String color);
	
	/*根据查询关键字返回所有素材的总数*/
	public int getRowCountBySer(String keyWord,String time,String color);
	
	/*根据用户的收藏返回所有素材的总数*/
	public int getRowCountByUserId(String userId,String time,String color,String biaoyin);
	
}
