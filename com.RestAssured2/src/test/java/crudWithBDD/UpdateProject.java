package crudWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class UpdateProject {
@Test
public void updateProj() {
	
	baseURI="http://rmgtestingserver";
	port=8084;
	
	JSONObject jObj= new JSONObject();
	jObj.put("createdBy", "vinodR");
	jObj.put("projectName", "VinodR606");
	jObj.put("status", "Created");
	jObj.put("teamSize", 30);
	
	
	given()
	.contentType(ContentType.JSON)
	.body(jObj)
	
	.when()
	.put("/projects/TY_PROJ_75551")
	
	.then()
	.assertThat()
	.statusCode(200)
	.contentType(ContentType.JSON)
	.log()
	.all();
	
}
}
