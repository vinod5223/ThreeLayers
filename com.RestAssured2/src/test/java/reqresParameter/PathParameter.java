package reqresParameter;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class PathParameter {
@Test
public void pathParam() {
	baseURI="https://reqres.in";
	
	given().pathParam("id", 2)
	
	.when().get("/api/users/{id}")
	.then().log().all();
	
}
}
