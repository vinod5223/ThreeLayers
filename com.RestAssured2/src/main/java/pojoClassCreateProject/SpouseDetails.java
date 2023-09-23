package pojoClassCreateProject;

public class SpouseDetails {
 String sName;
 int sAge;
 long[] sPhno;
public SpouseDetails(String sName, int sAge, long[] sPhno) {
	this.sName = sName;
	this.sAge = sAge;
	this.sPhno = sPhno;
}

public SpouseDetails() {
	
}

public String getsName() {
	return sName;
}
public void setsName(String sName) {
	this.sName = sName;
}
public int getsAge() {
	return sAge;
}
public void setsAge(int sAge) {
	this.sAge = sAge;
}
public long[] getsPhno() {
	return sPhno;
}
public void setsPhno(long[] sPhno) {
	this.sPhno = sPhno;
}
 
}
