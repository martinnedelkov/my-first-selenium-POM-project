package pageObjects;



import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Base.Base;
import TestData.Testdata;

public class CheckoutPageObjects extends Base{
	Testdata td = new Testdata();
	CommonObjects cm = new CommonObjects();
	
	@FindBy(xpath = "//button[@class=\"button-1 checkout-as-guest-button\"]")
	WebElement checkoutAsGuestBtn;
	@FindBy(xpath = "//select[@data-trigger=\"country-select\"]/option[2]")
	WebElement countryUSA;
	@FindBy(xpath = "//input[@data-val-required=\"First name is required.\"]")
	WebElement firsnameField;
	@FindBy(xpath = "//input[@data-val-required=\"Last name is required.\"]")
	WebElement lastnameField;
	@FindBy(xpath = "//input[@data-val-required=\"Email is required.\"]")
	WebElement emailField;
	@FindBy(xpath  = "//input[@name=\"BillingNewAddress.City\"]")
	WebElement cityField;
	@FindBy(xpath  = "//select[@id=\"BillingNewAddress_StateProvinceId\"]/option[19]")
	WebElement stateFieldHawaii;	
	@FindBy(xpath  = "//input[@id=\"BillingNewAddress_Address1\"]")
	WebElement AddressField1;
	@FindBy(xpath  = "//input[@id=\"BillingNewAddress_ZipPostalCode\"]")
	WebElement zipCodeField;
	@FindBy(xpath  = "//input[@id=\"BillingNewAddress_PhoneNumber\"]")
	WebElement phoneNumberField;
	@FindBy(xpath  = "(//button[@name=\"save\"])[1]")
	WebElement continueBtnToShippingMethod;
	@FindBy(xpath  = "//input[@id=\"shippingoption_0\"]")
	WebElement groundShipping;
	@FindBy(xpath  = "//input[@id=\"shippingoption_1\"]")
	WebElement nextDayAirShipping;
	@FindBy(xpath  = "//input[@id=\"shippingoption_2\"]")
	WebElement twoDayAirShipping;
	@FindBy(xpath  = "//button[@class=\"button-1 shipping-method-next-step-button\"]")
	WebElement continueBtnToPaymentMethod;
	@FindBy(xpath  = "//input[@id=\"paymentmethod_0\"]")
	WebElement checkMoneyOrderPaymentMethod;
	@FindBy(xpath  = "//input[@id=\"paymentmethod_1\"]")
	WebElement creditCardPaymenyMethod;
	@FindBy(xpath  = "//button[@class=\"button-1 payment-method-next-step-button\"]")
	WebElement continueBtnToPaymentInfo;
	@FindBy(xpath  = "//input[@id=\"CardholderName\"]")
	WebElement cardHolderNameField;
	@FindBy(xpath  = "//input[@id=\"CardNumber\"]")
	WebElement cardNumberFIeld;
	@FindBy(xpath  = "//select[@id=\"ExpireMonth\"]/option[1]")
	WebElement exparationMonth;
	@FindBy(xpath  = "//select[@id=\"ExpireYear\"]/option[1]")
	WebElement expiredCard;
	@FindBy(xpath  = "//select[@id=\"ExpireYear\"]/option[12]")
	WebElement exparationYearValid;
	@FindBy(xpath = "//input[@id=\"CardCode\"]")
	WebElement cardCode;
	@FindBy(xpath = "//button[@class=\"button-1 payment-info-next-step-button\"]")
	WebElement continueBtnToConfirmOrder;
	@FindBy(xpath = "//button[@class=\"button-1 confirm-order-next-step-button\"]")
	WebElement confirmBtnToOrderNumber;
	@FindBy(xpath = "//button[@class=\"button-1 order-completed-continue-button\"]")
	WebElement conntinueBtnToHomePage;
	@FindBy(xpath = "//button[@class=\"button-1 payment-info-next-step-button\"]")
	WebElement continueBtnFromCheckToConfrim;
	@FindBy(xpath = "//*[contains(text(),'details')]")
	WebElement orderDetailsBtn;
	@FindBy(xpath = "//a[@class=\"button-2 print-order-button\"]")
	WebElement printBtn;
	@FindBy(xpath = "//a[@class=\"button-2 pdf-invoice-button\"]")
	WebElement PdfInvoiceBtn;
	@FindBy(xpath = "//div[@class=\"message-error validation-summary-errors\"]")
	WebElement wrongCreditCard;
	
	
	
	
	
	public CheckoutPageObjects () {
		PageFactory.initElements(driver, this);
	}
	public void checkoutAsGuest() {
		checkoutAsGuestBtn.click();
	}
	public void selectCountry(String ValueOfCounrty) {
		WebElement country = driver.findElement(By.xpath("//select[@data-trigger=\"country-select\"]"));
		Select s = new Select(country);
		s.selectByValue(ValueOfCounrty);
				
	}

	public void billdFullAddressForGuest() {
		firsnameField.sendKeys(td.firstname);
		lastnameField.sendKeys(td.lastname);
		emailField.sendKeys(td.validEmail);
		selectCountry("11");
		cityField.sendKeys(td.city);
		AddressField1.sendKeys(td.address);
		zipCodeField.sendKeys(td.zipCode);
		phoneNumberField.sendKeys(td.phone);
		continueBtnToShippingMethod.click();
		
	}
	public void billdingAddress() {
		cm.waitForElementToBeClickable(continueBtnToShippingMethod);
		selectCountry("11");
		cityField.sendKeys(td.city);
		AddressField1.sendKeys(td.address);
		zipCodeField.sendKeys(td.zipCode);
		phoneNumberField.sendKeys(td.phone);
		continueBtnToShippingMethod.click();
	}
	public void shippingMethodNextDay() {
		cm.waitForElementToBeClickable(nextDayAirShipping);
		nextDayAirShipping.click();
		continueBtnToPaymentMethod.click();
	}
	public void paymentMethodByCard() {
		cm.waitForElementToBeClickable(creditCardPaymenyMethod);
		creditCardPaymenyMethod.click();
		continueBtnToPaymentInfo.click();
	}
	public void paymentMethodByCheckMoneyOrder() {
		cm.waitForElementToBeClickable(checkMoneyOrderPaymentMethod);
		checkMoneyOrderPaymentMethod.click();
		continueBtnToPaymentInfo.click();
		cm.waitForElementToBeClickable(continueBtnFromCheckToConfrim);
		continueBtnFromCheckToConfrim.click();
	}
	public void paymentInfoVallid() {
		cm.waitForElementToBeClickable(continueBtnToConfirmOrder);
		cardHolderNameField.sendKeys(td.firstname);
		cardNumberFIeld.sendKeys(td.validCredtCard);
		exparationMonth.click();
		exparationYearValid.click();
		cardCode.sendKeys(td.cardCode);
		continueBtnToConfirmOrder.click();
	}
	public void confirmORder() {
		cm.waitForElementToBeClickable(confirmBtnToOrderNumber);
		confirmBtnToOrderNumber.click();
	}
	public void seeOrderDetails() {
		cm.waitForElementToBeClickable(orderDetailsBtn);
		orderDetailsBtn.click();
	}
	public void navigateToNewTabToPrintDocument() {
		printBtn.click();
	}
	public void downloadPdfInvoice () {
		PdfInvoiceBtn.click();
	}
	public void closeNewTabForPrintAndNavigateToFirstTab () {
		List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(browserTabs .get(1));
    	driver.close();
    	driver.switchTo().window(browserTabs.get(0));
	}
	public void assertCheckOut() {
		cm.waitForElementToBeClickable(conntinueBtnToHomePage);
		String excMessage = driver.findElement(By.xpath("//*[contains(text(),'Your')]")).getText();
		Assert.assertTrue(excMessage.contains("Your order has been successfully processed!"));
		
	}
	public void continueToHomePageAfterAssertCheckout () {
		conntinueBtnToHomePage.click();
	}
	public void validRandomCreditCart () {
		  long min = 100000000000000000L;
		  long max = 999999999999999999L;	  
		  long random_int = (long)Math.floor(Math.random()*(max-min+1)+min);
		  cardNumberFIeld.sendKeys(""+random_int);
		  
	}
	public void paymentInfoVallidWithRandomCreditCard() throws InterruptedException {
		cm.waitForElementToBeClickable(continueBtnToConfirmOrder);
		cardHolderNameField.sendKeys(td.firstname);
		validRandomCreditCart();
		exparationMonth.click();
		exparationYearValid.click();
		cardCode.sendKeys(td.cardCode);
		continueBtnToConfirmOrder.click();
		cm.waitForElementToBeVisible(wrongCreditCard);
		while (wrongCreditCard.isDisplayed())  {
			  cardNumberFIeld.clear();
			  validRandomCreditCart();
			  continueBtnToConfirmOrder.click();
			  Thread.sleep(1000);
			 }
		  
	}
	
	public void assertThetUserIsONOrderInformationPage() {
		String excRes = driver.findElement(By.xpath("(//div/strong)[1]")).getText();
		Assert.assertTrue(excRes.contains("ORDER"));
	}
}
