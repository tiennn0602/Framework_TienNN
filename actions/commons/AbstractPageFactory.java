package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPageFactory {

	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver driverGlobal;
	WebDriverWait waitExplicit;
	
	public AbstractPageFactory(WebDriver driverLocal) {
		driverGlobal = driverLocal;
		waitExplicit = new WebDriverWait(driverGlobal,longTimeout);
	}
	
	public void waitToElementVisible(WebElement element) {
		waitExplicit.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void sendKeytoElement(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
	
	public void clickToElement(WebElement element) {
		element.click();
	}
	
	public boolean isElementDisplayed(WebElement element) {
		return element.isDisplayed();
	}
	
	public String getTextElement(WebElement element) {
		return element.getText();
	}
}
