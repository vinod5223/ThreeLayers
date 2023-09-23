package parameters;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoClassCreateProject.CreateProjectInRMG;

public class PathParameter {

	@Test
	public void pathParam() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		JavaLibrary jLib= new JavaLibrary();
		
		CreateProjectInRMG cpr= new CreateProjectInRMG("vinodRam","vinodR-0"+jLib.getRandomNum(), "created", "13");
		
		Response resp = given()
		.contentType(ContentType.JSON)
		.body(cpr)
		
		.when()
		.post("/addProject");
		
		String pid=resp.jsonPath().get("projectId");
		
		resp.then().log().all();
		
		given().pathParam("pro", pid)
		
		.when().get("/projects/{pro}").then().log().all();
		
		
		
	}
}
