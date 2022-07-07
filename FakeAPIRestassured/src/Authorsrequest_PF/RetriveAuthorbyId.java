package Authorsrequest_PF;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class RetriveAuthorbyId {
	@Test
	public void getAuthorbyID() {
		
		RestAssured.baseURI ="http://fakerestapi.azurewebsites.net";
		
		//define request format
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/api/v1/Authors/1");
		
		
		ResponseBody body = response.getBody();
		System.out.println("Response Body is: " + body.asString());
		System.out.println("Status received => " + response.getStatusLine());
		System.out.println("Response=>" + response.prettyPrint());
		
		// Assert that correct status code is returned.
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Successful");
       
		 //Assert Status line
        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");
      
        //Access header with a given name.
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);
        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8; v=1.0" /* expected value */);
        // Access header with a given name.
        String serverType = response.header("Server");
        System.out.println("Server value: " + serverType);
        Assert.assertEquals(serverType /* actual value */, "Kestrel" /* expected value */);
        // Access header with a given name. Header = Content-Encoding
        String acceptLanguage = response.header("Transfer-Encoding");
        System.out.println("Transfer-Encoding: " + acceptLanguage);

}
}
