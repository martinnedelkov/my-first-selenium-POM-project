package testCases.vezbi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FollowingSteps {
	WebDriver driver;
	String url  = "http://uitestingplayground.com/ajax";
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
	public void followingSteps () {
		driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"]")).click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"bg-success\"]")));
		WebElement clickForNothing = driver.findElement(By.xpath("//p[@class=\"bg-success\"]"));
		clickForNothing.click();
		String text = driver.findElement(By.xpath("//p[@class=\"bg-success\"]")).getText();
		Assert.assertEquals(text, "Data loaded with AJAX get request.");
		
	}
}
