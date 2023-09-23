package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassCreateProject.CreateEmployee;

public class EmployeeDeserialization {

	@Test
	public void empDeSerialization() throws Throwable, Throwable, Throwable {
		ObjectMapper omp= new ObjectMapper();
		CreateEmployee data = omp.readValue(new File("./employee.json"), CreateEmployee.class);
		System.out.println(data.getEmpName());
		System.out.println(data.getEmpID());
		System.out.println(data.getEmpAge());
				
	}
}
