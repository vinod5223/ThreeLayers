package pojoClassCreateProject;

public class CreateEmployee {

	
	String empName;
	int empID;
	int empAge;

	
	public CreateEmployee(String empName, int empID, int empAge) {
		
		this.empName = empName;
		this.empID = empID;
		this.empAge = empAge;
	}

public CreateEmployee() {
		
	}
	

	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public int getEmpAge() {
		return empAge;
	}


	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	
	
	

}
