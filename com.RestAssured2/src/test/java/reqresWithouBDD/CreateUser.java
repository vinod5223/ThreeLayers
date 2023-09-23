package reqresWithouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateUser {

	@Test
	public void createUser() {
		RequestSpecification reqsp = RestAssured.given();
		reqsp.contentType(ContentType.JSON);
		JSONObject jObj= new JSONObject();
		jObj.put("name", "morpheus");
		jObj.put("job", "leader");
		reqsp.body(jObj);
		Response  resp=reqsp.post("https://reqres.in/api/users");
		System.out.println(resp.statusCode());
		System.out.println(resp.prettyPeek());
		
	}
}
