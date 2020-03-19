package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.SitemapPageUI;

public class SitemapPO extends AbstractPageObject{

	public SitemapPO(WebDriver driverLocal) {
		super(driverLocal);
	}

//	public ShippingAndReturnPO openShippingAndReturnPage(WebDriver driver) {
//		waitToElementVisible(SitemapPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
//		clickToElement(SitemapPageUI.FOOTER_SHIPPING_AND_RETURN_LINK);
//		return PageGeneratorManager.getShippingAndReturnPage(driver);
//	}
}
