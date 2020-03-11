package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class LoginPageObject extends AbstractPage {

	public LoginPageObject(WebDriver driverLocal) {
		super(driverLocal);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(LoginPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(LoginPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String string) {
		waitToElementVisible(LoginPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(LoginPageUI.PASSWORD_TEXTBOX, "123456");
	}

	public void clickLoginButton() {
		waitToElementVisible(LoginPageUI.LOGIN_BUTTON);
		clickToElement(LoginPageUI.LOGIN_BUTTON);
		
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
