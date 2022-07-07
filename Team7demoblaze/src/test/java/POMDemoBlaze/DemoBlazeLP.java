package POMDemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoBlazeLP {
WebDriver driver;
    
    By email = By.id("loginusername");
    By password = By.id("loginpassword");
    By login = By.linkText("Log in");
    
    public DemoBlazeLP(WebDriver driver){
        this.driver = driver;
    }
    //Set email in textbox
    public void setEmail(String strEmail){
    driver.findElement(email).sendKeys(strEmail);
    }

    //Set password in password textbox
    public void setPassword(String strPassword){
    driver.findElement(password).sendKeys(strPassword);
    }

    //Click on login button
    public void clickLogin(){
    driver.findElement(login).click();
    }
    
    public void loginToDB(String strEmail,String strPassword) {
    //Fill user name
    this.setEmail(strEmail);
    //Fill password
    this.setPassword(strPassword);
    //Click Login button
    this.clickLogin();        
    }
}
