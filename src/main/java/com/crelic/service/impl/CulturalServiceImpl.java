package com.crelic.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crelic.model.CulturalBean;
import com.crelic.model.TopSimilar;
import com.crelic.model.UploadFile;
import com.crelic.service.BaseService;
import com.crelic.service.CulturalService;

@Service
public class CulturalServiceImpl extends BaseService implements CulturalService{

	private int pageSize = 8;
	
	public List<CulturalBean> getHotSearch() {
		// TODO Auto-generated method stub
		return getCulturalDao().getHotSearch();
	}

	public List<CulturalBean> getLatestCul() {
		// TODO Auto-generated method stub
		return getCulturalDao().getLatestCul();
	}

	public List<CulturalBean> getRecommCul(String type, int label) {
		// TODO Auto-generated method stub
		return getCulturalDao().getRecommCul(type, label);
	}

	public CulturalBean getCultural(String culId) {
		// TODO Auto-generated method stub
		return getCulturalDao().getCultural(culId);
	}

	public List<UploadFile> getCulturalPic(String culId) {
		// TODO Auto-generated method stub
		return getCulturalDao().getCulturalPic(culId);
	}

	public List<CulturalBean> getCulByType(String type, String time,
			String color, int pageNow) {
		// TODO Auto-generated method stub
		return getCulturalDao().getCulByType(type, time, color, pageNow);
	}

	public List<CulturalBean> search(List<String> keyWords, String time, String color,
			int pageNow) {
		// TODO Auto-generated method stub
		return getCulturalDao().search(keyWords, time, color, pageNow);
	}

	public List<CulturalBean> getCulByUserId(String userId, String time,
			String color, String biaoyin, int pageNow) {
		// TODO Auto-generated method stub
		return getCulturalDao().getCulByUserId(userId, time, color, biaoyin, pageNow);
	}

	public int getRowCountByType(String type, String time, String color) {
		// TODO Auto-generated method stub
		return getCulturalDao().getRowCountByType(type, time, color);
	}

	public int getRowCountBySer(List<String> keyWords, String time, String color) {
		// TODO Auto-generated method stub
		return getCulturalDao().getRowCountBySer(keyWords, time, color);
	}

	public int getRowCountByUserId(String userId, String time, String color,
			String biaoyin) {
		// TODO Auto-generated method stub
		return getCulturalDao().getRowCountByUserId(userId, time, color, biaoyin);
	}

	public int getPageCount(int rowCount) {
		// TODO Auto-generated method stub
		int pageCount = 0;
		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;

		} else {
			pageCount = rowCount / pageSize + 1;
		}
		return pageCount;
	}
	
	/**
	 * 根据文物id获取最相似的十件文物
	 */
	public List<CulturalBean> getTopSimilar(String identifier) {
		// TODO Auto-generated method stub
		List<CulturalBean> topSimilar = new ArrayList<CulturalBean>();
		TopSimilar top = getCulturalDao().getTopSimilar(identifier);
		if(top != null){
			String topsimilar = top.getTopSimilar();
			String[] tops = topsimilar.split(",");
			HashMap<String,String> map = new HashMap<String,String>();
			for(int i=0;i<tops.length;i++){
				String id = tops[i];
				CulturalBean cb = getCulturalDao().getCultural(id);
				String title = cb.getTitle();
				if(cb != null && map.get(title) == null){
					map.put(title, "exist");
					topSimilar.add(cb);
				}
			}
		}
		return topSimilar;
	}


}
