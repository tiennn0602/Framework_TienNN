package com.nopcommerce.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_RegisterToSystem;

import commons.AbstractTest;
import commons.PageGeneratorManager;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;

public class Search_01 extends AbstractTest {

	private WebDriver driver;
	Select select;
	private HomePO homePage;
	private LoginPO loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getHomePage(driver);

		//Login
		log.info("PreCondition - Step 01: Click the Login link");
		loginPage = homePage.openLoginPage();

		log.info("PreCondition - Step 02: Verify the Login page is displayed");
		verifyTrue(loginPage.isLoginPageDisplayed());

		log.info("PreCondition - Step 03: Input email and password");
		loginPage.inputToEmailTextbox(Common_01_RegisterToSystem.EMAIL);
		loginPage.inputToPasswordTextbox(Common_01_RegisterToSystem.PASSWORD);
		log.info("PreCondition - Step 04: Click the Login button");
		homePage = loginPage.clickLoginButton();

		log.info("PreCondition - Step 05: Verify 'My Account' and 'Logout' link are displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("PreCondition - Step 06: Verify 'Register' and 'Login' link are un-displayed");
		verifyFalse(homePage.isRegisterLinkUndisplayed());
		verifyFalse(homePage.isLoginLinkUndisplayed());
		
	}

	@Test
	public void TC_01_SearchWithName() {
		System.out.println("TC_01_SearchWithName");
	}

	@Test
	public void TC_02_SearchWithCategory() {
		System.out.println("TC_02_SearchWithCategory");
	}

	@Test
	public void TC_03_SearchWithManufacturer() {
		System.out.println("TC_03_SearchWithManufacturer");
	}
	
	@AfterClass

	public void afterClass() {
		driver.quit();
	}
}
