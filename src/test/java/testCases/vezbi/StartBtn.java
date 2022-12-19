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

public class StartBtn {

	WebDriver driver;
	String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
	String browser = "Chrome";
	@BeforeMethod
	public void testSetup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void exitSetup () {
		driver.quit();
	}
	@Test
	public void findText () {
		driver.findElement(By.xpath("//button")).click();
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"finish\"]/h4")));
		String text = driver.findElement(By.xpath("//div[@id=\"finish\"]/h4")).getText();
		Assert.assertTrue(text.contains("Hello World!"));
		
	}
	
}
