package practice;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class PostInShopperStack {

	
	@Test
	public void createUser() {
		baseURI="https://www.shoppersstack.com/shopping";
		
		File f= new File("./postingARequest.xml");
		
		given()
		.contentType(ContentType.XML)
		.body(f)
		
		.when()
		.post("/shoppers")
		
		.then()
		
//		.contentType(ContentType.XML)
		.log().all();
		
		
	}
}
