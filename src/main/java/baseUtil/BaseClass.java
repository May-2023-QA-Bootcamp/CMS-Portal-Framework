package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;

public class BaseClass {
	public WebDriver driver; // or we can use protected type, otherwise it is default type
	public HomePage homePage; // or we can use protected type, otherwise it is default type
	
	// Before start a test what need to do?
	@BeforeMethod
	public void setUp() {
		// First job is to recognize the location of driver from your device
		// right click on chromedriver.exe --- properties -- copy the location an paste below
		
		/*
		// System is a class and setProperty is a method
		// 1st way, to show the location of chrome driver
		// This is an absolute path
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\gov.cms.portal.may\\driver\\chromedriver.exe");
		*/
		
		// new
		// 2nd way, to show the location of the chrome driver
		// This is a dynamic way (relative path)
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/driver/chromedriver.exe");
		
		
		
		
		// We instantiated the driver here
		driver = new ChromeDriver();
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		// get method is used to get the targeted url
		driver.get("https://portal.cms.gov/portal/");
		// maximize method maximize the window
		// driver.manage().window().maximize();
		// We can also use fullscreen() instead of maximize()
		driver.manage().window().fullscreen();
		// Pageloadtimeout is to wait to load the page for curtain amount of time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		// Implicitly wait is used to wait for each web element
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		homePage = new HomePage(driver);
	}
	
	// After a test is done, what need to do
	@AfterMethod
	public void tearUp(){
		driver.quit();
	}

}
