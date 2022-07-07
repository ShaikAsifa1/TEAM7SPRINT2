package Fotor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class FotorPropertyFile {
	public static void main(String[] args) throws IOException, InterruptedException {
	    WebDriver driver;
	    File src= new File("C:\\Users\\shivr\\eclipse-workspace\\FotorWebDriverProject\\TestResources\\FOTOR.property");
	    FileInputStream fis = new FileInputStream(src);    
	    Properties prop = new Properties();
	    prop.load(fis);
	    System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriver"));                    
	    driver = new ChromeDriver();                    
	    driver.get(prop.getProperty("url"));                    
	    driver.manage().window().maximize(); 
	    Thread.sleep(3000);
	   
	    driver.findElement(By.xpath("a[contains(text(),'Accept')]")).click();
	    Thread.sleep(3000);
        ChromeOptions NP = new ChromeOptions();             
        NP.addArguments("--disable-notifications");      
       WebDriver driver1 = new ChromeDriver(NP); 
       Thread.sleep(3000);
        WebElement si = driver.findElement(By.xpath("//button[contains(text(),'Sign in')]"));
        si.click();
       Thread.sleep(3000);
	    
	    
	    
	    driver1.findElement(By.name(prop.getProperty("username"))).sendKeys("shivrajsable83@gmail.com");
	    driver1.findElement(By.name(prop.getProperty("password"))).sendKeys("Shivraj@8007");
	    driver1.findElement(By.name(prop.getProperty("Sign In"))).click();

	    Assert.assertEquals(driver.getTitle(),"Home - Fotor");

	    graphql.Assert.assertTrue(driver1.findElement(By.id(prop.getProperty("shivrajsable83"))).getText().matches("Welcome [a-z|A-Z|0-9]+"));
	    System.out.println(driver1.findElement(By.id(prop.getProperty("shivrajsable83"))).getText());

	    driver1.close();                    

	  }
	}
