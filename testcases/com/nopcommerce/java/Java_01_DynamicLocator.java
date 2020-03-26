package com.nopcommerce.java;

public class Java_01_DynamicLocator {
	
	// 98 locators
	
	static String HOME_PAGE_LINK = "//a[text()= 'Home Page']";
	static String SITE_MAP_LINK = "//a[text()= 'Sitemap Page']";
	static String SHIPPING_LINK = "//a[text()= 'Shipping & Returns Page']";
	static String MY_ACCOUNT_LINK = "//a[text()= 'My Account Page']";
	
	// 1 param
	static String DYNAMIC_LINK = "//a[text() = '%s']";
	
	// 2 params
	
	static String DYNAMIC_COUNTRY_DYNAMIC_BUTTON = "//td[@data-key='country' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	
	// 3 params
	static String DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON = "//td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']/preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'%s')]";
	
	
	public static void main(String[] args) {
		clickToElement(DYNAMIC_LINK, "Home Page");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Vietnam", "edit");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_BUTTON, "Vietnam", "remove");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON, "Vietnam", "1320000", "edit");
		clickToElement(DYNAMIC_COUNTRY_DYNAMIC_TOTAL_DYNAMIC_BUTTON, "Vietnam", "1320000", "remove");
	}	
	
	// Apply Tinh Da Hinh trong Lap Trinh Huong Doi Tuong
	// Da hinh 1: 1 hàm cùng tên và khác nhau về số lượng tham số
	// Đa hình 2: 1 hàm cùng tên và cùng số lượng tham số nhưng khác nhau về kiểu dữ liệu
	
	// Khi co the 1 tham so moi, phai tao them 1 ham (+1 tham so)
//	public static void clickToElement(String locator, String param) {
//		System.out.println("Locator before = " + locator);
//		System.out.println("Page name = " + param);
//		locator = String.format(locator, param);
//		System.out.println("Locator after = " + locator);
//	}
//	
//	public static void clickToElement(String locator, String param1, String param2) {
//		System.out.println("Locator before = " + locator);
//		locator = String.format(locator, param1, param2);
//		System.out.println("Locator after = " + locator);
//	}
//	
//	public static void clickToElement(String locator, String param1, String param2, String param3) {
//		System.out.println("Locator before = " + locator);
//		locator = String.format(locator, param1, param2, param3);
//		System.out.println("Locator after = " + locator);
//	}
	
	
	//Apply Rest Parameter để xử lý cho n tham số còn lại (last)
	public static void clickToElement(String locator, String...params) {
		System.out.println("Locator before = " + locator);
		locator = String.format(locator, (Object[]) params);
		System.out.println("Locator after = " + locator);
	}
}
