package createProjectUsingHashMap;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreateProjectHashMap {

	@Test
	public void createProjWithHashMap() {
		
		baseURI="http://rmgtestingserver";
		port=8084;
		JavaLibrary jLib= new JavaLibrary();
		
		
		HashMap<Object, Object> hmap= new HashMap<Object, Object>();
		hmap.put("createdBy", "VinodRam");
		hmap.put("projectName", "vinodR-0"+jLib.getRandomNum());
		hmap.put("status", "On-Going");
		hmap.put("teamSize", 14);
		
		given()
		.body(hmap)
		.contentType(ContentType.JSON)
		
		.when()
		.post("/addProject")
		
		.then()
		.assertThat()
		.statusCode(201)
		.time(Matchers.lessThanOrEqualTo(3000l),TimeUnit.MILLISECONDS)
		.log()
		.all();
		
	}
}
