package com.nopcommerce.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;

public class Level_13_Dynamic_Page_Element extends AbstractTest {

	private WebDriver driver;
	Select select;
	String email, password;
	private HomePO homePage;
	private RegisterPO registerPage;
	private LoginPO loginPage;

	@Parameters("browser") // apply for before class
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name = " + browserName);
		driver = getBrowserDriver(browserName);
		email = "tien_nguyen" + randomNumber() + "@gmail.com";
		password = "Automation";
		log.info("Precondition - Step 01: Open HomePage");
		homePage = PageGeneratorManager.getHomePage(driver);
	}

	@Test
	public void TC_01_Validate_Register_Form() {
		log.info("Validation - Step 01: Click the Register link");
		registerPage = homePage.openRegisterPage();
		
		log.info("Validation - Step 02: Click the Register Button");
		registerPage.clickToDynamicButton("Register");
		
		log.info("Validation - Step 03: Verify Error Messages displayed For Required Fields");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("FirstName"), "First name is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("LastName"), "Last name is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("Email"), "Email is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("Password"), "Password is required.");
		verifyEquals(registerPage.getDynamicRequiredFieldErrorMessage("ConfirmPassword"), "Password is required.");
	}
	
	@Test
	public void TC_02_Register() {
		log.info("Register - Step 01: Click the Register link");
		registerPage = homePage.openRegisterPage();

		log.info("Register - Step 02: Verify the Register page is displayed");
		verifyTrue(registerPage.isRegisterPageDisplayed());

		log.info("Register - Step 03: Input data for all required fields");

		registerPage.clickToDynamicRadioButton("gender-male");
		registerPage.inputToDynamicTextbox("FirstName", "Nguyen");
		registerPage.inputToDynamicTextbox("LastName", "Tien");
		registerPage.inputToDynamicTextbox("Email", email);
		registerPage.inputToDynamicTextbox("Company", "Aug");
		registerPage.inputToDynamicTextbox("Password", password);
		registerPage.inputToDynamicTextbox("ConfirmPassword", password);
		registerPage.clickToDynamicButton("Register");

		log.info("Register - Step 04: Verify a successful message displayed");
		verifyTrue(registerPage.isSuccessfulMessageDisplayed());

		log.info("Register - Step 05: Verify a successful registration text displayed");
		verifyEquals(registerPage.getSucessfulRegistrationText(), "Your registration completed");

		log.info("Register - Step 06: Click Logout Link -> navigate to Home Page");
		homePage = registerPage.clickLogoutLink();
	}

	@Test
	public void TC_03_Login() {
		log.info("Login - Step 01: Click the Login link");
		loginPage = homePage.openLoginPage();

		log.info("Login - Step 02: Verify the Login page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());

		log.info("Login - Step 03: Input email and password");
		loginPage.inputToDynamicTextbox("Email", email);
		loginPage.inputToDynamicTextbox("Password", password);
		
		log.info("Login - Step 04: Click the Login button");
		loginPage.clickToDynamicButton("Log in");
		homePage = PageGeneratorManager.getHomePage(driver);

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
