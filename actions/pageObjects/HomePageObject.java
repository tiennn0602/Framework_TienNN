package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import pageUIs.HomePageUI;

public class HomePageObject extends AbstractPageObject {

	public HomePageObject(WebDriver driverLocal) {
		super(driverLocal);
	}

	public void clickToRegisterLink() {
		waitToElementVisible(HomePageUI.REGISTER_LINK);
		clickToElement(HomePageUI.REGISTER_LINK);
	}

	public void clickToLoginLink() {
		waitToElementVisible(HomePageUI.LOGIN_LINK);
		clickToElement(HomePageUI.LOGIN_LINK);
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
