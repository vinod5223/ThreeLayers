package serialization;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import pojoClassCreateProject.EmployeeWithSpouse;
import pojoClassCreateProject.SpouseDetails;

public class SerializeWithSpouse {

	@Test
	public void serializePouse() throws JsonGenerationException, JsonMappingException, IOException {
		
		long empPh[]= {9878598654l, 8979756564l};
		long spPh[]= {8755496552l, 8544612389l};
		SpouseDetails spouse= new SpouseDetails("Biwi", 22, spPh);
		
		ObjectMapper omp= new ObjectMapper();
		EmployeeWithSpouse ews= new EmployeeWithSpouse("Vinod", 1654, empPh, spouse);
		omp.writerWithDefaultPrettyPrinter()
		.writeValue(new File("./employeeWithSpouse.json"), ews);
	}
}
