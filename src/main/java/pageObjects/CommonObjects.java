package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Base.Base;

public class CommonObjects extends Base {

	
	public CommonObjects() {
		PageFactory.initElements(driver, this);
}
	//hover on element
	public void hoverToElement(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
	}
	// hover on element and click
	public void hoverToElementAndClick(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).click().perform();
	}
	// navigate with hover
	public void navigateWithHover(WebElement ele, WebElement item) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();
		item.click();
	}
	// theard sleep
	public void theardSleepInSeconds (int sec) throws InterruptedException {
		sec= sec*1000;
		Thread.sleep(sec);
	}
	// wait implicity
	public void waitForseconds (int sec) {
		driver.manage().timeouts().implicitlyWait(sec,TimeUnit.SECONDS);
	}
	// wait until element is clickable
	public void waitForElementToBeClickable (WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.elementToBeClickable(ele));
	}
	// verify that page contains text
	public void verifyThatPageContainsText(String t){
		assertTrue(driver.getPageSource().contains(t));
	}
	// print in console
	public void print(String text) {
		System.out.println(text);
	}
	//fetch text from element
	public String fetchTextFromElement(WebElement ele) {
		return ele.getText();
	}
	// wait until element is visible
	public void waitForElementToBeVisible(WebElement ele) {
		WebDriverWait w = new WebDriverWait(driver,30);
		w.until(ExpectedConditions.visibilityOf(ele));
	}
	// scroll to element
	public void scrollToElement(WebElement ele) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	// add to cart from PDP
	public void addToCardFromPDP() {
		driver.findElement(By.xpath("//button[@class=\"button-1 add-to-cart-button\"]")).click();
	}
	// taking a screenshot
	public void takingAscreenShot (WebElement ele, String nameOfSC) throws IOException {
    	File sc =((TakesScreenshot)ele).getScreenshotAs(OutputType.FILE);
    	FileUtils.copyFile(sc, new File(".//screenshot//"+nameOfSC+".png"));
	
	}
	// verify that file is downloaded and if its true print in console
	public void verifyThatFileIsDownloaded (String nameOfFile) {
		File fileLocation = new File ("C:\\Users\\marti\\Downloads");
		File [] totalfiles = fileLocation.listFiles();
		for (File file : totalfiles) {
			if(file.getName().contains(nameOfFile)) {
				System.out.print("File is downloaded");
				break;
			}
		}
	}
	// verify that new window tab is open and close it
	public void verifyThatNewWindowTabIsOpenAndCloseIt(String newTabContains , String oldTabContains) {
    	List<String> browserTabs = new ArrayList<String> (driver.getWindowHandles());
    	driver.switchTo().window(browserTabs .get(1));
    	Assert.assertTrue(driver.getCurrentUrl().contains(newTabContains));
    	driver.close();
    	driver.switchTo().window(browserTabs.get(0));
    	Assert.assertTrue(driver.getCurrentUrl().contains(oldTabContains));
    }
	
}