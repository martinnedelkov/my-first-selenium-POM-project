package testCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.CommonObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;

import pageObjects.PLPPageObjects;
import pageObjects.WishlistPageObjects;

public class Wishlist extends Base {
	HomePageObjects hp;
	PLPPageObjects plp;
	WishlistPageObjects wp;
	LoginPageObjects lp;
	CommonObjects cm;
	Testdata td;
	
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		lp = new LoginPageObjects();
		wp = new WishlistPageObjects();
		cm = new CommonObjects();
		td = new Testdata();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	//TC3
	// Check Add products to Cart from wishlist page functionality is working correctly 
	
	@Test
	public void checkAddProductToCartFromWishlist()  {
		hp.naviagteToBooks();      // navigate to books
		plp.addToWishlistFirstPrizeBook();   // add to wishlist First Prize Book
		hp.navigateToWishlistPage();		// navigate to Wishlist page
		String skuFromWishlist = wp.getSkuWishlist();
		wp.addProductToCartFromWishlist();		// select check box and add to cart product
		String SkuFromShoppingCart = wp.getSkuFromShoppingCart();
		wp.checkAddProductToCartFromWishlistAssert();		// verify that user is navigated to shopping cart 
		Assert.assertEquals(skuFromWishlist, SkuFromShoppingCart); 	//verify that product from wishlist is add to cart
	}
	//TC7
	//Check if the total price is calculated correctly
	@Test
	public void checkThePrice() {
		hp.naviagteToBooks();		// navigate to books
		plp.addToWishlistFirstPrizeBook();			// add to wishlist First Prize Book
		hp.navigateToWishlistPage();		// navigate to Wishlist page
		wp.changeTheQuantityField();		// change the quantity of product
		wp.checkThePriceAssert();		// verify that price is changed
	}
	
	//TC4
	//Check the Share wishlist functionality
	@Test
	public void checkTheShareWishlistFunctionality () {
		hp.navigateToLoginPage();		//navigate to login page
		lp.loginUser(td.validEmail, td.validPassword); 		//login with valid Cridentials
		hp.naviagteToBooks();			// navigate to books
		plp.addToWishlistFirstPrizeBook();	// add to wishlist First Prize Book
		hp.navigateToWishlistPage();	// navigate to Wishlist page
		wp.emailAFriendFromWishlist(td.friendEmail, "ova kniga ti ja preporacvam mn e uba ");		//navigate to email a friend, populate email a friend and personal message for a product and send a email
		cm.verifyThatPageContainsText("Your message has been sent.");		//verify that message has been sent
		
		
	}
	
	//Remove All product From wishlist
	@Test
	public void removeAllProductFromWishlist ()   {
		hp.naviagteToBooks();	// navigate to books
		plp.addToWishlistFirstPrizeBook();	// add to wishlist First Prize Book
		hp.naviagteToBooks();	// navigate to books
		plp.addToWiShlistPrideAndPrejudice();	// add to wishlist Pride and Prejudice
		hp.navigateToWishlistPage();	// navigate to Wishlist page
		wp.removeProductFromWishlist();	//remove all product from wishlist (for loop)
		cm.verifyThatPageContainsText("The wishlist is empty!");	// verify that wihslist is empty
	}
}
