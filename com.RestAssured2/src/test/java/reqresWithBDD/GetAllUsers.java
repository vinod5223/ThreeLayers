package reqresWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class GetAllUsers {

	@Test
	public void getAllUsers() {
		
		baseURI="https://reqres.in/";
		
		when()
		.get("api/users")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
	}
}
