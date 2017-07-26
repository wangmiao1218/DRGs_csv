package com.gennlife.drgs.csv.test;

import org.junit.Test;
import com.gennlife.drgs.csv.DRGsCsvAddQuotationMarks;

public class TestDRGsCsvAddQuotationMarks {

	//private static String readFilePath = "F:\\DRGs\\newadd";
	//private static String writeFilePath = "F:\\DRGs\\test\\";
	
	private static String readFilePath = "E:\\武汉DRGS\\数据\\DRGsData_0722_w_wzx";
	private static String writeFilePath = "E:\\武汉DRGS\\数据\\DRGsData_0722_w_wzx_add\\";

	@Test
	public void drgsCsvAddQuotationMarksByFilePath() {
		DRGsCsvAddQuotationMarks.drgsCsvAddQuotationMarksByFilePath(readFilePath, writeFilePath);
		System.out.println("OK");
	}

	
}