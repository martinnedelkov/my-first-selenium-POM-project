package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Base.Base;

public class PLPPageObjects extends Base{
	
	CommonObjects cm; 
	
	@FindBy(xpath = "(//a[@href=\"/desktops\"])[5]")
	WebElement desktopsBtn;
	@FindBy(xpath = "(//a[@href=\"/notebooks\"])[5]")
	WebElement notebooksBtn;
	@FindBy(xpath = "(//a[@href=\"/software\"])[5]")
	WebElement softwareBtn;
	@FindBy(xpath = "(//a[@href=\"/camera-photo\"])[5]")
	WebElement cameraPhotoBtn;
	@FindBy(xpath = "(//a[@href=\"/cell-phones\"])[5]")
	WebElement cellPhonesBtn;
	@FindBy(xpath = "(//a[@href=\"/others\"])[5]")
	WebElement othersBtn;
	@FindBy(xpath = "(//a[@href=\"/shoes\"])[5]")
	WebElement shoesBtn;
	@FindBy(xpath = "(//a[@href=\"/clothing\"])[5]")
	WebElement clothingBtn;
	@FindBy (xpath = "(//a[@href=\"/accessories\"])[5]")
	WebElement accessoriesBtn;
	@FindBy(xpath = "(//a[@href=\"/build-your-own-computer\"])[2]")
	WebElement buildYourComp;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement buildYourCompAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement buildYourCompAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement buildYourCompAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"])[2]")
	WebElement digitalStormVANQUISHComp;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement digitalStormVANQUISHCompAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement digitalStormVANQUISHCompAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement digitalStormVANQUISHCompAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"])[2]")
	WebElement lenovoIdeaComp;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement lenovoIdeaCompAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement lenovoIdeaCompAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement lenovoIdeaCompAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/apple-macbook-pro-13-inch\"])[4]")
	WebElement appleMac13;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement appleMac13AddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement appleMac13AddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement appleMac13AddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/asus-n551jk-xo076h-laptop\"])[2]")
	WebElement assusLaptop;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement assusLaptopAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement assusLaptopAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement assusLaptopAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/hp-envy-6-1180ca-156-inch-sleekbook\"])[2]")
	WebElement hpEnvyLaptop;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement hpEnvyLaptopAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement hpEnvyLaptopAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement hpEnvyLaptopAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/hp-spectre-xt-pro-ultrabook\"])[2]")
	WebElement hpSpectreLaptop;
	@FindBy(xpath = "(//button[@type=\"button\"])[10]")
	WebElement hpSpectreLaptopAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[11]")
	WebElement hpSpectreLaptopAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[12]")
	WebElement hpSpectreLaptopAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/lenovo-thinkpad-x1-carbon-laptop\"])[2]")
	WebElement lenovoLaptop;
	@FindBy(xpath = "(//button[@type=\"button\"])[13]")
	WebElement lenovoLaptopAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[14]")
	WebElement lenovoLaptopAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[15]")
	WebElement lenovoLaptopAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/samsung-series-9-np900x4c-premium-ultrabook\"])[2]")
	WebElement samsungLaptop;
	@FindBy(xpath = "(//button[@type=\"button\"])[16]")
	WebElement samsungLaptopAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[17]")
	WebElement samsungLaptopAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[18]")
	WebElement samsungLaptopAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/adobe-photoshop-cs4\"])[2]")
	WebElement abodeSoftware;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement abodeSoftwareAddToComparateList;
	@FindBy(xpath = "(//a[@href=\"/sound-forge-pro-11-recurring\"])[2]")
	WebElement soundSoftware;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement soundSoftwareAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement soundSoftwareAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement soundSoftwareAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/windows-8-pro\"])[4]]")
	WebElement windowsSoftware;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement windowsSoftwareeAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement windowsSoftwareAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement windowsSoftwareAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/adidas-consortium-campus-80s-running-shoes\"])[2]")
	WebElement adidasShoes;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement adidasShoesAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement adidasShoesAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement adidasShoesAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/nike-floral-roshe-customized-running-shoes\"])[2]")
	WebElement nikFloralShoes;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement nikFloralShoesAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement nikFloralShoesAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement nikFloralShoesAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/nike-sb-zoom-stefan-janoski-medium-mint\"])[2]")
	WebElement nikSBShoes;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement nikSBShoesAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement nikSBShoesAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement nikSBShoesAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/custom-t-shirt\"])[4]")
	WebElement costumTShirt;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement costumTShirtAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement costumTShirtAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement costumTShirtAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/levis-511-jeans\"])[2]")
	WebElement levis511Jeans;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement levis511JeansAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement levis511JeansAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement clevis511JeansAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/nike-tailwind-loose-short-sleeve-running-shirt\"])[2]")
	WebElement nikeTShirt;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement nikeTShirtAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement nikeTShirtAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement nikeTShirtAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/oversized-women-t-shirt\"])[2]")
	WebElement oversizedTShirt;
	@FindBy(xpath = "(//button[@type=\"button\"])[10]")
	WebElement oversizedTShirtAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[11]")
	WebElement oversizedTShirtAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[12]")
	WebElement oversizedTShirtAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/nikon-d5500-dslr\"])[2]")
	WebElement nikonD5500Camera;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement nikonD5500CameraAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement nikonD5500CameraAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement nikonD5500CameraAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/apple-icam\"])[2]")
	WebElement appleICamera;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement appleICameraAddToComparateList;
	@FindBy(xpath = "(//a[@href=\"/leica-t-mirrorless-digital-camera\"])[2]")
	WebElement leicaTCamera;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement leicaTCameraAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement leicaTCameraAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement leicaTCameraAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/htc-one-m8-android-l-50-lollipop\"])[2]")
	WebElement htcOneM8Phone;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement htcOneM8PhoneAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement htcOneM8PhoneaAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement htcOneM8PhoneAddToWishlist;
	@FindBy(xpath = "(//a[@href=\"/htc-one-mini-blue\"])[2]")
	WebElement htcOneMiniPhone;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement htcOneMiniPhoneAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement hhtcOneMiniPhoneAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement htcOneMiniPhoneAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/nokia-lumia-1020\"])[2]")
	WebElement nokiaLumiaPhone;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement nokiaLumiaPhoneAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement nokiaLumiaPhoneAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement nokiaLumiaPhoneAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/if-you-wait-donation\"])[2]")
	WebElement ifYouWaitMovie;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement ifYouWaitMovieAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement ifYouWaitMovieAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement ifYouWaitMovieAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/night-visions\"])[2]")	
	WebElement nightVisionsMovie;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement nightVisionsMovieAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement nightVisionsMovieAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement nightVisionsMovieAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/science-faith\"])[2]")
	WebElement scienceFaithMovie;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement scienceFaithMovieAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement scienceFaithMovieeAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement scienceFaithMovieeAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/fahrenheit-451-by-ray-bradbury\"])[2]]")
	WebElement fahrenheitBook;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement fahrenheitBookAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement fahrenheitBookAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement fahrenheitBookAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/first-prize-pies\"])[2]")
	WebElement firstPrizeBook;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement firstPrizeBookAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement firstPrizeBookAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement firstPrizeBookAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/pride-and-prejudice\"])[2]")
	WebElement prideAndPrejudiceBook;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement prideAndPrejudiceBookAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement prideAndPrejudiceBookAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement prideAndPrejudiceBookAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/elegant-gemstone-necklace-rental\"])[2]")
	WebElement elegantJewelry;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement elegantJewelryAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement elegantJewelryAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement elegantJewelryAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/flower-girl-bracelet\"])[2]")
	WebElement flowerGirlJewelry;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement flowerGirlJewelryAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement flowerGirlJewelryAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement flowerGirlJewelryAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/vintage-style-engagement-ring\"])[2]")
	WebElement vintageJewelry;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement vintageJewelryAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement vintageJewelryAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement vintageJewelryAddToWishlist;
	
	
	@FindBy(xpath = "(//a[@href=\"/25-virtual-gift-card\"])[2]")
	WebElement virtualGiftCard;
	@FindBy(xpath = "(//button[@type=\"button\"])[1]")
	WebElement virtualGiftCardAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[2]")
	WebElement virtualGiftCardAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[3]")
	WebElement virtualGiftCardAddToWishlist;
	
	
	@FindBy(xpath = "(//a[@href=\"/50-physical-gift-card\"])[2]")
	WebElement physical50GiftCard;
	@FindBy(xpath = "(//button[@type=\"button\"])[4]")
	WebElement physical50GiftCardAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[5]")
	WebElement physical50GiftCardAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[6]")
	WebElement physical50GiftCardAddToWishlist;
	
	@FindBy(xpath = "(//a[@href=\"/100-physical-gift-card\"])[2]")
	WebElement physical100GiftCard;
	@FindBy(xpath = "(//button[@type=\"button\"])[7]")
	WebElement physical100GiftCardAddToCart;
	@FindBy(xpath = "(//button[@type=\"button\"])[8]")
	WebElement physical100GiftCardAddToComparateList;
	@FindBy(xpath = "(//button[@type=\"button\"])[9]")
	WebElement physical100GiftCardAddToWishlist;
	
	
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[1]")
	WebElement sortByPosition;
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[2]")
	WebElement sortByAtoZ;
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[3]")
	WebElement sortByZtoA;
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[4]")
	WebElement sortByLowToHigh;
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[5]")
	WebElement sortByHighToLow;
	@FindBy(xpath = "//select[@id=\"products-orderby\"]/option[6]")
	WebElement sortCreateOn;
	@FindBy(xpath = "//select[@id=\"products-pagesize\"]/option[1]")
	WebElement display3;
	@FindBy(xpath = "//select[@id=\"products-pagesize\"]/option[2]")
	WebElement display6;
	@FindBy(xpath = "//select[@id=\"products-pagesize\"]/option[3]")
	WebElement display9;
	@FindBy(xpath = "//a[@class=\"viewmode-icon grid selected\"]")
	WebElement viewGrid;
	@FindBy(xpath = "//a[@class=\"viewmode-icon list\"]")
	WebElement viewList;
	@FindBy(xpath = "//input[@id=\"attribute-option-6\"]")
	WebElement intelCoreI5CpuTypeFillterBy;
	@FindBy(xpath = "//input[@id=\"attribute-option-7\"]")
	WebElement intelCoreI7CpuTypeFillterBy;
	@FindBy(xpath = "//input[@id=\"attribute-option-8\"]")
	WebElement memory4GBFillterBy;
	@FindBy(xpath = "//input[@id=\"attribute-option-9\"]")
	WebElement memory8GBFillterBy;
	@FindBy(xpath = "//input[@id=\"attribute-option-10\"]")
	WebElement memory16GBFillterBy;
	@FindBy(xpath = "//div[@class='pager']/ul/li[@class='individual-page']")
	WebElement list2page;
	
	
	
	public PLPPageObjects () {
		PageFactory.initElements(driver, this);
	}
	//TC_4
	public void verifyTheSortingAndDisplaying () throws InterruptedException {
		notebooksBtn.click();
		sortByHighToLow.click();
		display3.click();
		viewList.click();
		Thread.sleep(3000);
		list2page.click();
		
	}
	//TC_1
	public void confirmHPNotebook () {
		notebooksBtn.click();
		hpEnvyLaptop.click();
		
	}
	//TC_7
	public void verifyAddToWishlist () {
		firstPrizeBookAddToWishlist.click();
	}
	
	//asserts
	
	public void verifySortingandDisplayingWorking () {
		int excRes = 3;
		int actREs = driver.findElements(By.xpath("//button[@class=\"button-2 product-box-add-to-cart-button\"]")).size();
		Assert.assertEquals(actREs, excRes);
	}
	 public void verifyHPIsDysplayed () {
		String extRes = driver.findElement(By.xpath("//h1")).getText();
		Assert.assertTrue(extRes.contains("HP Envy 6-1180ca 15.6-Inch Sleekbook"));
	 }
	 public void verifyFirstPrizewishlist () throws InterruptedException {
		 Thread.sleep(2000);
		String message = driver.findElement(By.xpath("//div/p[@class=\"content\"]")).getText();
		String excRes = "The product has been added to your wishlist";
		Assert.assertEquals(message, excRes);
	 }
	 
	 //For PDP
	public void navigateToCameraAndleica () {
		cameraPhotoBtn.click();
		leicaTCamera.click();
		
	}
	public void navigateToNokiaLumiaPDP() {
		nokiaLumiaPhone.click();
	}
	
	public void navigateToPrideAndPrejudice() {
		prideAndPrejudiceBook.click();
	}
	public void navigateToHPSpectreXTPDP() {
		hpSpectreLaptop.click();
	}
	
	//For Wishlist
	
	public void addToWishlistFirstPrizeBook() {
		firstPrizeBookAddToWishlist.click();
	}
	// vezba od chasot
	public void navigateToNikeTailWingPDP() {
		nikeTShirt.click();
	}
	public void navigateToLevis511PDP() {
		levis511Jeans.click();
	}
	public void leicaTAddToCard() {
		leicaTCameraAddToCart.click();
	}
	

		
}
