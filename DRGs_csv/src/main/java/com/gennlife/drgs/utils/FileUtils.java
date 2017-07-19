package com.gennlife.drgs.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
	
	/** 
	* @Title: getListFiles 
	* @Description: 获取指定目录下的所有的文件（不包括文件夹），采用了递归
	* @param: @param obj
	* @param: @return :
	* @return: ArrayList<File>
	* @throws 
	*/
	public static ArrayList<File> getListFiles(Object obj) {
		File directory = null;
		if (obj instanceof File) {
			directory = (File) obj;
		} else {
			directory = new File(obj.toString());
		}
		ArrayList<File> files = new ArrayList<File>();
		if (directory.isFile()) {
			files.add(directory);
			return files;
		} else if (directory.isDirectory()) {
			File[] fileArr = directory.listFiles();
			for (int i = 0; i < fileArr.length; i++) {
				File fileOne = fileArr[i];
				files.addAll(getListFiles(fileOne));
			}
		}
		return files;
	}
	
	
	/** 
	* @Title: ArrayFilesToListString 
	* @Description: 将ArrayFiles中\变成\\后，存到数组中去
	* @param: @param files
	* @param: @return :
	* @return: List<String> 返回String类型的list
	* @throws 
	*/
	public static List<String> ArrayFilesToListString(ArrayList<File> files){
		// 用来保存数据
		List<String> list = new ArrayList<>();

		for (int i = 0; i < files.size(); i++) {
	       String str= files.get(i).toString().replaceAll("\\\\","\\\\\\\\");
	       list.add(str);
		}
		return list;
	}
	
	
}
