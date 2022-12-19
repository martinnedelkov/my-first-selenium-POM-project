package testCases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.HomePageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;
import pageObjects.ShoppingCartPageObjects;

public class ShoppingCart extends Base {

	HomePageObjects hp;
	PLPPageObjects plp;
	PDPPageObjects pdp;
	ShoppingCartPageObjects sc;
	Testdata td;
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		pdp = new PDPPageObjects();
		sc = new ShoppingCartPageObjects();
		td = new Testdata();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	@Test
	public void vezbaodcashot() {
		hp.navigateToClothingWithHover();
		plp.navigateToNikeTailWingPDP();
		pdp.nikeTailwind3xSize4Quantity();
		String SkuFromPDP = pdp.nikeTaildWindSkuPDP();
		hp.navigateToShoppingCart();
		String skuShoppingCart = sc.nikeTaildwingskuFromSC();		
		Assert.assertEquals(SkuFromPDP, skuShoppingCart);
		
	}
	@Test
	public void checkIfThePriceChangesAccordingtheDiscountGivenForProducts ()  {
		hp.navigateToClothingWithHover();
		plp.navigateToLevis511PDP();
		pdp.levis511AddToCart();
		hp.navigateToShoppingCart();
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();
		sc.levis511ChangeQuantity3();
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();
		sc.levis511ChangeQuantity7();
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();
		sc.levis511ChangeQuantity10();
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();
		
		
	}
	
			
		 
	 
}
