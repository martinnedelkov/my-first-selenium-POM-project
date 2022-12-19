package pageObjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base;

public class CommonObjects extends Base {

	
	public CommonObjects() {
		PageFactory.initElements(driver, this);
}
	public void hoverToElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	public void hoverToElementAndClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}
	public void navigateWithHover(WebElement ele, WebElement item) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		item.click();
	}
	
	public void waitForElementToBeClickable (WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void verifyThatPageContainsText(String t){
		assertTrue(driver.getPageSource().contains(t));
	}
	public void print(String text) {
		System.out.println(text);
	}
	public String fetchTextFromElement(WebElement ele) {
		return ele.getText();
	}
	public void waitForElementToBeVisible(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	public void scrollToElement(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	

	public void addToCardFromPDP() {
		driver.findElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]")).click();
	}
	
	}