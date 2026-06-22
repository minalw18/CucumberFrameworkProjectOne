package utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchToChildWindow() {
			
			String PID = driver.getWindowHandle();
			for(String CID: driver.getWindowHandles()) {
				if(!CID.equals(PID)) {
					driver.switchTo().window(CID);
					break;
				}
		}
	}

}
