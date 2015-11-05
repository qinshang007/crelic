package com.crelic.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.json.JSONArray;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


public class JsonUtils {
	
	/** 
	 * ��json������java�ַ�������
	 * jsonArrayStr:["1","2","3"]
	 */
	public static String[] toStringArray(String jsonArrayStr) {
		JSONArray jsonArray = new JSONArray(jsonArrayStr);
		String[] stringArray = new String[jsonArray.length()];
		for (int i = 0; i < jsonArray.length(); i++) {
			stringArray[i] = jsonArray.getString(i);
		}
		return stringArray;
	}
	
	/** 
	 * ��һ��JSON �����ַ���ʽ�еõ�һ��java����
	 * {key1:value1,key2:value2}
	 */
    public static <T> T toBean(String jsonString, Class<T> objClass){
        if(StringUtils.isEmpty(jsonString)){
             return null;
        }else{
        	 Gson gson = new Gson();
             return  (T)gson.fromJson(jsonString, objClass);
        }
    }
    
	/** 
	 * ��json���󼯺ϱ��ʽ�еõ�һ��java�����б�
	 * @param <objClass>
	 * @param jsonString:�����ַ���[{key1:value1,key2:value2},{bean2},{bean3},...]
	 */
    public static <T> List<T>  toBeans(String jsonArrayStr,Class<T> objClass) {
    	Type type = new ListParameterizedType(objClass);
    	List<T> list = new ArrayList<T>();
    	if(StringUtils.isEmpty(jsonArrayStr)){
            return null;
        }
    	Gson gson = new Gson();
    	list =  gson.fromJson(jsonArrayStr,type);
    	return list;
    }
    
    
    
    private static class ListParameterizedType implements ParameterizedType {

        private Type type;

        private ListParameterizedType(Type type) {
            this.type = type;
        }

        public Type[] getActualTypeArguments() {
            return new Type[] {type};
        }

        public Type getRawType() {
            return ArrayList.class;
        }

        public Type getOwnerType() {
            return null;
        }

        // implement equals method too! (as per javadoc)
    }
}
