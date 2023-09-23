package testScripts;

import static io.restassured.RestAssured.given;

import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import io.restassured.response.Response;
import pojoClassCreateProject.CreateProjectInRMG;

public class CreateProjectAndValidate extends BaseClass{

	@Test
	public void createProjValid() throws SQLException {
		CreateProjectInRMG cp= new CreateProjectInRMG("Vinod", "VR-01234"+jLib.getRandomNum(), "created", "32");
		
		Response resp= given()
		.spec(reqsp).body(cp)
		
		.when()
		.post(EndPointsLibrary.createProject);
		
String expData = rLib.getJsonData(resp, "projectId");
System.out.println(expData);
		String query= "Select * from project;";
String actData=dLib.readDataFromDBandValidate(query, 1, expData);
System.out.println(actData);
Assert.assertEquals(actData, expData);
System.out.println("data matched");

		resp.then()
		.spec(resposp).log().all();
	}
	
}
