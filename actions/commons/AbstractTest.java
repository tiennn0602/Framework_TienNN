package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	//private, public, protected, default
	//Neu khong set gi, mac dinh se la default, va class dang ke thua (AbstractTest) o khac package se khong nhin thay duoc bien nay.
	// search access level for more details
	private WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	
	// Init log
	protected final Log log;
	
	//Contractor
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox_ui"))	{
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
		driver = new FirefoxDriver();
	} else if (browserName.equalsIgnoreCase("firefox_headless")){
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		driver = new FirefoxDriver(options);
	} else if (browserName.equalsIgnoreCase("chrome_ui")) {
		System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	} else if (browserName.equalsIgnoreCase("chrome_headless")) {
		System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		driver = new ChromeDriver(options);
	} else {
		System.out.println("Please input your browser");
	}
		System.out.println("Driver at AbtractTest = " + driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	protected int randomNumber() {
		Random random = new Random();
		return random.nextInt(999999);
	}
	
	private boolean checkTrue(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;

			// Add lỗi vào Report HTML
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyTrue(boolean condition) {
		return checkTrue(condition);
	}

	private boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == false) {
				log.info(" -------------------------- PASSED -------------------------- ");
			} else {
				log.info(" -------------------------- FAILED -------------------------- ");
			}
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
			log.info(" -------------------------- PASSED -------------------------- ");
		} catch (Throwable e) {
			pass = false;
			log.info(" -------------------------- FAILED -------------------------- ");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	protected boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}
}
