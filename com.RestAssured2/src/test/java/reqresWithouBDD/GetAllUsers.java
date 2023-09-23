package reqresWithouBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllUsers {

	@Test
	public void getAllUsers() {
		Response resp=RestAssured.get("https://reqres.in/api/users");
		System.out.println(resp.statusCode());
		System.out.println(resp.prettyPeek());
	}
}
