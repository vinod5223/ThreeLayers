package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.FileUtilsLibrary;

public class LoginPage {

	@FindBy(xpath="//input[@name='username']")
	private WebElement username;
	
//	@FindAll({@FindBy(xpath="//label[@for='inputPassword']"), })
//	private WebElement password;
	
	
	@FindBy(xpath="//input[@id='inputPassword']")
	private WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginBtn;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getUsername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void loginToRMG(FileUtilsLibrary flib) throws InterruptedException, IOException {
		getUsername().sendKeys(flib.readDataFromPropFile("username"));
		getPassword().sendKeys(flib.readDataFromPropFile("password"));
		getLoginBtn().click();
	}
	
}
