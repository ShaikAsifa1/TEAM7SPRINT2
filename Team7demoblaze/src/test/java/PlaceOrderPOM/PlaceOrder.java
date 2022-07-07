package PlaceOrderPOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.netty.util.AsciiString;

public class PlaceOrder {
	WebDriver driver;
	
	By placeorderlink = By.xpath("//button[contains(text(),'Place Order')]");
	By name=By.xpath("//input[@id='name']");
	By country=By.xpath("//input[@id='country']");
	By city=By.xpath("//input[@id='city']");
	By creditcard=By.xpath("//input[@id='card']");
	By month=By.xpath("//input[@id='month']");
	By year=By.xpath("//input[@id='year']"); 
	By purchase=By.xpath("//button[contains(text(),'Purchase')]");
	By purchasesuccessful=By.xpath("//h2[contains(text(),'Thank you for your purchase!')]");
	By body=By.xpath("//body/div[10]/p[1]");
	By oklink=By.xpath("//button[contains(text(),'OK')]");
	
	public PlaceOrder(WebDriver driver){
        this.driver = driver;
    }
	public void clickcartlink(){
	    By cartlink = null;
		driver.findElement(cartlink).click();
	    }
	
	public void clickplaceorderlink(){
	    driver.findElement(placeorderlink).click();
	    }
	
	public void setName()
	{
	    CharSequence strname = null;
		driver.findElement(name).sendKeys(strname);
	    }
	public void setcountry() {
		// TODO Auto-generated method stub
		CharSequence[] strcountry = null;
		By setcountry = null;
		driver.findElement(setcountry).sendKeys( strcountry);
	}
	public void setCity() {
		// TODO Auto-generated method stub
		By setcity = null;
		CharSequence strcity = null;
		// TODO Auto-generated method stub
		driver.findElement(setcity).sendKeys(strcity);
	}
	
	public void setCreditcard(){
	    CharSequence intcreditcard = null;
		((WebElement) driver.findElements(creditcard)).sendKeys(intcreditcard);
	    }
	

	public void setmonth(String strmonth){
	    driver.findElement(month).sendKeys(strmonth);
	    }
	
	public void setyear(String stryear){
	    CharSequence intyear = null;
		driver.findElement(year).sendKeys(intyear);
	    }
	
	public void clickpurchase(){
	    driver.findElement(purchase).click();
	    }
	
	public void purchasesuccessful(String strpurchasesuccessful){
	    driver.findElement(purchasesuccessful).getText();
	    }
	
	public String printbody(){
	
	return driver.findElement(body).getText();
	    }
	
	public void clickoklink(){
	    driver.findElement(oklink).click();
	    }
}
