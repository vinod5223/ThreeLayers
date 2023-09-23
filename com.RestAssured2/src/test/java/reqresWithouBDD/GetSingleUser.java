package reqresWithouBDD;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleUser {

	@Test
	public void getSingle() {
		Response resp=RestAssured.get("https://reqres.in/api/users/1");
		System.out.println(resp.statusCode());
		System.out.println(resp.prettyPeek());
		Assert.assertEquals(200, resp.statusCode());
	
	}
}
