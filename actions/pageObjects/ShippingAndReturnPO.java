package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.ShippingAndReturnPageUI;

public class ShippingAndReturnPO extends AbstractPageObject {

	WebDriver driverGlobal;
	public ShippingAndReturnPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}
//	public FooterMyAccountPO openFooterMyAccountPage(WebDriver driver) {
//		waitToElementVisible(ShippingAndReturnPageUI.FOOTER_MY_ACCOUNT_LINK);
//		clickToElement(ShippingAndReturnPageUI.FOOTER_MY_ACCOUNT_LINK);
//		return PageGeneratorManager.getFooterMyAccountPage(driver);
//	}
}
