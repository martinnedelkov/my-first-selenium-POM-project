package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import pageObjects.HomePageObjects;

public class Home extends Base {
	HomePageObjects hp;
	@BeforeMethod
	 public void start() {
		 openApp();
		 hp = new HomePageObjects();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		}
	@Test
	public void scrollVoteBtn() throws InterruptedException {
		hp.scrollToVoteBtn();
	}
	@Test
	public void scrollToTwiterNavigateAtoNewTab() {
		hp.navigateToTwitter();
		hp.assertNewWindowTab();
	}
}
