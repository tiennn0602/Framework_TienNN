package pageUIs;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='Email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='Password']";
	public static final String LOGIN_BUTTON = "//input[@class='button-1 login-button']";
	public static final String EMPTY_EMAIL_ERROR = "//span[@id='Email-error' and text()='Please enter your email']";
	public static final String WRONG_EMAIL_FORMAT = "//span[@id='Email-error' and text()='Wrong email']";
	public static final String PASSWORD_ERROR = "//li[contains(text(),'The credentials provided are incorrect')]";
	public static final String LOGIN_FORM = "//div[@class='page login-page']";
}
