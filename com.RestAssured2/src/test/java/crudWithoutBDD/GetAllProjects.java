package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAllProjects {

	@Test
	public void getProjs() {
		Response resp=RestAssured.get("http://rmgtestingserver:8084/projects");
//		System.out.println(resp.asPrettyString());
		resp.then().log().body();
//		System.out.println(resp.then().log().all());
	}
	
	
}
