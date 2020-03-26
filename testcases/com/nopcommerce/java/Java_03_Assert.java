package com.nopcommerce.java;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Java_03_Assert {

	@BeforeClass
	public void beforeClass() {
	}

	@Test
	public void TC_01() {
		System.out.println("Step 01 - Open X Page");
		
		System.out.println("Step 02 - Verify X page displayed");
		Assert.assertTrue(false);
		
		System.out.println("Step 03 - Verify Y field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 04 - Verify Z field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 05 - Verify V field displayed");
		Assert.assertTrue(true);
	}

	@Test
	public void TC_02() {
		System.out.println("Step 01 - Open X Page");
		
		System.out.println("Step 02 - Verify X page displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 03 - Verify Y field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 04 - Verify Z field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 05 - Verify V field displayed");
		Assert.assertTrue(true);
	}

	@Test
	public void TC_03() {
		System.out.println("Step 01 - Open X Page");
		
		System.out.println("Step 02 - Verify X page displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 03 - Verify Y field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 04 - Verify Z field displayed");
		Assert.assertTrue(true);
		
		System.out.println("Step 05 - Verify V field displayed");
		Assert.assertTrue(true);
	}

	@AfterClass
	public void afterClass() {
	}

}
