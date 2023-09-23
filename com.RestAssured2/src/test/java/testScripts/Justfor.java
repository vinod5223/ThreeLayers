package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



public class Justfor {

	
	
	public static void main(String[] args) {
		ChromeOptions option= new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.google.com/");
	}
}
