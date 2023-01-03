package testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.CommonObjects;
import pageObjects.HomePageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;
import pageObjects.ShoppingCartPageObjects;

public class ShoppingCart extends Base {

	HomePageObjects hp;
	PLPPageObjects plp;
	PDPPageObjects pdp;
	ShoppingCartPageObjects sc;
	CommonObjects cm;
	Testdata td;
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		pdp = new PDPPageObjects();
		sc = new ShoppingCartPageObjects();
		cm = new CommonObjects();
		td = new Testdata();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	// verify that Sku from PDP equals on Sku from Shopping cart
	@Test
	public void vezbaodcashot() {
		hp.navigateToClothingWithHover(); // navigate to clothing
		plp.navigateToNikeTailWingPDP();	// navigate to Nike tailwing PDP
		pdp.nikeTailwind3xSize4Quantity();	// add to cart 3x size, 4quantity
		String SkuFromPDP = pdp.nikeTaildWindSkuPDP();	// taking a SKU for the product from PDP
		hp.navigateToShoppingCart();	// navigate to shopping cart
		String skuShoppingCart = sc.nikeTaildwingskuFromSC();	// taking a SKU for the product from Shopping cart	
		Assert.assertEquals(SkuFromPDP, skuShoppingCart);	// verify that Sku from PDP equals on Sku from Shopping cart
		
	}
	
	//TC_22
	//Check if the price changes according the discount given for the product
	@Test
	public void checkIfThePriceChangesAccordingtheDiscountGivenForProducts ()  {
		hp.navigateToClothingWithHover(); 	//navigate to Clothing
		plp.navigateToLevis511PDP();	// navigate To leviss 511 pdp
		pdp.levis511AddToCart();		// add to card levis 511
		hp.navigateToShoppingCart();	// navigate to shopping cart
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();	// verify the price of 1 product
		sc.levis511ChangeQuantity3(); 	// changing the quantity in 3
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();	// verify the price of 3 product
		sc.levis511ChangeQuantity7(); 	//changing the quantity in 7
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();	// verify the price of 7 product
		sc.levis511ChangeQuantity10();	//changing the quantity in 10
		sc.levis511checkIfThePriceChangesAccordingtheDiscount3();	// verify the price of 10 product
		
	}
	// add 3 products to shopping cart and remove all with for loop
	@Test
	public void removeFromShoppingCartAllProducts () {
		hp.navigateToCameraAndPhoto();	// navigate to camera and photo
		plp.leicaTAddToCard();	// add to cart leica T mirrorless
		hp.navigateToNoteBooks();	// navigate to NoteBooks
		plp.HPEnvyAddToCard();	// add to cart Hp Envy laptop
		hp.naviagteToBooks();	// navigate to books
		plp.addToCartFahrenheit451Book();	// add to cart Fahrenheit451 book
		hp.navigateToShoppingCart();	// navigate to shopping cart
		sc.removeAllProductsFromShoppingCart();	// remove all products from shopping cart by usingfor loop
		cm.verifyThatPageContainsText("Your Shopping Cart is empty!");	// verify that shopping cart is empty
		
	} 
	// verify that user can't checkout without selected terms and service field and taking a screenshot of error message
	@Test
	public void checkoutWithoutSelectedTermsAndService () throws IOException {
		hp.naviagteToBooks();	// navigate to books
		plp.addToCartFahrenheit451Book();	// add to cart Fahrenheit 451 Book
		hp.navigateToShoppingCart();	// navigate to shopping cart
		sc.onlyPressedOnCheckoutButton();	// press on checkout button without selecting/populate anything in fields
		sc.verifyThatUserCantCheckoutWithoutSelectTermsAndService(); // verify that user can't go checkout without selecting a field for terms and service
		sc.takingAScreenShotFromTermsErrorMsg();	//taking a screenshot form error message for terms and service
	}
			
		 
	 
}
