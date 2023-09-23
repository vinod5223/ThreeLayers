package responseBodyValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.List;

public class GetReponseValidationWithoutIndex {

	@Test
	public void getResponse() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expData="TY_PROJ_75771";
		
		
		Response resp=when().get("/projects");
				
		List<String> projID=resp.jsonPath().get("projectId");
		boolean flag=false;
		for (String pid : projID) {
			
			if(pid.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag==true) {
			System.out.println("data verified");
		}
		
		resp.then().log().all();
		
	}
}
