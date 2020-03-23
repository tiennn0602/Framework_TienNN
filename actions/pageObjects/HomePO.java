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

	public boolean isMyAccountLinkDisplayed() {
		waitToElementVisible(HomePageUI.HEADER_MY_ACCOUNT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_MY_ACCOUNT_LINK);
	}

	public boolean isLogoutLinkDisplayed() {
		waitToElementVisible(HomePageUI.LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.LOGOUT_LINK);
	}
}
