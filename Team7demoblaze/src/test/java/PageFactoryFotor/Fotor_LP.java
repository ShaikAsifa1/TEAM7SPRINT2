package PageFactoryFotor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Fotor_LP {
	WebDriver driver;
	@FindBy(id="rootLogin")
    WebElement emailId;
    @FindBy(className="inputClass inputBorderRed")
    WebElement password;    
    @FindBy(linkText="Sign In")
    WebElement signin;

	public  Fotor_LP() {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public void  setEmail(String strEmail) {
		emailId.sendKeys(strEmail);
	}
	public void setPassword(String strPassword) {
		password.sendKeys(strPassword);
	}
	public void clickSignin() {
		signin.click();
	}
	public void login(String strEmail,String strPassword) {
		this.setEmail(strEmail);
		this.setPassword(strPassword);
		this.clickSignin();
	}
	}
