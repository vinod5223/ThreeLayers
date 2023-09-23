package testScripts;

import java.sql.SQLException;
import java.time.Duration;
import static io.restassured.RestAssured.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genericUtility.DataBaseLibrary;
import genericUtility.JavaLibrary;

public class ThreeLayerCreateProject {

	@Test
	public void createProjectu() throws SQLException {
		
		JavaLibrary jLib= new JavaLibrary();
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://rmgtestingserver:8084");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra", Keys.TAB,"rmgy@9999", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		String ProjectName="Ayyayyo"+jLib.getRandomNum();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(ProjectName, Keys.TAB, "Random");
		WebElement dd= driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select[@name='status']"));
		
		Select sel= new Select(dd);
		sel.selectByIndex(0);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		String s=driver.findElement(By.xpath("//td[text()='"+ProjectName+"']/preceding-sibling::td")).getText();
		System.out.println(s);
		driver.close();
		baseURI="http://rmgtestingserver:8084";
		when().get("/projects/"+s).then().assertThat().statusCode(200).log().all();
		
		DataBaseLibrary dlib= new DataBaseLibrary();
		dlib.connectToDB();
		String query="select * from project;";
		dlib.readDataFromDBandValidate(query, 1, s);
		dlib.closeDB();
	
	
	}
	
}
