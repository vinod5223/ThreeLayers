package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import genericUtility.JavaLibrary;

public class ProjectsPage {

	@FindBy(xpath="//span[text()='Create Project']")
	private WebElement createProj;

	@FindBy(xpath="//input[@name='projectName']")
	private WebElement projectName;
	
	@FindBy(xpath="//input[@name='createdBy']")
	private WebElement projectMgr;
	
	@FindBy(xpath = "//label[text()='Project Status ']/following-sibling::select")
	private WebElement projStatus;
	
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement addProject;
	
	public WebElement getCreateProj() {
		return createProj;
	}

	public WebElement getProjectName() {
		return projectName;
	}

	public WebElement getProjectMgr() {
		return projectMgr;
	}

	public WebElement getProjStatus() {
		return projStatus;
	}
	

	public WebElement getAddProject() {
		return addProject;
	}

	public ProjectsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void createProject(String pName, int indexForStatus) {
		
		getCreateProj().click();
		getProjectName().sendKeys(pName);
		getProjectMgr().sendKeys("AmmoBomma");
		Select sel= new Select(projStatus);
		sel.selectByIndex(indexForStatus);
		getAddProject().click();
		
		
		
	}
	
	
}
