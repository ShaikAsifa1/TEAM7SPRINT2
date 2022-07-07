package POMFOTOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotorHP {
	WebDriver driver;
	By SignIn = By.xpath("//div[contains(text(),'Sign In')]");
	
	public FotorHP(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void clickSignIn() {
		
		driver.findElement(SignIn).click();
	}
}
