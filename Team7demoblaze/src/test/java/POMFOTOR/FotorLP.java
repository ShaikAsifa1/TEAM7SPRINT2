package POMFOTOR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FotorLP {
WebDriver driver;
    
    By email = By.id("rootLogin");
    By password = By.className("inputClass inputBorderRed");
    By login = By.linkText("Sign In");

    public FotorLP(WebDriver driver){
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
    
    public void loginToAP(String strEmail,String strPassword) {
    //Fill user name
    this.setEmail(strEmail);
    //Fill password
    this.setPassword(strPassword);
    //Click Login button
    this.clickLogin();        
    }
}
