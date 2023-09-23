package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassCreateProject.EmployeeComplex;

public class EmpComplexDeserialization {
@Test
public void empDeserializationComplex() throws Throwable, Throwable, Throwable {
	ObjectMapper omp= new ObjectMapper();
	EmployeeComplex data = omp.readValue(new File("./employee.json"), EmployeeComplex.class);
	System.out.println(data.getEmpName());
	System.out.println(data.getEmpID());
	System.out.println(data.getPhNo()[1]);
}
}
