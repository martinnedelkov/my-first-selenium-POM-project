package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Base.Base;


public class PDPPageObjects extends Base {
		CommonObjects cm = new CommonObjects();
		@FindBy (xpath = "//select[@data-attr=\"11\"]/option[5]")
		WebElement nikeTailwindSize3x;
		@FindBy(xpath = "//input[@id=\"product_enteredQuantity_27\"]")
		WebElement nikeTailwindQuantityField;
		@FindBy(xpath = "//button[@id=\"add-to-cart-button-27\"]")
		WebElement nikeTailWindAddToCartBtn;
		@FindBy(xpath = "//span[@id=\"sku-27\"]")
		WebElement SkuNikeTailwind;
		
		@FindBy(xpath = "//a[@href=\"/productreviews/16\"][2]")
		WebElement leicaTMirrorlessReviewBtn;
		@FindBy(xpath = "//input[@id=\"product_enteredQuantity_16\"]")
		WebElement leicaTMirrorlessQuantity;
		@FindBy(xpath = "(//button[@type=\"button\"])[1]")
		WebElement leicaTMirrorlessAddToCartPLP;
		@FindBy(xpath = "(//button[@type=\"button\"])[3]")
		WebElement leicaTMirrorlessAddToWishlistPLP;
		@FindBy(xpath = "(//button[@type=\"button\"])[4]")
		WebElement leicaTMirrorlessAddToComparelistPLP;
		@FindBy(xpath = "(//button[@type=\"button\"])[5]")
		WebElement leicaTMirrorlessEmailAFriendPLP;
		
		@FindBy(xpath = "//input[@id=\"product_enteredQuantity_38\"]")
		WebElement firstPrizeQuantity;
		@FindBy(xpath = "(//button[@type=\"button\"])[1]")
		WebElement firstPrizeAddToCartPlp;
		@FindBy(xpath = "(//button[@type=\"button\"])[3]")
		WebElement firstPrizeAddToWishlistPLP;
		@FindBy(xpath = "(//button[@type=\"button\"])[4]")
		WebElement firstPrizeAddToComparelistPLP;
		@FindBy(xpath = "(//button[@type=\"button\"])[5]")
		WebElement firstPrizeEmailAFriendPLP;
		
		@FindBy(xpath = "//button[@name=\"send-email\"]")
		WebElement sendEmailBtn;
		@FindBy(xpath = "//input[@class=\"friend-email\"]")
		WebElement friendsEmailField;
		@FindBy(xpath = "//textarea[@class=\"your-email\"]")
		WebElement personalMessageField;
		
		@FindBy(xpath = "//button[@id=\"add-to-cart-button-30\"]")
		WebElement levis511AddToCartBtn;
		@FindBy(xpath = "//input[@class=\"qty-input\"]")
		WebElement levis511QuantityField;
		@FindBy(xpath = "//a[@href=\"/productreviews/30\"][2]")
		WebElement levis511AddReviewBtn;
		@FindBy(xpath = "//button[@id=\"add-to-wishlist-button-30\"]")
		WebElement levis511AddToWishlistBtn;
		@FindBy(xpath = "(//button[@class=\"button-2 add-to-compare-list-button\"])[1]")
		WebElement levis511AddToCompareBtn;
		@FindBy(xpath = "//button[@class=\"button-2 email-a-friend-button\"]")
		WebElement levis511EmailAFriendBtn;
		
		@FindBy(xpath = "(//a[@href=\"/htc-one-mini-blue\"])[2]")
		WebElement htcOneMiniRelatedProducts;
		@FindBy(xpath = "//span[@id=\"sku-20\"]")
		WebElement nokiaLumiaSku;
		@FindBy(xpath = "//span[@id=\"sku-19\"]")
		WebElement htcOneMiniSku;
		
		@FindBy(xpath = "//span[@id=\"sku-7\"]")
		WebElement hpSpecteSKU;
		
		
		public PDPPageObjects () {
			PageFactory.initElements(driver, this);
		}
		//TC_2
		public void productReview () {
			leicaTMirrorlessReviewBtn.click();
		}
		//TC_5
		public void checkShareProductFunctionality(String emailFriend, String PersonalMessage) {
			firstPrizeEmailAFriendPLP.click();
			friendsEmailField.sendKeys(emailFriend);
			personalMessageField.sendKeys(PersonalMessage);
			sendEmailBtn.click();
		}
		// vezba od chasot
		public String nikeTaildWindSkuPDP() {
			return SkuNikeTailwind.getText();
		}
		public void nikeTailwind3xSize4Quantity() {
			nikeTailwindSize3x.click();
			nikeTailwindQuantityField.clear();
			nikeTailwindQuantityField.sendKeys("4");
			nikeTailWindAddToCartBtn.click();
		}
		
		public void levis511AddToCart() {
			levis511AddToCartBtn.click();
			
		}
		public void scrollToHtcMiniForEndToEnd() {
			cm.scrollToElement(htcOneMiniRelatedProducts);
			htcOneMiniRelatedProducts.click();
		}
		public String nokiaLumiaSKUPDP() {
			return nokiaLumiaSku.getText();
		}
		public String htcOneMiniSKUPDP() {
			return htcOneMiniSku.getText();
		}
		public String hpSpectreXtSKUPDP() {
			return hpSpecteSKU.getText();
		}
		
		//assert
		public void productReviewAssertv() {
			String excRes = driver.findElement(By.xpath("//form/div/ul/li")).getText();
			assertTrue(excRes.contains("Only registered users can write reviews"));
			
		}
		public void checkShareProductAssert () {
			String actRes = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
			assertTrue(actRes.contains("Your message has been sent."));
		}
	
	
	
}
