package rmgWithPojo;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import pojoClassCreateProject.CreateProjectInRMG;

public class CreateProjectWithPojo {
 
	@Test
	public void createProjWithPOJO() {
		
		JavaLibrary jlib= new JavaLibrary();
		
		CreateProjectInRMG cpr= new CreateProjectInRMG("vinodRam", "VinodR-0"+jlib.getRandomNum(), "onGoing", "12");
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.body(cpr)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThanOrEqualTo(3000l),TimeUnit.MILLISECONDS)
		.log().all();
	
	
	
	
	}
	
}
