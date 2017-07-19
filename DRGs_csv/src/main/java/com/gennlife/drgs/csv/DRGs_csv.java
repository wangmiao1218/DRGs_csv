package com.gennlife.drgs.csv;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import com.gennlife.drgs.utils.ListAndStringUtils;

public class DRGs_csv {
	// 用来保存数据
	private static List<String> csvList = new ArrayList<String>();

	/** 
	* @Title: readCsv 
	* @Description: 读取csv文件
	* @param: @param readFilePath
	* @param: @return :
	* @return: List<String>  返回list
	* @throws 
	*/
	public static List<String> readCsv(String readFilePath) {
		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(readFilePath,',',Charset.forName("UTF-8"));
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
	* @param: @param writeFilePath
	* @param: @param list :
	* @return: void
	* @throws 
	*/
	public static void writeCsv(String writeFilePath,List<String> list) {
		try {
			CsvWriter csvWriter = new CsvWriter(writeFilePath,',',Charset.forName("UTF-8"));

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

	
	public static void readAndWriteCsv(String readFilePath,String writeFilePath) {
		try {
			// 创建CSV读对象
			CsvReader csvReader = new CsvReader(readFilePath,',', Charset.forName("UTF-8"));
			CsvWriter csvWriter = new CsvWriter(writeFilePath,',', Charset.forName("UTF-8"));
			
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
				
				//再转为String[]
				//String listToString = ListAndStringUtils.ListToString(stringToList);
				//System.out.println(listToString);
				//String[] content = ListAndStringUtils.ListToString2(stringToList);
				//csvWriter.writeRecord(content);
				
				// 读这行的某一列s
				//String value = csvReader.get("src.p13");
			}
			csvReader.close(); 
			
			//写入csv
			for (int i = 0; i < csvList.size(); i++) {
				String[] content =ListAndStringUtils.listToStringArray(ListAndStringUtils.stringToList(csvList.get(i)));
				csvWriter.writeRecord(content);
			}
			csvWriter.close();  
	        System.out.println("--------CSV文件已经写入--------");  
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
}