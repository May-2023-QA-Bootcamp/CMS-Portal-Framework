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
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tofael\\eclipse-workspace\\gov.cms.portal.may\\driver\\chromedriver.exe");
		// We instantiated the driver here
		driver = new ChromeDriver();
		// maximize method maximize the window
		driver.manage().window().maximize();
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		// get method is used to get the targeted url
		driver.get("https://portal.cms.gov/portal/");
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
