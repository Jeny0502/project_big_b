package pagefactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.Base;

public class HomePageElements{

	public WebDriver driver;
	
	public HomePageElements(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//By profile=By.xpath("//span[text()=\"Profile\"]");
	@FindBy(xpath = "//span[text()=\"Profile\"]")
	private WebElement profile;
	
	
	private By login=By.xpath("//a[@data-track=\"login\"]");
	private By search=By.cssSelector(".desktop-query .desktop-searchBar");
	
	public WebElement getProfile() {
		return profile;
	}
	
	public WebElement clickLogin() {
		return driver.findElement(login);
	}
	
	
	public WebElement searchBar() {
		return driver.findElement(search);
	}
}
