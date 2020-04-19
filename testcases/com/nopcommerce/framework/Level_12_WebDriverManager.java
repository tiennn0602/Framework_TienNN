package com.nopcommerce.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;

public class Level_12_WebDriverManager extends AbstractTest {

	private WebDriver driver;
	Select select;
	String email, password;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;

	@Parameters({"browser","version"})
	@BeforeClass
	public void beforeClass(String browserName, String driverVersion) {
		System.out.println("Browser name = " + browserName + " and driver version = " + driverVersion);
		driver = getBrowserDriver(browserName, driverVersion);
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		password = "Automation";
		homePage = PageGeneratorManager.getHomePage(driver);
	//	Assert.assertTrue(false);
	}

	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Open URL");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("Register - Step 02: Click the Register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 03: Verify the Register page is displayed");
		verifyFalse(registerPage.isRegisterPageDisplayed());

		log.info("Register - Step 04: Input data for all required fields");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox("Nguyen");
		registerPage.inputToLastnameTextbox("Tien");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);
		registerPage.clickRegisterButton();

		log.info("Register - Step 05: Verify a successful message displayed");
		verifyFalse(registerPage.isSuccessfulMessageDisplayed());

		log.info("Register - Step 06: Verify a successful registration text displayed");
		verifyEquals(registerPage.getSucessfulRegistrationText(), "Your registration completed");

		log.info("Register - Step 07: Click Logout Link -> navigate to Home Page");
		homePage = registerPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: Click the Login link");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Verify the Login page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());

		log.info("Login - Step 03: Input email and password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		log.info("Login - Step 04: Click the Login button");
		homePage = loginPage.clickLoginButton();

		log.info("Login - Step 05: Verify 'My Account' and 'Logout' link are displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 06: Verify 'Register' and 'Login' link are un-displayed");
		verifyFalse(homePage.isRegisterLinkUndisplayed());
		verifyFalse(homePage.isLoginLinkUndisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver(driver);
	}
}
