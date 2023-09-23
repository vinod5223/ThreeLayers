package reqChaining;

import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojoClassCreateProject.CreateProjectInRMG;

import static io.restassured.RestAssured.*;


public class CreateProject {

	@Test
	public String createProj() {
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaLibrary jlib= new JavaLibrary();
		
		CreateProjectInRMG cpr= new CreateProjectInRMG("vinodRam", "vinodR-0"+jlib.getRandomNum(), "on-going", "11");
		
		RequestSpecification reqsp = given()
		.contentType(ContentType.JSON)
		.body(cpr);
		
		Response resp = reqsp.when()
		.post("/addProject");
		
		String pjId=resp.jsonPath().get("projectId");
		
		resp.then()
		.log().all();
		return pjId;
	}
}
