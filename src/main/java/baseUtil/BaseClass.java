package baseUtil;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ForgotUserId;
import pages.HomePage;
import utils.Configuration;
import static utils.IConstant.*;

public class BaseClass {
	public WebDriver driver; // or we can use protected type, otherwise it is default type
	public HomePage homePage; // or we can use protected type, otherwise it is default type
	Configuration config;
	protected Dimension dimension;
	public ForgotUserId forgotUserId;
	protected Select select;
	protected Actions actions;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() {
		config = new Configuration();
		initDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(config.getProperties(URL));
		// How can we convert a String to Long type
		long pageLoadTime = Long.parseLong(config.getProperties(PAGELOAD_WAIT));
		long implicitlyWait =	Long.parseLong(config.getProperties(IMPLICITLY_WAIT));
		long explicitlyWait =	Long.parseLong(config.getProperties(EXPLICITLY_WAIT));		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitlyWait));
		wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
		initClasses();
	}
	
	public void initDriver () {
		String browserName = config.getProperties(BROWSER);	
		
		switch (browserName) {		
		
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
			driver = new ChromeDriver();	
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver = new FirefoxDriver();
			break;			
		case "EDGE":
			System.setProperty("webdriver.edge.driver",  "./driver/msedgedriver.exe");
			driver = new EdgeDriver();	
			
		default:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
	}
	
	public void initClasses () {
		homePage = new HomePage(driver);
		forgotUserId = new ForgotUserId(driver);
	}
	
	// After a test is done, what need to do
	@AfterMethod
	public void tearUp(){
		driver.quit();
	}

}
