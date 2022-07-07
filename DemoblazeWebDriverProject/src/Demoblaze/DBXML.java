package Demoblaze;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ch.qos.logback.core.pattern.parser.Node;

public class DBXML {
	public static void main(String[] args) throws FileNotFoundException, DocumentException {
		WebDriver driver;
		String driverPath="C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		
		File src= new File("C:\\Users\\shivr\\eclipse-workspace\\DemoblazeWebDriverProject\\TestResources\\DB.xml");
		FileInputStream fis = new FileInputStream(src);
		SAXReader saxReader=new SAXReader(); 
		org.dom4j.Document document=saxReader.read(fis);
		
		//Enter data
				driver.get(document.selectSingleNode("//DB_detail/URL").getText());
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/signup_info/Signuplink").getText())).click();
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/signup_info/Username").getText())).sendKeys("rukmani13@gmail.com");
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/signup_info/Password").getText())).sendKeys("Rukmani@123");
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/signup_info/Signup1").getText())).click();
		        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		     
				String alertMessage =driver.switchTo().alert().getText();
		        System.out.println(alertMessage);
		        driver.switchTo().alert().accept();
		        
		        //Login
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/Login_info/Loginlink").getText())).click();
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/Login_info/Username").getText())).sendKeys("shivrajsable83@gmail.com");
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/Login_info/Password").getText())).sendKeys("Shivraj@123");
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/Login_info/Login1").getText())).click();
		        System.out.println("User Login successful");
		        
		        //selectProduct or add to cart
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/add_cart/productselect1").getText())).click();
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/add_cart/addtocart").getText())).click();
				
				String alertMessage1 =driver.switchTo().alert().getText();
		        System.out.println(alertMessage1);
		        driver.switchTo().alert().accept();
				
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/add_cart/homelink").getText())).click();
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/add_cart/productselect2").getText())).click();
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/add_cart/addtocart2").getText())).click();
		        
		        String alertMessage2 =driver.switchTo().alert().getText();
		        System.out.println(alertMessage2);
		        driver.switchTo().alert().accept();
		        System.out.println("Product is added to cart successfuly");
		        
		      //delete product
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/remove_product/cartlink").getText())).click();
		        
		        
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/remove_product/deleteproduct").getText())).click();
		        System.out.println("Product should be deleted successfully");
		        
		        //purchase
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/placeorderlink").getText())).click();
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/name").getText())).sendKeys("Shivraj");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/country").getText())).sendKeys("india");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/city").getText())).sendKeys("pune");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/creditcard").getText())).sendKeys("0987654321");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/month").getText())).sendKeys("oct");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/year").getText())).sendKeys("2023");
				driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/purchase").getText())).click();
				
				//Assert.assertTrue(((org.dom4j.Node) driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/purchasesuccessful").getText()))).matches("Welcome [a-z|A-Z|!]+"));
			    System.out.println(driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/purchasesuccessful").getText())));	
			    System.out.println(driver.findElement(By.xpath("//DB_detail/order_info/body")).getText());	
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/order_info/oklink").getText())).click();
			    
			    //contact in home page
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/contact_info/contactlink").getText())).click();
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/contact_info/ContactEmail").getText())).sendKeys("shivrajsable83@gmail.com");
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/contact_info/ContactName").getText())).sendKeys("Shivraj");
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/contact_info/Message").getText())).sendKeys("Amount debited from my account twice");
			    driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/contact_info/sendmessage").getText())).click();
			    
			    String alertMessage3 =driver.switchTo().alert().getText();
		        System.out.println(alertMessage3);
		        driver.switchTo().alert().accept();
		        
		        //logout
		        driver.findElement(By.xpath(document.selectSingleNode("//DB_detail/logout_info/logout").getText())).click();
		   	 	System.out.println("user should logout successfully");
		   	
		   		 driver.close();
		   	     driver.quit();
		        
		        
			    
	}
		        
	
	


}
