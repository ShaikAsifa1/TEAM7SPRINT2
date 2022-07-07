package editimage;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.google.common.base.Strings;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class EdImageStepDef {
 WebDriver driver;
 
	
	@Given("^User navigates to fotor homepage$")
	public void User_navigates_to_fotor_homepage() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();             
		  co.addArguments("--disable-notifications");      
		 WebDriver driver = new ChromeDriver(co); 

		driver=new ChromeDriver();
     driver.get("https://www.fotor.com/");
     
	} 
	
	@When("^User enters valid credentials$")
	public void User_enters_valid_credentials(DataTable usercredentials) {
		
		List<List<String>> data = usercredentials.cells();
     //Enter data
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
     driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/input[1]")).sendKeys(data.get(0).get(0));
     driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/input[1]")).sendKeys(data.get(0).get(1));
     driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
		}
	
	@Then("^User Signin Successful$")
	public void User_Signin_Successful() throws InterruptedException {
		System.out.println("User Signin successful");
		
	}
	
	@Given("^I have an image$")
	public void I_have_an_image() {
		driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/p[1]")).click();
		driver.findElement(By.xpath("//body[1]/div[9]/div[1]/div[1]/span[1]/svg[1]/path[1]")).click();
		driver.findElement(By.xpath("//body/div[@id='app']/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]")).click();
		
		
		
	}
	@When("^User enters valid credentials$")
	public void User_enters_valid_credentials() {
		
		
		}
	
	//@Then("^User Signin Successful$")
	//public void User_Signin_Successful() throws InterruptedException {
		//System.out.println("User Signin successful");
		
		
	} 
		  
