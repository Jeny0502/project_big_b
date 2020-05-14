import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagefactory.HomePageElements;
import pagefactory.SearchedItemPageElements;
import resources.Base;

public class SearchItem extends Base{

	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void driverInitialisation() throws IOException {
		
		driverSetup();
		driver.get(getSiteUrl());
	}
	
	@Test(dataProvider = "getData",priority = 2)
	public void searchItem(String item) throws InterruptedException {
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.xml");
		HomePageElements homeEle=new HomePageElements(driver);
		homeEle.searchBar().sendKeys(item);
		homeEle.searchBar().sendKeys(Keys.ENTER);
		Thread.sleep(1000L);
		SearchedItemPageElements ite=new SearchedItemPageElements(driver);
		
		
	}
	
	
	
	@DataProvider
	public Object getData() {
		Object[][] data=new Object[2][1];
		data[0][0]="mask";
		data[1][0]="gloves";
		return data;
	}
	
	
}
