package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import TestData.Testdata;

	

public class RegisterPageObjects extends Base{
	
	Testdata td = new Testdata();
	
	@FindBy(xpath = "//span[@class=\"male\"]/input[1]")
	WebElement maleGender;
	@FindBy (xpath = "//span[@class=\"male\"]/input[2]")
	WebElement femaleGender;
	@FindBy(xpath = "//input[@id=\"FirstName\"]")
	WebElement firstnameField;
	@FindBy(xpath = "//input[@id=\"LastName\"]")
	WebElement lastnameField;
	@FindBy(xpath = "//input[@id=\"Email\"]")
	WebElement emailField;
	@FindBy(xpath = "//input[@id=\"Password\"]")
	WebElement passwordField;
	@FindBy(xpath = "//input[@id=\"ConfirmPassword\"]")
	WebElement confirmpasswordField;
	@FindBy(xpath = "//button[@id=\"register-button\"]")
	WebElement registerBtn;
	@FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]/option[18]")
	WebElement dateOfB;
	@FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]/option[6]")
	WebElement monthOfB;
	@FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]/option[90]")
	WebElement yearOfB;
	@FindBy(xpath = "(//input[@type=\"text\"])[4]")
	WebElement companyNameField;
	@FindBy(xpath = "//input[@type=\"checkbox\"]")
	WebElement newsletter;
	
	public RegisterPageObjects () {
		PageFactory.initElements(driver, this);
	}
	
	public void registerMandatroyFields (String name,String lastname,String email,String password, String confirmpassword) {
		firstnameField.sendKeys(name);
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		registerBtn.click();
		
	}
	
	public void registerWithFullFields (String name,String lastname,String email,String password, String confirmpassword, String companyName) {
		firstnameField.sendKeys(name);
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		companyNameField.sendKeys(companyName);
		maleGender.click();
		dateOfB.click();
		monthOfB.click();
		yearOfB.click();
		newsletter.click();
		registerBtn.click();
		
	}
	public void randomEmail() {
		Random randomEmail = new Random ();
		int randomInt = randomEmail.nextInt(100);
		emailField.sendKeys("kocan"+randomInt+"@fabrika.com");
	}
	public void registerMandatroyFieldsWithRandomEmail (String name,String lastname,String password, String confirmpassword) {
		firstnameField.sendKeys(name);
		lastnameField.sendKeys(lastname);
		randomEmail();
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		registerBtn.click();
	}
	
	public void verifyThatUserIsRegister() {
		String message = driver.findElement(By.xpath("//div/div[@class=\"result\"]")).getText();
		Assert.assertTrue(message.contains("Your registration completed"));
	}
	
	public void verifyThatUserIsNotRegister() {
		Assert.assertEquals(driver.getTitle(), td.registerpage);
	}
	
	
	
}
