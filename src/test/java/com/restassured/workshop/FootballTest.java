package com.restassured.workshop;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

class FootballTest {
	@Test
	public void listOfComptitions() {	
		given()
		.baseUri("https://api.football-data.org").basePath("/v4").header("X-Auth-Token","fe85ca98cfb44fdaa97228c3404fd6c9")
			.log().all().
		when().
			get("/competitions").
		then().
			statusCode(200).
			body("count", greaterThan(0)).
			log().all();
	};
	@Test
	public void areaById() {	
		String id = "2000";		
		given()
		.baseUri("https://api.football-data.org").basePath("/v4").header("X-Auth-Token","fe85ca98cfb44fdaa97228c3404fd6c9").
		queryParam("areas",id).
		log().all().
		when().
			get("/areas").
		then().
			statusCode(200).
			body("count", greaterThan(0)).
			body("areas[0]", hasEntry(equalTo("name"),equalTo("Afghanistan"))).
			body("areas[0]", hasEntry(equalTo("countryCode"),equalTo("AFG"))).
			body("areas[0]", hasEntry(equalTo("parentArea"),equalTo("Asia"))).
			log().all();
	};
	@Test
	public void deleteArea() {	
		String id = "2000";		
		given()
		.baseUri("https://api.football-data.org").basePath("/v4").header("X-Auth-Token","fe85ca98cfb44fdaa97228c3404fd6c9").
		queryParam("areas",id).
		log().all().
		when().
			delete("/areas").
		then().
			statusCode(400).
			log().all();
	};

}
