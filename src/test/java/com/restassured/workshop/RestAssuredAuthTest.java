package com.restassured.workshop;


import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;
public class RestAssuredAuthTest extends BaseClassAuth {
	
	public void test1() {
			
		RestAssured.given()
			.get()
			.then()
			.statusCode(200)
			.body("authenticated", equalTo(true));
			
	}

}
