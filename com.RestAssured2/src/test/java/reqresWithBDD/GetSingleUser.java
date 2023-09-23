package reqresWithBDD;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GetSingleUser {

	@Test
	public void getSingleUser() {

		baseURI="https://reqres.in/";
		
		when()
		.get("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
//		.time(Matchers.lessThanOrEqualTo(5000l),TimeUnit.MILLISECONDS)
//		.time(Matchers.lessThan(3000l), TimeUnit.MILLISECONDS)
		.log().all();
	}
	
}
