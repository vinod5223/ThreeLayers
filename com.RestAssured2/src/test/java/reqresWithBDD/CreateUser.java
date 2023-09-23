package reqresWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateUser {
@Test
public void createUser() {
	baseURI="https://reqres.in/";
	
	JSONObject jObj= new JSONObject();
	jObj.put("name", "Sasmitha");
	jObj.put("job", "ATE");
	
	given()
	.contentType(ContentType.JSON)
	.body(jObj)
	
	.when()
	.post("api/users")
	
	.then()
	.assertThat()
	.statusCode(201)
	.contentType(ContentType.JSON)
	.log().all();
	
}
}
