package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;

public class RegisterPageFactory extends AbstractPageFactory {
	
	public RegisterPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, this);
	}

	@FindBy (how = How.ID, using = "gender-male")
	private WebElement genderMaleRadioButton;
	
	@FindBy (how = How.ID, using = "FirstName")
	private WebElement firstNameTextbox;
	
	@FindBy (how = How.ID, using = "LastName")
	private WebElement lastNameTextbox;
	
	@FindBy (how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy (how = How.ID, using = "Password")
	private WebElement passwordTextbox;
	
	@FindBy (how = How.ID, using = "ConfirmPassword")
	private WebElement confirmPasswordTextbox;
	
	@FindBy (how = How.CSS, using = "#register-button")		//# for button
	private WebElement registerButton;
	
	@FindBy (how = How.XPATH, using = "//div[@class='result'and text()='Your registration completed']")
	private WebElement successfulRegisterMessage;
	
	@FindBy (how = How.CSS, using = ".result")		//. for class
	private WebElement successfulRegisterText;
	
	@FindBy (how = How.CSS, using = ".ico-logout")		//. for class
	private WebElement logoutLink;
	
	public void clickToMaleRadioButton() {
		waitToElementVisible(genderMaleRadioButton);
		clickToElement(genderMaleRadioButton);	
	}
	
	public void inputToFirstnameTextbox(String firstNameValue) {
		waitToElementVisible(firstNameTextbox);
		sendKeytoElement(firstNameTextbox, firstNameValue);
	}

	public void inputToLastnameTextbox(String lastNameValue) {
		waitToElementVisible(lastNameTextbox);
		sendKeytoElement(lastNameTextbox, lastNameValue);
	}

	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendKeytoElement(emailTextbox, email);
	}

	public void inputToPasswordTextbox(String passwordValue) {
		waitToElementVisible(passwordTextbox);
		sendKeytoElement(passwordTextbox, passwordValue);
	}

	public void inputToConfirmPasswordTextbox(String confirmPasswordValue) {
		waitToElementVisible(confirmPasswordTextbox);
		sendKeytoElement(confirmPasswordTextbox, confirmPasswordValue);
		
	}

	public void clickRegisterButton() {
		waitToElementVisible(registerButton);
		clickToElement(registerButton);	
	}

	public boolean isSuccessfulMessageDisplayed() {
		waitToElementVisible(successfulRegisterMessage);
		return isElementDisplayed(successfulRegisterMessage);
	}

	public String getSucessfulRegistrationText() {
		waitToElementVisible(successfulRegisterText);
		return getTextElement(successfulRegisterText);
	}
	
	public void clickLogoutLink() {
		waitToElementVisible(logoutLink);
		clickToElement(logoutLink);		
	}
}
