package testScripts;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import static io.restassured.RestAssured.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import genericUtility.FileUtilsLibrary;
import genericUtility.IConstants;
import genericUtility.JavaLibrary;
import io.restassured.http.ContentType;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProjectsPage;
import pojoClassCreateProject.CreateProjectInRMG;

/**
 * create a project in GUI and update it with API and verify whether it is updated in database
 * @author USER
 *
 */

public class ThirdScenario extends BaseClass{

	@Test
	public void updateProj() throws InterruptedException, IOException, SQLException {
		
		FileUtilsLibrary flib  = new FileUtilsLibrary();
		JavaLibrary jlib= new JavaLibrary();
		
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(flib.readDataFromPropFile("url"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToRMG(flib);
		HomePage hp = new HomePage(driver);
		hp.clickOnProject();
		ProjectsPage pp= new ProjectsPage(driver);
		String projectName="Vinod"+jlib.getRandomNum();
		pp.createProject(projectName, 2);
		String s=driver.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td")).getText();
		
		CreateProjectInRMG cp= new CreateProjectInRMG("abboo", "ayyayyoo", "OnGogin", "32");
		
		driver.close();
		given().spec(reqsp).contentType(ContentType.JSON).body(cp)
		.when().put(IConstants.baseURI+EndPointsLibrary.updateProject+s)
		.then().log().all();
		
//		dLib.connectToDB();
//		String query1="select * from project;";
//		dLib.readDataFromDBandValidate(query1, 1, s);

		String pid="'"+s+"'";
		String query= "select * from project where project_id="+pid+";";
		dLib.readMultipleDataInRMG(query);
		
		dLib.closeDB();
		
	}
}




















