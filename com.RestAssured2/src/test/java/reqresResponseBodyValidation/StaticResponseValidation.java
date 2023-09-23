package reqresResponseBodyValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.when;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class StaticResponseValidation {

	@Test
	public void staticResponse() {
	baseURI="https://reqres.in";
	int expData=8;
	
	
	 Response resp=when().get("/api/users?page=2");
	 int actualData=resp.jsonPath().get("data[1].id");
	 
	Assert.assertEquals(actualData, expData);
	System.out.println("data is matching");
	resp.then()
	.log().all();
	
	
	
	
	
	
	
	
	}
}
