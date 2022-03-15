package apitesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class ValidationResponse {

	@Test
	public void validResponse() {
		
		Response response=RestAssured.get("https://reqres.in/api/users?page=2");
		
		given()
		  .accept(ContentType.JSON)
		  .when()
		  .get("https://reqres.in/api/users?page=2")
		  .then()
		  .body("first_name", equalToIgnoringCase("Michael"));
	}
}
