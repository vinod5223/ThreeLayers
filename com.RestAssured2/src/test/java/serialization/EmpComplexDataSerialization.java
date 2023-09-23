package serialization;

import java.io.File;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassCreateProject.EmployeeComplex;

public class EmpComplexDataSerialization {

	@Test
	public void empComplex() throws Throwable{
		
		long[] ph= {8989989988l, 9898989898l};
		
		EmployeeComplex eCmpx= new EmployeeComplex("vinod", 1265, ph);
		
		ObjectMapper omp= new ObjectMapper();
		omp.writerWithDefaultPrettyPrinter()
		.writeValue(new File("./employeeArray.json"), eCmpx);
		
		
		
	}
}
