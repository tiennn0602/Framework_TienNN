package com.nopcommerce.payment;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_01_Step_By_Step {

	WebDriver driver;
	Select select;
	String email;
	
  @BeforeClass
  public void beforeClass() {
	  driver = new FirefoxDriver();
	  email = "john_wick_" + randomNumber() + "@gmail.com";
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }
	
  @Test
  public void TC_01_Register() {
	  //click to Register page
	  driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();
	  
	  //Verify Register Page displayed
	  // Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page")).isDisplayed());
	  assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());
	  
	  //Click to Gender radio button
	  driver.findElement(By.xpath("//input[@id='gender-female']")).click();
	  
	  //Enter First Name
	  driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
	  
	  //Enter Last Name
	  driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
	  
	  //Select DOB dropdown
	  select = new Select (driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
	  select.selectByVisibleText("10");
	  
	  select = new Select (driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
	  select.selectByVisibleText("October");
	  
	  select = new Select (driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
	  select.selectByVisibleText("2000");
	  
	  //Enter email
	  
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  
	  //Enter Company Name
	  driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Augen");
	  
	  //Enter Password and Confirm Password
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	  driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
	  
	  //Click Register
	  driver.findElement(By.xpath("//input[@id='register-button']")).click();
	  
	  //Verify Register successfully
	  assertTrue(driver.findElement(By.xpath("//div[@class='result'and text() = 'Your registration completed']")).isDisplayed());
	  
	  //Click to Logout page
	  driver.findElement(By.xpath("//a[@class='ico-logout' and text() = 'Log out']")).click();
	  
	  //Verify navigate to Home page successfully
	  //Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
	  assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
  }
 
  @Test
  public void TC_02_Login() {
	  driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();
	  //Verify Login page displayed
	  assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());
	  
	  //Enter email
	  driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
	  
	  //Enter Password
	  driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
	  
	  //Click Login button
	  driver.findElement(By.cssSelector(".login-button")).click();
	  
	  //Verify My Account link displayed
	  assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text() = 'My account']")).isDisplayed());
	  	  
  }
 
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  public int randomNumber() {
	  Random random = new Random();
	  return random.nextInt(999999);
  }
}
