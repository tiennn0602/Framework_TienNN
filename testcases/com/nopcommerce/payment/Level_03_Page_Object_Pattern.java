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

import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;
import pageUIs.HomePageUI;

public class Level_03_Page_Object_Pattern {

	WebDriver driver;
	Select select;
	String email;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	
	@BeforeClass
 	public void beforeClass() {

		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
		driver = new FirefoxDriver();
		System.out.println("Driver ID = " + driver.toString());
		
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Register() {
		//TDD: Test Driven Development
		System.out.println("Open URL - Navigate to Home Page");
		homePage = new HomePO(driver);
		System.out.println("Home Page - Click the Register link");
		homePage.openRegisterPage();
		registerPage = new RegisterPO(driver);
		
		System.out.println("Register Page - Click on the Gender radio button");
		registerPage.clickToMaleRadioButton();
		
		System.out.println("Register Page - Input First Name");
		registerPage.inputToFirstnameTextbox("Nguyen");
		
		System.out.println("Register Page - Input Last Name");
		registerPage.inputToLastnameTextbox("Tien");
		
		System.out.println("Register Page - Input Email");
		registerPage.inputToEmailTextbox(email);
		
		System.out.println("Register Page - Input Password");
		registerPage.inputToPasswordTextbox("123456");
		
		System.out.println("Register Page - Input Confirm Password");
		registerPage.inputToConfirmPasswordTextbox("123456");
		
		System.out.println("Register Page - Click Register button");
		registerPage.clickRegisterButton();
		
		System.out.println("Register Page - Verify a successful message displayed");
		assertTrue(registerPage.isSuccessfulMessageDisplayed());
		
		System.out.println("Register Page - Verify a successful registration text displayed");
		assertEquals(registerPage.getSucessfulRegistrationText(),"Your registration completed");
		
		System.out.println("Register Page - Click Logout Link -> navigate to Home Page");
		registerPage.clickLogoutLink();
		homePage = new HomePO(driver);
	}

	@Test
	public void TC_02_LoginWithEmailAndPasswordEmpty() {
		System.out.println("Home Page - Click the Login link");
		homePage.openLoginPage();
		loginPage = new LoginPO(driver);
		
		System.out.println("Register Page - Leave Email empty");
		loginPage.inputToEmailTextbox("");
		
		System.out.println("Register Page - Leave Password empty");
		loginPage.inputToPasswordTextbox("");
		
		System.out.println("Home Page - Click the Login button");
		loginPage.clickLoginButton();

		assertTrue(loginPage.isErrorMessageDisplayed());

	}
	
	@Test
	public void TC_03_LoginWithEmailEmpty() {
		System.out.println("Register Page - Leave Email empty and Password Entered");
		loginPage.inputToEmailTextbox("");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		assertTrue(loginPage.isErrorMessageDisplayed());

	}
	
	@Test
	public void TC_04_LoginWithWrongEmailFormat() {
		System.out.println("Register Page - Enter a wrong email format");
		loginPage.inputToEmailTextbox("abc");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		assertTrue(loginPage.isWrongEmailMessageDisplayed());
	}
	
	
//	public void TC_05_LoginWithPasswordEmpty() {
//		System.out.println("Register Page - Enter Email and Password empty");
//		loginPage.inputToEmailTextbox(email);
//		loginPage.inputToPasswordTextbox("");
//		loginPage.clickLoginButton();
//		assertTrue(loginPage.isErrorPasswordDisplayed());
//	}
	
	@Test
	public void TC_05_LoginWithValidEmailAndPassword() {
		System.out.println("Register Page - Enter An Valid Email and Password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickLoginButton();
		homePage = new HomePO(driver);
		assertTrue(homePage.isElementDisplayed(HomePageUI.HEADER_MY_ACCOUNT_LINK));
		assertTrue(homePage.isElementDisplayed(HomePageUI.HEADER_LOGOUT_LINK));
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