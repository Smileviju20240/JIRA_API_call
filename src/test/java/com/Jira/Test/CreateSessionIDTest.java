package com.Jira.Test;

import org.testng.annotations.Test;

import authTestData.AuthenticationTestData;
import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class CreateSessionIDTest {
	
	SessionFilter sessionfilter = new SessionFilter();
	
  @Test
  
  public void creatingSessionID() {
	  
	  RestAssured.baseURI = "http://localhost:8080";
	  
	  AuthenticationTestData authdata = new AuthenticationTestData();
	  
	  authdata.setUsername("Smileviju30260");
	  authdata.setPassword("Smile@123");
	  
	                    given().log().all()
	                           .contentType(ContentType.JSON)
	                           .filter(sessionfilter)
	                           .body(authdata)
	                           .when().post("/rest/auth/1/session")
	                           .then().statusCode(200).log().all()
	                           .extract().asString();  
	  
  }
}
