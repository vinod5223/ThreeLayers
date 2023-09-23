package authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BasicPreemptiveDigestAuth {

	@Test
	public void preemptiveAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).contentType(ContentType.JSON).log().all();
	}
	
	@Test
	public void digestAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().digest("rmgyantra", "rmgy@9999")
 		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).contentType(ContentType.JSON).log().all();
		
	}
	@Test
	public void basicAuth() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
 		
		.when()
		.get("/login")
		
		.then().assertThat().statusCode(202).contentType(ContentType.JSON).log().all();
		
	}
}
