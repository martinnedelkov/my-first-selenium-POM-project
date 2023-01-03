package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class WishlistPageObjects extends Base {
	
	CommonObjects cm = new CommonObjects();
	@FindBy(xpath = "(//input[@type=\"checkbox\"])[1]")
	WebElement checkBoxAddToCard;
	@FindBy(xpath = "//button[@id=\"updatecart\"]")
	WebElement updateWishlist;	
	@FindBy(xpath = "//button[@class=\"button-2 wishlist-add-to-cart-button\"]")
	WebElement addToCartWishlist;	
	@FindBy(xpath = "//input[@class=\"qty-input\"]")
	WebElement quantityWishlist;
	@FindBy(xpath = "//button[@class=\"remove-btn\"]")
	WebElement removeWishlist;
	@FindBy(xpath = "//button[@class=\"button-2 email-a-friend-wishlist-button\"]")
	WebElement emailAFriendBtnWishlist;
	@FindBy(xpath = "//input[@class=\"friend-email\"]")
	WebElement friendEmailField;
	@FindBy(xpath = "//input[@class=\"your-email\"]")
	WebElement yourEmailField;
	@FindBy(xpath = "//textarea[@id=\"PersonalMessage\"]")
	WebElement personalMsgField;
	@FindBy(xpath = "//button[@name=\"send-email\"]")
	WebElement sendEmailBtn;
	@FindBy(xpath = "//td[@class=\"sku\"]")
	WebElement skuInTableWihsist;
	@FindBy(xpath = "//span[@class=\"sku-number\"]")
	WebElement skuFromShoppingCart;
	
	
	
	
	public WishlistPageObjects() {
		PageFactory.initElements(driver, this);
	}
	public void addProductToCartFromWishlist() {
		checkBoxAddToCard.click();
		addToCartWishlist.click();
	}
	public String getSkuWishlist () {
		return skuInTableWihsist.getText();
	}
	public String getSkuFromShoppingCart() {
		return skuFromShoppingCart.getText();
	}
	
	public void changeTheQuantityField()  {
		quantityWishlist.clear();
		quantityWishlist.sendKeys("5");
		updateWishlist.click();
	}
	
	public void emailAFriendFromWishlist (String friendEmail , String PersonalMsg) {
		emailAFriendBtnWishlist.click();
		friendEmailField.sendKeys(friendEmail);
		personalMsgField.sendKeys(PersonalMsg);
		sendEmailBtn.click();
	}
	
	public void removeProductFromWishlist () {
		int size = driver.findElements(By.xpath("//tr/td[@class=\"sku\"]")).size();
		for(int i = 1; i < size + 1; i++) {
			removeWishlist.click();
		}
	}
	
	public void checkAddProductToCartFromWishlistAssert() {
		Assert.assertEquals(driver.getTitle(), "nopCommerce demo store. Shopping Cart");
	}
	public void checkThePriceAssert() {
		String excRes = "$255.00";
		String actRes = driver.findElement(By.xpath("//span[@class=\"product-subtotal\"]")).getText();
		assertEquals(actRes, excRes);
	}

}
