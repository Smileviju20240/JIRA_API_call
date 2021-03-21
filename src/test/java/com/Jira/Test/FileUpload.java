package com.Jira.Test;

import java.io.File;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class FileUpload  extends CreateSessionIDTest{
	
	  @Test
	  
	  public void loadingaFile() {
		  
		  
		  given().log().all()
	             .header("content-Type","multipart/form-data")
	             .header("X-Atlassian-Token","nocheck")
	             .filter(sessionfilter)
	             .multiPart("file",new File(".\\src\\test\\resources\\TestFile"))
	             .when().post("http://localhost:8080/rest/api/2/issue/10201/attachments")
	             .then().log().all().assertThat().statusCode(200)
	             .log().all();
		  
	  }
	}


