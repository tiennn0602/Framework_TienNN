package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.HeaderMyAccountPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;

public class PageGeneratorManager {

	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}
	
	public static HeaderMyAccountPO getHeaderMyAccountPage(WebDriver driver) {
		return new HeaderMyAccountPO(driver);
	}
}
