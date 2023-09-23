package pojoClassCreateProject;

public class EmployeeComplex {
String empName;
int empID;
long[] phNo;
public EmployeeComplex(String empName, int empID, long[] phNo) {
	this.empName = empName;
	this.empID = empID;
	this.phNo = phNo;
}

public EmployeeComplex() {
	
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
public long[] getPhNo() {
	return phNo;
}
public void setPhNo(long[] phNo) {
	this.phNo = phNo;
}

}
