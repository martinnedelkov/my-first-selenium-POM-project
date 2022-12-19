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
	 @Test
	 public void loginWithValidCridentials () {
		 hp.navigateToLoginPage();
		 lp.loginUser(td.validEmail, td.validPassword);
		 lp.verifyUserIsLogin();
	 }
	 @Test
	 public void loginWithEmptyPassword() {
		 hp.navigateToLoginPage();
		 lp.loginUser(td.validEmail, "");
		 lp.verifyUserIsNotLogin();
	 }
	 @Test
	 
	 public void scrollMethod() throws InterruptedException {
		 hp.navigateToLoginPage();
		 lp.scrollToLoginBtn();;
	 }
}
