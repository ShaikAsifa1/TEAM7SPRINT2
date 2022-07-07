package PlaceOrderPOM;

import java.io.FileInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



@SuppressWarnings("unused")
public class PlaceOrderTest{
	String driverPath = "C:\\Users\\HP\\Desktop\\SELENIUM\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    PlaceOrder objPlaceOrder;

 @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Place_Order() throws InterruptedException, IOException{
    
    //Create Object for Cart
    	objPlaceOrder= new PlaceOrder(driver);
    	objPlaceOrder.clickcartlink();
    	objPlaceOrder.clickplaceorderlink();
    	objPlaceOrder.setName();
    	objPlaceOrder.setcountry();
    	objPlaceOrder.setCity();
    	objPlaceOrder.setCreditcard();
    	objPlaceOrder.setmonth();
    	objPlaceOrder.setyear();
    
    FileInputStream fis = new FileInputStream("C:\\Users\\SHASIFA\\Desktop\\placeorderpom.xlsx");
    @SuppressWarnings("resource")
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);
		XSSFSheet ws1 = workbook.getSheetAt(1);


		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		int rownum1  = ws1.getLastRowNum();
		int colnum1 = ws1.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell Name;
		XSSFCell Country;
		XSSFCell City;
		XSSFCell Creditcard;
		XSSFCell Month;
		XSSFCell Year;
		
		for(int i = 0; i <= rownum ; i++) {
		   
			Name= ws.getRow(i).getCell(0);
			Country= ws.getRow(i).getCell(1);
			City=ws.getRow(i).getCell(2);
			Creditcard=ws.getRow(i).getCell(3);
			Month=ws.getRow(i).getCell(4);
			Year=ws.getRow(i).getCell(4);
			objPlaceOrder.clickpurchase();

			 //Explicit wait
		    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")));	
			
			
			
			
			Assert.assertTrue(objPlaceOrder.printbody().matches("[A-Z|a-z|0-9|\\W]+"));
			
			if(driver.findElement(By.xpath("//body/div[10]/p[1]")).isDisplayed())
			{
				System.out.println("Thank you for your purchase!"+driver.findElement(By.xpath("//body/div[10]/p[1]")));
			}
			System.out.println("Order placed");
			
			objPlaceOrder.clickoklink();
			
		}
			driver.close();
    
    }
    
    
}
