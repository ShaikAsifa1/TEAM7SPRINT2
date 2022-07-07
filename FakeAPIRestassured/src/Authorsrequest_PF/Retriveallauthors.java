package Authorsrequest_PF;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Retriveallauthors {
	@Test
	public void getallauthors() {
			
			RestAssured.baseURI ="http://fakerestapi.azurewebsites.net";
		RequestSpecification request = RestAssured.given();
	    Response response = request.get("/api/v1/Authors");
	 // Retrieve the body of the Response
	    ResponseBody body = response.getBody();
	    //Response in raw format
	    System.out.println("Response Body is: " + body.asString());
	    // Print the status and message body of the response received from the server
	    System.out.println("Status received => " + response.getStatusLine());
	    //Response in pretty format
	    System.out.println("Response=>" + response.prettyPrint());
	 // Get all the headers and then iterate over allHeaders to print each header
	    Headers allHeaders = response.headers();
	   // Iterate over all the Headers
	    for(Header header : allHeaders) {
	      System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	    }
	    // Assert that correct status code is returned.
	    int statusCode = response.getStatusCode();
	    Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Successful");

	    //Assert Status line
	    String statusLine = response.getStatusLine();
	    //Assert.assertEquals(statusLine /actual value/, "HTTP/1.1 200 OK" /expected value/, "Correct status code returned");
	    // Access header with a given name.
	    String contentType = response.header("Content-Type");
	    System.out.println("Content-Type value: " + contentType);
	    Assert.assertEquals(contentType /* actual value */,"application/json; charset=utf-8; v=1.0"/* expected value */);
	   // Access header with a given name.
	    String serverType = response.header("Server");
	    System.out.println("Server value: " + serverType);
	    Assert.assertEquals(serverType /* actual value*/, "Kestrel" /* expected value */);
	   // Access header with a given name. Header = Content-Encoding
	    String acceptLanguage = response.header("Transfer-Encoding");
	    System.out.println("Transfer-Encoding: " + acceptLanguage);
	    
	   
		
		

	}
	}
