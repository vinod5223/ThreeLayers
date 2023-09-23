package validation;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class HeaderValidation {

	@Test
	public void headerValid() {
		baseURI="http://rmgtestingserver";
		port=8084;
		
		String expStatusLine="HTTP/1.1 200 ";
		String expVary="Access-Control-Request-Headers"; 
		String expPragma="no-cache";
		String expContentType= "application/json";
		
		
		
Response resp = when()
		.get("/projects/TY_PROJ_9780");
System.out.println(resp.statusLine());
System.out.println(	resp.getHeaders());	

String actStatusLine= resp.statusLine();
System.out.println(actStatusLine);
Assert.assertEquals(actStatusLine, expStatusLine);

String actVary=	resp.getHeader("Vary");
System.out.println(actVary);
Assert.assertEquals(actVary,expVary);

String actPragma=resp.getHeader("Pragma");
System.out.println(actPragma);
Assert.assertEquals(actPragma, expPragma);

String actContentType= resp.getHeader("Content-Type");
System.out.println(actContentType);
Assert.assertEquals(actContentType, expContentType);

	}
}