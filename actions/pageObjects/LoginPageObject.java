package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.LoginPageUI;

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

}
