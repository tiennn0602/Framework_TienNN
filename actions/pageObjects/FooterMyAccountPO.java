package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class FooterMyAccountPO extends AbstractPageObject {

	WebDriver driverGlobal;
	public FooterMyAccountPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

}
