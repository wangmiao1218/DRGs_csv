package com.gennlife.drgs.csv.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.utils.FileUtils;

public class TestFileUtils {
	
	private static String filePath = "F:\\newadd";

    @Test  
    public  void testArrayFilesToListString(){  
        ArrayList<File> files=FileUtils.getListFiles(filePath);  
        List<String> list = FileUtils.ArrayFilesToListString(files);
        for (int i = 0; i < list.size(); i++) {
        	String string = list.get(i);
			System.out.println(string);
			//String substring = ListAndStringUtils.StringToSubstring(string);
			//System.out.println(substring);
		}
    }  
    
    @Test  
    public  void testStringToSubstring(){  
    	String value="F:\\newadd\\990002_武汉市中心医院.csv";
    	//String substring = ListAndStringUtils.StringToSubstring(string);
    	
    	int i=value.lastIndexOf(".");
    	String substring = value.substring(0,i);
    	
    	int j=value.lastIndexOf("\\");
    	String substring2 = substring.substring(j+1);
    	
    	System.out.println(substring2);
    }  

    
}