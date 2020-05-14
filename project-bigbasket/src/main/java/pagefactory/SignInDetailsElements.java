package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInDetailsElements {

	public WebDriver driver;
	public SignInDetailsElements(WebDriver driver) {
		this.driver=driver;
	}
	
	private By email=By.cssSelector("input[type=\"email\"]");
	private By password=By.cssSelector("input[type=\"password\"]");
	private By loginButton=By.xpath("//button[text()=\"Log in\"]");
	
	public WebElement insertEmail() {
		return driver.findElement(email);
	}
	
	public WebElement insertPass() {
		return driver.findElement(password);
	}
	
	public WebElement submitButton() {
		return driver.findElement(loginButton);
	}
	
	
}
