package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By cartBag = By.cssSelector("[alt='Cart']");
	By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoButton = By.cssSelector(".promoBtn");
	By placeOrder =  By.xpath("//button[contains(text(),'Place Order')]");
	By productOnCheckout = By.xpath("//p[@class='product-name']");

	
	public void CheckoutItem() {
		
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}

	public boolean VerifyPromoButton() {
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}
	
	public String getProductOnCheckout() {
		return driver.findElement(productOnCheckout).getText();
	}
	
}
