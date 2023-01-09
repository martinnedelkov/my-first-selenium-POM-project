package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.Base;
import TestData.Testdata;

	

public class RegisterPageObjects extends Base{
	
	
	Testdata td = new Testdata();
	LoginPageObjects lp = new LoginPageObjects();
	
	
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
	@FindBy(xpath = "//a[@href=\"/login?returnUrl=%2F\"]")
	WebElement loginIcon;
	@FindBy(xpath = "//a[@href=\"/logout\"]")
	WebElement logoutIcon;
	@FindBy(xpath = "//select[@name=\"DateOfBirthDay\"]")
	WebElement dayOfBirth;
	@FindBy(xpath = "//select[@name=\"DateOfBirthMonth\"]")
	WebElement MonthOfBirth;
	@FindBy(xpath = "//select[@name=\"DateOfBirthYear\"]")
	WebElement yearOfBirth;
	
	public RegisterPageObjects () {
		PageFactory.initElements(driver, this);
	}
	
	// user should be registered with only mandatory fields 
	//check if the user is logged in automatically, if not logged in automatically then log them in
	public void registerMandatroyFieldsAndLoginUser (String name,String lastname,String email,String password, String confirmpassword) {
		firstnameField.sendKeys(name);			
		lastnameField.sendKeys(lastname);
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		registerBtn.click();
		verifyThatUserIsRegister();
		if (loginIcon.isDisplayed()) {
			loginIcon.click();
			lp.loginUser(email, password);
			lp.verifyUserIsLogin();
		}else {
			System.out.println("User is automatically login");
		}
		
	}

	// user should be registered with populate all fields
	
	public void registerWithFullFieldsAndLogin (String name,String lastname,String email,String password, String confirmpassword, String companyName) {
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
	// user should be registered with populate mandatory fields with random email and random date of birth
	public void registerWithRandomEmailRandomDateOfBirth(String name,String lastname,String password, String confirmpassword) {
		firstnameField.sendKeys(name);
		lastnameField.sendKeys(lastname);
		randomDaYOfBirth();
		randomMonthOfBirth();
		randomYearOfBirth();
		randomEmail();
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		registerBtn.click();
	}
		
	
	// method for random email
	public void randomEmail() {
		Random randomEmail = new Random ();
		int randomInt = randomEmail.nextInt(100);
		emailField.sendKeys("dimitar"+randomInt+"@test.com");
	}
	// method for random day of Birth
	public void randomDaYOfBirth () {
		dayOfBirth.click();
		Select s = new Select(dayOfBirth);
		int randomDate = driver.findElements(By.xpath("//select[@name=\"DateOfBirthDay\"]/option[not(position()=0)]")).size();
		Random random = new Random ();
		int index = random.nextInt(randomDate);
		s.selectByIndex(index);
		
		}
	// method for random Month of Birth
	public void randomMonthOfBirth () {
		MonthOfBirth.click();
		Select s = new Select(MonthOfBirth);
		int randomMonth = driver.findElements(By.xpath("//select[@name=\"DateOfBirthMonth\"]/option[not(position()=1)]")).size();
		Random random = new Random ();
		int index = random.nextInt(randomMonth);
		s.selectByIndex(index);
		}
	// method for random Year of Birth
	public void randomYearOfBirth () {
		yearOfBirth.click();
		Select s = new Select(yearOfBirth);
		int randomYear = driver.findElements(By.xpath("//select[@name=\"DateOfBirthYear\"]/option[not(position()=1)]")).size();
		Random random = new Random ();
		int index = random.nextInt(randomYear);
		s.selectByIndex(index);
		}
	// user should be registered with only mandatory fields and email should be random
	//check if the user is logged in automatically, if not logged in automatically then log them in
	public void registerMandatroyFieldsWithRandomEmailAndLogin (String name,String lastname,String password, String confirmpassword)  {
		firstnameField.sendKeys(name);
		lastnameField.sendKeys(lastname);
		randomEmail();
		String text = emailField.getAttribute("value");
		passwordField.sendKeys(password);
		confirmpasswordField.sendKeys(confirmpassword);
		registerBtn.click();
		verifyThatUserIsRegister();
		if (loginIcon.isDisplayed()) {
			loginIcon.click();
			lp.loginUser(text, td.validPassword);
			
		
		} else {
			System.out.println("User is automatically login");
		}
		
	
		
	}
	// verify that user is registed
	public void verifyThatUserIsRegister() {
		String message = driver.findElement(By.xpath("//div/div[@class=\"result\"]")).getText();
		Assert.assertTrue(message.contains("Your registration completed"));
	}
	// verify that user is not registed
	public void verifyThatUserIsNotRegister() {
		Assert.assertEquals(driver.getTitle(), td.registerpage);
	}
	
	
	
}
