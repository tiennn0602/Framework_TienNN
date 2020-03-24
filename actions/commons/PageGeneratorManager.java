package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.FooterMyAccountPO;
import pageObjects.HeaderMyAccountPO;
import pageObjects.HomePO;
import pageObjects.LoginPO;
import pageObjects.RegisterPO;
import pageObjects.SearchPO;
import pageObjects.ShippingAndReturnPO;
import pageObjects.ShoppingCartPO;
import pageObjects.SitemapPO;

public class PageGeneratorManager {

	public static HomePO getHomePage(WebDriver driver) {
		return new HomePO(driver);
	}

	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}

	public static RegisterPO getRegisterPage(WebDriver driver) {
		return new RegisterPO(driver);
	}

	public static HeaderMyAccountPO getHeaderMyAccountPage(WebDriver driver) {
		return new HeaderMyAccountPO(driver);
	}

	public static FooterMyAccountPO getFooterMyAccountPage(WebDriver driver) {
		return new FooterMyAccountPO(driver);
	}

	public static SearchPO getSearchPage(WebDriver driver) {
		return new SearchPO(driver);
	}

	public static ShippingAndReturnPO getShippingAndReturnPage(WebDriver driver) {
		return new ShippingAndReturnPO(driver);
	}

	public static ShoppingCartPO getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPO(driver);
	}

	public static SitemapPO getSiteMapPage(WebDriver driver) {
		return new SitemapPO(driver);
	}
}
