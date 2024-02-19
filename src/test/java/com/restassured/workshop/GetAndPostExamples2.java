package com.restassured.workshop;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class GetAndPostExamples2 {
	
	@Test
	public void testGet() {
		RestAssured.baseURI = "https://reqres.in/api";
		given().
			log().all().
		when().
			get("/users?page=2").
		then().
			statusCode(200).
			body("data.size()", is(6)).
			body("data.first_name", hasItems("George", "Rachel"));
	};
	
	@Test
	public void testPost() {		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "daniela");
		request.put("job", "qa automation");
		
		System.out.println(request.toJSONString());
		
		RestAssured.baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type","application/json").
			contentType(ContentType.JSON).
			body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201).log().all();
	}
}
