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
	* @Title: copyOneFile 
	* @Description: 根据旧的文件名称，复制单个文件
	* @param: @param oldFilePathAndFileName F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院.csv
	* @param: @param newFilePathAndFileName F:\\DRGs\\newadd\\990728_武汉市江夏区中医医院-1.csv
	* @param: @return :
	* @return: String
	* @throws 
	*/
	public static void copyOneFile(String oldFilePathAndFileName, String newFilePathAndFileName) {
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

	
	
	/** 
	* @Title: copyTheSameFilesByFilePath 
	* @Description: 判断少的文件夹中，在全的文件夹中是否存在，存在则拷贝相同的文件到拷贝的路径
	* @param: @param oldFilePath:少的文件路径
	* @param: @param newFilePath:全的路径
	* @param: @param copyFilePath :拷贝到的路径
	* @return: String 返回拷贝到的新路径中文件数量
	* @throws 
	*/
	public static String copyTheSameFilesByFilePath(String oldFilePath, String newFilePath,String copyFilePath){
		List<String> oldFilePathList = FindAndCopyFile.findFileReturnFileNameList(oldFilePath);	
		List<String> newFilePathList = FindAndCopyFile.findFileReturnFileNameList(newFilePath);
		//判断bigList中是否有smallList
		for (String str : newFilePathList) {
			/*
			//没有，不做处理
			if(!oldFilePathList.contains(str)){  
                System.out.println("newFilePathList里没有的是==>" + str+"==>不做处理");  
            } 
			*/
			//拷贝
			if(oldFilePathList.contains(str)){  
                System.out.println("newFilePathList里有的是==>" + str+"==>拷贝到新路径");  
                FindAndCopyFile.copyOneFile(newFilePath+"\\"+str+".csv", copyFilePath+"\\"+str+".csv");
            } 
		}
		//返回拷贝到的新路径中文件数量
		return "成功拷贝："+FindAndCopyFile.findFileReturnFileNameList(copyFilePath).size() +" 个文件。";
	}

	
	/** 
	 * @Title: copyTheDifferentFilesByFilePath 
	 * @Description: 判断少的文件夹中，在全的文件夹中是否存在，不存在则拷贝文件到拷贝的路径
	 * @param: @param oldFilePath:少的文件路径
	 * @param: @param newFilePath:全的路径
	 * @param: @param copyFilePath :拷贝到的路径
	 * @return: String 返回拷贝到的新路径中文件数量
	 * @throws 
	 */
	public static String copyTheDifferentFilesByFilePath(String oldFilePath, String newFilePath,String copyFilePath){
		List<String> oldFilePathList = FindAndCopyFile.findFileReturnFileNameList(oldFilePath);	
		List<String> newFilePathList = FindAndCopyFile.findFileReturnFileNameList(newFilePath);
		//判断bigList中是否有smallList
		for (String str : newFilePathList) {
			//没有，则拷贝
			if(!oldFilePathList.contains(str)){  
				System.out.println("newFilePathList里没有的是==>" + str+"==>拷贝到新路径");  
				FindAndCopyFile.copyOneFile(newFilePath+"\\"+str+".csv", copyFilePath+"\\"+str+".csv");
			} 
		}
		//返回拷贝到的新路径中文件数量
		return "成功拷贝："+FindAndCopyFile.findFileReturnFileNameList(copyFilePath).size() +" 个文件。";
	}
	
	
}
