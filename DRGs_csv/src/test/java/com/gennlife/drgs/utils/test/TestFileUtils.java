package com.gennlife.drgs.utils.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.utils.FileUtils;
import com.gennlife.drgs.utils.ListAndStringUtils;

public class TestFileUtils {
	
	private static String filePath = "F:\\DRGs\\newadd";

    @Test  
    public  void testArrayFilesToListString(){  
        ArrayList<File> files=FileUtils.getListFiles(filePath);  
        List<String> list = FileUtils.arrayFilesToListString(files);
        for (int i = 0; i < list.size(); i++) {
        	String string = list.get(i);
			System.out.println(string);
			//String substring = ListAndStringUtils.StringToSubstring(string);
			//System.out.println(substring);
		}
    }  
    
    @Test  
    public  void testStringToSubstring(){  
    	String value="F:\\DRGs\\newadd\\990002_武汉市中心医院.csv";
    	String substring = ListAndStringUtils.stringToSubstring(value);
    	
    	System.out.println(substring);
    }  

    
}