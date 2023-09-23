package serialization;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;
import pojoClassCreateProject.CreateEmployee;

public class CreateEmployeeeSerialization {

	@Test
	public void createEmpSerialization() throws Exception, Exception, Exception {
	
		CreateEmployee emp= new CreateEmployee("vinod123", 1612, 26);
		
		ObjectMapper omp= new ObjectMapper();
		omp.writerWithDefaultPrettyPrinter().
		writeValue(new File("./employee.json"), emp);
		
	}
}
