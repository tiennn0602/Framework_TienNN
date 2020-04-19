package com.nopcommerce.search;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class Annotations {
  @Test
  public void TC_01() {
	  System.out.println("Run test 01");
  }
  
  @Test
  public void TC_02() {
	  System.out.println("Run test 02");
  }
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Run beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Run afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Run beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Run afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Run beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Run afterSuite");
  }

}
