package POMFOTOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotorAP {
	WebDriver driver;
	By userName = By.xpath("//strong[contains(text(),'shivrajsable83')]");
	By signout = By.xpath("//button[contains(text(),'Sign out')]");
	
	public FotorAP(WebDriver driver) {
		this.driver=driver;
	}

    public String getUserName() {
        return driver.findElement(userName).getText();
    }
    
	public void clickSignout() {
		driver.findElement(signout).click();
	}
}
