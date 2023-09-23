package practice;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class ArrayObjectOrNot {

	@Test
	public void arrayObj() {
		
		baseURI="http://rmgtestingserver:8084";
		
		when().get("/projects")
		.then()
		.assertThat()
		.body("", Matchers.instanceOf(List.class)).log().all();
		
		
		
	}
	
	
	@Test
	public void masking() {

		baseURI="http://rmgtestingserver:8084";
		
Response resp = when().get("/projects/TY_PROJ_9938");
String respBody= resp.getBody().asString();

		
	}
	
	
	
	
	
}
