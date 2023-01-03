package pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;
import TestData.Testdata;

public class MyAccountPageObjects extends Base {
	
	Testdata td = new Testdata();
	CommonObjects cm = new CommonObjects();
	
	@FindBy(xpath = "//input[@id=\"Email\"]")
	WebElement emailField;
	@FindBy(xpath = "//button[@id=\"save-info-button\"]")
	WebElement saveBtn;
	@FindBy(xpath = "//p[@class=\"content\"]")
	WebElement greenMsgUpdateInfo;
	@FindBy(xpath = "//span[@class=\"close\"]")
	WebElement closeGreenMessage;
	@FindBy(xpath = "(//a[@href=\"/order/history\"])[1]")
	WebElement ordersSection;
	@FindBy(xpath = "//a[@href=\"/customer/changepassword\"]")
	WebElement changePassword;
	@FindBy(xpath = "//input[@id=\"OldPassword\"]")
	WebElement oldPasswordField;
	@FindBy(xpath = "//input[@id=\"NewPassword\"]")
	WebElement newPasswordField;
	@FindBy(xpath = "//input[@id=\"ConfirmNewPassword\"]")
	WebElement confrimPasswordField;
	@FindBy(xpath = "//button[@class=\"button-1 change-password-button\"]")
	WebElement changePassBtn;
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement errorMessage;
	
	
	
	public MyAccountPageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	// change a email
	public void changeEmail(String NewEmail) {
		emailField.clear();
		emailField.sendKeys(NewEmail);
		saveBtn.click();
	}
	// verify that The customer info has been updated successfully
	public void verifyThatCustomerInfoUpdate() {
		cm.waitForElementToBeVisible(greenMsgUpdateInfo);
		Assert.assertTrue(greenMsgUpdateInfo.getText().contains("The customer info has been updated successfully."));
	}
	//green msg on top
	public void closeGreenTopMessage() {
		closeGreenMessage.click();
	}
	//navigate to Orders
	public void navigateToOrdersSection() {
		ordersSection.click();
	}
	//navigate to change password
	public void navigateToChangePass() {
		changePassword.click();
	}
	// change old  password  with new
	public void changePassword(String oldPass, String newPass , String ConfrimNewPass) {
		oldPasswordField.sendKeys(oldPass);
		newPasswordField.sendKeys(newPass);
		confrimPasswordField.sendKeys(ConfrimNewPass);
		changePassBtn.click();
	}
	// verify that password is changed
	public void verifyThatPassIsChanged() {
		cm.waitForElementToBeVisible(greenMsgUpdateInfo);
		cm.waitForElementToBeClickable(closeGreenMessage);
		Assert.assertTrue(greenMsgUpdateInfo.getText().contains("Password was changed"));
	}
	// error message for password
	public void errorMessagePassword() {
		Assert.assertTrue(errorMessage.getText().contains("You entered the password that is the same as one of the last passwords you used. Please create a new password."));
	}
	// taking a screenshot from error mesage for passwrod
	public void takingScreenShotFromErrorMsg() throws IOException {
		cm.takingAscreenShot(errorMessage, "errorMessagePasswordPreviously");
	}
}
