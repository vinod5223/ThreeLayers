package reqresWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateUser {
@Test
public void updateUser() {
		
		baseURI="https://reqres.in/";
		
		JSONObject jObj= new JSONObject();
		jObj.put("name", "morpheus");
		jObj.put("job", "zion resident");
		
		given()
		.body(jObj)
		
		
		.when()
		.put("/api/users/2")
		
		.then()
		.assertThat()
		.statusCode(200)
		.contentType(ContentType.JSON)
		.log().all();
		
}
}
