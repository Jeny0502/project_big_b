package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Base {

	public static WebDriver driver;
	public FileInputStream file;
	public Properties prop;
	
		
		public WebDriver driverSetup() throws IOException {
		
			file=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			prop=new Properties();
			prop.load(file);
			//String browserName=prop.getProperty("browser");
			String browserName=System.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome")) {
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("UNHANDLED_PROMPT_BEHAVIOUR", "accept");
				ChromeOptions ch=new ChromeOptions();
				ch.merge(capabilities);
				ch.addArguments("--disable-notifications");
				//ch.addArguments("headless");
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
				driver=new ChromeDriver(ch);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:\\Users\\vijur\\Downloads\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
			}else if(browserName.equalsIgnoreCase("ie")) {
				System.out.println("IE");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			}
			return driver;
	}
		
		public String getSiteUrl() {
			return prop.getProperty("url");
		}
		
		public void takeScreenshot(String result) throws IOException {
			File image=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(image, new File("C:\\Users\\vijur\\Documents\\Screenshots\\result_image.png"));
		}
		
		public String getEmailId() {
			return prop.getProperty("email");
		}
		
		public String getPassword() {
			return prop.getProperty("password");
		}

}
