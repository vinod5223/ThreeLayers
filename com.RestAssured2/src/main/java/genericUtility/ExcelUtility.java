package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readDataFromExcel(String sheetName, int rowNum, int colNum) throws IOException {
		
		FileInputStream fis= new FileInputStream("./src/test/resources/ApiTest.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String s=wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	
		return s;
	}
	
}
