package testCases.vezbi;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alerts {
WebDriver driver;
	
	String url = "https://the-internet.herokuapp.com/javascript_alerts";
	String browser = "chrome";
	
	@BeforeMethod
	public void testSetup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	@Test
	
	public void jsAlert() {
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Alert')]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		String actRes = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertTrue(actRes.contains("You successfully clicked an alert"));
				
		
		
	}
	@Test
	
	public void jsConfirm() {
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]")).click();
		Alert a = driver.switchTo().alert();
		a.accept();
		String actRes = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertTrue(actRes.contains("You clicked: Ok"));
				
		
		
	}
	@Test
	public void jsConfirmClickCancel() {
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Confirm')]")).click();
		Alert a = driver.switchTo().alert();
		a.dismiss();
		String actRes = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertTrue(actRes.contains("You clicked: Cancel"));
				
		
		
	}
	@Test
	
	public void jsPrompt() {
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]")).click();
		Alert a = driver.switchTo().alert();
		a.sendKeys("pece");
		a.accept();
		String actRes = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertTrue(actRes.contains("pece"));
				
		
		
	}
	@Test
	public void jsPromptClickCancel() {
		driver.findElement(By.xpath("//*[contains(text(),'Click for JS Prompt')]")).click();
		Alert a = driver.switchTo().alert();
		a.dismiss();
		String actRes = driver.findElement(By.xpath("//p[@id=\"result\"]")).getText();
		Assert.assertTrue(actRes.contains("You entered: null"));
				
		
		
	}
}
