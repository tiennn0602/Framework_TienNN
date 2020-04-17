package com.nopcommerce.framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import driverFactoryPattern.DriverManagerFactory;
import pageObjects.FooterMyAccountPO;
import pageObjects.HeaderMyAccountPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;
import pageObjects.SearchPO;
import pageObjects.ShippingAndReturnPO;
import pageObjects.ShoppingCartPO;
import pageObjects.SitemapPO;

public class Level_09_DynamicLocator_Rest_Parameters extends AbstractTest {

	private WebDriver driver;
	Select select;
	String email;
	private DriverManager driverManager;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;
	private HeaderMyAccountPO headerMyAccountPage;
	private ShoppingCartPO shoppingCartPage;
	private FooterMyAccountPO footerMyAccountPage;
	private SitemapPO siteMapPage;
	private ShippingAndReturnPO shippingAndReturnPage;
	private SearchPO searchPage;

	@Parameters("browser") // apply for before class
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name = " + browserName);

		// Get ra browser service
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);

		// Init browser driver
		driver = driverManager.getDriver();

		// driver = getBrowserDriver(browserName);

		System.out.println("Driver at Class Test = " + driver.toString());
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	// @Parameters("browser")
	@Test
	public void TC_01_Register() {
		// TDD: Test Driven Development
		System.out.println("Open URL - Navigate to Home Page");
		// homePage = new HomePageObject(driver);
		homePage = PageGeneratorManager.getHomePage(driver);

		System.out.println("Home Page - Click the Register link");
		registerPage = homePage.openRegisterPage();
		// registerPage = new RegisterPageObject(driver);
		// moved to HomPageObject

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
		assertEquals(registerPage.getSucessfulRegistrationText(), "Your registration completed");

		System.out.println("Register Page - Click Logout Link -> navigate to Home Page");
		homePage = registerPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		System.out.println("Home Page - Click the Login link");
		loginPage = homePage.openLoginPage();
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox("");
		System.out.println("Home Page - Click the Login button -> Navigate to HomePage");
		homePage = loginPage.clickLoginButton();

		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_Dynamic_Locator_LessPages() throws Exception {
		// HomePage -> Footer My Account (Customer Info)
		footerMyAccountPage = (FooterMyAccountPO) homePage.openMultiplePage("My account");
		Thread.sleep(2000);

		// Footer My Account (Customer Info) -> Footer (Sitemap)
		siteMapPage = (SitemapPO) footerMyAccountPage.openMultiplePage("Sitemap");
		Thread.sleep(2000);

		// Footer (Site map) -> Shipping & Returns
		shippingAndReturnPage = (ShippingAndReturnPO) siteMapPage.openMultiplePage("Shipping & returns");
		Thread.sleep(2000);

		// Shipping & Returns -> Search
		searchPage = (SearchPO) shippingAndReturnPage.openMultiplePage("Search");
		Thread.sleep(2000);

		// Search -> Shopping Cart
		shoppingCartPage = (ShoppingCartPO) searchPage.openMultiplePage("Shopping cart");
		Thread.sleep(2000);
	}

	@Test
	public void TC_04_Dynamic_Locator_ManyPages() throws Exception {
		// Shopping Cart -> Footer My Account (Customer Info)
		shoppingCartPage.openMultiplePages("My account");
		//Tính đóng gói (Encapsolution) - Che giấu sự khởi tạo
		footerMyAccountPage = PageGeneratorManager.getFooterMyAccountPage(driver);
		
		// Footer My Account (Customer Info) -> Footer (Sitemap)
		footerMyAccountPage.openMultiplePages("Sitemap");
		siteMapPage = PageGeneratorManager.getSiteMapPage(driver);
		
		// Footer (Site map) -> Shipping & Returns
		siteMapPage.openMultiplePages("Shipping & returns");
		shippingAndReturnPage = PageGeneratorManager.getShippingAndReturnPage(driver);
		
		// Shipping & Returns -> Search
		shippingAndReturnPage.openMultiplePages("Search");
		searchPage = PageGeneratorManager.getSearchPage(driver);

		// Search -> Shopping Cart
		searchPage.openMultiplePages("Shopping cart");
		shoppingCartPage = PageGeneratorManager.getShoppingCartPage(driver);
		Thread.sleep(5000);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
