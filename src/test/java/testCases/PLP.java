package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;
import pageObjects.PLPPageObjects;

public class PLP extends Base {
	HomePageObjects hp;
	PLPPageObjects plp;
	Testdata td;
	
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		td = new Testdata();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	//TC_4 PLP
	@Test
	public void verifyTheSortingAndDisplayingOptionOnTheProductPageIsWorkingCorrectly() throws InterruptedException {
		hp.navigateToComputers();
		plp.verifyTheSortingAndDisplaying();
		plp.verifySortingandDisplayingWorking();
	}
	//TC_1 PLP
	@Test
	public void ConfirmHPNotebookAndBeFoundInComputersCategoryAndNotebooksSubCategory() {
		hp.navigateToComputers();
		plp.confirmHPNotebook();
		plp.verifyHPIsDysplayed();
		
	}
	//TC_7
	@Test
	public void verifyAddToWishWistShouldWorkProperly() throws InterruptedException {
		hp.naviagteToBooks();
		plp.verifyAddToWishlist();
		plp.verifyFirstPrizewishlist();
	}
}
