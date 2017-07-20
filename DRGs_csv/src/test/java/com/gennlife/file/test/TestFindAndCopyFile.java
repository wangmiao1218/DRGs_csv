package com.gennlife.file.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.utils.FileUtils;
import com.gennlife.file.FindAndCopyFile;

public class TestFindAndCopyFile {
	private static String filePath = "F:\\DRGs\\newadd";
	private static String oldFilePathAndFileName = "F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院.csv";
	private static String newFilePathAndFileName = "F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院_1.csv";
	
	private static String oldFilePath = "F:\\test";
	private static String newFilePath = "F:\\testall";
	
	private static String copyFilePath = "F:\\test1";
	

	@Test
	public void copyFile1() {	
		List<String> oldFilePathList = FindAndCopyFile.findFileReturnFileNameList(oldFilePath);	
		List<String> newFilePathList = FindAndCopyFile.findFileReturnFileNameList(newFilePath);

		//判断bigList中是否有smallList
		for (String str : newFilePathList) {
			if(!oldFilePathList.contains(str)){  
                System.out.println("newFilePathList里没有的是==>" + str+"==>不做处理");  
            } 
			
			if(oldFilePathList.contains(str)){  
                System.out.println("newFilePathList里有的是==>" + str+"==>拷贝到新路径");  
                FindAndCopyFile.copyFile(oldFilePath+"\\"+str+".csv", copyFilePath+"\\"+str+".csv");
            } 
		}
		
		
		
	}
	
	@Test
	public void copyFile() {
		FindAndCopyFile.copyFile(oldFilePathAndFileName, newFilePathAndFileName);
		
	}

	@Test
	public void findFileReturnFileNameList() {
		List<String> list = FindAndCopyFile.findFileReturnFileNameList(filePath);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	
	
}
