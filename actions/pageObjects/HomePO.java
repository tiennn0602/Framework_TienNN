package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
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
		waitToElementVisible(HomePageUI.HEADER_LOGOUT_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGOUT_LINK);
	}
	
	public boolean isRegisterLinkUndisplayed() {
		waitToElementInvisible(HomePageUI.HEADER_REGISTER_LINK);
		return isElementDisplayed(HomePageUI.HEADER_REGISTER_LINK);
	}

	public boolean isLoginLinkUndisplayed() {
		waitToElementInvisible(HomePageUI.HEADER_LOGIN_LINK);
		return isElementDisplayed(HomePageUI.HEADER_LOGIN_LINK);
	}
	
}
