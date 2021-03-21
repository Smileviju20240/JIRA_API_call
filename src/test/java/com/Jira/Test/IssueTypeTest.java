package com.Jira.Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import CreateIssueTestData.AllFields;
import CreateIssueTestData.Fields;
import CreateIssueTestData.IssueTypes;
import CreateIssueTestData.Project;
import CreateIssueTestData.ResponseData;
import io.restassured.http.ContentType;

public class IssueTypeTest extends CreateSessionIDTest{
	
	public String key;
	ResponseData genearateddata = new ResponseData();
	
	@Test(priority=1)
  
  public String creatingIssueTypes(String key) {
	  
	    Project project = new Project("JGT");

		IssueTypes issutypes = new IssueTypes("story");

		AllFields all = new AllFields(project, issutypes, "Creating new Issue summary by API end-point", "Sample Story");

		Fields fields = new Fields(all);
			
	genearateddata = given().log().all()
			                .contentType(ContentType.JSON)
			                .filter(sessionfilter)
			                .body(fields)
			                .when().post("http://localhost:8080/rest/api/2/issue")
			                .then().statusCode(201).log().all()
			                .extract().as(ResponseData.class);
	System.out.println(genearateddata);
	String keyID = genearateddata.getKey();
	return keyID;
	
  }
	
	@Test(priority=2)
	
	public void getIssueDetails() {
	
	given().log().all()
	       .contentType(ContentType.JSON)
	       //.pathParam("key", creatingIssueTypes(key))
	       .filter(sessionfilter)
	       .when().get("http://localhost:8080/rest/agile/1.0/issue/"+creatingIssueTypes(key))
	       .then().statusCode(200).log().all();
	}
  
}
