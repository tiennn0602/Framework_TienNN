package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.LoginPageUI;
import pageUIs.RegisterPageUI;

public class RegisterPO extends AbstractPageObject{
	
	WebDriver driver;
	public RegisterPO(WebDriver driverLocal) {
		super(driverLocal);
		driver = driverLocal;
	}

	public void clickToMaleRadioButton() {
		waitToElementVisible(RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(RegisterPageUI.GENDER_MALE_RADIO);	
	}

	public void inputToFirstnameTextbox(String firstNameValue) {
		waitToElementVisible(RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendKeytoElement(RegisterPageUI.FIRST_NAME_TEXTBOX, firstNameValue);
	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(RegisterPageUI.LAST_NAME_TEXTBOX);
		sendKeytoElement(RegisterPageUI.LAST_NAME_TEXTBOX, lastNameValue);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(RegisterPageUI.EMAIL_TEXTBOX);
		sendKeytoElement(RegisterPageUI.EMAIL_TEXTBOX, email);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeytoElement(RegisterPageUI.PASSWORD_TEXTBOX, passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementVisible(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeytoElement(RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPasswordValue);
		
	}

	public void clickRegisterButton() {
		waitToElementVisible(RegisterPageUI.REGISTER_BUTTON);
		clickToElement(RegisterPageUI.REGISTER_BUTTON);	
	}

	public boolean isSuccessfulMessageDisplayed() {
		waitToElementVisible(RegisterPageUI.SUCCESSFUL_REGISTER_MESSAGE);
		return isElementDisplayed(RegisterPageUI.SUCCESSFUL_REGISTER_MESSAGE);
	}

	public String getSucessfulRegistrationText() {
		waitToElementVisible(RegisterPageUI.SUCCESSFUL_REGISTER_TEXT);
		return getTextElement(RegisterPageUI.SUCCESSFUL_REGISTER_TEXT);
	}
	
	public HomePO clickLogoutLink() {
		waitToElementVisible(RegisterPageUI.LOGOUT_LINK);
		clickToElement(RegisterPageUI.LOGOUT_LINK);	
	//	return new HomePageObject(driver);
		return PageGeneratorManager.getHomePage(driver);
	}

	public boolean isRegisterPageDisplayed() {
		waitToElementVisible(RegisterPageUI.REGISTER_FORM);
		return isElementDisplayed(RegisterPageUI.REGISTER_FORM);
	}
}
