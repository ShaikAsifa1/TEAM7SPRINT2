package POMContactlnfo;

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



public class ContactlnfoTest{
	String driverPath = "C:\\Users\\HP\\OneDrive\\Desktop\\selenium\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    ContactlnfoAccount objContactAccount;

 

    @BeforeTest
    public void setup(){
    System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.demoblaze.com/index.html");
        System.out.println(driver.getTitle());
    }
    
    @Test(priority=0)
    public void test_Home_Page_Appear_Correct() throws InterruptedException, IOException{
    
    //Create Object Of Home page
    objContactAccount = new ContactlnfoAccount(driver);
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='exampleModal']/div[1]/div[1]/div[2]")));
    FileInputStream fis = new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\selenium\\datasource\\contact.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);

		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell ContactEmail;
		XSSFCell ContactName;
		XSSFCell Message;
		
		for(int i = 0; i <= rownum ; i++) {
		   
			ContactEmail = ws.getRow(i).getCell(0);
			ContactName = ws.getRow(i).getCell(1);
			Message = ws.getRow(i).getCell(2);
			
			
			//objLogin.loginToDB(email.toString(),password.toString());
			//Thread.sleep(3000);
			Assert.assertTrue(objContactAccount.getContactName().matches("[A-Z|a-z|0-9|\\W]+"));
			if(driver.findElement(By.xpath("//input[@id='recipient-name']")).isSelected());
			{
			     System.out.println(ContactName);
			}
			objContactAccount.clicksendmessage();
			
			
		   
		}
			driver.close();
    
    }
    
    
}
