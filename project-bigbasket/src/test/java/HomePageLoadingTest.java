import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pagefactory.HomePageElements;
import pagefactory.SearchedItemPageElements;
import pagefactory.SignInDetailsElements;
import resources.Base;





public class HomePageLoadingTest extends Base{
	
	public static Logger log=LogManager.getLogger(Base.class.getName());
	
	
	@BeforeTest
	public void pageLoading() throws IOException {
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.xml");
		driverSetup();
		log.debug("Launching to Myntra");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.get(getSiteUrl());
		log.info("Myntra Launched Successfully");
	}
	
	@Test
	public void login() throws InterruptedException, IOException {
		DOMConfigurator.configure(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\log4j.xml");
		HomePageElements homeEle=new HomePageElements(driver);
		Actions action=new Actions(driver);
		action.moveToElement(homeEle.getProfile()).click(homeEle.clickLogin()).perform();
		log.info("Going to Login");
		SignInDetailsElements login=new SignInDetailsElements(driver);
		login.insertEmail().sendKeys(getEmailId());
		login.insertPass().sendKeys(getPassword());
		login.submitButton().click();
		log.info("Logged in successfully");
		Thread.sleep(1000L);
		action.moveToElement(homeEle.getProfile()).perform();
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		driver=null;
	}
}
