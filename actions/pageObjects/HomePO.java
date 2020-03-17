package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HomePageUI;

public class HomePO extends AbstractPageObject {

	WebDriver driverGlobal;
	public HomePO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

	public RegisterPO clickToRegisterLink() {
		waitToElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driverGlobal);
	}

	public LoginPO clickToLoginLink() {
		waitToElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driverGlobal);
	}

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(HomePageUI.HEADER_MY_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
	}

	public HeaderMyAccountPO openHeaderMyAccountPage(WebDriver driver) {
		waitToElementVisible(HomePageUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(HomePageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHeaderMyAccountPage(driver);
	}
}
