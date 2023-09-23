package crudWithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
@Test
public void deleteProj() {
	Response resp= RestAssured.delete("http://rmgtestingserver:8084/projects/TY_PROJ_75368");
	System.out.println(resp.statusCode());
}
}
