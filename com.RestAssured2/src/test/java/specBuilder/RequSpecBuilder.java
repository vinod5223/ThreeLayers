package specBuilder;
import static io.restassured.RestAssured.*;
import  io.restassured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClassCreateProject.CreateProjectInRMG;

import org.testng.annotations.Test;

import genericUtility.JavaLibrary;

public class RequSpecBuilder {

	@Test
	public void reqSpecBuilder() {
		JavaLibrary jlib= new JavaLibrary();
		CreateProjectInRMG cp= new CreateProjectInRMG("Random", "tyss"+jlib.getRandomNum(), "created", "15");
	RequestSpecification reqspb = new  RequestSpecBuilder().setBaseUri("http://rmgtestingserver:8084").setContentType(ContentType.JSON).build();
		
ResponseSpecification respb = new ResponseSpecBuilder().expectStatusCode(201)
.expectContentType(ContentType.JSON).build();

	

	given().spec(reqspb).body(cp)
	
	.when()
	.post("/addProject")

	.then()
	.spec(respb).log().all();

	
	}
	
}
