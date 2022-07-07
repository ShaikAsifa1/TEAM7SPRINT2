package POMDemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeHP {
	WebDriver driver;
	By LoginIn = By.xpath("//a[@id='login2']");
	
	public DemoBlazeHP(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickLoginIn() {
		
		driver.findElement(LoginIn).click();
	}
}