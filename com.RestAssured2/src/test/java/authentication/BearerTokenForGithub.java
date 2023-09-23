package authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BearerTokenForGithub {

	@Test
	public void bTokenForCreateUser() {
		baseURI="https://api.github.com";
		
		JavaLibrary jlib= new JavaLibrary();
		
		JSONObject jObj= new JSONObject();
		jObj.put("name", "harappan"+jlib.getRandomNum());
		
		RequestSpecification reqsp = given().auth().oauth2("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").body(jObj).contentType(ContentType.JSON);
		
		reqsp.when().post("/user/repos")
		.then().statusCode(201).contentType(ContentType.JSON).log().all();
		
		
		
		
	}
	
	@Test
	public void bTokenForGetUser() {
		baseURI="https://api.github.com";
		
				given().auth()
				.oauth2("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")
				.when()
				.get("/user/repos")
				.then().log().all();
	}
}
