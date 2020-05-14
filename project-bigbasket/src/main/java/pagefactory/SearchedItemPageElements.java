package pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchedItemPageElements {

public WebDriver driver;
	
	public SearchedItemPageElements(WebDriver driver) {
		this.driver=driver;
	}
	
	
	private By title=By.xpath("//div[@class=\"desktop-query\"]/input");
	
	public WebElement getTitleItem() {
		return driver.findElement(title);
	}
}
