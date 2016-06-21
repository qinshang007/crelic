package com.crelic.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.crelic.model.Biaoyin;
import com.crelic.model.CollectBean;
import com.crelic.model.CulturalBean;
import com.crelic.model.UploadFile;
import com.crelic.model.UserBean;
import com.crelic.service.CulturalService;
import com.crelic.service.UserService;

@Controller
@RequestMapping(value="/home")
public class HomeController extends BaseController{
	
	@Autowired
	private UserService userService;
	@Autowired
	private CulturalService culService;
	
	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	/**
	 * 首页
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("index.do")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			List<CulturalBean> hsList = culService.getHotSearch();	//获取热门检索的五件文物
			List<CulturalBean> lcList = culService.getLatestCul();	//获取最近更新的五件文物
			Map map = new HashMap();
			map.put("hsList", hsList);
			map.put("lcList", lcList);
			return new ModelAndView("index").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("首页展示出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	/**
	 * 登录接口
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("login.do")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			if(userService.checkUser(ub))
			{
				HttpSession hs = request.getSession();
				hs.setAttribute("username", ub.getUserName());
				String userid = userService.getIdByName(ub.getUserName());
				hs.setAttribute("userid", userid);
				List<CulturalBean> hsList = culService.getHotSearch();	//获取热门检索的五件文物
				List<CulturalBean> lcList = culService.getLatestCul();	//获取最近更新的五件文物
				Map map = new HashMap();
				map.put("hsList", hsList);
				map.put("lcList", lcList);
				return new ModelAndView("index").addAllObjects(map);
			}
			else{
				return new ModelAndView("login");
			}
		}catch (RuntimeException e) {
			logger.error("登录出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	
	
	/**
	 * 分类查找入口
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("type.do")
	public ModelAndView type(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			String type = request.getParameter("culType");
			int pageNow = Integer.valueOf(request.getParameter("pageNow"));
			String time = request.getParameter("time");
			String color = request.getParameter("color");
			int rowCount = culService.getRowCountByType(type,time,color);
	        int pageCount = culService.getPageCount(rowCount);
			List<CulturalBean> clList = culService.getCulByType(type,time,color,pageNow);;	//分页查找某一类别下的文物
			List<CulturalBean> recommList = culService.getRecommCul(type,2);	//获取推荐文物列表
			Map map = new HashMap();
			map.put("rowCount", rowCount);
			map.put("pageCount", pageCount);
			map.put("pageNow", pageNow);
			map.put("culType", type);
			map.put("clList", clList);
			map.put("recommList", recommList);
			return new ModelAndView("classification").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("分类查找出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * 检索入口
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("search.do")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			String keyword = request.getParameter("keyWord");
			String keywords[] = keyword.split(";");
			List<String> keywordList = Arrays.asList(keywords);
			int pageNow = Integer.valueOf(request.getParameter("pageNow"));
			String time = request.getParameter("time");
			String color = request.getParameter("color");
			String type = request.getParameter("culType");
			int rowCount = culService.getRowCountBySer(keywordList,time,color,type);
	        int pageCount = culService.getPageCount(rowCount);
			List<CulturalBean> clList = culService.search(keywordList,time,color,type,pageNow);	//根据搜索关键词分页查找文物
			List<CulturalBean> recommList = culService.getRecommCul("",0); ;	//获取推荐文物列表
			Map map = new HashMap();
			map.put("rowCount", rowCount);
			map.put("pageCount", pageCount);
			map.put("pageNow", pageNow);
			map.put("keyWord", keyword);
			map.put("culType", type);
			map.put("keywordList",keywordList);
			map.put("clList", clList);
			map.put("recommList", recommList);
			return new ModelAndView("search").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("检索文物出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * 收藏页面展示
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("collections.do")
	public ModelAndView collections(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			HttpSession session = request.getSession(true); 
			String userid = (String)session.getAttribute("userid");
			int pageNow = Integer.valueOf(request.getParameter("pageNow"));
			String time = request.getParameter("time");
			String color = request.getParameter("color");
			String biaoyin = request.getParameter("biaoyin");
			int rowCount = culService.getRowCountByUserId(userid,time,color,biaoyin);
	        int pageCount = culService.getPageCount(rowCount);
			List<CulturalBean> clList = culService.getCulByUserId(userid,time,color,biaoyin,pageNow);	//根据用户id，分页查找他收藏的文物
			List<CulturalBean> recommList = culService.getRecommCul("",0); ;	//获取推荐的文物
			List<String> bylist = userService.getBy(userid);
			Map map = new HashMap();
			map.put("rowCount", rowCount);
			map.put("pageCount", pageCount);
			map.put("pageNow", pageNow);
			map.put("clList", clList);
			map.put("recommList", recommList);
			map.put("bylist", bylist);
			return new ModelAndView("collect").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("收藏文物展示出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}

	/**
	 * 获取文物详情接口
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("display.do")
	public ModelAndView display(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			String culId = request.getParameter("culId");
			HttpSession se = request.getSession();  // 获取session
			String userName = (String)se.getAttribute("username");
			String userid = userService.getIdByName(userName);
			CollectBean col = new CollectBean();
			col.setUserid(userid);
			col.setCulid(culId);
			String isCollect="0";
			if(userService.checkCollect(col))
				isCollect="1";
			CulturalBean cb = culService.getCultural(culId);
			List<UploadFile> piclist = culService.getCulturalPic(culId);
			cb.setEwPicture(piclist);
			List<CulturalBean> recommList = culService.getTopSimilar(culId);//.getRecommCul(cb.getClassification(),2); //获取推荐列表
			List<CulturalBean> otcl = culService.getRecommCul(cb.getType(),1);	//最近查看文物
			Map map = new HashMap();
			map.put("cb", cb);
			map.put("isCollect", isCollect);
			map.put("recommList", recommList);
			map.put("otcl", otcl);
			return new ModelAndView("display").addAllObjects(map);
		}catch (RuntimeException e) {
			logger.error("获取文物详情出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
			return null;
		}
	}
	

	/**
	 * 收藏文物接口
	 * @param request
	 * @param response
	 * @param ub
	 * @throws Exception
	 */
	@RequestMapping("collect.do")
	public void collect(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			HttpSession session = request.getSession(true); 
			String userid = (String)session.getAttribute("userid");
			String culId = request.getParameter("culId");
			String cultype = request.getParameter("cultype");
			CollectBean cb = new CollectBean();
			cb.setCulid(culId);
			cb.setCultype(cultype);
			cb.setUserid(userid);
			userService.collectCul(cb);
			outputJsonResponse(response,true);
		}catch (RuntimeException e) {
			logger.error("收藏文物出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	/**
	 * 取消收藏接口
	 * @param request
	 * @param response
	 * @param ub
	 * @throws Exception
	 */
	@RequestMapping("delcollect.do")
	public void delcollect(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			HttpSession session = request.getSession(true); 
			String userid = (String)session.getAttribute("userid");
			String culId = request.getParameter("culId");
			String cultype = request.getParameter("cultype");
			CollectBean cb = new CollectBean();
			cb.setCulid(culId);
			cb.setCultype(cultype);
			cb.setUserid(userid);
			userService.delCollect(cb);
			outputJsonResponse(response,true);
		}catch (RuntimeException e) {
			logger.error("取消收藏出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	/**
	 * 标引接口
	 * @param request
	 * @param response
	 * @param ub
	 * @throws Exception
	 */
	@RequestMapping("biaoyin.do")
	public void biaoyin(HttpServletRequest request, HttpServletResponse response,UserBean ub) throws Exception{
		try{
			HttpSession session = request.getSession(true); 
			String userid = (String)session.getAttribute("userid");
			String biaoyin = request.getParameter("by");
			String culId = request.getParameter("culId");
			String cultype = request.getParameter("cultype");
			CollectBean cb = new CollectBean();
			cb.setCulid(culId);
			cb.setCultype(cultype);
			cb.setUserid(userid);
			cb.setBiaoyin(biaoyin);
			boolean isCollect = userService.checkCollect(cb);
			if(isCollect){
				userService.saveBy(cb);
			}else{
				userService.collectCul(cb);
			}
			String words[] = biaoyin.split(";");
			ArrayList<Biaoyin> list = new ArrayList<Biaoyin>();
			for(int i=0; i<words.length;i++){
				Biaoyin by = new Biaoyin();
				by.setUserid(userid);
				by.setBiaoyin(words[i]);
				list.add(by);
			}
			userService.batchBy(list);
			outputJsonResponse(response,true);
		}catch (RuntimeException e) {
			logger.error("标引文物出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}

	/**
	 * 获取文物详情接口
	 * @param request
	 * @param response
	 * @param ub
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("viewCulture.do")
	public void viewCulture(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try{
			String culId = request.getParameter("culId");
			CulturalBean cb = culService.getCultural(culId);
			outputJsonResponse(response,cb);
		}catch (RuntimeException e) {
			logger.error("获取文物详情出错：" +  ",errMsg=" + e.getMessage());
			outputJsonResponse(response, false, e.getMessage());
		}
	}
}
