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

public class AllBtnClicked {
	WebDriver driver;
	String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html";
	String browser = "Chrome";
	@BeforeMethod 
	public void startingSetup() {
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
	public void allBtnClicked () {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id=\"button00\"]")));
		WebElement btnStar = driver.findElement(By.xpath("//button[@id=\"button00\"]"));
		btnStar.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"button01\"]")));
		WebElement btn1= driver.findElement(By.xpath("//button[@id=\"button01\"]"));
		btn1.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"button02\"]")));
		WebElement btn2 = driver.findElement(By.xpath("//button[@id=\"button02\"]"));
		btn2.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id=\"button03\"]")));
		WebElement btn3 = driver.findElement(By.xpath("//button[@id=\"button03\"]"));
		btn3.click();
		String actRes = driver.findElement(By.xpath("//p[@id=\"buttonmessage\"]")).getText();
		Assert.assertEquals(actRes, "All Buttons Clicked");
		
	}
}
