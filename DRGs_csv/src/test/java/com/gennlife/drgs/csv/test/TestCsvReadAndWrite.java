package com.gennlife.drgs.csv.test;

import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.csv.CsvReadAndWrite;

public class TestCsvReadAndWrite {
	
	private static String readFilePathAndFileName = "F:\\DRGs\\newadd\\990063_武汉市江岸区中西医结合医院.csv";
	private static String writeFilePathAndFileName="F:\\DRGs\\newadd\\1.csv";

	
	@Test
	public void readAndWriteCsv() {
		CsvReadAndWrite.readAndWriteCsv(readFilePathAndFileName, writeFilePathAndFileName);
	}

	@Test
	public void readCsvOfLine() {
		List<String> list =CsvReadAndWrite.readCsvOfLine(readFilePathAndFileName);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void readCsv() {
		List<String> list = CsvReadAndWrite.readCsv(readFilePathAndFileName);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void write() {
		
	}
	
}