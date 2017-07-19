package com.gennlife.drgs.csv.test;

import java.util.List;

import org.junit.Test;

import com.gennlife.drgs.csv.DRGs_csv;

public class TestDRGs_csv {
	
	private static String readFilePath = "F:\\newadd\\990004_武汉市普爱医院.csv";
	private static String writeFilePath="F:\\newadd\\1.csv";

	
	@Test
	public void readAndWriteCsv() {
		DRGs_csv.readAndWriteCsv(readFilePath, writeFilePath);
	}

	@Test
	public void readCsv() {
		List<String> list = DRGs_csv.readCsv(readFilePath);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void write() {
		
	}
	
}