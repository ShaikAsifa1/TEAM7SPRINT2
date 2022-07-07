package PageFactoryFotor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fotor_AP {
	WebDriver driver;
	@FindBy(xpath="By.xpath=//span[contains(text(),'shiv sabale')]")
	WebElement userName;
	@FindBy(linkText="Sign out")
	WebElement signout;
	public  Fotor_AP() {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public String getUserName() {
        return userName.getText();
    }
    
	public void clickSignout() {
		
		signout.click();
	
	}
	
}
