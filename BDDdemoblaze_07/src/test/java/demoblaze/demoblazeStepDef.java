package demoblaze;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
public class demoblazeStepDef {
WebDriver driver;
	
	@Given("^User navigates to Store homepage$")
	public void User_navigates_to_fotor_homepage() {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        
	} 
	
	@When("^User enters valid credentials$")
	public void User_enters_valid_credentials(DataTable usercredentials) throws IOException {
		
		
		
	List<List<String>> data = usercredentials.cells();
        //Enter data
		driver.findElement(By.xpath("//a[@id='signin2']")).click();
        driver.findElement(By.xpath("//input[@id='sign-username']")).sendKeys(data.get(0).get(0));
        driver.findElement(By.xpath("//input[@id='sign-password']")).sendKeys(data.get(0).get(1));
        driver.findElement(By.xpath("//button[contains(text(),'Sign up')]")).click();
		//driver.get("http://shivrajsable123@gmail.com:Shiv@123@demoblaze.com/");

            
		
		String alertMessage =driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().accept();
        
            
	}
        
        
		
	
	@Then("^User Signin Successful$")
	public void User_Signin_Successful() throws InterruptedException {
		System.out.println("User Signin successful");
		
	}
	
	@Given("^User navigates to Login page$")
	public void User_navigates_to_Login_page() {
	}
		
	@When("^I enter login credential$")
	public void I_enter_login_credential(DataTable usercredentials) {
		driver.findElement(By.xpath("//a[@id='login2']")).click();
		driver.findElement(By.xpath("//input[@id='loginusername']")).sendKeys("data.get(0).get(0)");
		driver.findElement(By.xpath("//input[@id='loginpassword']")).sendKeys("data.get(0).get(1)");
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();
	}
	
	@Then("^User should get login successful$")
	public void User_should_get_login_successful() throws InterruptedException {
		System.out.println("User Login successful");
	}
	
	@Given("^User navigates to Product$")
	public void User_navigates_to_Product() {
		
	}
	
	@When("^I click on add to cart$")
	public void I_click_on_add_to_cart(DataTable usercredentials) {
		driver.findElement(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
		
		String alertMessage =driver.switchTo().alert().getText();
        System.out.println(alertMessage);
        driver.switchTo().alert().accept();
		
        driver.findElement(By.xpath("//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Nokia lumia 1520')]")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
        
        String alertMessage1 =driver.switchTo().alert().getText();
        System.out.println(alertMessage1);
        driver.switchTo().alert().accept();
        
        
        }
	@Then("^Product should get added to cart$")
	public void Product_should_get_added_to_cart() throws InterruptedException {
		System.out.println("Product is added to cart successfuly");
	}

	@Given("^User navigates to Product in cart page$")
	public void User_navigates_to_Product_in_cart_page() {
		driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
		
	} 
	@When("^I click on delete$")
	public void I_click_on_delete() {
		driver.findElement(By.xpath("//tbody/tr[2]/td[4]/a[1]")).click();
	}
	@Then("^Product should get deleted from cart$")
	public void Product_should_be_deleted_from_cart() {
	   System.out.println("Product should be deleted successfully");
	}
	
	@Given("^User navigates to Place order$")
	public void User_navigates_to_Place_order() {
		
	}

	@When("^I click on Place order$")
	public void I_click_on_Place_order() {
		driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("data.get(0).get(0)");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("data.get(0).get(1)");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("data.get(0).get(2)");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("data.get(0).get(3)");
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("data.get(0).get(4)");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("data.get(0).get(5)");
		driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
	
	}
	
	@Then("^Product order should get placed$")
	public void Product_order_should_get_placed() {

		 Assert.assertTrue(driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText().matches("Welcome [a-z|A-Z|!]+"));
		    System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]")).getText());	
		    System.out.println(driver.findElement(By.xpath("//body/div[10]/p[1]")).getText());	
		    driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
}


	@Given("^User navigates to contact$")
	public void User_navigates_to_contact() {
		
	}
	
	@When("^I click on contact in home page$")
	public void I_click_on_contact_in_home_page() {
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		driver.findElement(By.xpath("//input[@id='recipient-email']")).sendKeys("data.get(0).get(0)");
		driver.findElement(By.xpath("//input[@id='recipient-name']")).sendKeys("data.get(0).get(1)");
		driver.findElement(By.xpath("//textarea[@id='message-text']")).sendKeys("data.get(0).get(2)");
		driver.findElement(By.xpath("//button[contains(text(),'Send message')]")).click();
		
		 
	}
	
	@Then("^user should be able to contact store$")
	public void user_should_be_able_to_contact_store() {
		
		String alertMessage2 =driver.switchTo().alert().getText();
        System.out.println(alertMessage2);
        driver.switchTo().alert().accept();
	}
	
	@Given("^User navigates to Logout$")
	public void User_navigates_to_Logout() {
		
	}



	@When("^I click on Logout on home page$")
	public void  I_click_on_Logout_on_homepage() {
		driver.findElement(By.xpath("//a[@id='logout2']")).click();
	}

	@Then("^User should logout$")
	public void the_result_should_be(String result) {
		 System.out.println("user should logout successfully");
	
		 driver.close();
	        driver.quit();
	
	
	}
	
	
	
}






















