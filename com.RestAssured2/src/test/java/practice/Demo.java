package practice;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import pojoClassCreateProject.CreateProjectInRMG;

public class Demo {

	@Test(dataProvider = "data1")
	public void pojodata(String createdBy,String projectName,String status,String teamSize)
	{

		CreateProjectInRMG p=new CreateProjectInRMG(createdBy, projectName, status, teamSize);

		given()
		.body(p)
		.contentType(ContentType.JSON)	
		.when()
		.post("http://rmgtestingserver:8084/addProject")
		.then().log().all();

	}
	@DataProvider
	public Object[][] data()
	{
		Object[][] obj=new Object[3][4];

		obj[0][0]="king";
		obj[0][1]="rmg";
		obj[0][2]="ongoing";
		obj[0][3]=5;

		obj[1][0]="king1";
		obj[1][1]="rmg1";
		obj[1][2]="ongoing";
		obj[1][3]=6;

		obj[2][0]="king2";
		obj[2][1]="rmg2";
		obj[2][2]="ongoing";
		obj[2][3]=7;


		return obj;

	}
	@DataProvider
	public Object[][] data1() throws EncryptedDocumentException, IOException
	{

		FileInputStream fis=new FileInputStream("C:\\Users\\Athar\\eclipse-workspace\\RestAssured\\src\\test\\resources\\dataprovider.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();//start from zero//0//4
		System.out.println(rowcount);
		int cellcount=sh.getRow(1).getLastCellNum();//starts from 1//2
		System.out.println(cellcount);
		Object[][] obj=new Object[rowcount][cellcount];//coz excel matrix count is 5 and i got rowcount 4so i add 1 with it;
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				 obj[i-1][j]=sh.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		return obj;

		

	}
}