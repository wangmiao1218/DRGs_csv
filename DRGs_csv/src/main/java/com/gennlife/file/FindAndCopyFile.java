package com.gennlife.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.gennlife.drgs.utils.FileUtils;
import com.gennlife.drgs.utils.ListAndStringUtils;

/**
 * @Description: 查并且复制文件
 * @author: wangmiao
 * @Date: 2017年7月20日 下午3:17:20
 */
public class FindAndCopyFile {

	/**
	 * @Title: findFileReturnFileNameList
	 * @Description: 查询路径下所有文件，并返回纯文件名的list
	 * @param: @param filePath: F:\\DRGs\\newadd
	 * @param: @return :
	 * @return: List<String>
	 * @throws
	 */
	public static List<String> findFileReturnFileNameList(String filePath) {
		List<String> fileNameListList = new ArrayList<String>();
		// 获取目录下所有文件
		ArrayList<File> files = FileUtils.getListFiles(filePath);
		// 将其转成\\返回list
		List<String> list = FileUtils.arrayFilesToListString(files);

		// 处理路径返回文件名
		for (int i = 0; i < list.size(); i++) {
			String fileName = ListAndStringUtils.stringToSubstring(list.get(i));
			fileNameListList.add(fileName);
		}
		return fileNameListList;
	}

	
	
	/** 
	* @Title: copyFile 
	* @Description: 复制文件
	* @param: @param oldFilePathAndFileName F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院.csv
	* @param: @param newFilePathAndFileName F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院-1.csv
	* @param: @return :
	* @return: String
	* @throws 
	*/
	public static void copyFile(String oldFilePathAndFileName, String newFilePathAndFileName) {
		try {
			int bytesum = 0;
			int byteread = 0;
			File oldfile = new File(oldFilePathAndFileName);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldFilePathAndFileName); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newFilePathAndFileName);
				byte[] buffer = new byte[1444];
				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();
		}
		
	}

	
}
