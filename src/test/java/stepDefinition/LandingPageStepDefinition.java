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
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	TestContextSetup testContextSetup;
	public String landingPagePrductName;
	public String offersPageProductName;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup= testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
		
	}

	@Given("User is on Greencart landing page")
	public void user_is_on_greencart_landing_page() throws IOException {
		
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
		//testContextSetup.testBase.WebDriverManager();
	   //testContextSetup.driver = new ChromeDriver();
	  //testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  
	}
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
	
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPagePrductName= landingPage.getProductName().split("-")[0].trim();
		System.out.println("Product name extracted from home page:"+ testContextSetup.landingPagePrductName);
		
		
		
		/*Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String PID = it.next();
		String CID = it.next(); */
		

	}
	
	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) {
		
	landingPage.incrementItem(Integer.parseInt(quantity));
	landingPage.AaddItemToCart();
		
	}
	

	
}
