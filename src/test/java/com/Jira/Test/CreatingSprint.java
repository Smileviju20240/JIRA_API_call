package com.Jira.Test;

import org.testng.annotations.Test;

import createSprintdata.CreateSprintTestData;
import createSprintdata.Response;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreatingSprint extends CreateSessionIDTest{
	
	Response genearateddata = new Response();
	public int sprintID;
	
  @Test
  
  public int creatingNewSprint(int sprintId) {
	  
	  RestAssured.baseURI = "http://localhost:8080";
	  
	  CreateSprintTestData params = new CreateSprintTestData("sprint-3", "2021-04-11T15:22:00.000+10:00", "2021-04-20T01:22:00.000+10:00", 1);
	  
	  genearateddata = given().log().all()
	                          .contentType(ContentType.JSON)
	                          .filter(sessionfilter)
	                          .body(params)
	                          .when().post("/rest/agile/1.0/sprint")
	                          .then().statusCode(201).log().all()
	                          .extract().as(Response.class);
	  
	  System.out.println(genearateddata);
	  int sprintID = genearateddata.getId();
	  return sprintID;
	  
  }
  
  @Test
  
  public void fetchingSprintInfo() {
	  
	  RestAssured.baseURI = "http://localhost:8080";
	  
	  given().log().all()
	         .contentType(ContentType.JSON)
	         .pathParam("sprintId", creatingNewSprint(sprintID))
	         .filter(sessionfilter)
	         .when().get("/rest/agile/1.0/sprint/{sprintId}")
	         .then().statusCode(200).log().all();
	  
  }
  
}
