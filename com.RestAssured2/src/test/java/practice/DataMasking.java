package practice;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DataMasking {
//public String modifiedData;
	@Test
	public void dataMask() {
		baseURI="http://rmgtestingserver:8084";
		JavaLibrary jlib= new JavaLibrary();
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "vinod");
		jobj.put("projectName", "RandomRam"+jlib.getRandomNum());
		jobj.put("status", "created");
		jobj.put("teamSize", "12");
		
//		Response 
//		resp = given()
		//.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Connection", "VINOD-RAM")))
		
//		.body(jobj)
		//.contentType(ContentType.JSON)
		
		Response resp=when().get("/addProject/TY_PROJ_76343");
		

//		
//String 	data=	resp.getBody().asString();	
//data=maskSensitiveData(data);
	
resp.then()

		
		.log().all();
		
		
		
		
	}

	public String maskSensitiveData(String originalData) {
        // Implement your custom logic to mask sensitive data here
        // For example, replace credit card numbers with "XXXX-XXXX-XXXX-XXXX"
        // or email addresses with "user@example.com"
        return "hello";
    }

}
