package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;

public class LoginPO extends AbstractPageObject {

	WebDriver driver;
	public LoginPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String string) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(LoginPageUI.PASSWORD_TEXTBOX, "123456");
	}

	public HomePO clickLoginButton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
		
	}

	public boolean isErrorMessageDisplayed() {
		waitToElementVisible(LoginPageUI.EMPTY_EMAIL_ERROR);
		return isElementDisplayed(LoginPageUI.EMPTY_EMAIL_ERROR);
	}

	public boolean isErrorPasswordDisplayed() {
		waitToElementVisible(LoginPageUI.PASSWORD_ERROR);
		return isElementDisplayed(LoginPageUI.PASSWORD_ERROR);
	}

	public boolean isWrongEmailMessageDisplayed() {
		waitToElementVisible(LoginPageUI.WRONG_EMAIL_FORMAT);
		return isElementDisplayed(LoginPageUI.WRONG_EMAIL_FORMAT);
	}

}
