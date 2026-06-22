package stepDefinition;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public WebDriver driver;
	TestContextSetup testContextSetup;
	public String landingPagePrductName;
	public String offersPageProductName;
	public CheckoutPage checkoutPage;
	public String checkoutPageProductName;
	
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup= testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}


	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
	
		
		Assert.assertTrue(checkoutPage.VerifyPromoButton());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		
		System.out.println("User has ability to enter promo code and place the order");
		
	}
	
	@Then("^User proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException{
		
		checkoutPage.CheckoutItem();
		Thread.sleep(2000);
		
		checkoutPageProductName = checkoutPage.getProductOnCheckout().split("-")[0].trim();
		System.out.println("Product name extracted from checkout page:"+ checkoutPageProductName);
		
		
	}
	
}
