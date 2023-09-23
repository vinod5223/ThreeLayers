package crudWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetSingleProject {

	@Test
	public void getSingleProj() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		when()
		.get("projects/TY_PROJ_75551")
		
		
		.then()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log()
		.all();
		
		
		
		
	}
}
