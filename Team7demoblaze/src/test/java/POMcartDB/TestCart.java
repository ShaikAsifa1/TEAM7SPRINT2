package POMcartDB;


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



public class TestCart{
	String driverPath = "C:\\Users\\HP\\Desktop\\SELENIUM\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    AddtoCart objAddtoCart;
    DeleteProduct objDeleteProduct;
    

 

    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Add_to_Cart() throws InterruptedException, IOException{
    
    //Create Object for Cart
    objAddtoCart = new AddtoCart(driver);
    objAddtoCart.clickproductselect1();
    objAddtoCart.clickaddtocart();
    objAddtoCart.clickhomelink();
    
    //Explicit wait
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Nokia lumia 1520')]")));
	
    objAddtoCart.clickproductselect2();
    objAddtoCart.clickaddtocart2();
    
    
    
    FileInputStream fis = new FileInputStream("C:\\Users\\HP\\Desktop\\SELENIUM\\DataSource\\Product.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);
		XSSFSheet ws1 = workbook.getSheetAt(1);


		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		int rownum1  = ws1.getLastRowNum();
		int colnum1 = ws1.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell productname;
		
		
		for(int i = 0; i <= rownum ; i++) {
		   
			productname= ws.getRow(i).getCell(0);
			productname= ws.getRow(i).getCell(1);
			
			Assert.assertTrue(objAddtoCart.getproductname().matches("[A-Z|a-z|0-9]\\W+"));
			
			if(driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s7')]")).isDisplayed())
			{
				System.out.println("Product added");
			}
			objDeleteProduct.clickcartlink();
			objDeleteProduct.deleteproduct();
			
		}
		
			driver.close();
    
    }
    
    
}
