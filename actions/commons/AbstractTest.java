package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class AbstractTest {
	//private, public, protected, default
	//Neu khong set gi, mac dinh se la default, va class dang ke thua (AbstractTest) o khac package se khong nhin thay duoc bien nay.
	// search access level for more details
	private WebDriver driver;
	String rootFolder = System.getProperty("user.dir");
	public WebDriver getBrowserDriver(String browserName) {
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
		return driver;
	}
}
