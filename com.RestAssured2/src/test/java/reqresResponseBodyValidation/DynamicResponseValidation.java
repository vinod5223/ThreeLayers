package reqresResponseBodyValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {

	@Test
	public void dynamic() {
		
		baseURI="https://reqres.in";
		
		Response resp=when().get("/api/users?page=2");
		List<Integer> ids=resp.jsonPath().get("data.id");
		int expData=12;
		boolean flag=false;
		for(int id:ids) {
			if(id==expData) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println("verified");
		}
		resp.then().log().all();
		
		
	}
}
