package crudWithoutBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {

	
	@Test
	public void createProj() {
		
		Random r= new Random();
		int rando=r.nextInt(1000);
		
		RequestSpecification reqs=RestAssured.given();
		reqs.contentType(ContentType.JSON); 
		JSONObject jObj=new JSONObject();
		
		 jObj.put("createdBy", "vinod"+rando);
		 jObj.put("projectName", "VinodR"+rando);
		 jObj.put("status", "created");
		 jObj.put("teamSize", 12);
		 
		 reqs.body(jObj);
		 
		 Response resp = reqs.post("http://rmgtestingserver:8084/addProject");
		 System.out.println(resp.getContentType());
//		 System.out.println(resp.prettyPrint());
		 System.out.println(resp.prettyPeek());
		 System.out.println(resp.asString());
		 System.out.println(resp.asPrettyString());
		 System.out.println(resp.statusCode());
		 System.out.println(resp.statusLine());
		 System.out.println(resp.time());
		 Assert.assertEquals(201,resp.statusCode());
		 
	}
}
