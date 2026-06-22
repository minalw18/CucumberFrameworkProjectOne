package pageObjects;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("h4.product-name");
	By topDeals = By.xpath("//a[text()='Top Deals']");
	By increment = By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");

	
	public void searchItem(String shortName) {
		driver.findElement(search).sendKeys(shortName);
	}
	
	public void getSearchText() {
		driver.findElement(search).getText();
		
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage() {
		
		return driver.getTitle();
	}
	
	public void incrementItem(int quantity) {

		int i = quantity-1;
		while(i>0) {
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void AaddItemToCart() {
		
		driver.findElement(addToCart).click();
		
	}

}
