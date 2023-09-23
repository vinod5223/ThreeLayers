package reqresParameter;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class QueryParameter {
@Test
public void queryParam() {
	
	baseURI="https://reqres.in";
	given().queryParam("page", 2)
	
	.when().get("/api/users").then().statusCode(200).contentType(ContentType.JSON).log().all();
}
}
