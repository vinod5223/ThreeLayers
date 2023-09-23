package pojoClassCreateProject;

public class CreateProjectInRMG {
	
	//create variables globally
	String createdBy;
	String projectName;
	String status;
	String teamSize;
	
	//provide constructor to initialize the variables
	public CreateProjectInRMG(String createdBy, String projectName, String status, String i) {
		this.createdBy = createdBy;
		this.projectName = projectName;
		this.status = status;
		this.teamSize = i;
	}
	//provide getters and setters
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeamSize() {
		return teamSize;
	}

	public void setTeamSize(String teamSize) {
		this.teamSize = teamSize;
	}
	
	
	

}
