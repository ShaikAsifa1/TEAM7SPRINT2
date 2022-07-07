package POMcartDB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddtoCart {
	WebDriver driver;
	
	By productselect1 = By.xpath("//a[contains(text(),'Samsung galaxy s7')]");
	By addtocart = By.xpath("//a[contains(text(),'Add to cart')]");
	
	By homelink= By.xpath("//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]");
	By productselect2 = By.xpath("//a[contains(text(),'Nokia lumia 1520')]");
	By addtocart2 =By.xpath("//a[contains(text(),'Add to cart')]");
	
	//String alertMessage =driver.switchTo().alert().getText();
    //System.out.println(alertMessage);
    //driver.switchTo().alert().accept();
	
	
	
	public AddtoCart(WebDriver driver){
        this.driver = driver;
    }
	
	//Select product1
	public void clickproductselect1(){
	    driver.findElement(productselect1).click();
	    }
	//click add to cart
	public void clickaddtocart(){
	    driver.findElement(addtocart).click();
	    }
	//click in cart in homepage
	public void clickhomelink(){
	    driver.findElement(homelink).click();
	    }
	
	//select product2
	public void clickproductselect2(){
	    driver.findElement(productselect2).click();
	    }
	
	//click on add to cart
	public void clickaddtocart2(){
	    driver.findElement(addtocart2).click();
	    }

	public String getproductname() {
		
		 return driver.findElement(productselect1).getText();
	}
	
	
}
