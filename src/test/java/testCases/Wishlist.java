package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import pageObjects.HomePageObjects;
import pageObjects.PLPPageObjects;
import pageObjects.WishlistPageObjects;

public class Wishlist extends Base {
	HomePageObjects hp;
	PLPPageObjects plp;
	WishlistPageObjects wp;
	
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		plp = new PLPPageObjects();
		wp = new WishlistPageObjects();
	}
	@AfterMethod
	public void end() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
	
	//TC3
	@Test
	public void checkAddProductToCartFromWishlist() throws InterruptedException {
		hp.naviagteToBooks();
		plp.addToWishlistFirstPrizeBook();
		Thread.sleep(7000);
		hp.navigateToWishlistPage();
		wp.checkAddProductToCartFromWishlist();
		wp.checkAddProductToCartFromWishlistAssert();
		
	}
	//TC7
	@Test
	public void checkThePrice() throws InterruptedException {
		hp.naviagteToBooks();
		plp.addToWishlistFirstPrizeBook();
		Thread.sleep(7000);
		hp.navigateToWishlistPage();
		wp.checkThePrice();
		wp.checkThePriceAssert();
	}
}
