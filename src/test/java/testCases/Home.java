package testCases;

import java.io.IOException;

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
	
	
	// scroll  practice
	// using Thread sleep to see that Scrolling is working properly
	@Test
	public void scrollVoteBtn() throws InterruptedException {
		hp.scrollToVoteBtn();		// srcoll to vote button on home page
	}
	
	// scroll to Twitter, navigate , open New tab and close the tab 
	@Test
	public void scrollToTwiterNavigateAtoNewTab() {
		hp.navigateToTwitter();    // scroll to Twitter, navigate in new tab and close the tab
		hp.assertNewWindowTab();	//verify that new tab is open  and then closed (verify that user is on first tab)
	}
	
	//screenshot pratice
	//taking a screenshot from follow us icons on homepage (screenshot will be save in the folder screenshot)
	@Test
	public void screenShotOfFollowUsIcons () throws IOException {
		hp.takingAscreenShot();		// taking a screenshot from follow us icons on homepage
	}
	
	//Screen Video Recording practice
	//hover on computers,electronics,apparel,  and make a video of the test(video will be save in the folder test-recordings)
	@Test
	public void screenVideoRecording () throws Exception {
		hp.screenVideoRecording();		//hover on computers,electronics,apparel,scroll to follow us icons  and make a video of the test
	}
	
}
