package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPageObject;

public class Level_02_AbstractPage_02_Extends extends AbstractPageObject {

	WebDriver driver;
	Select select;
	String email;
	//AbstractPage abstractPage;
	public Level_02_AbstractPage_02_Extends(WebDriver driverLocal) {
		super(driverLocal);
	}

	@BeforeClass
	public void beforeClass() {
		// set for the new Firefox version
		// System.setProperty("webdriver.gecko.driver",".\\resources\\geckodriver.exe");
		String rootFolder = System.getProperty("user.dir");
		// D:\Automation\03_Java_PageObject
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		// Disable logs
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
		driver = new FirefoxDriver();
		//driver = ID
		System.out.println("Driver ID = " + driver.toString());
		
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		// click to Register page
		//driver.findElement(By.xpath("//a[@class='ico-register' and text()='Register']")).click();
		clickToElement("//a[@class='ico-register' and text()='Register']");
		
		// Verify Register Page displayed
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@class='page
		// registration-page")).isDisplayed());
		//assertTrue(driver.findElement(By.xpath("//div[@class='page registration-page']")).isDisplayed());
		assertTrue(isElementDisplayed("//div[@class='page registration-page']"));

		// Click to Gender radio button
		//driver.findElement(By.xpath("//input[@id='gender-female']")).click();
		clickToElement("//input[@id='gender-male']");
		
		// Enter First Name
		//driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("John");
		sendKeytoElement("//input[@id='FirstName']", "Nguyen");

		// Enter Last Name
		//driver.findElement(By.xpath("//input[@id='LastName']")).sendKeys("Wick");
		sendKeytoElement("//input[@id='LastName']", "Tien");
		
		// Select DOB dropdown
		//select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthDay']")));
		//select.selectByVisibleText("10");
		selectItemInDropdown("//select[@name='DateOfBirthDay']", "6");

		//select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']")));
		//select.selectByVisibleText("October");
		selectItemInDropdown("//select[@name='DateOfBirthMonth']", "February");

		//select = new Select(driver.findElement(By.xpath("//select[@name='DateOfBirthYear']")));
		//select.selectByVisibleText("2000");
		selectItemInDropdown("//select[@name='DateOfBirthYear']", "1990");
		
		// Enter email
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		sendKeytoElement("//input[@id='Email']", email);

		// Enter Company Name
		//driver.findElement(By.xpath("//input[@id='Company']")).sendKeys("Augen");
		sendKeytoElement("//input[@id='Company']", "Augen");

		// Enter Password and Confirm Password
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		//driver.findElement(By.xpath("//input[@id='ConfirmPassword']")).sendKeys("123456");
		sendKeytoElement("//input[@id='Password']", "123456");
		sendKeytoElement("//input[@id='ConfirmPassword']", "123456");
		

		// Click Register
		//driver.findElement(By.xpath("//input[@id='register-button']")).click();
		clickToElement("//input[@id='register-button']");
		
		// Verify Register successfully
		//assertTrue(driver.findElement(By.xpath("//div[@class='result'and text() = 'Your registration completed']")).isDisplayed());
		assertTrue (isElementDisplayed("//div[@class='result'and text() = 'Your registration completed']"));
		
		// Click to Logout page
		//driver.findElement(By.xpath("//a[@class='ico-logout' and text() = 'Log out']")).click();
		clickToElement("//a[@class='ico-logout' and text() = 'Log out']");
		
		// Verify navigate to Home page successfully
		// Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
		//assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
		assertEquals(getPageCurrentUrl(),"https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_02_Login() {
		//driver.findElement(By.xpath("//a[@class='ico-login' and text()='Log in']")).click();
		clickToElement("//a[@class='ico-login' and text()='Log in']");
		
		// Verify Login page displayed
		//assertTrue(driver.findElement(By.xpath("//div[@class='page login-page']")).isDisplayed());
		assertTrue (isElementDisplayed("//div[@class='page login-page']"));
		
		// Enter email
		//driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		sendKeytoElement("//input[@id='Email']", email);
		
		// Enter Password
		//driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("123456");
		sendKeytoElement("//input[@id='Password']", "123456");
		
		// Click Login button
		//driver.findElement(By.cssSelector(".login-button")).click();
		clickToElement("//input[@class='button-1 login-button']");
		
		// Verify My Account link displayed
		//assertTrue(driver.findElement(By.xpath("//a[@class='ico-account' and text() = 'My account']")).isDisplayed());
		assertTrue (isElementDisplayed("//a[@class='ico-account' and text() = 'My account']"));
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
