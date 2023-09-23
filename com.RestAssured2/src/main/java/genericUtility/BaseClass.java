package genericUtility;

import java.sql.SQLException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	
	public DataBaseLibrary dLib = new DataBaseLibrary();
	public JavaLibrary jLib= new JavaLibrary();
	public RestAssuredLibrary rLib = new RestAssuredLibrary();
	public RequestSpecification reqsp;
	public ResponseSpecification resposp;
	
	
	
	
	@BeforeSuite
	public void bsConfig() throws SQLException {
		dLib.connectToDB();
		reqsp= new RequestSpecBuilder()
				.setBaseUri(IConstants.baseURI)
				.setContentType(ContentType.JSON)
				.build();
		resposp= new ResponseSpecBuilder()
				.expectContentType(ContentType.JSON)
				.build();
		System.out.println("Databasee uuu");
	}
	
	@AfterSuite
	public void asConfig() throws SQLException {
		
		dLib.closeDB();
	}
}


