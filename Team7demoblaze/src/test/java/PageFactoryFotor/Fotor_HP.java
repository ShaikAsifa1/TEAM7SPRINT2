package PageFactoryFotor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fotor_HP {
	WebDriver driver;
	@FindBy(linkText="Sign in")
	WebElement signin;
	public  Fotor_HP() {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void clickSignin() {
		signin.click();
	
	}
	
 

}
