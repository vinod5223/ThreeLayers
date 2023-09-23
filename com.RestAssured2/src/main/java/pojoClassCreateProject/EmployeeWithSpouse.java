package pojoClassCreateProject;

public class EmployeeWithSpouse {
	String eName;
	int empID;
	long[] ePhno;
	SpouseDetails spouse;
	public EmployeeWithSpouse(String eName, int empID, long[] ePhno, SpouseDetails spouse) {
		this.eName = eName;
		this.empID = empID;
		this.ePhno = ePhno;
		this.spouse = spouse;
	}
	
	public EmployeeWithSpouse() {
		
	}
	
	
	
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public long[] getePhno() {
		return ePhno;
	}
	public void setePhno(long[] ePhno) {
		this.ePhno = ePhno;
	}
	public SpouseDetails getSpouse() {
		return spouse;
	}
	public void setSpouse(SpouseDetails spouse) {
		this.spouse = spouse;
	}
	
	
}
