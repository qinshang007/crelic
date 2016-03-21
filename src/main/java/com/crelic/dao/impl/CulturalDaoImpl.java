package com.crelic.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crelic.dao.BaseDao;
import com.crelic.dao.CulturalDao;
import com.crelic.model.CulturalBean;
import com.crelic.model.TopSimilar;
import com.crelic.model.UploadFile;

public class CulturalDaoImpl extends BaseDao implements CulturalDao{
	
	private int pageSize = 8;

	public List<CulturalBean> getHotSearch() {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			cblist = getSqlMapClientTemplate().queryForList("getHotSearch");
		}catch (Exception e) {
			logger.error("����������������������" +  ",errMsg=" + e.getMessage());
		}
		return cblist;
	}

	public List<CulturalBean> getLatestCul() {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			cblist = getSqlMapClientTemplate().queryForList("getLatestCul");
		}catch (Exception e) {
			logger.error("����������µ�����������" +  ",errMsg=" + e.getMessage());
		}
		return cblist;
	}

	public List<CulturalBean> getRecommCul(String type, int label) {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			Map map = new HashMap();
			map.put("type", type);
			map.put("label", label);
			cblist = getSqlMapClientTemplate().queryForList("getRecommCul",map);
		}catch (Exception e) {
			logger.error("�����Ƽ�������������" +  ",errMsg=" + e.getMessage());
		}
		return cblist;

	}

	public CulturalBean getCultural(String culId) {
		// TODO Auto-generated method stub
		CulturalBean cb = null;
		try{
			cb = (CulturalBean)getSqlMapClientTemplate().queryForObject("getCultural", culId);
		}catch (Exception e) {
			logger.error("���������������" +  ",errMsg=" + e.getMessage());
			System.out.println(e.getMessage());
		}
		return cb;
	}

	public List<UploadFile> getCulturalPic(String culId) {
		// TODO Auto-generated method stub
		List<UploadFile> piclist = null;
		try{
			piclist = getSqlMapClientTemplate().queryForList("getCulturalPic", culId);
		}catch (Exception e) {
			logger.error("��ȡ����ͼƬ����" +  ",errMsg=" + e.getMessage());
			System.out.println(e.getMessage());
		}
		return piclist;
	}

	public List<CulturalBean> getCulByType(String type, String time,
			String color, int pageNow) {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			Map map = new HashMap();
			map.put("classification", type);
			map.put("time", time);
			map.put("color", color);
			map.put("_start", (pageNow-1)*pageSize);
			map.put("_size", pageSize);
			cblist = getSqlMapClientTemplate().queryForList("getCulByType", map);
		}catch (Exception e) {
			logger.error("������𷵻ز�ѯ���������س���" +  ",errMsg=" + e.getMessage());
			System.out.println(e.getMessage());
		}
		return cblist;
	}

	public List<CulturalBean> search(String keyword, String time,
			String color, int pageNow) {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			Map map = new HashMap();
			map.put("keyword", keyword);
			map.put("time", time);
			map.put("color", color);
			map.put("_start", (pageNow-1)*pageSize);
			map.put("_size", pageSize);
			cblist = getSqlMapClientTemplate().queryForList("search", map);
		}catch (Exception e) {
			logger.error("���������Ĺؼ��ʷ��ز�ѯ���������" +  ",errMsg=" + e.getMessage());
		}
		return cblist;

	}

	public List<CulturalBean> getCulByUserId(String userId, String time,
			String color, String biaoyin, int pageNow) {
		// TODO Auto-generated method stub
		List<CulturalBean> cblist = null;
		try{
			Map map = new HashMap();
			map.put("userid", userId);
			map.put("time", time);
			map.put("color", color);
			map.put("biaoyin", biaoyin);
			map.put("_start", (pageNow-1)*pageSize);
			map.put("_size", pageSize);
			cblist = getSqlMapClientTemplate().queryForList("getCulByUserId", map);
		}catch (Exception e) {
			logger.error("���������Ĺؼ��ʷ��ز�ѯ���������" +  ",errMsg=" + e.getMessage());
		}
		return cblist;
	}

	public int getRowCountByType(String type, String time, String color) {
		// TODO Auto-generated method stub
		int res = 0;
		try{
			Map map = new HashMap();
			map.put("classification", type);
			map.put("time", time);
			map.put("color", color);
			res = (Integer)getSqlMapClientTemplate().queryForObject("getRowCountByType", map);
		}catch (Exception e) {
			logger.error("����ĳ�����������زĵ���������" +  ",errMsg=" + e.getMessage());
		}
		return res;
	}

	public int getRowCountBySer(String keyword, String time, String color) {
		// TODO Auto-generated method stub
		int res = 0;
		try{
			Map map = new HashMap();
			map.put("keyword", keyword);
			map.put("time", time);
			map.put("color", color);
			res = (Integer)getSqlMapClientTemplate().queryForObject("getRowCountBySer", map);
		}catch (Exception e) {
			logger.error("����ĳ�����������زĵ���������" +  ",errMsg=" + e.getMessage());
		}
		return res;

	}

	public int getRowCountByUserId(String userId, String time, String color,
			String biaoyin) {
		// TODO Auto-generated method stub
		int res = 0;
		try{
			Map map = new HashMap();
			map.put("userid", userId);
			map.put("time", time);
			map.put("color", color);
			map.put("biaoyin", biaoyin);
			res = (Integer)getSqlMapClientTemplate().queryForObject("getRowCountByUserId", map);
		}catch (Exception e) {
			logger.error("����ĳ�����������زĵ���������" +  ",errMsg=" + e.getMessage());
		}
		return res;
	}
	
	public TopSimilar getTopSimilar(String identifier) {
		// TODO Auto-generated method stub
		TopSimilar top = null;
		try{
			top = (TopSimilar)getSqlMapClientTemplate().queryForObject("getTopSimilar", identifier);
		}catch (Exception e) {
			logger.error("��������id��ȡ�����Ƶ�ʮ���������" +  ",errMsg=" + e.getMessage());
		}
		return top;
	}


}
