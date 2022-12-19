package pageObjects;

import java.awt.Window;

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
	public void loginUser(String email,String password) {
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		loginBtn.click();
		
	}
	
	public void scrollToLoginBtn() throws InterruptedException {
		WebElement element = loginBtn;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
		
		
	}
	public void verifyUserIsLogin() {
		Assert.assertEquals(driver.getTitle(), td.homepage);
	}
	public void verifyUserIsNotLogin() {
		Assert.assertEquals(driver.getTitle(), td.loginpage);
	}
}
