package Authorsrequest_PF;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeleteAuthorById {
	@Test
	public void delUser() {
		RestAssured.baseURI ="http://fakerestapi.azurewebsites.net";
		RequestSpecification request = RestAssured.given();
		Response response=request.delete("/api/v1/Authors/4");
		ResponseBody body = response.getBody();
		    //Response in raw format
		    System.out.println("Response Body is: " + body.asString());
		    Assert.assertEquals(200,response.getStatusCode());
		    System.out.println("The status code is:" + response.getStatusCode());
		    
		    
		  
	}
}
