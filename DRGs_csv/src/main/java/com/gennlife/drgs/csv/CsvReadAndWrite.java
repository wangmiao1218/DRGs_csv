package com.gennlife.drgs.csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.gennlife.drgs.utils.ListAndStringUtils;

/**
 * @Description: 处理csv文件方法
 * @author: wangmiao
 * @Date: 2017年7月19日 下午2:13:03 
 */
public class CsvReadAndWrite {
	
	/** 
	* @Title: readCsvOfLine 
	* @Description: 读取csv文件，某一列
	* @param: @param readFilePathAndFileName:读入路径和文件名F:\\DRGs\\newadd\\990002_武汉市中心医院.csv
	* @param: @return :
	* @return: List<String>  返回list
	* @throws 
	*/
	public static List<String> readCsvOfLine(String readFilePathAndFileName) {
		// 用来保存数据
		List<String> csvList = new ArrayList<String>();

		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(readFilePathAndFileName,',',Charset.forName("UTF-8"));
			//CsvReader csvReader = new CsvReader(readFilePath,',',Charset.forName("GBK"));
			// 读表头
			csvReader.readHeaders();
			
			// 逐行读入除表头的数据
			while (csvReader.readRecord()) {
				// 读这行的某一列s
				String value = csvReader.get("src.jzlsh");
				csvList.add(value);
			}
			// 关闭
			csvReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return csvList;
	}
	
	
	/** 
	 * @Title: readCsv 
	 * @Description: 读取csv文件并把23、24列加引号
	 * @param: @param readFilePathAndFileName:读入路径和文件名F:\\DRGs\\newadd\\990002_武汉市中心医院.csv
	 * @param: @return :
	 * @return: List<String>  返回list
	 * @throws 
	 */
	public static List<String> readCsv(String readFilePathAndFileName) {
		// 用来保存数据
		List<String> csvList = new ArrayList<String>();

		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(readFilePathAndFileName,',',Charset.forName("UTF-8"));
			//CsvReader csvReader = new CsvReader(readFilePath,',',Charset.forName("GBK"));
			// 读表头
			csvReader.readHeaders();
			String record = csvReader.getRawRecord();
			csvList.add(record);
			
			// 逐行读入除表头的数据
			while (csvReader.readRecord()) {
				// 读一整行
				String rawRecord = csvReader.getRawRecord();
				
				// 将此行转为list，
				List<String> stringToList = ListAndStringUtils.stringToList(rawRecord);
				// 再23 24列加入引号后
				stringToList.set(23, "'" + stringToList.get(23) + "'");
				stringToList.set(24, "'" + stringToList.get(24) + "'");
				
				// 再转为String
				String listToString = ListAndStringUtils.listToString(stringToList);
				// 添加到list中
				csvList.add(listToString);
			}
			// 关闭
			csvReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return csvList;
	}

	
	/** 
	* @Title: writeCsv 
	* @Description: 写入csv文件
	* @param: @param writeFilePathAndFileName: 写入路径和文件名F:\\DRGs\\newadd\\1.csv
	* @param: @param list :
	* @return: void
	* @throws 
	*/
	public static void writeCsv(String writeFilePathAndFileName,List<String> list) {
		try {
			//CsvWriter csvWriter = new CsvWriter(writeFilePath,',',Charset.forName("GBK"));
			CsvWriter csvWriter = new CsvWriter(writeFilePathAndFileName,',',Charset.forName("UTF-8"));

			for (int i = 0; i < list.size(); i++) {
				String[] content = ListAndStringUtils.listToStringArray(ListAndStringUtils.stringToList(list.get(i)));
				csvWriter.writeRecord(content);
			}
			
			csvWriter.close();
			System.out.println("--------CSV文件已经写入--------");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	/** 
	* @Title: readAndWriteCsv 
	* @Description: 读文件并写入
	* @param: @param readFilePathAndFileName:"F:\\DRGs\\newadd\\990063_武汉市江岸区中西医结合医院.csv";
	* @param: @param writeFilePathAndFileName :"F:\\DRGs\\newadd\\1.csv";
	* @return: void
	* @throws 
	*/
	public static void readAndWriteCsv(String readFilePathAndFileName,String writeFilePathAndFileName) {
		// 用来保存数据(不用全局变量，否则调用循环时，数据累计增加)
		List<String> csvList = new ArrayList<String>();

		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(readFilePathAndFileName,',', Charset.forName("UTF-8"));
			CsvWriter csvWriter = new CsvWriter(writeFilePathAndFileName,',', Charset.forName("UTF-8"));
			
			// 读表头
			csvReader.readHeaders();
			
			String[] headers = ListAndStringUtils.listToStringArray(ListAndStringUtils.stringToList(csvReader.getRawRecord()));
	        csvWriter.writeRecord(headers);
	        
			//逐行读入除表头的数据
			while (csvReader.readRecord()) {
				// 读一整行
				String rawRecord = csvReader.getRawRecord();
				
				//将此行转为list，
				List<String> stringToList = ListAndStringUtils.stringToList(rawRecord);
				//再23 24列加入引号后
				stringToList.set(23,"'"+stringToList.get(23)+"'");
				stringToList.set(24,"'"+stringToList.get(24)+"'");
				
				//再转为String
				String listToString = ListAndStringUtils.listToString(stringToList);
				csvList.add(listToString);
				
			}
			csvReader.close(); 
			
			//写入csv
			for (int i = 0; i < csvList.size(); i++) {
				String[] content =ListAndStringUtils.listToStringArray(ListAndStringUtils.stringToList(csvList.get(i)));
				csvWriter.writeRecord(content);
			}
			csvWriter.close();  
			
	        System.out.println(readFilePathAndFileName+"--------CSV文件已经写入--------");  
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}