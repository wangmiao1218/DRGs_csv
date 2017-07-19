package com.gennlife.drgs.csv;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.gennlife.drgs.utils.FileUtils;
import com.gennlife.drgs.utils.ListAndStringUtils;

/**
 * @Description: 处理csv文件
 * @author: wangmiao
 * @Date: 2017年7月19日 下午2:14:36 
 */
public class DRGs {
	
	/** 
	* @Title: drgs 
	* @Description: 
	* @param: @param filePath :
	* @return: void
	* @throws 
	*/
	public static void drgs(String filePath) {
		//获取目录下所有文件
		ArrayList<File> files=FileUtils.getListFiles(filePath);  
		//将其转成list
	    List<String> list = FileUtils.arrayFilesToListString(files);
	    
	    //循环遍历list，分别读入和写入
	    for (int i = 0; i < list.size(); i++) {
        	String readFilePath = list.get(i);
			
			//处理路径变成文件名
			String str = ListAndStringUtils.stringToSubstring(list.get(i));
			//拼接成写入路径
			String writeFilePath = "F:\\DRGs\\test\\"+str+"_1.csv";
			
			CsvReadAndWrite.readAndWriteCsv(readFilePath, writeFilePath);
	    }
	}
	
	
}