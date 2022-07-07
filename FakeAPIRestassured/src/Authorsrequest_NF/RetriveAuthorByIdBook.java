package Authorsrequest_NF;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RetriveAuthorByIdBook {
	@Test
	public void getAuthorbyIDBook() {
		
		RestAssured.baseURI ="http://fakerestapi.azurewebsites.net";
		
		//define request format
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/api/v1/Authors/authors/books/8765343098765");
		
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());
		
		// Assert that correct status code is returned.
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 400 /*expected value*/, "Successful");
       
		 //Assert Status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 400 Bad Request" /*expected value*/, "Correct status code returned");
      
		

}
}

