package com.crelic.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;


public class BaseController {
	
	protected Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * Method to flush a String as response.
	 * @param response
	 * @param responseContent
	 * @throws IOException
	 */
	protected void flushResponse(HttpServletResponse response, String responseContent) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try {
			PrintWriter out = response.getWriter();
			out.write(responseContent);
			out.flush();
			out.close();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}


	/**
	 *  �����Ӧ
	 */
	public void outputHtmlResponse(HttpServletResponse response, String str) {
		try {
			StringBuffer htmlText = new StringBuffer();
			htmlText.append("<script type=\"text/javascript\">\n");
			htmlText.append(str);
			htmlText.append("</script>\n");
			this.flushResponse(response, htmlText.toString());
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	
	/**
	 * ���Json��Ӧ��{"result":true}
	 */
	protected void outputJsonResponse(HttpServletResponse response, boolean result) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		String content = json.toString();
		this.flushResponse(response, content);
	}

	/**
	 * ���Json��Ӧ��{"result":true,"msg":"abc"}
	 */
	protected void outputJsonResponse(HttpServletResponse response, boolean result, String message) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("message", message);
		String content = json.toString();
		this.flushResponse(response, content);
	}
	
	/**
	 * ���Json��Ӧ��{"msg":"abc"}
	 */
	protected void outputJsonResponse(HttpServletResponse response,String message) {
		this.flushResponse(response, message);
	}

	
	protected void outputJsonResponse(HttpServletResponse response, boolean result, String message,Object obj) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("message", message);
		if (obj != null ){
			JSONArray jsonArray = new JSONArray(obj);   //��article����תΪjson����  
			String data = jsonArray.toString();         //��json����תΪ�ַ���  
			json.put("data", data);
		}
		String content = json.toString();
		this.flushResponse(response, content);
	}

	protected void outputJsonResponse(HttpServletResponse response,Object obj) {
		String content = "";
		if (obj != null ){
			if(obj.getClass().isArray()){
				JSONArray jsonArray = new JSONArray(obj);
				content = jsonArray.toString();  
			}else{
				JSONObject json = new JSONObject(obj);
				content = json.toString();
			}
		}
		this.flushResponse(response, content);
	}


	protected void outputJsonResponse(HttpServletResponse response, Map dataMap) {
		this.flushResponse(response, toJsonString(dataMap));
	}

	/*
	 * {"result":true,"data":{"key1":"value1","key2":"value2"}}
	 */
	protected void outputJsonResponse(HttpServletResponse response, boolean result, Map customData) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		if (customData != null && customData.size() > 0)
			json.put("data", customData);
		String content = json.toString();
		this.flushResponse(response, content);
	}
	

	
	protected void outputJsonResponse(HttpServletResponse response, boolean result, String message, Map customData) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("message", message);
		if (customData != null && customData.size() > 0)
			json.put("data", customData);
		String content = json.toString();
		this.flushResponse(response, content);
	}

	/*
	 * json
	 * {result:true,data:[{"name":"name1","id":"id1"},{"name":"name2","id":"id2"}]}
	 */
	protected void outputJsonResponse(HttpServletResponse response, boolean result, Collection coll) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		if (coll != null && coll.size() > 0) {
			JSONArray jsonArray = new JSONArray(coll);
			json.put("data", jsonArray);
		}
		String content = json.toString();
		this.flushResponse(response, content);
	}
	
	/*
	 * ���json����
	 * �����ʽΪ��{data:[{"name":"name1","id":"id1"},{"name":"name2","id":"id2"}]}
	 */
	protected void outputJsonResponse(HttpServletResponse response,Collection coll) {
		JSONArray jsonArray = null;
		if (coll != null && coll.size() > 0) {
			jsonArray = new JSONArray(coll);
		}
		String content ="{}";
		if(jsonArray!=null)
			content = jsonArray.toString();
		this.flushResponse(response, content);
	}

	
	protected void outputJsonResponse(HttpServletResponse response, boolean result, String message, Collection coll) {
		JSONObject json = new JSONObject();
		json.put("result", result);
		json.put("message", message);
		if (coll != null && coll.size() > 0) {
			JSONArray jsonArray = new JSONArray(coll);
			json.put("data", jsonArray);
		}
		String content = json.toString();
		this.flushResponse(response, content);
	}

	/**
	 * ��java����ת����json�ַ���
	 *{"name":"name1","id":"id1"}
	 */
	public static String toJsonString(Object object) {
		String res = "";
		if (object != null ){
			JSONArray jsonArray = new JSONArray(object);   //��article����תΪjson����  
			res = jsonArray.toString();         //��json����תΪ�ַ���  
		}
		return res;
	}

	/*
	 * ��java����ת��Ϊjson�����ַ���
	 * [{"name":"name1","id":"id1"},{"name":"name2","id":"id2"}]
	 */
	public static String toJsonArrayString(Collection<Object> coll) {
		String res = "";
		if (coll != null && coll.size() > 0) {
			JSONArray jsonArray = new JSONArray(coll);
			res = jsonArray.toString();
		}
		return res;
	}
	
}
