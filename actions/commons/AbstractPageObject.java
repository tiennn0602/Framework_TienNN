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

import pageObjects.FooterMyAccountPO;
import pageObjects.HeaderMyAccountPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;
import pageObjects.SearchPO;
import pageObjects.ShippingAndReturnPO;
import pageObjects.SitemapPO;
import pageUIs.AbstractPageUI;

public class AbstractPageObject {

	By by;
	Select select;
	Actions action; // user interactions - actions
	WebElement element;
	long shortTimeout = 5;
	long longTimeout = 30;
	WebDriver driver;
	List<WebElement> elements;
	WebDriverWait waitExplicit;
	JavascriptExecutor jsExecutor;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver; // chinh la bien WebDriver driver;
		jsExecutor = (JavascriptExecutor) driver;
		waitExplicit = new WebDriverWait(driver, longTimeout);
		action = new Actions(driver); // tham so la driver, ta truyen o day
	}

	public void openUrl(String urlValue) {
		driver.get(urlValue);
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageCurrentUrl() {
		return driver.getCurrentUrl();
	}

	public String getPageSource() {
		return driver.getPageSource();
	}

	public void backToPage() {
		driver.navigate().back();
	}

	public void refreshPage() {
		driver.navigate().refresh();
	}

	public void forwardToPage() {
		driver.navigate().forward();
	}

	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert() {
		driver.switchTo().alert().dismiss();
	}

	public String getTextAlert() {
		return driver.switchTo().alert().getText();
	}

	public void sendKeyAlert(String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence() {
		waitExplicit.until(ExpectedConditions.alertIsPresent());
	}
	// Web Browser: open page/ getUrl/ getTitle/ Window/Alert/ Page Source/...
	// Web Element: click/sendKey/submit/select/getText/getAttributes/Css/...

	public WebElement find(String locator) {
		return driver.findElement(byXpath(locator));
	}

	public void clickToElement(String locator) {
		element = find(locator);
		element.click();
	}

	public String castRestParameters(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	// n tham so
	public void clickToElement(String locator, String... values) {
		locator = castRestParameters(locator, values);
		element = find(locator);
		element.click();
	}

	public void sendKeytoElement(String locator, String value) {
		element = find(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void selectItemInDropdown(String locator, String valueItem) {
		element = find(locator);
		select = new Select(element);
		select.selectByVisibleText(valueItem);
	}

	public String getValueItemInDropdown(String locator) {
		element = find(locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public void selectItemInCustomDropdown(String parentLocator, String allItemsLocator, String expectedItem) {
		element = driver.findElement(By.xpath(parentLocator));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].click();", element);
		sleepInSecond(1);
		waitExplicit.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allItemsLocator)));
		elements = driver.findElements(By.xpath(allItemsLocator));
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
		element = find(locator);
		return element.getAttribute(attributeName);
	}

	public String getTextElement(String locator) {
		element = find(locator);
		return element.getText();
	}

	// n tham so
	public String getTextElement(String locator, String... values) {
		locator = castRestParameters(locator, values);
		element = find(locator);
		return element.getText();
	}

	public List<WebElement> finds(String locator) {
		return driver.findElements(byXpath(locator));
	}

	public int countElementNumber(String locator) {
		elements = finds(locator);
		return elements.size();
	}

	public void checkTheCheckbox(String locator) {
		element = find(locator);
		if (element.isSelected() == false) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(String locator) {
		element = find(locator);
		if (element.isSelected() == true) {
			element.click();
		}
	}

	public boolean isElementDisplayed(String locator) {
		element = find(locator);
		return element.isDisplayed();
	}

	// n tham so
	public boolean isElementDisplayed(String locator, String... values) {
		locator = castRestParameters(locator, values);
		element = find(locator);
		return element.isDisplayed();
	}

	public boolean isElementSelected(String locator) {
		element = find(locator);
		return element.isSelected();
	}

	public boolean isElementEnabled(String locator) {
		element = find(locator);
		return element.isEnabled();
	}

	public void switchToChildWindowByID(String parent) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parent)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToChildWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public boolean closeAllWindowsWithoutParent(String parentWindow) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentWindow)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	public void switchToFrameOrIframe(String locator) {
		element = find(locator);
		driver.switchTo().frame(element);
	}

	public void switchToParentPage() {
		driver.switchTo().defaultContent();
	}

	public void hoverToElement(String locator) {
		element = find(locator);
		action.moveToElement(element).perform();
	}

	public void doubleToElement(String locator) {
		element = find(locator);
		action.doubleClick(element).perform();
	}

	public void sendKeyboardToElement(String locator, Keys key) {
		element = find(locator);
		action.sendKeys(element, key).perform();
	}

	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public void waitToElementVisible(String locator) {
		by = byXpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToElementVisible(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		by = byXpath(locator);
		waitExplicit.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitToElementPresence(String locator) {
		by = byXpath(locator);
		waitExplicit.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitToElementInvisible(String locator) {
		by = byXpath(locator);
		waitExplicit.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitToElementClickable(String locator) {
		by = byXpath(locator);
		waitExplicit.until(ExpectedConditions.elementToBeClickable(by));
	}

	// 28 hàm để mở ra 28 pages
	public HeaderMyAccountPO openHeaderMyAccountPage() {
		waitToElementVisible(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.HEADER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getHeaderMyAccountPage(driver);
	}

	public HomePO openHomePage() {
		waitToElementVisible(AbstractPageUI.HEADER_HOMEPAGE_LINK);
		clickToElement(AbstractPageUI.HEADER_HOMEPAGE_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}

	public SitemapPO openSiteMapPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_SITEMAP_LINK);
		clickToElement(AbstractPageUI.FOOTER_SITEMAP_LINK);
		return PageGeneratorManager.getSiteMapPage(driver);
	}

	public ShippingAndReturnPO openShippingAndReturnPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
		clickToElement(AbstractPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
		return PageGeneratorManager.getShippingAndReturnPage(driver);
	}

	public FooterMyAccountPO openFooterMyAccountPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		clickToElement(AbstractPageUI.FOOTER_MY_ACCOUNT_LINK);
		return PageGeneratorManager.getFooterMyAccountPage(driver);
	}

	public SearchPO openSearchPage() {
		waitToElementVisible(AbstractPageUI.FOOTER_SEARCH_LINK);
		clickToElement(AbstractPageUI.FOOTER_SEARCH_LINK);
		return PageGeneratorManager.getSearchPage(driver);
	}

	public RegisterPO openRegisterPage() {
		waitToElementVisible(AbstractPageUI.HEADER_REGISTER_LINK);
		clickToElement(AbstractPageUI.HEADER_REGISTER_LINK);
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPO openLoginPage() {
		waitToElementVisible(AbstractPageUI.HEADER_LOGIN_LINK);
		clickToElement(AbstractPageUI.HEADER_LOGIN_LINK);
		return PageGeneratorManager.getLoginPage(driver);
	}

	// 1 hàm để mở ra 28 pages hoặc n pages
	// Nếu số lượng common pages ít (20-25 pages) thì làm cách sau, return từng page cho
	// từng case

	public AbstractPageObject openMultiplePage(String pageName) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		switch (pageName) {
		case "My account":
			return PageGeneratorManager.getFooterMyAccountPage(driver);
		case "Sitemap":
			return PageGeneratorManager.getSiteMapPage(driver);
		case "Search":
			return PageGeneratorManager.getSearchPage(driver);
		case "Shipping & returns":
			return PageGeneratorManager.getShippingAndReturnPage(driver);
		case "Shopping cart":
			return PageGeneratorManager.getShoppingCartPage(driver);
		default:
			return PageGeneratorManager.getHomePage(driver);
		}
	}

	// Nếu số lượng common pages nhiều, cả trăm page, không cần return (quá nhiều pages),
	// page tự new lên trong chính TCs
	public void openMultiplePages(String pageName) {
		waitToElementVisible(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
		clickToElement(AbstractPageUI.DYNAMIC_FOOTER_LINK, pageName);
	}
}
