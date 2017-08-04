package com.gennlife.drgs.csv.test;

import org.junit.Test;
import com.gennlife.drgs.csv.DRGsCsvAddQuotationMarks;

public class TestDRGsCsvAddQuotationMarks {

	//private static String readFilePath = "F:\\DRGs\\newadd";
	//private static String writeFilePath = "F:\\DRGs\\test\\";
	
	private static String readFilePath = "E:\\安贞\\！安贞数据导出\\1";
	private static String writeFilePath = "E:\\安贞\\！安贞数据导出\\1\\";

	@Test
	public void drgsCsvAddQuotationMarksByFilePath() {
		DRGsCsvAddQuotationMarks.drgsCsvAddQuotationMarksByFilePath(readFilePath, writeFilePath);
		System.out.println("OK");
	}

	
}