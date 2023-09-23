package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassCreateProject.EmployeeWithSpouse;

public class DeseralizeWithSpouse {

	@Test
	public void desWithSpouse() throws JsonParseException, JsonMappingException, IOException {
		
	ObjectMapper omp= new ObjectMapper();
	EmployeeWithSpouse data = omp.readValue(new File("./employeeWithSpouse.json"), EmployeeWithSpouse.class);
		
	System.out.println(data.geteName());
	System.out.println(data.getEmpID());
	System.out.println(data.getePhno()[1]);
	System.out.println(data.getSpouse().getsPhno()[1]);
	System.out.println(data.getSpouse().getsName());
	
	}
}
