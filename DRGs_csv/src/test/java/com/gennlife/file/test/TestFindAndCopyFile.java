package com.gennlife.file.test;

import java.util.List;

import org.junit.Test;

import com.gennlife.file.FindAndCopyFile;

public class TestFindAndCopyFile {
	private static String filePath = "F:\\DRGs\\newadd";
	private static String oldFilePathAndFileName = "F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院.csv";
	private static String newFilePathAndFileName = "F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院_1.csv";
	
	private static String oldFilePath = "F:\\test";
	private static String newFilePath = "F:\\testall";
	
	private static String copyFilePath = "F:\\test1";
	

	@Test
	public void copyTheSameFilesByFilePath() {	
		String str = FindAndCopyFile.copyTheSameFilesByFilePath(oldFilePath, newFilePath, copyFilePath);
		System.out.println(str);
	}
	
	@Test
	public void copyFile() {
		FindAndCopyFile.copyOneFile(oldFilePathAndFileName, newFilePathAndFileName);
		
	}

	@Test
	public void findFileReturnFileNameList() {
		List<String> list = FindAndCopyFile.findFileReturnFileNameList(filePath);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	
	
}
