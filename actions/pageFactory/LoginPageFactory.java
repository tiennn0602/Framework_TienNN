package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.AbstractPageFactory;
import pageUIs.LoginPageUI;

public class LoginPageFactory extends AbstractPageFactory{
	public LoginPageFactory(WebDriver driverLocal) {
		super(driverLocal);
		PageFactory.initElements(driverLocal, this);
	}

	//Khoi tao cac element co trong page
	@FindBy (how = How.ID, using = "Email")
	private WebElement emailTextbox;
	
	@FindBy (how = How.ID, using = "Password")
	private WebElement passWordTextbox;
	
	@FindBy (how = How.CSS, using = ".login-button")
	private WebElement loginButon;
	
	@FindBy (how = How.XPATH, using = "//span[@id='Email-error' and text()='Please enter your email']")
	private WebElement errorEmptyEmail;
	
	@FindBy (how = How.XPATH, using = "//span[@id='Email-error' and text()='Wrong email']")
	private WebElement wrongEmailFormat;
	
	@FindBy (how = How.XPATH, using = "//li[contains(text(),'The credentials provided are incorrect')]")
	private WebElement passWordError;
	
	//Khi goi den ham nao se di tim element do
	public void inputToEmailTextbox(String email) {
		waitToElementVisible(emailTextbox);
		sendKeytoElement(emailTextbox, email);
	}

	public void inputToPasswordTextbox(String password) {
		waitToElementVisible(passWordTextbox);
		sendKeytoElement(passWordTextbox, "123456");
	}

	public void clickLoginButton() {
		waitToElementVisible(loginButon);
		clickToElement(loginButon);
		
	}
	
	public boolean isErrorMessageDisplayed() {
		waitToElementVisible(errorEmptyEmail);
		return isElementDisplayed(errorEmptyEmail);
	}

	public boolean isWrongEmailMessageDisplayed() {
		waitToElementVisible(wrongEmailFormat);
		return isElementDisplayed(wrongEmailFormat);
	}
	
	public boolean isErrorPasswordDisplayed() {
		waitToElementVisible(passWordError);
		return isElementDisplayed(passWordError);
	}

	

}
