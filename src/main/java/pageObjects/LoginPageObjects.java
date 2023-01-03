package pageObjects;



import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import TestData.Testdata;


public class LoginPageObjects extends Base{
	
	Testdata td = new Testdata();
	
	@FindBy(xpath = "//input[@name=\"Email\"]")
	WebElement emailField;
	@FindBy(xpath = "//input[@name=\"Password\"]")
	WebElement passwordField;
	@FindBy(xpath = "(//button[@type=\"submit\"])[2]")
	WebElement loginBtn;
	@FindBy(xpath = "//a[@href=\"http://www.facebook.com/nopCommerce\"]")
	WebElement fbScroll;
	
	public LoginPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	// login method
	public void loginUser(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	
	// scroll practice
	//using Thread sleep to see that Scrolling is working
	public void scrollToLoginBtn() throws InterruptedException {
		WebElement element = loginBtn;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		
	}
	
	// verify that user is login successful
	public void verifyUserIsLogin() {
		Assert.assertEquals(driver.getTitle(), td.homepage);
	}
	
	// verify that user  not login
	public void verifyUserIsNotLogin() {
		Assert.assertEquals(driver.getTitle(), td.loginpage);
	}
}
