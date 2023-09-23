package responseBodyValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GetResponseValidationWithIndex {

	@Test
	public void grvIndex() {
		String expData="TY_PROJ_17547";
		baseURI="http://rmgtestingserver";
		port=8084;
		
	Response resp = when().get("/projects");	
	String actualData = resp.jsonPath().get("[0].projectId");
		Assert.assertEquals(actualData, expData);
		System.out.println("data verified");
		resp.then().log().all();
	}
}
