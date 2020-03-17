package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.HeaderMyAccountPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;
import pageObjects.ShippingAndReturnPO;
import pageObjects.SitemapPO;
import pageUIs.HomePageUI;

public class Level_08_WebDriverLifeCycle_ActionChain extends AbstractTest {

	private WebDriver driver;
	Select select;
	String email;
	private DriverManager driverManager;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	private HeaderMyAccountPO headerMyAccountPage; 
	private SitemapPO siteMapPage;
	private ShippingAndReturnPO shippingAndReturnPage;
	
	@Parameters("browser") //apply for before class
	@BeforeClass
 	public void beforeClass(String browserName) {
		System.out.println("Browser Name = " + browserName);
		
		//Get ra browser service
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		
		//Init browser driver
		driver = driverManager.getDriver();
		
		//driver =  getBrowserDriver(browserName);
		
		System.out.println("Driver at Class Test = " + driver.toString());
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	//@Parameters("browser")
	@Test
	public void TC_01_Register() {
		//TDD: Test Driven Development
		System.out.println("Open URL - Navigate to Home Page");
		//homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);
		
		System.out.println("Home Page - Click the Register link");
		registerPage = homePage.clickToRegisterLink();
		//registerPage = new RegisterPageObject(driver);
		//moved to HomPageObject
		
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
		homePage = registerPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click the Login link");
		loginPage = homePage.clickToLoginLink();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		System.out.println("Home Page - Click the Login button -> Navigate to HomePage");
		homePage = loginPage.clickLoginButton();

		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplayed());
	}
	
	@Test
	public void TC_03_ActionChain() {
		//HomePage -> Header My Account (Customer Info)
		headerMyAccountPage = homePage.openHeaderMyAccountPage(driver);
		
		// Header My Account (Customer Info) -> Footer (Sitemap)
		siteMapPage = headerMyAccountPage.openSiteMapPage(driver);
		
		// Footer (Sitemap) -> Shipping & Returns
		shippingAndReturnPage = siteMapPage.openShippingAndReturnPage(driver);
		// Shipping & Returns -> Footer My Account 
		
		// Footer My Account (Customer Info) -> Search
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
