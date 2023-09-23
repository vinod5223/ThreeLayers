package coops;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;


public class AuthenticationWithFormParam {
	
	@Test
	public void oAuth2Coops() {
		baseURI="http://coop.apps.symfonycasts.com";
		
		Response resp=given()
		.formParam("client_id", "JailCollege")
		.formParam("client_secret", "f768550282f88c8c443ea0748897cacf")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://www.chaina.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("/token");
		
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		resp.then().log().all();
		
		given().auth().oauth2(token)
		.pathParam("userID",4676)
		
		.when().post("/api/{userID}/barn-unlock")
		
		.then().log().all();
		
	}
	
	@Test
	public void eggsCollected() {
baseURI="http://coop.apps.symfonycasts.com";
		
		Response resp=given()
		.formParam("client_id", "JailCollege")
		.formParam("client_secret", "f768550282f88c8c443ea0748897cacf")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://www.chaina.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("/token");
		
		String token=resp.jsonPath().get("access_token");
		System.out.println(token);
		resp.then().log().all();
		
		given().auth().oauth2(token)
		.pathParam("userID",4676)
		.when().post("/api/{userID}/eggs-count")
		
		.then().log().all();
		

		
		
		
		
	}
}








