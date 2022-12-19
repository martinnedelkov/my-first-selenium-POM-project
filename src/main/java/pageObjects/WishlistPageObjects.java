package pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class WishlistPageObjects extends Base {
	
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
	WebElement emailWishlist;
	
	public WishlistPageObjects() {
		PageFactory.initElements(driver, this);
	}
	public void checkAddProductToCartFromWishlist() {
		checkBoxAddToCard.click();
		addToCartWishlist.click();
	}
	
	public void checkThePrice() throws InterruptedException {
		quantityWishlist.clear();
		quantityWishlist.sendKeys("5");
		updateWishlist.click();
		Thread.sleep(5000);
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
