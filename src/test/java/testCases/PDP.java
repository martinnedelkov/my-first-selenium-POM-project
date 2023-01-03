package testCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.Base;
import TestData.Testdata;
import pageObjects.CommonObjects;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.PDPPageObjects;
import pageObjects.PLPPageObjects;

public class PDP extends Base {
	HomePageObjects hp;
	LoginPageObjects lp;
	PLPPageObjects plp;
	PDPPageObjects pdp;
	CommonObjects cm;
	Testdata td;
	@BeforeMethod
	public void start() {
		openApp();
		hp = new HomePageObjects();
		lp = new LoginPageObjects();
		plp = new PLPPageObjects();
		pdp = new PDPPageObjects();
		cm = new CommonObjects();
		td = new Testdata();
	}
		@AfterMethod
		public void end() throws InterruptedException {
			Thread.sleep(4000);
			driver.quit();
		}
		
		//TC_2
		//Write and submit review for product without login in
		@Test
		public void productReview () {
			hp.navigateToCameraAndPhoto();  	//navigate to Camera and Photo
			plp.navigateToLeicaTMirrolesCamera();		//navigate to Leica T Mirroless PDP
			pdp.navigateToLeicaTMirrolessReviewPage();		// navigate To Leica T Mirroless Review Page
			pdp.verifyUserCannotWriteReviewsIfNotLogin();		// verify that user cannot write a Reviews if user is not registered and login
		
		}
		//TC_5
		// Check the Share product functionality
		@Test
		public void checkShareProductFunctionality() {
			hp.navigateToLoginPage();		//navigate to login page
			lp.loginUser(td.validEmail, td.validPassword);		// login with valid Cridentials
			hp.naviagteToBooks();		// navigate to books
			plp.navigateToPrideAndPrejudice();		// navigate to Pride And Prejudice PDP
			pdp.navigateToPrideAndPrejudiceEmailAFriendWriteAemailMessageAndSendEmail(td.friendEmail, "MnOGU UBA KNIga");		//navigate to Pride and Prejudice Email a Friend , write a email and message and send a email
			pdp.verifyThatUserSentAEmailToFriend();		// verify that user sent a email to friend
		}
		
		//TC_13
		//Download sample from product details
		@Test
		public void downloadSampleFromPDP () {
			hp.naviagteToDigitalDownloads(); // navigate to digital downloads
			plp.navigateToNightVisionsPDP(); // navigate to Night Visions
			pdp.downloadSample();	// download sample from Night Visions
			pdp.verifyThatFileIsDownloaded();	// verify that file is downloaded
		}
		//TC_11
		//Test social  sharring button(switchTo.Window)
		@Test
		public void testSocialSharringButton(){
			hp.navigateToNoteBooks();	// navigate to notebooks
			plp.navigateToAsusN551PDP();	//navigate to asus n551 pdp
			pdp.shareOnFB();	// click to share product on FB
			cm.verifyThatNewWindowTabIsOpenAndCloseIt("facebook", "asus");// verify that new facebook window tab will be open and close it and verify then that user is on  pdp page
		}
}
