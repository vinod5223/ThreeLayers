package crudWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import genericUtility.JavaLibrary;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {

	
	@Test
	public void updateProj() {
		JSONObject jObj=new JSONObject();
		 jObj.put("status", "OnGoing");
		 jObj.put("teamSize", 25);
		
		JavaLibrary jlib= new JavaLibrary();
	RequestSpecification reqsp=RestAssured.given();
	reqsp.contentType(ContentType.JSON);
	
	reqsp.body(jObj);
	
	Response resp = reqsp.put("http://rmgtestingserver:8084/projects/TY_PROJ_75510");
	System.out.println(resp.statusCode());
	System.out.println(resp.prettyPeek());
	
	
	
	
	}
	
}
