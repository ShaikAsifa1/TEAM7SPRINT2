package POMContactlnfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactlnfoAccount {
	WebDriver driver;
	By contactlink = By.xpath("//a[contains(text(),'Contact')]");
	By ContactEmail = By.xpath("//input[@id='recipient-email']");
	By ContactName = By.xpath("//input[@id='recipient-name']");
	By Message = By.xpath("//textarea[@id='message-text']");
	By sendmessage = By.xpath("//button[contains(text(),'Send message')]");
	
	
	public ContactlnfoAccount(WebDriver driver) {
		this.driver=driver;
	}

    public void Clickcontactlink() {
         driver.findElement(contactlink).click();
    }
    
    public String getContactEmail() {
        return driver.findElement(ContactEmail ).getText();
   }
   
    public String getContactName() {
        return driver.findElement(ContactName ).getText();
   }
    

    public String getMessage() {
        return driver.findElement(Message ).getText();
   }
	public void clicksendmessage() {
		driver.findElement(sendmessage).click();
	}
}
