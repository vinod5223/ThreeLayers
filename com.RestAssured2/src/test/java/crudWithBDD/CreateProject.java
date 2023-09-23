package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {

	@Test
	public void createProj() {
		
		JavaLibrary jLib= new JavaLibrary();
		
		
		baseURI="http://rmgtestingserver";
		
		port=8084;
		JSONObject jObj= new JSONObject();
		jObj.put("createdBy", "vinodR");
		jObj.put("projectName", "VinodR"+jLib.getRandomNum());
		jObj.put("status", "OnGoing");
		jObj.put("teamSize", 20);
		
		//step 1 pre-condition
		given()
		.contentType(ContentType.JSON)
		.body(jObj)
		
		
		//step 2 actions
		.when()
		.post("/addProject")
		
		//step 3 validation
		.then()
		.assertThat()
		.contentType(ContentType.JSON)
		.statusCode(201)
		.log()
		.all();
		
		
		
	}
}
