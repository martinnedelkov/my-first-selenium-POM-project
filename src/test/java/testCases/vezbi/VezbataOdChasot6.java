package testCases.vezbi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VezbataOdChasot6 {
	
	//ja zavrsiv na chas
	
	WebDriver driver;
	
	String url = "http://uitestingplayground.com/dynamictable";
	String browser = "chrome";
	
	@BeforeMethod
	public void testSetup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	@Test
	public void vezbaa() {
	String cpuChrome = driver.findElement(By.xpath("//*[contains(text(),'Chrome')]//following-sibling::span[contains(text(),'%')]")).getText();
	String  actCu = driver.findElement(By.xpath("//p[@class=\"bg-warning\"]")).getText().replaceAll("Chrome CPU: ", "");
	Assert.assertEquals(cpuChrome, actCu);
	System.out.print("cpu tabela"+ cpuChrome);
	System.out.print("linija"+ actCu);
	
	
		
	}

}
