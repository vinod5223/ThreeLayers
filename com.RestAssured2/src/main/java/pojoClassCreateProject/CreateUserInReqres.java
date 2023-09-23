package pojoClassCreateProject;

public class CreateUserInReqres {

	//declaring the variables globally
	String name;
	String job;
	
	//provide constructors to initialize the variables
	public CreateUserInReqres(String name, String job) {

		this.name = name;
		this.job = job;
	}
	
	//provide getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}	
}
