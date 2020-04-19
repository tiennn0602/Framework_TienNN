package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePO;
import pageObjects.RegisterPO;

public class Common_01_RegisterToSystem extends AbstractTest {

	private WebDriver driver;
	Select select;
	public static String EMAIL, PASSWORD;
	//Khi dung static, bien nay se duoc luu lai de cho class khac su dung
	private HomePO homePage;
	private RegisterPO registerPage;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		EMAIL = "tien_nguyen" + randomNumber() + "@gmail.com";
		PASSWORD = "Automation";
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("PreCondition - Step 01: Open URL");
		homePage = PageGeneratorManager.getHomePage(driver);

		log.info("PreCondition - Step 02: Click the Register link");
		registerPage = homePage.openRegisterPage();

		log.info("PreCondition - Step 03: Verify the Register page is displayed");
		verifyFalse(registerPage.isRegisterPageDisplayed());

		log.info("PreCondition - Step 04: Input data for all required fields");
		registerPage.clickToMaleRadioButton();
		registerPage.inputToFirstnameTextbox("Nguyen");
		registerPage.inputToLastnameTextbox("Tien");
		registerPage.inputToEmailTextbox(EMAIL);
		registerPage.inputToPasswordTextbox(PASSWORD);
		registerPage.inputToConfirmPasswordTextbox(PASSWORD);
		registerPage.clickRegisterButton();

		log.info("PreCondition - Step 05: Verify a successful message displayed");
		verifyFalse(registerPage.isSuccessfulMessageDisplayed());

		log.info("PreCondition - Step 06: Verify a successful registration text displayed");
		verifyEquals(registerPage.getSucessfulRegistrationText(), "Your registration completed");

		driver.quit();
	}
}
