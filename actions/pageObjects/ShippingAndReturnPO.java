package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class ShippingAndReturnPO extends AbstractPageObject {

	WebDriver driverGlobal;
	public ShippingAndReturnPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

}
