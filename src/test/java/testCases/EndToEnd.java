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
	
	// user is register(verify that user is registed) shopping more then 2 product (verify shopping cart SKU with SKU PDP) continue to checkout and pay with Card(assert that order is completed)
	@Test
	public void userIsRegisterShoppingAndCheckout() {
		hp.navigateToRegisterPage();
		rp.registerMandatroyFields(td.firstname, td.lastname, td.validEmail, td.validPassword, td.validPassword);
		rp.verifyThatUserIsRegister();
		hp.navigateToClothingWithHover();
		plp.navigateToNikeTailWingPDP();
		String nikeTaildwingSkuPDP = pdp.nikeTaildWindSkuPDP();
		pdp.nikeTailwind3xSize4Quantity();
		hp.navigateToCameraAndPhoto();
		plp.leicaTAddToCard();
		hp.navigateToShoppingCart();
		String nikeTaildWingSkuSC = sc.nikeTaildwingskuFromSC();
		Assert.assertEquals(nikeTaildwingSkuPDP, nikeTaildWingSkuSC);
		sc.continueToCheckout();
		co.billdingAddress();
		co.shippingMethodNextDay();
		co.paymentMethodByCard();
		co.paymentInfoVallid();
		co.confirmORder();
		co.assertCheckOut();
		co.continueToHomePageAfterAssertCheckout();
		
	}
	
	// user search product add to cart scroll to other product add to cart verify SKU in shopping cart checkout like a guest and pay with check , verify confirm order
	@Test
	public void searchProdoctChekOutLikeAQuest() {
		hp.searchItem("nokia");
		plp.navigateToNokiaLumiaPDP();
		String nokiaLumiaSkuPDP = pdp.nokiaLumiaSKUPDP();
		cm.addToCardFromPDP();
		pdp.scrollToHtcMiniForEndToEnd();
		String htcOneMiniSkuPDP = pdp.htcOneMiniSKUPDP();
		cm.addToCardFromPDP();
		hp.navigateToShoppingCart();
		String nokiaLumiaSkuSC = sc.nokiaLumiaSkuSC();
		String htcOneMiniSkuSC = sc.htcOneMiniSkuSC();
		Assert.assertEquals(nokiaLumiaSkuPDP, nokiaLumiaSkuSC);
		Assert.assertEquals(htcOneMiniSkuPDP, htcOneMiniSkuSC);
		sc.continueToCheckout();
		co.checkoutAsGuest();
		co.billdFullAddressForGuest();
		co.shippingMethodNextDay();
		co.paymentMethodByCheckMoneyOrder();
		co.confirmORder();
		co.assertCheckOut();
		co.continueToHomePageAfterAssertCheckout();
	
	}
	
	// user register with random email,(verify that user is registed), shopping (verify SKU from SC and PDP), checkout(verify confirm order), open newTab to print the order list and close the Tab for print
	@Test
	public void registerWithRandomUserShoppingPrintDocInNewTab () {
		hp.navigateToRegisterPage();
		rp.registerMandatroyFieldsWithRandomEmail(td.firstname, td.lastname, td.validPassword, td.validPassword);
		rp.verifyThatUserIsRegister();
		hp.navigateToNoteBooks();
		plp.navigateToHPSpectreXTPDP();
		String hpSpecteSkuFromPDP = pdp.hpSpectreXtSKUPDP();
		cm.addToCardFromPDP();
		hp.navigateToShoppingCart();
		String hpSpectreSkuFromSC = sc.hpSpectreSkuSC();
		Assert.assertEquals(hpSpecteSkuFromPDP, hpSpectreSkuFromSC);
		sc.continueToCheckout();
		co.billdingAddress();
		co.shippingMethodNextDay();
		co.paymentMethodByCard();
		co.paymentInfoVallid();
		co.confirmORder();
		co.assertCheckOut();
		co.seeOrderDetails();
		co.navigateToNewTabToPrintDocument();
		co.closeNewTabForPrintAndNavigateToFirstTab();
		co.assertThetUserIsONOrderInformationPage();
		
	}
	
}

