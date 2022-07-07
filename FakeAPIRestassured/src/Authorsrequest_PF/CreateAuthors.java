package Authorsrequest_PF;

import org.bouncycastle.mime.Headers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class CreateAuthors {
	@Test
	public void addNewAuthors() {
		RestAssured.baseURI ="http://fakerestapi.azurewebsites.net";
		RequestSpecification request = RestAssured.given()
													.header("Content-Type", "application/json")
													.header("accept","text/plain; v=1.0");
	    Response response = request.body("{\"id\":0,\"idBook\":0,\"firstName\":\"string\",\"lastName\":\"string\"}").post("/api/v1/Authors");
	  
	   // Retrieve the body of the Response
	    ResponseBody body = response.getBody();
	    //Response in raw format
	    System.out.println("Response Body is: " + body.asString());
	    JsonPath jsonPathEvaluator = response.jsonPath();
	    System.out.println("The id is : " + jsonPathEvaluator.get("id"));
	    
	   
	    System.out.println("Status received => " + response.getStatusLine());
		//Response in pretty format
		System.out.println("Response=>" + response.prettyPrint());
		// Assert that correct status code is returned.
		
		  
          int statusCode = response.getStatusCode();
          Assert.assertEquals(statusCode /* actual value */, 200 /* expected value */, "Successful");
         
		 //Assert Status line
          String statusLine = response.getStatusLine();
          Assert.assertEquals(statusLine /* actual value */, "HTTP/1.1 200 OK" /* expected value */, "Correct status code returned");

	}
	
}

