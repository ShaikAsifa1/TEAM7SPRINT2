package POMDemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeAP {
	WebDriver driver;
	By userName = By.xpath("//a[@id='nameofuser']");
	By logout = By.xpath("//a[@id='logout2']");
	
	public DemoBlazeAP(WebDriver driver) {
		this.driver=driver;
	}
	 public String getUserName() {
	        return driver.findElement(userName).getText();
	    }
	    
    
   public void clickSignout() {
		driver.findElement(logout).click();
	}
}

