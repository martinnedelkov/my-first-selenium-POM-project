package pageObjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;



public class HomePageObjects extends Base{
	
	CommonObjects cm = new CommonObjects();
	
	@FindBy(xpath = "//a[@href=\"/login?returnUrl=%2F\"]")
	WebElement loginTopBtn;
	@FindBy(xpath = "//a[@class=\"ico-logout\"]")
	WebElement logoutTopBtn;
	@FindBy(xpath = "//a[@href=\"/register?returnUrl=%2F\"]")
	WebElement registerTopBtn;
	@FindBy(xpath = "//span[@class=\"wishlist-label\"]")
	WebElement wishlisthTopBtn;
	@FindBy(xpath = "//span[@class=\"cart-label\"]")
	WebElement shoppingcartTopBtn;
	@FindBy(xpath = "(//a[@href=\"/customer/info\"])[1]")
	WebElement myAccTopBtn;
	@FindBy (xpath = "//input[@type=\"text\"]")
	WebElement searchField;
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement searchBtn;
	@FindBy (xpath ="(//a[@href=\"/computers\"])[1]")
	WebElement computersBtn;
	@FindBy (xpath = "(//a[@href=\"/electronics\"])[1]")
	WebElement electronicsBtn;
	@FindBy(xpath = "(//a[@href=\"/apparel\"])[1]")
	WebElement apparelBtn;
	@FindBy(xpath = "(//a[@href=\"/digital-downloads\"])[1]")
	WebElement digitalDownloadsBtn;
	@FindBy(xpath = "(//a[@href=\"/books\"])[1]")
	WebElement booksBtn;
	@FindBy(xpath = "(//a[@href=\"/jewelry\"])[1]")
	WebElement jewelrtBtn;
	@FindBy(xpath = "(//a[@href=\"/gift-cards\"])[1]")
	WebElement giftCardsBtn;
	@FindBy(xpath = "//button[@class=\"button-2 vote-poll-button\"]")
	WebElement voteBtn;
	@FindBy(xpath = "//div[@class=\"warning\"]")
	WebElement expMesForSearchMinWith3Char;
	@FindBy(xpath = "//div[@class=\"no-result\"]")
	WebElement expMsgForNotExistProduct;
	@FindBy(xpath ="(//a[@href=\"/camera-photo\"])[1]")
	WebElement cameraPhoto;
	@FindBy(xpath ="(//a[@href=\"/cell-phones\"])[1]")
	WebElement cellPhones;
	@FindBy(xpath = "(//a[@href=\"/notebooks\"])[1]")
	WebElement notebooks;
	@FindBy(xpath = "//a[@href=\"https://twitter.com/nopCommerce\"]")
	WebElement twitterBtn;
	@FindBy(xpath = "//div[@class=\"social\"]")
	WebElement followUsIcons;
	
	


public HomePageObjects() {
	PageFactory.initElements(driver, this);
}


//methods
public void navigateToLoginPage () {
	loginTopBtn.click();
}
public void navigateToRegisterPage () {
	registerTopBtn.click();
}
public void navigateToWishlistPage () {
	wishlisthTopBtn.click();
}
public void navigateToShoppingCart () {
	shoppingcartTopBtn.click();
}
public void searchItem(String products) {
	searchField.sendKeys(products);
	searchBtn.click();

}
public void navigateToComputers () {
	computersBtn.click();
}
public void naviagteToElectronics () {
	electronicsBtn.click();
}
public void naviagteToApparel () {
	apparelBtn.click();
}
public void naviagteToDigitalDownloads () {
	digitalDownloadsBtn.click();
}
public void naviagteToBooks () {
	booksBtn.click();
}
public void naviagteToGiftCards () {
	giftCardsBtn.click();
}
public void naviagteJewelry() {
	jewelrtBtn.click();
}
public void navigateToMyAcc() {
	myAccTopBtn.click();
}
public void logout() {
	cm.waitForElementToBeVisible(logoutTopBtn);
	logoutTopBtn.click();
}
public void navigateToClothingWithHover() {
	WebElement ele = driver.findElement(By.xpath("(//a[@href=\"/apparel\"])[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(ele).perform();
	WebElement item = driver.findElement(By.xpath("(//a[@href=\"/clothing\"])[1]"));
	item.click();
}
public void navigateToCameraAndPhoto() {
	cm.navigateWithHover(electronicsBtn, cameraPhoto);
}
public void navigateToNoteBooks() {
	cm.navigateWithHover(computersBtn, notebooks);
}
public void navigateToCellPhones() {
	cm.navigateWithHover(electronicsBtn, cellPhones);
}
public void navigateToTwitter () {
	cm.scrollToElement(twitterBtn);
	twitterBtn.click();
}


	//asserts for search

	//verify that user cannot search with 2 characters
    public void verifyThatUserCantSearchWith2Characters() {
    
    	assertEquals(expMesForSearchMinWith3Char.getText(), "Search term minimum length is 3 characters");
}
    
  //verify that user cannot search non exist product on the website
    public void verifyThatProductNotExist() {
    			
		assertEquals(expMsgForNotExistProduct.getText(), "No products were found that matched your criteria.");
    }
    
  //verify that all displayed product are nike 
    public void verifySearchValidation() {
    	int size = driver.findElements(By.xpath("//h2[@class=\"product-title\"]")).size();
		
		for(int i = 1; i < size + 1; i++) {
			
			String text = driver.findElement(By.xpath("(//h2[@class=\"product-title\"])[" +i+ "]")).getText().toLowerCase();
			assertTrue(text.contains("NIKE".toLowerCase()));
			
		}
    }
    
    //verify that user cannot search with empty search field (verify text from alert message)
     public void verifyThatUserCantSearchWithEmptySearchField () {
    	 Alert a = driver.switchTo().alert();
    	 String alertMessage= driver.switchTo().alert().getText();
    	 a.accept();
    	 Assert.assertEquals(alertMessage, "Please enter some search keyword");
     }
    
    // scroll  practice
     // using Thread sleep to see that Scrolling is working
    public void scrollToVoteBtn() throws InterruptedException {
		WebElement element = voteBtn;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element); // scrolling to the vote btn
		Thread.sleep(300); 
    }
    
    //verify that new tab is open  and then closed (verify that user is on first tab)
    //( a new window tab will be open where it will be shown a Twitter site(checking that user is on twitter site) and then tab will be closed(checking that user is on on the first site))
    public void assertNewWindowTab () {
    	List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(browserTabs .get(1));
    	Assert.assertEquals(driver.getCurrentUrl(), "https://twitter.com/nopCommerce");
    	driver.close();
    	driver.switchTo().window(browserTabs.get(0));
    	Assert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
    }
    
    //screenshot practice
    public void takingAscreenShot () throws IOException {
    	cm.takingAscreenShot(followUsIcons, "FollowUsIcons");  // taking a screenshot from follow us icons
    }
    
    //Screen Video Recording practice
    public void screenVideoRecording () throws Exception  {
    	ScreenRecorderUtil.startRecord("test-recording");
    	cm.hoverToElement(computersBtn);  // hover to computers
    	cm.hoverToElement(electronicsBtn);	// hover to electronics
    	cm.hoverToElement(apparelBtn);		// hover to apparel
    	ScreenRecorderUtil.stopRecord();
    }
}