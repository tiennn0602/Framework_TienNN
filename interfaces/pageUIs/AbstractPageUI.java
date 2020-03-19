package pageUIs;

public class AbstractPageUI {
	//Header (5 variables for the header to open 5 pages
	public static final String HEADER_MY_ACCOUNT_LINK = "//a[@class='ico-account' and text() = 'My account']";
	public static final String HEADER_WISHLIST_LINK = "//span[@class='wishlist-label']";
	public static final String HEADER_SHOPPING_CART_LINK = "//span[@class='cart-label']";
	//2
	
	//Footer (23 variables for the footer to open 23 pages)
	public static final String FOOTER_MY_ACCOUNT_LINK = "//div[@class='footer']//a[text()='My account']";
	public static final String FOOTER_SITEMAP_LINK = "//a[contains(text(),'Sitemap')]";
	public static final String FOOTER_SEARCH_LINK = "//a[contains(text(),'Search')]";
	public static final String FOOTER_SHOPPING_CART_LINK = "//a[contains(text(),'Search')]";
	public static final String FOOTER_SHIPPING_AND_RETURN_LINK = "//a[contains(text(),'Shipping & returns')]";
	//18
}
