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

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {
	// private, public, protected, default
	// Neu khong set gi, mac dinh se la default, va class dang ke thua
	// (AbstractTest) o khac package se khong nhin thay duoc bien nay.
	// search access level for more details
	private WebDriver driver;
	String rootFolder = System.getProperty("user.dir");

	// Init log
	protected final Log log;

	// Contractor
	protected AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	protected WebDriver getBrowserDriver(String browserName) {
		if (browserName.equalsIgnoreCase("firefox_ui")) {
			// System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			//System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("chrome_ui")) {
			//System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			//System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			//WebDriverManager.chromedriver().version("76.0.3809.25").setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Please input your browser");
		}
		System.out.println("Driver at AbstractTest = " + driver.toString());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		return driver;
	}
	
	protected WebDriver getBrowserDriver(String browserName, String driverVersion) {
		if (browserName.equalsIgnoreCase("firefox_ui")) {
			// System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().version(driverVersion).setup();
			System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
			System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("firefox_headless")) {
			//System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
			WebDriverManager.firefoxdriver().version(driverVersion).setup();
			FirefoxOptions options = new FirefoxOptions();
			options.setHeadless(true);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("chrome_ui")) {
			//System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().version(driverVersion).setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("chrome_headless")) {
			//System.setProperty("webdriver.chrome.driver", rootFolder + "\\resources\\chromedriver.exe");
			WebDriverManager.chromedriver().version(driverVersion).setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(true);
			driver = new ChromeDriver(options);
		} else {
			System.out.println("Please input your browser");
		}
		System.out.println("Driver at AbstractTest = " + driver.toString());
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

	protected void closeBrowserAndDriver(WebDriver driver) {
		try {
			// get ra tên của OS và convert qua chữ thường
			String osName = System.getProperty("os.name").toLowerCase();
			log.info("OS name = " + osName);

			// Khai báo 1 biến command line để thực thi
			String cmd = "";
			if (driver != null) {
				driver.quit();
			}

			if (driver.toString().toLowerCase().contains("chrome")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill chromedriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
				}
			} else if (driver.toString().toLowerCase().contains("internetexplorer")) {
				if (osName.toLowerCase().contains("window")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
				}
			} else if (driver.toString().toLowerCase().contains("firefox")) {
				if (osName.toLowerCase().contains("mac")) {
					cmd = "pkill geckodriver";
				} else if (osName.toLowerCase().contains("windows")) {
					cmd = "taskkill /F /FI \"IMAGENAME eq geckodriver*\"";
				}
			}

			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();

			log.info("---------- QUIT BROWSER SUCCESSFULLY ----------");
		} catch (Exception e) {
			log.info(e.getMessage());
		}
	}
}
