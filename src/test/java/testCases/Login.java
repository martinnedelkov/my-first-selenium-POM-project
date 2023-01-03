package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;


public class Login extends Base {
	HomePageObjects hp;
	LoginPageObjects lp;
	Testdata td;
	 @BeforeMethod
	 public void start() {
		 openApp();
		 hp = new HomePageObjects();
		 lp = new LoginPageObjects();
		 td = new Testdata();
		 		 
	 }
	 @AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}
	 
	 // user should be able to login with valid credentials
	 @Test
	 public void loginWithValidCridentials () {
		 hp.navigateToLoginPage();      // navigate to login page
		 lp.loginUser(td.validEmail, td.validPassword);		// populated fields with valid credentials
		 lp.verifyUserIsLogin();		// verify that user successfully login
	 }
	 
	 // user should't be able to login with empty password field
	 @Test
	 public void loginWithEmptyPassword() {
		 hp.navigateToLoginPage(); 	// navigate to login page
		 lp.loginUser(td.validEmail, "");  // populated field for email and leave empty field for password
		 lp.verifyUserIsNotLogin();		// verify that user is not login
	 }
	 
	 //user should't be able to login with empty fields
	 @Test
	 public void loginWithEmptyFields () {
		 hp.navigateToLoginPage();	// navigate to login page
		 lp.loginUser("", "");	//leave the fields empty
		 lp.verifyUserIsNotLogin();	// verify that user is not login
	 }
	 
	 // user should't be able to login with empty email field
	 @Test
	 public void loginWithEmptyEmail () {
		 hp.navigateToLoginPage();	// navigate to login page
		 lp.loginUser("", td.validPassword);	// populated field for password and leave empty field for email
		 lp.verifyUserIsNotLogin();	// verify that user is not login
	 }
	 
	 //  scroll  practice
	// using Thread sleep to see that Scrolling is working
	 @Test
	 public void scrollMethod() throws InterruptedException {
		 hp.navigateToLoginPage(); 	// navigate to login page
		 lp.scrollToLoginBtn();;	// scroll to login button on login page
	 }
}
