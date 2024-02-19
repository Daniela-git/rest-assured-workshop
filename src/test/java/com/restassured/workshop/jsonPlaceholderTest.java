package com.restassured.workshop;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class jsonPlaceholderTest {
  @Test
	public void creatingAPost() {	
    JSONObject request = new JSONObject();
    request.put("title", "daniela");
		request.put("body", "qa automation");
		request.put("userId", "2000");
		given()
      .baseUri("https://jsonplaceholder.typicode.com").
      header("Content-Type","application/json; charset=UTF-8").
			body(request.toJSONString())
			.log().all().
		when().
			post("/posts").
		then().
			statusCode(201).
			body("title",equalTo("daniela")).
			log().all();
	};
  @Test
	public void updatingAPost() {	
    JSONObject request = new JSONObject();
    request.put("title", "daniela");
		request.put("body", "qa automation");
		request.put("userId", "2000");
		given()
      .baseUri("https://jsonplaceholder.typicode.com").
      header("Content-Type","application/json; charset=UTF-8").
			body(request.toJSONString())
			.log().all().
		when().
			put("/posts/1").
		then().
			statusCode(200).
			body("title",equalTo("daniela")).
			body("body",equalTo("qa automation")).
			body("userId",equalTo("2000")).
			log().all();
	};
}
