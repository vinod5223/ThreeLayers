package testScripts;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.DataBaseLibrary;
import genericUtility.EndPointsLibrary;
import genericUtility.ExcelUtility;
import genericUtility.FileUtilsLibrary;
import genericUtility.IConstants;
import io.restassured.response.Response;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import pojoClassCreateProject.CreateProjectInRMG;

/**
 * the scenario is: creating a project through API and capture the projectID and fetch that created project in GUI, then validate wrt 
 * database whether it has been created. 
 * @author USER
 */

public class SecondScenario extends BaseClass{

	@Test
	public void createProject() throws IOException, InterruptedException, SQLException {
		
//		IConstants.baseURI+EndPointsLibrary.createProject
		ExcelUtility elib= new ExcelUtility();
		FileUtilsLibrary flib= new FileUtilsLibrary();
		DataBaseLibrary dlib= new DataBaseLibrary();
		
		String pName=elib.readDataFromExcel("createProject", 1, 0)+jLib.getRandomNum();
		CreateProjectInRMG cp= new CreateProjectInRMG(elib.readDataFromExcel("createProject", 0, 0),pName ,  elib.readDataFromExcel("createProject", 2, 0),  elib.readDataFromExcel("createProject", 3, 0));
		Response resp = given()
		.spec(reqsp).body(cp)
		.when().post(IConstants.baseURI+EndPointsLibrary.createProject);
//		String pid=resp.jsonPath().get("projectId");
		resp.then().log().all();
		;
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(flib.readDataFromPropFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.loginToRMG(flib);
		HomePage hp= new HomePage(driver);
		hp.clickOnProject();
		String s=driver.findElement(By.xpath("//td[text()='"+pName+"']/preceding-sibling::td")).getText();
		driver.close();
		dlib.connectToDB();
		String query="select * from project;";
		dlib.readDataFromDBandValidate(query, 1, s);
		dlib.closeDB();
		
	}
}
