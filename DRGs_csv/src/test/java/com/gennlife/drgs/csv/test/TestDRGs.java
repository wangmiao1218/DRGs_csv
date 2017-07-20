package com.gennlife.drgs.csv.test;

import org.junit.Test;
import com.gennlife.drgs.csv.DRGs;

public class TestDRGs {

	private static String readFilePath = "F:\\DRGs\\newadd";
	private static String writeFilePath = "F:\\DRGs\\test\\";

	@Test
	public void testDrgs() {
		DRGs.drgs(readFilePath, writeFilePath);
		System.out.println("OK");
	}

	
}