package POMcartDB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteProduct {
	WebDriver driver;
	
	By cartlink =By.xpath("//a[contains(text(),'Cart')]");
	By deleteproduct =By.xpath("//tbody/tr[2]/td[4]/a[1]");
	
	public DeleteProduct(WebDriver driver){
        this.driver = driver;
    }
	
	public void clickcartlink(){
	    driver.findElement(cartlink).click();
	    }
	
	public void deleteproduct(){
	    driver.findElement(deleteproduct).click();
	    }
	

}
