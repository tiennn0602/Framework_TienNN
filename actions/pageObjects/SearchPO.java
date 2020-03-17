package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPageObject;

public class SearchPO extends AbstractPageObject{

	WebDriver driverGlobal;
	public SearchPO(WebDriver driverLocal) {
		super(driverLocal);
		driverGlobal = driverLocal;
	}

}
