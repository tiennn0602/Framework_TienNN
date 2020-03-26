package com.nopcommerce.java;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Java_02_Check_Element_Displayed_Undisplayed {
	WebDriver driver;
	Actions action;
	long longTimeout = 30;
	long shortTimeout = 5;
	@BeforeClass
	public void beforeClass() {
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
	}

	@Test
	public void TC_01_Check_Element_Displayed() throws Exception {
		// =================ELEMENT CÓ TRONG DOM ============================//

		// Step 01 - Check Login page displayed
		boolean loginPageStatus = isElementDisplayed("//a[@class='ico-login']");
		System.out.println("Login Page = " + loginPageStatus);
		Assert.assertTrue(loginPageStatus);

		// Step 02 - Check Mini Cart un-displayed (Leave Mouse)
		boolean miniCartStatusUndisplayed = isElementDisplayed("//div[@class='count']");
		System.out.println("Mini Cart Status = " + miniCartStatusUndisplayed);
		Assert.assertFalse(miniCartStatusUndisplayed);

		// Step 03 - Check Mini Cart displayed (Hover Mouse)
		action.moveToElement(driver.findElement(By.xpath("//a[@class='ico-cart']"))).perform();
		Thread.sleep(2000);
		boolean miniCartStatusDisplayed = isElementDisplayed("//div[@class='count']");
		System.out.println("Mini Cart Status = " + miniCartStatusDisplayed);
		Assert.assertTrue(miniCartStatusDisplayed);

		// =================ELEMENT KHÔNG CÓ TRONG DOM ============================//

		// Step 04 - Check My Account Page Un-displayed
		boolean myAccountPage = isElementDisplayed("//a[@class='ico-account']");
		System.out.println("My Account Page = " + myAccountPage);
		Assert.assertFalse(myAccountPage);

		// Step 05 - Open Login Page - Check Nivo Image Un-displayed
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		boolean nivoImageStatus = isElementDisplayed("//a[@class='nivo-imageLink']");
		System.out.println("Nivo Image Status = " + nivoImageStatus);
		Assert.assertFalse(nivoImageStatus);

	}

	public boolean isElementDisplayed(String locator) {
		driver.manage().timeouts().implicitlyWait(shortTimeout, TimeUnit.SECONDS);
		try {
			WebElement element = driver.findElement(By.xpath(locator));
			// 1 - Element có trong DOM và hiển thị trên UI
			// 2 - Element có trong DOM nhưng không hiển thị trên UI
			driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			// 3 - Element không có trong DOM tại current page
			driver.manage().timeouts().implicitlyWait(longTimeout, TimeUnit.SECONDS);
			return false;
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
