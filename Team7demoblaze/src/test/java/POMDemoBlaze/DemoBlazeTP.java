package POMDemoBlaze;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class DemoBlazeTP {
	String driverPath = "C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe";
    WebDriver driver;
    DemoBlazeLP objLogin;
    DemoBlazeHP objHome;
    DemoBlazeAP objAcc;

 

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
    objHome = new DemoBlazeHP(driver);
    objHome.clickLoginIn();
    
    objLogin = new DemoBlazeLP(driver);
    objAcc = new DemoBlazeAP(driver);
    FileInputStream fis = new FileInputStream("C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\Data source\\DBcredentials.xlsx");
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);

		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell email;
		XSSFCell password;
		for(int i = 0; i <= rownum ; i++) {
		   
		    email = ws.getRow(i).getCell(0);
		    password = ws.getRow(i).getCell(1);
		    
			objLogin.loginToDB(email.toString(),password.toString());
			Thread.sleep(3000);
			Assert.assertTrue(objAcc.getUserName().matches("[A-Z|a-z|0-9|\\W]+"));
			objAcc.clickSignout();
		}
			driver.close();
    
    }
    
    
}
