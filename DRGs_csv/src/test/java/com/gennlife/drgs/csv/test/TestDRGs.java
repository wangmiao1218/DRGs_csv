package com.gennlife.drgs.csv.test;

import org.junit.Test;
import com.gennlife.drgs.csv.DRGs;

public class TestDRGs {

	private static String filePath = "F:\\DRGs\\newadd";

	@Test
	public void testDrgs() {
		DRGs.drgs(filePath);
		System.out.println("OK");
	}

}