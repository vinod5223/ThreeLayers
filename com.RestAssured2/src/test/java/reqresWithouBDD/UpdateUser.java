package reqresWithouBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUser {

	@Test
public void updateProj() {
	RequestSpecification reqsp = RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	JSONObject jObj= new JSONObject();
	jObj.put("name","morpheus");
	jObj.put("job","zion resident");
	
	reqsp.body(jObj);
	Response resp= reqsp.put("https://reqres.in/api/users/2");
	System.out.println(resp.statusCode());

}
}
