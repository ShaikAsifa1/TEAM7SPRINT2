package PageFactoryFotor;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fotor_TP {
	String drivePath="C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe";
	WebDriver driver;
	Fotor_HP objHomePage;
	Fotor_LP objLoginPage;
	Fotor_AP objAccountPage;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", drivePath);
		driver=new ChromeDriver();
		driver.get("https://www.fotor.com/");
		}
	@Test(priority=0)
		
	public void test_Home_Page_Appear() {
		objHomePage=new Fotor_HP();
		objHomePage.clickSignin();
		
		objLoginPage=new Fotor_LP();
		objLoginPage.login("shivrajsable83@gmail.com","Shivraj@8007");
		//objLoginPage.clickSignin();
		
		objAccountPage=new Fotor_AP();
		Assert.assertTrue(objAccountPage.getUserName().toLowerCase().contains("Shivrajsable83"));
	    System.out.println("Successfully Logged in to Site!!");
		objAccountPage.clickSignout();
		driver.close();
	}
	}
