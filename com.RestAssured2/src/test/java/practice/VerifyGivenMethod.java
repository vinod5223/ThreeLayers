package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class VerifyGivenMethod {
@Test
public void verify() {
	
	RestAssured.given().body("").when().then().log().all();
	
	
}

}
