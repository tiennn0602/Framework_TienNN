package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.HeaderMyAccountPageUI;

// Ke thua AbstractPageObject
// Khai bao biet driver
// Tao contructor to map driver

public class HeaderMyAccountPO extends AbstractPageObject {

	WebDriver driverGlobal;
	public HeaderMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

//	public SitemapPO openSiteMapPage(WebDriver driver) {
//		waitToElementVisible(HeaderMyAccountPageUI.FOOTER_SITEMAP_LINK);
//		clickToElement(HeaderMyAccountPageUI.FOOTER_SITEMAP_LINK);
//		return PageGeneratorManager.getSiteMapPage(driver);
//	}
}
