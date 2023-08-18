package baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
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
		
		// 2nd way, to show the location of the chrome driver
		// This is a dynamic way (relative path)
		// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
		
		// New
		// 3rd and final way, to show the location of chrome driver
		// This is a dynamic path (relative path)
		// I will use this one till end of the course
		// System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		// We instantiated the driver here
		// driver = new ChromeDriver();
		
		// When driver absent, browser is not  working, then you can use webdrivermanager
		// webdriver manager doesn't need any physical driver
		// From below line, the most updated version of browser will be initialized, when no version is mentioned	
		/*
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		*/
		
		// 116.0.5845.96 --- new version
		// 114.0.5735.90 --- older version
		// 113.0.5672.63 --- older version
		// 111.0.5563.64  --- older version  
		// older version sometimes used for stability of browser, sometime for the request of Authority
		// if you choose version, then it will use that specific version of driver
		/*
		WebDriverManager.chromedriver().driverVersion("114.0.5735.90").setup();
		driver = new ChromeDriver();
		*/
		
		/*
		// if you wanna use a specific version, you can use driverVersion(), like line 59
		WebDriverManager is used for most updated firefoxdriver()
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		*/
		
		/*
		// For Firefox driver
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		*/
		
		/*
		// if you wanna use a specific version, you can use driverVersion(), like line 59
	    // WebDriverManager is used for most updated edgedriver()
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		*/
		
		/*
		System.setProperty("webdriver.edge.driver", "./driver/msedgedriver.exe");
		driver = new EdgeDriver();
		*/
		
		// New
		// 3rd and final way, to show the location of chrome driver
		// This is a dynamic path (relative path)
		// I will use this one till end of the course
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();		
		// deleteAllCookies do delete the cookies
		driver.manage().deleteAllCookies();
		// get method is used to get the targeted url
		driver.get("https://portal.cms.gov/portal/");
		// maximize method maximize the window
		driver.manage().window().maximize();
		// We can also use fullscreen() instead of maximize()
		// driver.manage().window().fullscreen();
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
