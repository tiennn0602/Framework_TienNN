package driverFactoryPattern;

import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
//		FirefoxProfile profile = new FirefoxProfile();
//		DesiredCapabilities capability = DesiredCapabilities.firefox();
//		profile.setAcceptUntrustedCertificates(false);
//		profile.setAssumeUntrustedCertificateIssuer(true);
//		profile.setPreference("dom.webnotifications.enabled", false);
//		profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//		profile.setPreference("browser.download.dir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.downloadDir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.download.defaultDir", rootFolder + "\\downloadFiles");
//		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/anytext, text/plain, text/html, application/plain");
//		capability = DesiredCapabilities.firefox();
//		capability.setCapability(FirefoxDriver.PROFILE, profile);
//		driver = new FirefoxDriver(capability);	
		
		String rootFolder = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", rootFolder + "\\resources\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, rootFolder + "\\Firefoxlogs.txt");
		driver = new FirefoxDriver();
	}
}
