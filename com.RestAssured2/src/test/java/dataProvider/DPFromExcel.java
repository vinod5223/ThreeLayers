package dataProvider;

import java.io.FileInputStream;
import static io.restassured.RestAssured.*;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoClassCreateProject.CreateProjectInRMG;

public class DPFromExcel {

	@DataProvider
	public Object[][] dpFromExcel() throws Throwable{
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\DPforAPI.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("create");
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

	
	@Test(dataProvider = "dpFromExcel")
	public void testingData(String createdBy, String projectName, String status, String teamSize) {
//		System.out.println(createdBy+" "+projectName+" "+status+" "+teamSize);
		

		CreateProjectInRMG cpr= new CreateProjectInRMG(createdBy, projectName, status, teamSize);
		
		baseURI="http://rmgtestingserver";
		port=8084;
		
		given().body(cpr)
		.contentType(ContentType.JSON)
		
		.when().post("/addProject")
		
		
		.then().log().all();
		
		
	}
	
}
