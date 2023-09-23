package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	@FindBy(xpath="//a[text()='Projects']")
	private WebElement projects;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getProjects() {
		return projects;
	}
	
	public void clickOnProject() {
		
		getProjects().click();
	}
	
	
}
 