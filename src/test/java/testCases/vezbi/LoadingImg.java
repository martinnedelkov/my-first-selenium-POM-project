package testCases.vezbi;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoadingImg {
	
	WebDriver driver;
	String url = "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
	String browser = "Chrome";
	@BeforeMethod
	public void startSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void exitSetup() {
		driver.quit();
	}
	@Test
	
	public void loadingImgAndeGetText () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@id=\"landscape\"]")));
		String text = driver.findElement(By.xpath("//div/p[@id=\"text\"]")).getText();
		Assert.assertEquals(text, "Done!");
		
	}

}
