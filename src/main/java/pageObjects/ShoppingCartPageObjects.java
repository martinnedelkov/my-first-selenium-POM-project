package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class ShoppingCartPageObjects extends Base {
	
	@FindBy(xpath = "(//input[@type=\"text\"])[2]")
	WebElement quantityFieldShoppingCart;
	@FindBy(xpath = "//button[@class=\"remove-btn\"]")
	WebElement removeBtnShoppingCart;
	@FindBy(xpath = "//button[@id=\"updatecart\"]")
	WebElement updateBtnShoppingCart;
	@FindBy (xpath = "//button[@name=\"continueshopping\"]")
	WebElement continueShoppingBtnShoppingCart;
	@FindBy(xpath = "//a[@id=\"open-estimate-shipping-popup\"]")
	WebElement estimateShippingBtnShoppingCart;
	@FindBy(xpath = "//select[@name=\"checkout_attribute_1\"]/option[1]")
	WebElement giftWrappingNo;
	@FindBy(xpath = "//select[@name=\"checkout_attribute_1\"]/option[2]")
	WebElement giftWrappingYes;
	@FindBy(xpath = "//input[@name=\"discountcouponcode\"]")
	WebElement discoundCodeField;
	@FindBy(xpath = "//input[@name=\"giftcardcouponcode\"]")
	WebElement giftCardCodeField;
	@FindBy(xpath = "//button[@name=\"applydiscountcouponcode\"]")
	WebElement applyCouponBtn;
	@FindBy(xpath = "//button[@name=\"applygiftcardcouponcode\"]")
	WebElement applyGiftCardBtn;
	@FindBy(xpath = "//input[@id=\"termsofservice\"]")
	WebElement checkboxAgreeWithTermsOfService;
	@FindBy(xpath = "//a[@id=\"read-terms\"]")
	WebElement readTermsOfService;
	@FindBy(xpath = "//button[@name=\"checkout\"]")
	WebElement checkOutBtn;
	
	@FindBy(xpath = "//span[@class=\"product-subtotal\"]")
	WebElement totalPriceShoppingCart;
	@FindBy (xpath = "//span[@class=\"sku-number\"]")
	WebElement skuNikeTailwindOnShoppingCart;
	
	@FindBy(xpath = "(//span[@class=\"sku-number\"])[1]")
	WebElement nokiaLumiaSku;
	@FindBy(xpath = "(//span[@class=\"sku-number\"])[2]")
	WebElement htcOneMiniSku;
	
	@FindBy (xpath = "//span[@class=\"sku-number\"]")
	WebElement hpSpectrexTSku;
	
	public ShoppingCartPageObjects () {
		PageFactory.initElements(driver, this);
	}
	public void continueToCheckout() {
		checkboxAgreeWithTermsOfService.click();
		checkOutBtn.click();
	}
	public void levis511ChangeQuantity3 () {
		quantityFieldShoppingCart.clear();
		quantityFieldShoppingCart.sendKeys("3");
		updateBtnShoppingCart.click();
	}
	public void levis511ChangeQuantity7 () {
		quantityFieldShoppingCart.clear();
		quantityFieldShoppingCart.sendKeys("7");
		updateBtnShoppingCart.click();
	}
	public void levis511ChangeQuantity10 () {
		quantityFieldShoppingCart.clear();
		quantityFieldShoppingCart.sendKeys("10");
		updateBtnShoppingCart.click();
	}
	//vezba od chasot
	public String nikeTaildwingskuFromSC() {
		return skuNikeTailwindOnShoppingCart.getText();
	}
	
	public String nokiaLumiaSkuSC() {
		return nokiaLumiaSku.getText();
	}
	public String htcOneMiniSkuSC() {
		return htcOneMiniSku.getText();
	}
	public String hpSpectreSkuSC() {
		return hpSpectrexTSku.getText();
	}
	// levis511Asserts
	
	 public void levis511checkIfThePriceChangesAccordingtheDiscount3() {
			String priceof1Product = driver.findElement(By.xpath("//span[@class=\"product-unit-price\"]")).getText();
			priceof1Product = priceof1Product.replaceAll("[$-,-.]", "");
			int priceOf1ProductINT = Integer.parseInt(priceof1Product) ;
			WebElement msg = quantityFieldShoppingCart;
			 String text = msg.getAttribute("value");
			 int q = Integer.parseInt(text);
		
			if (q <= 2) {
				
				Assert.assertEquals(priceOf1ProductINT, 4350);
			} else if (q <= 5) {
				Assert.assertEquals(priceOf1ProductINT, 4000);
			}
			else if (q <= 9) {
				Assert.assertEquals(priceOf1ProductINT, 3800);
			}
			else if (q <= 10) {
				Assert.assertEquals(priceOf1ProductINT, 3500);
			}
	 }
	 

}
