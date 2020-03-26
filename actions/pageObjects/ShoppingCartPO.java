package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class ShoppingCartPO extends AbstractPageObject{

	WebDriver driverGlobal;
	public ShoppingCartPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}
}
