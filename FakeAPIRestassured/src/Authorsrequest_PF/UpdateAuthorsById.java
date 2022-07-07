package Authorsrequest_PF;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class UpdateAuthorsById {
	@Test
    public void UpdateUser() throws IOException {
    
    
    
    
     FileInputStream fis = new FileInputStream("C:\\Users\\shivr\\OneDrive\\Desktop\\selenium\\Data source\\UpdateAuthor.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet ws = workbook.getSheetAt(0);
            int rownum  = ws.getLastRowNum();
            int colnum = ws.getRow(0).getPhysicalNumberOfCells();
            System.out.println(colnum);
            System.out.println(rownum);
            XSSFCell id;
            XSSFCell idBook;
            XSSFCell firstName;
            XSSFCell lastName;
            
            for(int i = 0; i <= rownum ; i++) {
                
                id = ws.getRow(i).getCell(0);
                idBook = ws.getRow(i).getCell(1);
                firstName = ws.getRow(i).getCell(2);
                lastName = ws.getRow(i).getCell(3);
                
                
                RestAssured.baseURI = "http://fakerestapi.azurewebsites.net";
                
                System.out.println(id.toString());
                System.out.println(idBook.toString());
                System.out.println(firstName.toString());
                System.out.println(lastName.toString());
                
                RequestSpecification request = RestAssured.given();
                Response response = request.body("{\"id\":\"" +id +"\", \"idBook\":\"" + idBook +"\", \"firstName\":\"" + firstName+"\", \"lastName\":\"" + lastName+"\"}").put("/api/v1/Authors");
                ResponseBody body = response.getBody();
                System.out.println(body.asString());
                
                
            }
            
            
	}

}
