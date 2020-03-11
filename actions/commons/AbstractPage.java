package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {
	
	By by;
	Select select;
	Actions action; //user interactions - actions
	WebElement element;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver driverGlobal;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;
	
	public AbstractPage(WebDriver driverLocal) {
		driverGlobal = driverLocal;
		jsExecutor = (JavascriptExecutor) driverGlobal;
		waitExplicit = new WebDriverWait(driverGlobal,longTimeout);
		action = new Actions(driverGlobal);	//tham so la driver, ta truyen o day
	}
	
	public void openUrl(String urlValue){
		driverGlobal.get(urlValue);		
	}
	
	public String getPageTitle () {
		return driverGlobal.getTitle();
	}
	
	public String getPageCurrentUrl() {
		return driverGlobal.getCurrentUrl();
	}
	
	public String getPageSource () {
		return driverGlobal.getPageSource();
	}
	
	public void backToPage() {
		driverGlobal.navigate().back();
	}
	
	public void refreshPage() {
		driverGlobal.navigate().refresh();
	}
	
	public void forwardToPage() {
		driverGlobal.navigate().forward();
	}
	
	public void acceptAlert() {
		driverGlobal.switchTo().alert().accept();
	}
	
	public void cancelAlert() {
		driverGlobal.switchTo().alert().dismiss();
	}
	
	public String getTextAlert() {
		return driverGlobal.switchTo().alert().getText();
	}
	
	public void sendKeyAlert(String value) {
		driverGlobal.switchTo().alert().sendKeys(value);
	}
	
	public void waitAlertPresence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	//Web Browser: open page/ getUrl/ getTitle/ Window/Alert/ Page Source/...
	//Web Element: click/sendKey/submit/select/getText/getAttributes/Css/...
	
	public void clickToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		element.click();
	}
	
	public void sendKeytoElement(String locator, String value) {
		element = driverGlobal.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}
	
	public void selectItemInDropdown(String locator, String valueItem) {
		element = driverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}
	
	public String getValueItemInDropdown(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}
	
	public void selectItemInCustomDropdown(String parentLocator, String allItemsLocator, String expectedItem) {
		element = driverGlobal.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));
		elements = driverGlobal.findElements(By.xpath(allItemsLocator));
		for (WebElement item : elements) {
			System.out.println(item.getText());
			if (item.getText().equals(expectedItem)) {
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(2);
				break;
			}
		}
	}
	
	public void sleepInSecond(long numberInSecond) {
		try {			
		Thread.sleep(numberInSecond * 1000);	
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getAttributeValue(String locator, String attributeName) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}
	
	public String getTextElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.getText();
	}

	public int countElementNumber(String locator) {
		elements = driverGlobal.findElements(By.xpath(locator));
		return elements.size();
	}
	
	public void checkTheCheckbox(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		if (element.isSelected()==false) {
			element.click();
		}
	}
	
	public void uncheckTheCheckbox(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		if (element.isSelected()==true) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isElementSelected(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.isSelected();
	}
	
	public boolean isElementEnabled(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		return element.isEnabled();
	}
	
	public void switchToChildWindowByID(String parent) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driverGlobal.switchTo().window(runWindow);
				break;
			}
		}
	}
	
	public void switchToChildWindowByTitle(String title) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		for (String runWindows : allWindows) {
			driverGlobal.switchTo().window(runWindows);
			String currentWin = driverGlobal.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}
	
	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		Set<String> allWindows = driverGlobal.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driverGlobal.switchTo().window(runWindows)
				driverGlobal.close();
			}
		}
		driverGlobal.switchTo().window(parentWindow);
		if (driverGlobal.getWindowHandles().size()==1)
			return true;
		else
			return false;
	}
	
	public void switchToFrameOrIframe(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		driverGlobal.switchTo().frame(element);
	}
	
	public void switchToParentPage() {
		driverGlobal.switchTo().defaultContent();
	}
	
	public void hoverToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.moveToElement(element).perform();
	}
	
	public void doubleToElement(String locator) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.doubleClick(element).perform();
	}
	
	public void sendKeyboardToElement (String locator, Keys key) {
		element = driverGlobal.findElement(By.xpath(locator));
		action.sendKeys(element,key).perform();
	}
	
	public void waitToElementVisible(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void waitToElementPresence(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	public void waitToElementInvisible(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}
	
	public void waitToElementClickable(String locator) {
		by = By.xpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}
	
	
}
