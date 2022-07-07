package Fotor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FotorSignup {

public static void main(String[] args) throws FileNotFoundException, DocumentException
{
        WebDriver driver;
        String driverPath= "C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\selenium jar\\chromedriver_win32\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",driverPath);
        driver = new ChromeDriver();

        //@Test(invocationCount=2)

        File src= new File("C:\\Users\\shivr\\eclipse-workspace\\FotorWebDriverProject\\TestResources\\FOTOR.xml");
        FileInputStream fis = new FileInputStream(src);   
        SAXReader saxReader = new SAXReader();
        org.dom4j.Document document = saxReader.read(fis);


        driver.findElement(By.name(document.selectSingleNode("//SignIn_detail/username").getText())).sendKeys("shivrajsable83@gmail.com");
        driver.findElement(By.name(document.selectSingleNode("//SignIn_detail/password").getText())).sendKeys("Shivraj@8007");
        driver.findElement(By.name(document.selectSingleNode("//SignIn_detail/Sign In").getText())).click();

        

       // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(msg)));

        

        driver.close();
        System.out.println("Successfully read key values from xml file!!");
    }
}
