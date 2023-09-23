package parameters;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class FormParameter {
	@Test
	public void formParam() {
		baseURI="https://reqres.in";
		
		given().formParam("job", "nothing").formParam("name", "morpheus")
				
		.when()
		.post("/api/users")
		
		.then()
		.log().all();
	}
}
