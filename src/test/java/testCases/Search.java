package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;


public class Search extends Base{
	
	HomePageObjects hp;
	Testdata td;
	 @BeforeMethod
	 public void start() {
		 openApp();
		 hp = new HomePageObjects();
		 td = new Testdata();
	 }
	 @AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}
	 
	 // user should be able to search with minimum 3 characters
	 @Test
	 public void userCantSearchWithLessThen2characters() {
		 hp.searchItem("hp");		// populate search field with 2 characters
		 hp.verifyThatUserCantSearchWith2Characters();		//verify that user cannot search with 2 characters
	 }
	 
	 // user cannot search non exist product on the website
   @Test
   public void nonExistProducts() {
	   hp.searchItem("sony"); 	//populate search field with non exist product on the website
	   hp.verifyThatProductNotExist();		//verify that user cannot search non exist product on the website
   }
   
   // user  search nike product,  and make validation on the products (validation)
   @Test
   public void searchValidatio() {
	   hp.searchItem(td.searchNIKE); 	// populate the search field with Nike
	   hp.verifySearchValidation();		//verify that all displayed product are nike 
   }
   
   // user cannot search with empty search field (alert)
   @Test
   public void userCantSearchWithEmptySearchField () {
	   hp.searchItem("");		// search with empty search field
	   hp.verifyThatUserCantSearchWithEmptySearchField();		//verify that user cannot search with empty search field (verify text from alert message)
   }
   
}
