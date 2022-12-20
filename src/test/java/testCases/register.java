package testCases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;
import pageObjects.RegisterPageObjects;

public class register extends Base {

	HomePageObjects hp;
	RegisterPageObjects rp;
	Testdata td;
	 @BeforeMethod
	 public void start() {
		 openApp();
		 hp = new HomePageObjects();
		 rp = new RegisterPageObjects();
		 td = new Testdata();
		 		 
	 }
	 @AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}
	 @Test
	 public void registerWithMandatoryFields () {
		 hp.navigateToRegisterPage();
		 rp.registerMandatroyFields(td.firstname, td.lastname, td.validEmail, td.validPassword, td.validPassword);
		 rp.verifyThatUserIsRegister();
	 }
	 @Test
	 public void registerAllFieldsAndDifferentPasswordAndConfrimPassword () {
		 hp.navigateToRegisterPage();
		 rp.registerWithFullFields(td.firstname, td.lastname, td.inValidEmail, td.companyName, td.validPassword, td.inValidPassword);
		 rp.verifyThatUserIsNotRegister();
	 }
	 @Test
	 public void registerWithRandomEmail() {
		 hp.navigateToRegisterPage();
		 rp.registerMandatroyFieldsWithRandomEmail(td.firstname, td.lastname, td.validPassword, td.validPassword);
		 rp.verifyThatUserIsRegister();
	 }
}
