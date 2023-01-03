package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.CommonObjects;
import pageObjects.HomePageObjects;
import pageObjects.PLPPageObjects;

public class PLP extends Base {
	HomePageObjects hp;
	PLPPageObjects plp;
	Testdata td;
	CommonObjects cm;
	
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		td = new Testdata();
		cm = new CommonObjects();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	//TC_4 PLP
	//Verify the sorting and displaying option on the product page is working correctly
	@Test
	public void verifyTheSortingAndDisplayingOptionOnTheProductPageIsWorkingCorrectly()  {
		hp.navigateToComputers();		// navigate to computers
		plp.sortingDisplayingViewList();	// sort by: Price: High to Low,Display: 3 per page ,display by list
		plp.verifySortingandDisplayingWorking(); //verify that 3 products displayed per page
	}
	//TC_1 PLP
	//Confirm that HP Notebook can be found in computers category and notebooks sub-category. 
	@Test
	public void ConfirmHPNotebookAndBeFoundInComputersCategoryAndNotebooksSubCategory() {
		hp.navigateToComputers();	// navigate to computers
		plp.confirmHPNotebook();	// navigate to notebook and navigate to HP Envy
		plp.verifyHPIsDysplayed();	// verify that HP Envy is displayed
		
	}
	//TC_7
	//Verify Add to wish list should work properly
	@Test
	public void verifyAddToWishWistShouldWorkProperly(){
		hp.naviagteToBooks(); // navigate to books
		plp.addToWishlistFirstPrizeBook();	// add to wishlist First Prize Book
		plp.verifyFirstPrizeIsAddedwishlist();	// verify that product is add to wishlist
	}
	
	//TC_9 and TC_10
	//Compare two products and Remove product from comparison page
	@Test
	public void compareTwoProducts() throws InterruptedException {
		hp.navigateToCellPhones(); //navigate to cell phones
		plp.compareHTConeMiniAndNokiaLumia();	// add to compare products htc one mini and nokia lumia
		plp.verifyThatProductsAreAddedComparePage();	// verify that products are displayed id compare page
		plp.removeProductFromComparePage();	// remove product from comparison page
		cm.verifyThatPageContainsText("You have no items to compare.");		// verify that user have no items to compare
	}
}
