package dataProvider;
import static io.restassured.RestAssured.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import pojoClassCreateProject.CreateProjectInRMG;



public class DP_PostInRMG {

	@DataProvider
	public Object[][] data() {
		Object[][] obj= new Object[2][4];
		
		obj[0][0]="VinodRam";
		obj[0][1]="VinodR-01";
		obj[0][2]="on-going";
		obj[0][3]=12;
		
		obj[1][0]="Ramilla";
		obj[1][1]="ram-01";
		obj[1][2]="created";
		obj[1][3]=22;
		
		return obj;
		
	}
	
	@Test(dataProvider = "data")
	public void createProject(String createdBy, String projectName, String status, String teamSize) {
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaLibrary jlib= new JavaLibrary();
CreateProjectInRMG cp=new CreateProjectInRMG(createdBy, projectName+jlib.getRandomNum(), status, teamSize);

		given().body(cp).contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		.then().statusCode(201).log().all();
		
		
	}
}



















