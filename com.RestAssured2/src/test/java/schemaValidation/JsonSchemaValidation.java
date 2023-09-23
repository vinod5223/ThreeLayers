package schemaValidation;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;
import static io.restassured.RestAssured.*;
import java.io.File;

public class JsonSchemaValidation {

	@Test
	public void jsonSchemaValidate() {
		
		baseURI="https://reqres.in";
		
		File f= new File("./reqresJsonSchema.json");
		when()
		.get("/api/users?page=2")
		.then()
		.assertThat()
       .body(JsonSchemaValidator.matchesJsonSchema(f))
		.log().all();
		
		
	}
}
