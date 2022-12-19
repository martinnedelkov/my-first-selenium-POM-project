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
	 @Test
	 public void userCantSearchWithLessThen2characters() {
		 hp.searchItem("hp");
		 hp.verifyThatUserCantSearchWith2Characters();
	 }
   @Test
   public void nonExistProducts() {
	   hp.searchItem("sony");
	   hp.verifyThatProductNotExist();
   }
   @Test
   public void searchValidatio() {
	   hp.searchItem(td.searchNIKE);
	   hp.verifySearchValidation();
   }
   
}
