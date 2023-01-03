package testCases;




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
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;
import pageObjects.RegisterPageObjects;
import pageObjects.ScreenRecorderUtil;
import pageObjects.ShoppingCartPageObjects;

public class EndToEnd extends Base {
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
	
	// user is register, shopping more then 2 product (verify shopping cart SKU with SKU PDP) continue to checkout and pay with Card(assert that order is completed)
	@Test
	public void userIsRegisterShoppingAndCheckout() {
		hp.navigateToRegisterPage(); // navigate to register page
		rp.registerMandatroyFieldsAndLoginUser(td.firstname, td.lastname, td.validEmail2, td.validPassword, td.validPassword);	// register with random Email and login
		hp.navigateToClothingWithHover(); // navigate to clothing
		plp.navigateToNikeTailWingPDP();	// navigate to nike tailwing pdp
		String nikeTaildwingSkuPDP = pdp.nikeTaildWindSkuPDP();	// taking a sku from pdp
		pdp.nikeTailwind3xSize4Quantity();	// add to cart nike tailwing size 3x quantity 4
		hp.navigateToCameraAndPhoto();	// navigate to camera and photo
		plp.leicaTAddToCard();	// add to cart leica t mirroless
		hp.navigateToShoppingCart();	// navigate to shopping cart
		String nikeTaildWingSkuSC = sc.nikeTaildwingskuFromSC();	// takig a sku from sc
		Assert.assertEquals(nikeTaildwingSkuPDP, nikeTaildWingSkuSC);	// verify sku from pdp and sc
		sc.continueToCheckout();	// select terms and service and continue to checkout
		co.billdingAddress();	// build a address with populated mandatory fields and navigate to shipping method
		co.shippingMethodNextDay();	//shipping method: next day delivery and navigate to payment method
		co.paymentMethodByCard();	// payment method: pay by credit card and navigate to payment information
		co.paymentInfoVallid(); // payment information: enter a valid credentials and navigate to confrim order
		co.confirmORder(); // confirm order
		co.assertCheckOut(); // verify that order has been successfully processed!
		co.continueToHomePageAfterAssertCheckout(); // navigate to homepage
		
	}
	
	// user search product,add to cart product, scroll to other product, add to cart other product, verify SKU in shopping cart, checkout like a guest and pay with check , verify confirm order
	@Test
	public void searchProdoctChekOutLikeAQuest() {
		hp.searchItem("nokia");		// populated a search field with nokia
		plp.navigateToNokiaLumiaPDP();	// navigate to nokia lumia pdp
		String nokiaLumiaSkuPDP = pdp.skuFromPDP();	//taking a sku from PDP
		cm.addToCardFromPDP();	// add to cart nokia lumia
		pdp.scrollToHtcMiniForEndToEnd();	// scroll down to htc one mini and navigate to PDP
		String htcOneMiniSkuPDP = pdp.skuFromPDP();	//taking a sku from PDP
		cm.addToCardFromPDP();	// add to cart htc one mini
		hp.navigateToShoppingCart();	// navigate to shopping cart
		String nokiaLumiaSkuSC = sc.SkuFromfirstProductInTableSC();	//taking a sku from SC
		String htcOneMiniSkuSC = sc.SkuFromSecondProductInTableSC(); //taking a sku from SC
		Assert.assertEquals(nokiaLumiaSkuPDP, nokiaLumiaSkuSC);	// verify Sku from PDP and SC
		Assert.assertEquals(htcOneMiniSkuPDP, htcOneMiniSkuSC);	// verify Sku from PDP and SC
		sc.continueToCheckout();	// select terms and service and continue to checkout
		co.checkoutAsGuest();	// navigate to checkout as guest
		co.billdFullAddressForGuest();	// build a adres for a guest and navigate to shipping method
		co.shippingMethodNextDay();	//shipping method: next day delivery and navigate to payment method
		co.paymentMethodByCheckMoneyOrder();	// payment mehtod:by check money order and navigate to confrim order
		co.confirmORder();	// confirm order
		co.assertCheckOut();	// verify that order has been successfully processed!
		co.continueToHomePageAfterAssertCheckout();	// navigate to homepage
	
	}
	
	// user register with random email,(verify that user is registed), shopping (verify SKU from SC and PDP), checkout(verify confirm order), open newTab to print the order list and close the Tab for print
	@Test
	public void registerWithRandomUserShoppingPrintDocInNewTab ()  {
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
		co.shippingMethodNextDay(); //shipping method: next day delivery and navigate to payment method
		co.paymentMethodByCard();	// payment method: pay by credit card and navigate to payment information
		co.paymentInfoVallid();	// payment information: enter a valid credentials and navigate to confrim order
		co.confirmORder();	// confrim order
		co.assertCheckOut();	// verify that order has been successfully processed!
		co.seeOrderDetails();	// navigate to order details
		co.navigateToNewTabToPrintDocument();	// navigate to print document with new window tab
		co.closeNewTabForPrintAndNavigateToFirstTab();	// close second(print) tab and navigate to first tab
		co.assertThetUserIsONOrderInformationPage();	// verify that user is on first tab
		
	}
	// Start video recording , user is registed with random Email, shopping, verify sku pdp with sku in Shopping cart, checkout pay with random credit card,download invoice, verify that pdf invoice file is downloaded and stop video
	@Test
	public void registerUserShoppingPayWithRandomCreditCartDownloadInvoiceVideo () throws Exception {
		ScreenRecorderUtil.startRecord("EndToEndTC");		// start video recording
		hp.navigateToRegisterPage();		// navigate to register page
		rp.registerMandatroyFieldsWithRandomEmailAndLogin(td.firstname, td.lastname, td.validPassword, td.validPassword);	// register with random Email and login
		hp.navigateToClothingWithHover();		// navigate to clothing
		plp.navigateToNikeTailWingPDP();	// navigate to Nike Tailwing PDP
		String SkuFromNikePDP = pdp.nikeTaildWindSkuPDP();	// taking a Sku from nike tailwing PDP
		pdp.nikeTailwind3xSize4Quantity();	// add to cart 4quantity with size 3x
		hp.searchItem("nokia");		// search for nokia products
		plp.navigateToNokiaLumiaPDP();	// navigate to nokia lumia pdp
		String nokiaLumiaSkuPDP = pdp.skuFromPDP();		// taking a sku from nokia lumia PDP
		cm.addToCardFromPDP();	// add to cart nokia lumia
		hp.navigateToShoppingCart();	// navigate to shopping cart
		String SkuNikeFromSC = sc.SkuFromfirstProductInTableSC();	// taking a sku from nike tailwing Shopping Cart
		String nokiaLumiaSkuSC = sc.SkuFromSecondProductInTableSC();	// taking a sku from nokia lumia Shopping Cart
		Assert.assertEquals(SkuFromNikePDP, SkuNikeFromSC);	// verify sku from nike PDP and SC
		Assert.assertEquals(nokiaLumiaSkuPDP, nokiaLumiaSkuSC); // verify sku from nokia PDP and SC
		sc.continueToCheckout();	// select terms and service and continue to checkout
		co.billdingAddress();		// build a address with populated mandatory fields and navigate to shipping method
		co.shippingMethodNextDay();	// shipping method: next day delivery and navigate to payment method
		co.paymentMethodByCard();	//payment method: pay by credit card and navigate to payment information
		co.paymentInfoVallidWithRandomCreditCard();	//payment information: pay with valid random credit card and other fields populated with valid credential navigate to confrim order
		co.confirmORder();	// confrim order
		co.assertCheckOut();	// verify that order has been successfully processed!
		co.seeOrderDetails();	// navigate to order details
		co.downloadPdfInvoice();	// download pdf invoice
		cm.theardSleepInSeconds(3);	// use  theardsleep  to wait  finishing downloading
		cm.verifyThatFileIsDownloaded("order");	// verify that file is downloaded (if file is downloaded successfully ,user can read in console: File is downloaded)
		ScreenRecorderUtil.stopRecord();	// stop video recording

		
		
		
	}
}

