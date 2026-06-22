package stepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

public class OffersPageStepDefinition {
	
	TestContextSetup testContextSetup;
	public String offersPageProductName;
	OffersPage offersPage ;
	LandingPage landingPage;
	//public String landingPagePrductName;

	
	public OffersPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup= testContextSetup;
		landingPage = testContextSetup.pageObjectManager.getLandingPage();

	}
	
	@Then("^user searched for (.+) shortname in offers page to check if product exist with same name$")
	public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		//OffersPage offersPage = new OffersPage(testContextSetup.driver);
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);

		offersPageProductName = offersPage.getProductName();
		System.out.println("Product name extracted from offers page:"+ offersPageProductName);
	}
	
	public void switchToOffersPage() {
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.switchToChildWindow();
		
	/*	String PID = testContextSetup.driver.getWindowHandle();
		for(String CID: testContextSetup.driver.getWindowHandles()) {
			if(!CID.equals(PID)) {
				testContextSetup.driver.switchTo().window(CID);
				break;
			} */
		}
	
	
	@And("validate product name matches in Offers page with Landing page")
	public void validate_product_name_matches_in_offers_page_with_landing_page() throws InterruptedException {
		
		System.out.println("offersPageProductName: " + offersPageProductName);
		System.out.println("landingPageProductName: " + testContextSetup.landingPagePrductName);
		Thread.sleep(2000);

		Assert.assertEquals(offersPageProductName, testContextSetup.landingPagePrductName);
		//Thread.sleep(2000);
		//testContextSetup.driver.quit();
	}
	

}
