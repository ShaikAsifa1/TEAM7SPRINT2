package Demoblaze;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
public class DBproperty {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		 File src= new File("C:\\Users\\shivr\\eclipse-workspace\\DemoblazeWebDriverProject\\TestResources\\DB.property");
	        FileInputStream fis1 = new FileInputStream(src);    
	     // Load the properties File
	        Properties prop = new Properties();
	        prop.load(fis1);
	        
	        System.setProperty("webdriver.chrome.driver","C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe");                    
	        driver = new ChromeDriver();                    
	        driver.get(prop.getProperty("URL"));                    
	        driver.manage().window().maximize();            
	   //Excel
	    FileInputStream fis2 = new FileInputStream("C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\Data source\\DBcredentials.xlsx");
	    XSSFWorkbook workbook = new XSSFWorkbook(fis2);
			XSSFSheet ws = workbook.getSheetAt(0);
			int rownum  = ws.getLastRowNum();
			int colnum = ws.getRow(0).getPhysicalNumberOfCells();
			System.out.println(colnum);
			System.out.println(rownum);
			XSSFCell userName;
			XSSFCell password;
			for(int i=1;i<=rownum;i++) {
			   
			    userName = ws.getRow(i).getCell(0);
			    password = ws.getRow(i).getCell(1);
         
         System.out.println("Username is: "+userName);
         System.out.println("Password is: "+password);
         driver.findElement(By.id(prop.getProperty("Login"))).click();
         driver.findElement(By.id(prop.getProperty("userName"))).sendKeys(userName.toString());
	        Thread.sleep(3000);
	        driver.findElement(By.id(prop.getProperty("password"))).sendKeys(password.toString());
	        Thread.sleep(3000);
	        driver.findElement(By.name(prop.getProperty("loginButton"))).click();
			
	        System.out.println("User Login successful");
			}
			
			
        

        Assert.assertTrue(driver.findElement(By.id(prop.getProperty("welcome"))).isDisplayed());     
		System.out.println("logo validated successfully by assertion");
		WebElement wel =driver.findElement(By.id("nameofuser"));                          
		if (wel.isDisplayed()) {
			System.out.println("Welcome shivrajsable83@gmail.com message is displayed");
		}
		else {
			System.out.println("Welcome shivrajsable83@gmail.com message is not displayed");
		}
		
		
		//add to cart
		
		driver.findElement(By.xpath(prop.getProperty("productselect1"))).click();
        driver.findElement(By.xpath(prop.getProperty("addtocart"))).click();
        
        
        String alertMessage =driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().accept();
        
        driver.findElement(By.xpath(prop.getProperty("homelink"))).click();
        driver.findElement(By.xpath(prop.getProperty("productselect2"))).click();
        driver.findElement(By.id(prop.getProperty("addtocart2"))).click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
		String alertMessage1 =driver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        driver.switchTo().alert().accept();
        
	
	//delete product
        
        driver.findElement(By.xpath(prop.getProperty("cartlink"))).click();
        driver.findElement(By.xpath(prop.getProperty("deleteproduct"))).click();
		
		
		//purchase
		
		driver.findElement(By.xpath(prop.getProperty("placeorderlink"))).click();
        driver.findElement(By.xpath(prop.getProperty("name"))).sendKeys("Shivraj");
        driver.findElement(By.xpath(prop.getProperty("country"))).sendKeys("india");
        driver.findElement(By.xpath(prop.getProperty("city"))).sendKeys("pune");
        driver.findElement(By.xpath(prop.getProperty("creditcard"))).sendKeys("0987654321");
        driver.findElement(By.xpath(prop.getProperty("month"))).sendKeys("oct");
        driver.findElement(By.xpath(prop.getProperty("year"))).sendKeys("2023");
        
        driver.findElement(By.xpath(prop.getProperty("purchase"))).click();
        
        System.out.println(driver.findElement(By.xpath("purchasesuccessful")).getText());	
	    System.out.println(driver.findElement(By.xpath("body")).getText());	
	    driver.findElement(By.xpath(prop.getProperty("oklink"))).click();
     
	    
	    //contact in home page
	    
	    driver.findElement(By.xpath(prop.getProperty("contactlink"))).click();
	    driver.findElement(By.xpath(prop.getProperty("ContactEmail"))).sendKeys("shivrajsable83@gmail.com");
	    driver.findElement(By.xpath(prop.getProperty("ContactName"))).sendKeys("Shivraj");
	    driver.findElement(By.xpath(prop.getProperty("Message"))).sendKeys("Amount debited from my account twice");
	    driver.findElement(By.xpath(prop.getProperty("sendmessage"))).click();
       
	    String alertMessage2 =driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        driver.switchTo().alert().accept();
        
     
      
      //Logout
     
      driver.findElement(By.xpath(prop.getProperty("logout"))).click();
      System.out.println("user should logout successfully");
	   	
		 driver.close();
	     driver.quit();
       
       
	
	
	
}
}

