package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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
		
		@FindBy(xpath = "//span[@class=\"value\"]")
		WebElement skuFromPDP;
		
		
		@FindBy(xpath = "//div/a[@title=\"Facebook\"]")
		WebElement shareToFacebookIcon;
		
		@FindBy(xpath = "//input[@id=\"rental_start_date_40\"]")
		WebElement startDateForRentAElegantGemstoneJewelry;
		@FindBy(xpath = "//input[@id=\"rental_end_date_40\"]")
		WebElement endDateOFRentAElegantGemstoneJewelry;
		@FindBy(xpath = "//a[@title=\"Next\"]")
		WebElement monthNextBtnCalender;
		@FindBy(xpath = "//span[@class=\"product-subtotal\"]")
		WebElement totalPriceInShoppingCart;
		
		
		@FindBy(xpath = "//a[@class=\"button-2 download-sample-button\"]")
		WebElement downloadSampleBTN;
		
		public PDPPageObjects () {
			PageFactory.initElements(driver, this);
		}
		//TC_2
		//navigate to LeicaTMirroles Camera Review page
		public void navigateToLeicaTMirrolessReviewPage () {
			leicaTMirrorlessReviewBtn.click();
		}
		
		//TC_5
		//navigate to Pride and Prejudice Email a Friend , write a email and message and send a email
		public void navigateToPrideAndPrejudiceEmailAFriendWriteAemailMessageAndSendEmail(String emailFriend, String PersonalMessage) {
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
		public String skuFromPDP() {
			return skuFromPDP.getText();
		}
		//TC13
		public void downloadSample() {
			downloadSampleBTN.click();
		}
		//TC11
		public void shareOnFB() {
			cm.waitForElementToBeVisible(shareToFacebookIcon);
			shareToFacebookIcon.click();
		}
		
		//assert
		// verify that user cannot write a Reviews if user is not registered and login
		public void verifyUserCannotWriteReviewsIfNotLogin() {
			String excRes = driver.findElement(By.xpath("//form/div/ul/li")).getText();
			assertTrue(excRes.contains("Only registered users can write reviews"));
			
		}
		// verify that user sent a email to friend
		public void verifyThatUserSentAEmailToFriend () {
			String actRes = driver.findElement(By.xpath("//div[@class=\"result\"]")).getText();
			assertTrue(actRes.contains("Your message has been sent."));
		}
		// verify that file is downloaded
		public void verifyThatFileIsDownloaded () {
			File fileLocation = new File ("C:\\Users\\marti\\Downloads");
			File [] totalfiles = fileLocation.listFiles();
			for (File file : totalfiles) {
				if(file.getName().equals("Night_Vision_1.txt")) {
					Assert.assertEquals(file.getName(), "Night_Vision_1.txt");
					System.out.print("File is downloaded");
					break;
				}
			}
		}
		// verify that new tab is open and close it
		public void verifyThatNewWindowTabIsOpenAndCloseIt() {
			    	List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
			    	driver.switchTo().window(browserTabs .get(1));
			    	Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));
			    	driver.close();
			    	driver.switchTo().window(browserTabs.get(0));
			    	Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/asus-n551jk-xo076h-laptop");
			    }
		// rent a Product Start Date To Rent To End Date To Rent
	public void rentAProductStartDateAndEndDate () {
		String wantedYearStart ="2024";
		String wantedMonthStart = "April";
		String wantedDayStart = "17";
		
		String wantedYearEnd ="2024";
		String wantedMonthEnd = "April";
		String wantedDayEnd = "20";
		
		 startDateForRentAElegantGemstoneJewelry.click();
		do {
			monthNextBtnCalender.click();
		}
		while (!driver.getPageSource().contains(wantedYearStart) || !driver.getPageSource().contains(wantedMonthStart));
		driver.findElement(By.xpath("//a[contains(text(),'" + wantedDayStart+ "')]")).click();
		
		
		 endDateOFRentAElegantGemstoneJewelry.click();
		do {
			monthNextBtnCalender.click();
		}
		while (!driver.getPageSource().contains(wantedYearEnd) || !driver.getPageSource().contains(wantedMonthEnd));
		driver.findElement(By.xpath("//a[contains(text(),'" + wantedDayEnd+ "')]")).click();
	
	}
	//verify that start date rent and end date rent is displayed
	 public void verifyThatProductForRentIsAvailableFor3days () {
		 int RentPerDay = 3000;
		 int daysOfRent = 3;
		 int rent = RentPerDay * daysOfRent;
		 String totalPriceInShoppingCart1 = totalPriceInShoppingCart.getText();
		 totalPriceInShoppingCart1 = totalPriceInShoppingCart1.replaceAll("[$-,-.]", "");
		 int totalPrice = Integer.parseInt(totalPriceInShoppingCart1);
		 
		 Assert.assertEquals(rent, totalPrice);
		 }
	
}
