package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;

public class PDP extends Base {
	HomePageObjects hp;
	LoginPageObjects lp;
	PLPPageObjects plp;
	PDPPageObjects pdp;
	Testdata td;
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		plp = new PLPPageObjects();
		pdp = new PDPPageObjects();
		td = new Testdata();
	}
		@AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}
		
		//TC_2
		@Test
		public void productReview () {
			hp.naviagteToElectronics();
			plp.navigateToCameraAndleica();
			pdp.productReview();
			pdp.productReviewAssertv();
		
		}
		
		@Test
		public void checkShareProductFunctionality() {
			hp.navigateToLoginPage();
			lp.loginUser(td.validEmail, td.validPassword);
			hp.naviagteToBooks();
			plp.navigateToPrideAndPrejudice();
			pdp.checkShareProductFunctionality(td.inValidEmail, "MnOGU UBA KNIga");
			pdp.checkShareProductAssert();
		}
}
