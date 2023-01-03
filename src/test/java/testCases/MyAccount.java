package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.CheckoutPageObjects;
import pageObjects.CommonObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.MyAccountPageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;
import pageObjects.RegisterPageObjects;
import pageObjects.ShoppingCartPageObjects;

public class MyAccount extends Base {
	MyAccountPageObjects myacc;
	HomePageObjects hp;
	LoginPageObjects lp;
	PLPPageObjects plp;
	PDPPageObjects pdp;
	CommonObjects cm;
	RegisterPageObjects rp;
	ShoppingCartPageObjects sc;
	CheckoutPageObjects co;
	Testdata td;
	@BeforeMethod
	public void start() {
		openApp();
		myacc = new MyAccountPageObjects();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		plp = new PLPPageObjects();
		pdp = new PDPPageObjects();
		rp = new RegisterPageObjects();
		sc = new ShoppingCartPageObjects();
		cm = new CommonObjects();
		co = new CheckoutPageObjects();
		td = new Testdata();
	}
	@AfterMethod
	public void exit() {
		driver.quit();
	}
	// register with random email, change email with new email, verify that email is changed, logout and login with new email, verify that user is login 
	@Test
	public void changeAemailAdress () throws InterruptedException {
		hp.navigateToRegisterPage();	// navigate to registerPage
		rp.registerMandatroyFieldsWithRandomEmailAndLogin(td.firstname, td.lastname, td.validPassword, td.validPassword);	//register with random email
		hp.navigateToMyAcc();	// navigate to my acc page
		myacc.changeEmail(td.validEmail3);	// change a email with new emai
		myacc.verifyThatCustomerInfoUpdate();	// verify that customer info has been updated successfully
		myacc.closeGreenTopMessage();	// close the green message for customer info  updated successfully
		cm.theardSleepInSeconds(1);	// must use theard sleep, because user cant logout
		hp.logout();	// logout user and navigate to home page
		hp.navigateToLoginPage();	//navigate to login page
		lp.loginUser(td.validEmail, td.validPassword);	// login with new email and password
		lp.verifyUserIsLogin();	// verify that user is login
	}
	//TC05
	//Check if orders are listed in my account - orders section
	@Test
	public void checkIfOrdersAreListedInMyaccOrdersSection () {
		hp.navigateToRegisterPage(); // navigate to register page
		rp.registerMandatroyFieldsWithRandomEmailAndLogin(td.firstname, td.lastname, td.validPassword, td.validPassword); // register with random Email and login
		hp.navigateToNoteBooks();	// navigate to notebooks
		plp.navigateToHPSpectreXTPDP();	// navigate to Hp spectre Xt PDP
		String hpSpecteSkuFromPDP = pdp.hpSpectreXtSKUPDP();	// taking a sku Hp spectre Xt from pdp
		cm.addToCardFromPDP();	// add to cart Hp spectre Xt
		hp.navigateToShoppingCart();	// navigate to shopping cart
		String hpSpectreSkuFromSC = sc.skuForOnlyOneProductInSC(); // taking a sku Hp spectre Xt from shopping cart
		Assert.assertEquals(hpSpecteSkuFromPDP, hpSpectreSkuFromSC);	// verify that sku from pdp and sc
		sc.continueToCheckout();	// select terms and service and continue to checkout
		co.billdingAddress();	// build a address with populated mandatory fields and navigate to shipping method
		co.shippingMethodNextDay();	//shipping method: next day delivery and navigate to payment method
		co.paymentMethodByCard();	// payment method: pay by credit card and navigate to payment information
		co.paymentInfoVallid(); // payment information: enter a valid credentials and navigate to confrim order
		co.confirmORder(); // confirm order
		co.assertCheckOut(); // verify that order has been successfully processed!
		co.continueToHomePageAfterAssertCheckout(); // navigate to homepage
		hp.navigateToMyAcc();	// navigate to my acc page
		myacc.navigateToOrdersSection();	// navigate to orders list page
		cm.verifyThatPageContainsText("Order Number:");	// verify that order is displayed
	}
	//TC10
	//Change the old password from My acount - Change password section
	@Test
	public void changePassWithNewPass() {
		hp.navigateToRegisterPage();	// navigate to registerPage
		rp.registerMandatroyFieldsWithRandomEmailAndLogin(td.firstname, td.lastname, td.validPassword, td.validPassword);	//register with random email
		hp.navigateToMyAcc();	// navigate to my acc page
		myacc.navigateToChangePass();	// navigate to changes in password
		myacc.changePassword(td.validPassword, "novpass", "novpass");	// change the old password with new password
		myacc.verifyThatPassIsChanged(); // verify that password is changed
	}
	//TC12
	//Change the password from My acount - Change password section with previously older password
	// taking a screenshot from errormsg
	@Test
	public void changePassWithNewAndChangeAgainWithPreviously() throws InterruptedException, IOException {
		hp.navigateToRegisterPage();	// navigate to registerPage
		rp.registerMandatroyFieldsAndLoginUser("david", "lucas", td.validEmail4, "lucas123", "lucas123");
		hp.navigateToMyAcc();	// navigate to my acc page
		myacc.navigateToChangePass();	// navigate to changes in password
		myacc.changePassword("lucas123", td.validPassword, td.validPassword);	// change the old password with new password
		myacc.verifyThatPassIsChanged(); // verify that password is changed
		myacc.closeGreenTopMessage();	// close the green message
		cm.theardSleepInSeconds(1);	// must use theard sleep, because user cant logout
		hp.logout();	// logout user and navigate to home pag
		hp.navigateToLoginPage();	// navigate to loginpage	
		lp.loginUser(td.validEmail4, td.validPassword);	// login with new password
		hp.navigateToMyAcc();	// navigate to my acc page
		myacc.navigateToChangePass();	// navigate to changes in password
		myacc.changePassword(td.validPassword, "lucas123", "lucas123");	//change the new password with previous old password
		myacc.errorMessagePassword();	//verify that password is the same as one of the last passwords you used
		myacc.takingScreenShotFromErrorMsg();	// taking a screenshot form error msg
		
	}
}
