package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;
import commons.PageGeneratorManager;
import pageUIs.FooterMyAccountPageUI;

public class FooterMyAccountPO extends AbstractPageObject {

	WebDriver driverGlobal;
	public FooterMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}
//	public SearchPO openSearchPage(WebDriver driver) {
//		waitToElementVisible(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
//		clickToElement(FooterMyAccountPageUI.FOOTER_SEARCH_LINK);
//		return PageGeneratorManager.getSearchPage(driver);
//	}
}
