package apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.core.Is;

public class RestApiTesting {
	
	@Test
	public void tesingApi() {
		
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		
		//System.out.println(response.asString());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode, 200);
		
		
		response.then().body("data.first_name",contains("Mich","Lindsay","Tobias","Byron","George","Rachel"));
		
		//response.then().body("data[0].first_name",equalTo("Michael"));
		//response.then().body("data[1].email", equalTo("lindsay.ferguson@reqres.in"));
		
	//	response.then().assertThat().body("first_name",equalTo("Michael"));
		
		
	}

}
