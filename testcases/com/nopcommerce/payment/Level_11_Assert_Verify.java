package com.nopcommerce.payment;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import driverFactoryPattern.DriverManager;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;

public class Level_11_Assert_Verify extends AbstractTest {

	private WebDriver driver;
	Select select;
	String email, password;
	private DriverManager driverManager;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		password = "123123";
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Register() {
		System.out.println("TC_01_Register - Open URL - Navigate to Home Page");
		homePage = PageGeneratorManager.getHomePage(driver);

		System.out.println("TC_01_Register - Home Page - Click the Register link");
		registerPage = homePage.openRegisterPage();
		
		System.out.println("TC_01_Register - Register Page - Verify the Register page is displayed");
		assertTrue(registerPage.isRegisterPageDisplayed());
		assertFalse(registerPage.isRegisterPageDisplayed());

		System.out.println("TC_01_Register - Register Page - Input data for all required fields");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox("Nguyen");
		registerPage.inputToLastnameTextbox("Tien");
		registerPage.inputToEmailTextbox(email);
		registerPage.inputToPasswordTextbox(password);
		registerPage.inputToConfirmPasswordTextbox(password);

		System.out.println("TC_01_Register - Register Page - Click Register button");
		registerPage.clickRegisterButton();

		System.out.println("TC_01_Register - Register Page - Verify a successful message displayed");
		assertTrue(registerPage.isSuccessfulMessageDisplayed());

		System.out.println("TC_01_Register - Register Page - Verify a successful registration text displayed");
		assertEquals(registerPage.getSucessfulRegistrationText(), "Your registration completed");

		System.out.println("TC_01_Register - Register Page - Click Logout Link -> navigate to Home Page");
		homePage = registerPage.clickLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		System.out.println("TC_02_Login - Home Page - Click the Login link");
		loginPage = homePage.openLoginPage();
		
		System.out.println("TC_02_Login - Login Page - Verify the Login page is displayed");
		assertTrue(loginPage.isLoginPageDisplayed());
		assertFalse(loginPage.isLoginPageDisplayed());
		
		System.out.println("TC_02_Login - Login Page - Input email and password");
		loginPage.inputToEmailTextbox(email);
		loginPage.inputToPasswordTextbox(password);
		
		System.out.println("TC_02_Login - Home Page - Click the Login button -> Navigate to HomePage");
		homePage = loginPage.clickLoginButton();
		
		System.out.println("TC_02_Login - Home Page - Verify 'My Account' and 'Logout' link are displayed");
		assertTrue(homePage.isMyAccountLinkDisplayed());
		assertTrue(homePage.isLogoutLinkDisplayed());
		
		System.out.println("TC_02_Login - Home Page - Verify 'Register' and 'Login' link are un-displayed");
		assertFalse(homePage.isRegisterLinkUndisplayed());
		assertFalse(homePage.isLoginLinkUndisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
