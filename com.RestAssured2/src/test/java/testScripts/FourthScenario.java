package testScripts;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import genericUtility.BaseClass;
import genericUtility.EndPointsLibrary;
import genericUtility.FileUtilsLibrary;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProjectsPage;


public class FourthScenario extends BaseClass{
@Test
public void deleteProject() throws InterruptedException, IOException, SQLException {
	FileUtilsLibrary flib  = new FileUtilsLibrary();
	
	
	
	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(flib.readDataFromPropFile("url"));
	LoginPage lp = new LoginPage(driver);
	lp.loginToRMG(flib);
	HomePage hp = new HomePage(driver);
	hp.clickOnProject();
	ProjectsPage pp= new ProjectsPage(driver);
	String projectName="Vinod"+jLib.getRandomNum();
	pp.createProject(projectName, 2);
	String s=driver.findElement(By.xpath("//td[text()='"+projectName+"']/preceding-sibling::td")).getText();
	driver.close();
	
	given().spec(reqsp)
	.when().delete(EndPointsLibrary.deleteProject+s);
	
	String query= "select * from project;";
	dLib.readDataFromDBandValidate(query, 1, s);
	
	
	
	
	
	
}
}












