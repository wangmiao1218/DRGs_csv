package com.gennlife.drgs.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 字符串处理的工具集
 * @author: wangmiao
 * @Date: 2017年7月18日 下午6:28:48 
 */
public class ListAndStringUtils {
	
	/** 
	* @Title: StringToList 
	* @Description: 将字符串用，分割后转成List
	* @param: @param value
	* @param: @return :
	* @return: List<String>
	* @throws 
	*/
	public static List<String> stringToList(String value){
		String[] strings = value.split(",");
		
		List<String> list=new ArrayList<String>();
		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i]);
		}
		
		return list;
	}
	
	
	/** 
	* @Title: listToString 
	* @Description: 将list转为string
	* @param: @param list
	* @param: @return :
	* @return: String
	* @throws 
	*/
	public static String listToString(List<String> list) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < list.size(); i++) {
			String attribute = list.get(i);
			sb.append(attribute+",");
		}
		return sb.toString();
	}
	
	
	/** 
	* @Title: listToStringArray 
	* @Description: 将list转为string[]数组
	* @param: @param list
	* @param: @return :
	* @return: String[]
	* @throws 
	*/
	public static String[] listToStringArray(List<String> list) {
		return list.toArray(new String[list.size()]);  
	}
	
	
	/** 
	* @Title: StringToSubstring 
	* @Description: 将路径中去掉最后一个\\之前，以及后缀名，只剩下文件名
	* @param: @param value
	* @return: String
	* @throws 
	*/
	public static String stringToSubstring(String value) {
		int i=value.lastIndexOf("\\");
    	int j=value.lastIndexOf(".");
    	String substring = value.substring(i+1, j);
		return substring;  
	}
	
	
}
