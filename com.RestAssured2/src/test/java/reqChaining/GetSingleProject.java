package reqChaining;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class GetSingleProject {
	@Test
	public void getProj() {
		baseURI="http:rmgtestingserver";
		port=8084;
		
		String pid= new CreateProject().createProj();
		System.out.println(pid);
		
		when().get("/projects/"+pid)
		.then().log().all();
		
		
		
	}
}
