package postUsingFile;


import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectUsingFile {

	@Test
	public void createProjWithFile() {

		
//		baseURI="http://rmgtestingservers";
		baseURI="http://rmgtestingserver";
		port=8084;
		
		File f= new File("./postingInRMG.json");
		
		given()
		.contentType(ContentType.JSON)
		.body(f)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.contentType(ContentType.JSON)
		.time(Matchers.lessThanOrEqualTo(3000l), TimeUnit.MILLISECONDS)
		.log()
		.all();
	}
}
