package pageUIs;

public class AbstractPageUI {
	//Header (5 variables for the header to open 5 pages
	public static final String HEADER_REGISTER_LINK = "//a[@class='ico-register']";
	public static final String HEADER_LOGIN_LINK = "//a[@class='ico-login']";
	public static final String HEADER_LOGOUT_LINK = "//a[@class='ico-logout' and text() = 'Log out']";
	public static final String HEADER_MY_ACCOUNT_LINK = "//a[@class='ico-account' and text() = 'My account']";
	public static final String HEADER_WISHLIST_LINK = "//span[@class='wishlist-label']";
	public static final String HEADER_SHOPPING_CART_LINK = "//span[@class='cart-label']";
	public static final String HEADER_HOMEPAGE_LINK = "//div[@class='header-logo']";
	//2
	
	//Footer (23 variables for the footer to open 23 pages)
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String FOOTER_SITEMAP_LINK = "//a[contains(text(),'Sitemap')]";
	public static final String FOOTER_SEARCH_LINK = "//a[contains(text(),'Search')]";
	public static final String FOOTER_SHOPPING_CART_LINK = "//a[contains(text(),'Shopping cart')]";
	public static final String FOOTER_SHIPPING_AND_RETURN_LINK = "//a[contains(text(),'Shipping & returns')]";
	//18
	
	//DYNAMIC element components
	public static final String DYNAMIC_FOOTER_LINK = "//div[@class='footer']//a[text()='%s']";
	public static final String DYNAMIC_TEXTBOX = "//input[@id='%s']";
	public static final String DYNAMIC_TEXTAREA = "//input[@id='%s']";
	public static final String DYNAMIC_BUTTON= "//input[@value='%s']";
	public static final String DYNAMIC_RADIO_BUTTON = "//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_LIST= "//select[@name='%s']";
	public static final String DYNAMIC_REQUIRED_FIELD_ERROR_MESSAGE= "//span[@id='%s-error']";
}
