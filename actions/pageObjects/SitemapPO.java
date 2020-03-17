package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import pageUIs.HomePageUI;

public class SitemapPO extends AbstractPageObject{

	public SitemapPO(WebDriver driverLocal) {
		super(driverLocal);
	}

	public ShippingAndReturnPO openShippingAndReturnPage(WebDriver driver) {
		waitToElementVisible(HomePageUI.);
		clickToElement(HomePageUI.FOOTER_SITEMAP_LINK);
		return null;
	}

}
