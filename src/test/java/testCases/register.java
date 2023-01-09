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
	 
	// user is successful registered with populate only  mandatory fields ( assert is inside in the rp.registerMandatoryFieldAndLoginUser method)
	 @Test
	 public void registerWithMandatoryFields () {
		 hp.navigateToRegisterPage();			// user  navigated to register page
		 rp.registerMandatroyFieldsAndLoginUser(td.firstname, td.lastname, td.validEmail, td.validPassword, td.validPassword);	// user popualted only mandatory fields and verify that user is successfully register and login
	 }
	 
	 
	//user populate all fields and not successfully registered because password and confirm password fields do not match
	 @Test
	 public void registerAllFieldsAndDifferentPasswordAndConfrimPassword () {
		 hp.navigateToRegisterPage(); // user  navigated to register page
		 rp.registerWithFullFieldsAndLogin(td.firstname, td.lastname, td.inValidEmail, td.companyName, td.validPassword, td.inValidPassword); // user populated all fields
		 rp.verifyThatUserIsNotRegister(); // verify that user is not successfully registed
	 }
	 
	// user is successful registered with entering a random email and populate others  mandatory fields ( assert is inside in the rp.registerMandatoryFieldWithRandomEmailAndLogin method)
	 @Test
	 public void registerWithRandomEmail() {
		 hp.navigateToRegisterPage(); // user  navigated to register page
		 rp.registerMandatroyFieldsWithRandomEmailAndLogin(td.firstname, td.lastname, td.validPassword, td.validPassword); //  user popualted only mandatory fields and email is random , verify that user is successfully register and login
	 }
	 
	// user populated fields and leave mandatory fields empty ,user  it's not successfully registered
	 @Test
	 public void registerWithEmptyFields () {
		 hp.navigateToRegisterPage();	// user  navigated to register page
		 rp.registerWithFullFieldsAndLogin("", "", "", "", "", "");	//// populated fields and leave mandatory fields empty
		 rp.verifyThatUserIsNotRegister();	// verify that user is not successfully registed
		
	 }
	 //  user is successful registered with entering a random email, random Date Of Birth and populate others  mandatory fields
	 @Test
	 public void registerWithRandomEmailAndRandomDateOfBirth() {
		 hp.navigateToRegisterPage();	// navigate to register page
		 rp.registerWithRandomEmailRandomDateOfBirth("pece", "randomot", "123456", "123456");	// populated mandatory fields with random email and selec random Date of Birth
		 rp.verifyThatUserIsRegister();	// verify that user is successfully registed
	 }
	 
}
