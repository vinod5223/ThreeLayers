package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {

	@Test
	public void getSingleProj() {
		Response resp=RestAssured.get("http://rmgtestingserver:8084/projects/TY_PROJ_75368");
		System.out.println(resp.getStatusCode());
		System.out.println(resp.prettyPeek());
	}
}
