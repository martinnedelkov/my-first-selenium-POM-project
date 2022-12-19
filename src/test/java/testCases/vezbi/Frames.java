package testCases.vezbi;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {
	WebDriver driver;
	
	String url = "https://testpages.herokuapp.com/styled/frames/frames-test.html";
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
	public void framesTable() {
		driver.switchTo().frame(driver.findElement(By.name("left")));
		WebElement leftdown = driver.findElement(By.xpath("//li[@id=\"left29\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", leftdown);
		String txtleft = leftdown.getText();
		//System.out.print(txtleft);
		Assert.assertTrue(txtleft.contains("Left List Item 29"));
		driver.switchTo().parentFrame();
		driver.switchTo().frame("middle");
		WebElement middledown = driver.findElement(By.xpath("//li[@id=\"middle39\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", middledown);
		String middletxt= middledown.getText();
		//System.out.print(middletxt);
		Assert.assertTrue(middletxt.contains("Middle List Item 39"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("right");
		WebElement rightdown = driver.findElement(By.xpath("//li[@id=\"right49\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", rightdown);
		String righttxt = rightdown.getText();
		//System.out.print(righttxt);
		Assert.assertTrue(righttxt.contains("Right List Item 49"));
		
		
		
	}
	@Test
	public void frameToFrame() {
	
		driver.switchTo().frame("top");
		String toptxt = driver.findElement(By.xpath("//body/div/div[@class=\"explanation\"]/p")).getText();
		//System.out.print(toptxt);
		Assert.assertTrue(toptxt.contains("Framesets"));
		driver.switchTo().parentFrame();
		driver.switchTo().frame("middle");
		String middletxt = driver.findElement(By.xpath("//body/ul/li[@id=\"middle0\"]")).getText();
		//System.out.print(middletxt);
		Assert.assertTrue(middletxt.contains("0"));
		driver.switchTo().defaultContent();
		driver.switchTo().frame("footer");
		String footertxt = driver.findElement(By.xpath("//body/div/div[@class=\"page-footer\"]/p")).getText();
		//System.out.print(footertxt);
		Assert.assertTrue(footertxt.contains(".com"));
	}
}
