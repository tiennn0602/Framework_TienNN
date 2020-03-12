package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPageObject {

	WebDriver driverGlobal;
	public HomePageObject(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

	public RegisterPageObject clickToRegisterLink() {
		waitToElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driverGlobal);
	}

	public LoginPageObject clickToLoginLink() {
		waitToElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driverGlobal);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
	}

}
