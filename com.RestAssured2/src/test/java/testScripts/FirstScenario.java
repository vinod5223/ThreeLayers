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
import genericUtility.DataBaseLibrary;
import genericUtility.EndPointsLibrary;
import genericUtility.FileUtilsLibrary;
import genericUtility.IConstants;
import genericUtility.JavaLibrary;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProjectsPage;


/**
 * this below scenario is:
 * creating a project through GUI and fetching and capturing it through API and verifying it in the database
 * @author USER
 *
 */

public class FirstScenario extends BaseClass {

	@Test
	public void createProj() throws InterruptedException, IOException, Exception {
		
		FileUtilsLibrary flib= new FileUtilsLibrary();
		JavaLibrary jlib= new JavaLibrary();
		DataBaseLibrary dlib= new DataBaseLibrary();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(flib.readDataFromPropFile("url"));
		LoginPage lp= new LoginPage(driver);
		lp.loginToRMG(flib);
		HomePage hp= new HomePage(driver);
		hp.clickOnProject();
		ProjectsPage pp= new ProjectsPage(driver);
		String ProjectName="vammoo"+jlib.getRandomNum();
		pp.createProject(ProjectName, 1);
		String s=driver.findElement(By.xpath("//td[text()='"+ProjectName+"']/preceding-sibling::td")).getText();
		driver.close();
		
		given().spec(reqsp).when().get(IConstants.baseURI+EndPointsLibrary.getSingleProject+s).then().spec(resposp).log().all();
		dlib.connectToDB();
		String query= "select * from project;";
		dlib.readDataFromDBandValidate(query, 1, s);
		dlib.closeDB();
		
		
		
	}
}
