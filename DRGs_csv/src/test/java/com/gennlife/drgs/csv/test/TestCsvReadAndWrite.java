package com.gennlife.drgs.csv.test;

import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.csv.CsvReadAndWrite;

public class TestCsvReadAndWrite {
	
	private static String readFilePath = "F:\\DRGs\\newadd\\990063_武汉市江岸区中西医结合医院.csv";
	private static String writeFilePath="F:\\DRGs\\newadd\\1.csv";

	
	@Test
	public void readAndWriteCsv() {
		CsvReadAndWrite.readAndWriteCsv(readFilePath, writeFilePath);
	}

	@Test
	public void readCsvOfLine() {
		List<String> list =CsvReadAndWrite.readCsvOfLine(readFilePath);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	@Test
	public void readCsv() {
		List<String> list = CsvReadAndWrite.readCsv(readFilePath);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void write() {
		
	}
	
}