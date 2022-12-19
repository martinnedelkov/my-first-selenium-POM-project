package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	public String homeURL ="https://demo.nopcommerce.com/";
	
		public void openApp () {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(homeURL);
			driver.manage().window().maximize();
		}
	
}
