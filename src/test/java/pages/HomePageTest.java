package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.SkipException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass {
	
	// The test executed based on alphabetical order, if no priority given
	// enabled = true means The test case is not disable
	// enabled = false means The test case is disable
	// priority = 1 means, this test case will run first, 2 means second ....
	
	@Test (enabled = false, priority=1)
	public void clickLoginButtonTest() throws InterruptedException {
		homePage.clickLoginButton();
	}
	
	@Test(enabled = false)
	public void clickUserIdTest() {
		homePage.clickUserId();
	}
	
	@Test (enabled = false)
	public void clickPasswordTest () {
		homePage.clickPassword();
	}
	
	@Test(enabled = false)
	public void clickNURTest() {
		homePage.clickNewUserRegistration();
	}
	
	// Test for implicit wait and it shows No such element exception
	@Test(enabled = false)
	public void clickWrongNURTest() {
		homePage.clickWrongNewUserRegistration();
	}
	
	// This test case will fail, when you remove Pagefactory class from code form HomePage to test this
	// When PageFactory class is absent, you will find NullPointerException
	@Test (enabled = false)
	public void nullPointerExceptionTest() throws InterruptedException {
		homePage.clickNewUserRegistration();
	}
	
	@Test (enabled = false)
	public void forgotUserIdTest () throws InterruptedException {
		homePage.forgotUserIdClick();
	}
	
	@Test (enabled = false)
	public void inputTextInUserIdFieldTest () {
		homePage.inputTextInUserIdField();
	}
	
	@Test(enabled = false)
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButtonTest () throws InterruptedException {
		homePage.inputTextInUserIdAndPasswordFieldThenClickLoginButton();
	}
	
	@Test(enabled = false)
	public void clickUnlockTest() throws InterruptedException {
		homePage.clickUnlock();
	}
	
	
	@Test (enabled = false, priority = 2)
	public void clickLogoTest() throws InterruptedException {
		homePage.clickLogo();
	}
	
	// Important: Use of xpath as locator
	// Web Element: New User Registration Button
	// We can use a web element directly in the test class, that is also common, but different people like different way
	@Test (enabled = false)
	public void use_of_xpath_as_locator_in_new_user_registration_button() throws InterruptedException {
		driver.findElement(By.xpath("//a[contains(text(), 'New')]")).click();
		Thread.sleep(4000);
	}
	
	// This is best scripted in ebay (I will show it later)
	// Important: Use of linkText as locator
	// Web Element: forgot User Id
	@Test(enabled = false)
	public void use_of_linkText_as_locator_in_forgot_user_id_hyperlink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.linkText("User ID")).click();
		Thread.sleep(5000);
	}
	
	// Important: Use of partialLinkText as locator
	// Web Element: forgot Password
	@Test(enabled = false)
	public void use_of_partialLinkText_as_locator_in_forgot_password_hyperlink() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.partialLinkText("Passwo")).click();
		Thread.sleep(5000);
	}
	
	// Error: 'Compound class names not permitted',
	// so even if you see class value is unique but separated by space, avoid this as class name locator
	// it will show error and failed
	
	@Test(enabled = false)
	public void why_we_use_cssSelector_as_locator_in_logo () {
		driver.findElement(By.className("cms-icon cms-sprite-loggedout ms-3")).click();
	}
	
	// Web Element: New User Registration Button
	// Important: Use of cssSelector as locator
	// cssSelector is very important for interview
	// cssSelector by class --> inside the string, first put html tag, then dot, then write value of the class attribute 
	@Test(enabled = false)
	public void role1_use_of_cssSelector_as_locator_in_new_user_registration_button () {
		driver.findElement(By.cssSelector("a.cms-newuser-reg")).click();
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// if you wanna create cssSelector by id 
	// first html tag, then # (hash), then write the value of id attribute inside the string
	@Test(enabled = false)
	public void role2_use_of_cssSelector_as_locator_in_login_button() {
		driver.findElement(By.cssSelector("button#cms-login-submit")).click();
	}
	
	// Web Element: logo
	// Important: Use of cssSelector as locator
	// if the class (compound class) contain separate words [cms-icon cms-sprite-loggedout ms-3], 
	// they are actually different class, then
	// we have to close the gap between classes by putting dot/period between them
	// cssSelector by class --> htmltag.class name value 
	// remove the space between words in class value, and replace with dot or period
	@Test(enabled = false)
	public void role3_use_of_cssSelector_as_locator_in_logo () {
		driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).click();
	}
	
	// Above 3 is mostly used 90% cases of css selector, also very common interview question
	// below 3 high level, no need to see if you feel they are tough
	
	// Use of cssSelector as locator
	// Web Element: login Button
	// high level, you can ignore
	// cssSelector by another attribute
	// --> htmltag[any attribute = 'value of the attribute' ] , in xpath - you use // and @, which is absent here 
	// and you can use any other attribute name except id and class
	@Test(enabled = false)
	public void role4_use_of_cssSelector_as_locator_in_login_button () {
		driver.findElement(By.cssSelector("button[name='Submit Login']")).click();
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: NUR Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag.value of class[attribute name='value'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	@Test(enabled = false)
	public void role5_use_of_cssSelector_as_locator_in_login_button() throws InterruptedException {
		driver.findElement(By.cssSelector("a.cms-newuser-reg[title='New User Registration']")).click();
		Thread.sleep(5000);
	}
	
	// Important: Use of cssSelector as locator
	// Web Element: login Button
	// Not important, can ignore
	// cssSelector by another attribute
	// --> htmltag#value of ID[attribute name='value'] , in xpath you use // and @, which is absent here and you can use attribute except id and class
	@Test(enabled = false)
	public void role6_use_of_cssSelector_as_locator_in_login_button () {
		driver.findElement(By.cssSelector("button#cms-login-submit[name='Submit Login']")).click();
	}

	// Important: Use of tagName as locator
	// tag name: we have to go to Amazon and look for table
	
	// Web Element: logo
	// isDisplayed() is an alternate of click() method which is boolean type
	// isDisplayed() is the method used to verify the presence of a web element within the web page.
	// Use of isDisplayed() available- image, link, button, text field, check box etc.
	@Test(enabled = false)
	public void use_of_isDisplayed_in_logo_image() {
		boolean elementDisplayed = driver.findElement(By.cssSelector("em.cms-icon.cms-sprite-loggedout.ms-3")).isDisplayed();
		System.out.println("Is the LOGO displayed? Ans: " + elementDisplayed);
	}
	
	// Web Element: login Button
	// isEnabled() is the method used to verify if the web element is enabled or
	// disabled within the web page. isEnabled() is primarily used with buttons.
	// Use of isEnabled(), a boolean type method
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_button() throws InterruptedException {
		boolean loginButtonEnabled = driver.findElement(By.name("Submit Login")).isEnabled();
		System.out.println("Login Button Enable: " + loginButtonEnabled);
	}
	
	// Both is not working [Need to discuss with Nasir]
	// Web Element: check box
	@Test (enabled = false)
	public void use_of_isSelected_in_check_box () {
		boolean checkBoxSelected = driver.findElement(By.xpath("//input[@id='checkd']")).isSelected();
		System.out.println("CheckBox is selected: " + checkBoxSelected);
	}
	
	// Web Element: Radio button in Forgot User ID 
	@Test (enabled = false)
	public void use_of_isSelected_in_radio_button () throws InterruptedException {
		// first click on Forgot User ID
		homePage.forgotUserIdClick();
		Thread.sleep(4000);
		boolean radioButtonSelected = driver.findElement(By.xpath("(//label[@class='check-radio'])[1]")).isSelected();
		System.out.println("Radio button selected: " + radioButtonSelected);
	}
	
	@Test(enabled = false)
	public void use_of_isEnabled_in_login_button02() throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed();
		driver.findElement(By.name("user-d")).sendKeys("May2023QA");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).isDisplayed();
		driver.findElement(By.name("pass-d")).sendKeys("ABC@123");
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).isEnabled();
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);
	}
	
	// how can you find the title of the page?
	// Basically inside <head> tag, <title> tag is present, you can get it from there or
	// right click on an empty place of any page -- click "view page source" -- ctrl+f (to find) 
	// -- Type 'title' -- find the <title> tag
	@Test(enabled = false)
	public void use_of_getTitle_method_in_home_page() {
		System.out.println("The title of the page is: " + driver.getTitle());
	}
	
	// We use New User Registration	
	@Test(enabled = false)
	public void use_of_getCurrentURL_method () throws InterruptedException {
		driver.findElement(By.className("cms-newuser-reg")).click();
		Thread.sleep(4000);
		System.out.println("The Title of the Page is: " + driver.getTitle());
		System.out.println("The current URL is: " + driver.getCurrentUrl());
	
	}
	
	// Line 261 is the outcome from here
	@Test(enabled = false)
	public void use_of_getText_method_in_login_button() throws InterruptedException {
		driver.findElement(By.name("user-d")).isDisplayed();
		driver.findElement(By.name("user-d")).sendKeys("May2023QA");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).isDisplayed();
		driver.findElement(By.name("pass-d")).sendKeys("ABC@123");
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).isEnabled();
		WebElement loginButton = driver.findElement(By.name("Submit Login"));
		System.out.println("The text for the web element is: " + loginButton.getText());
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);
	}
	
	// We use User ID field
	// getAttribute() actually give the value of the Attribute, not common
	@Test(enabled = false)
	public void use_of_getAttribute_method () throws InterruptedException {
		driver.findElement(By.id("cms-login-userId")).click();
		Thread.sleep(4000);
		String value01 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("placeholder");
		String value02 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("class");
		String value03 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("id");
		String value04 = driver.findElement(By.xpath("//input[@id='cms-login-userId']")).getAttribute("title");
		System.out.println("The value of the placeholder attribute is: " + value01);
		System.out.println("The value of the class attribute is: " + value02);
		System.out.println("The value of the id attribute is: " + value03);
		System.out.println("The value of the title attribute is: " + value04);
	}
	
	// Use of clear()
	// Using User Id field
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_clear() throws InterruptedException {
		driver.findElement(By.name("user-d")).sendKeys("May2023QA");
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).clear();
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).sendKeys("Enthrall2023QA");
		Thread.sleep(4000);
		driver.findElement(By.name("user-d")).clear();
		Thread.sleep(4000);
	}
	

	// Important: Use of tagName as locator
	// tag name: we have to go to Amazon and look for table
	
	
	// use of Keys.ENTER
	// Click on forgot password field, then send a value inside "Enter user id" field and click by Enter key
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_enter_key_of_the_laptop () throws InterruptedException {
		driver.findElement(By.id("cms-forgot-password")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("cms-forgotpwd-userId")).sendKeys("enthrall_12", Keys.ENTER);
		Thread.sleep(4000);
	}
	
	// use of Keys.RETURN
	// Click on forgot password field, then send a value inside "Enter user id" field and click by Enter key
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click_by_return_key_of_the_laptop () throws InterruptedException {
		driver.findElement(By.id("cms-forgot-password")).click();
		Thread.sleep(4000);
		driver.findElement(By.id("cms-forgotpwd-userId")).sendKeys("enthrall_12", Keys.RETURN);
		Thread.sleep(4000);
	}
	
	// use of navigate()
	// Interview Question
  
	@Test(enabled = false)
	public void use_of_navigate_method () throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().to("https://www.amazon.com");
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);
		driver.navigate().forward();
		Thread.sleep(4000);
		driver.navigate().refresh();
		Thread.sleep(4000);
	}
	
	// Very important interview question
	// How can you reset a window size? or they can ask how you can change the screen size by selenium
	
	@Test(enabled = false)
	public void use_of_set_a_specific_size_for_window() throws InterruptedException {
		Thread.sleep(4000);
		// Will get the size of cms window
		System.out.println("The size of the maximize screen is: "+ driver.manage().window().getSize());
		dimension = new Dimension(1000, 700);
		driver.manage().window().setSize(dimension);
		Thread.sleep(4000);
		System.out.println("The size of the set screen is: " + driver.manage().window().getSize());
		// Extra related to this method, although not related
		Thread.sleep(4000);
		driver.navigate().to("https://www.cvs.com");
		Thread.sleep(4000);
		System.out.println("The size of the set screen is: "+ driver.manage().window().getSize());
		driver.manage().window().maximize();
		Thread.sleep(5000);
		System.out.println("The size of the maximize screen is: "+ driver.manage().window().getSize());
		Thread.sleep(5000);
		driver.manage().window().setSize(dimension); // just to show again the set size
		Thread.sleep(5000);
		System.out.println("The size of the set screen is: "+ driver.manage().window().getSize());
		Thread.sleep(5000);
		driver.manage().window().fullscreen();
		Thread.sleep(5000);
		System.out.println("The size of the full screen is: "+ driver.manage().window().getSize());	
	}
	
	// not important at all
	@SuppressWarnings("deprecation")
	@Test(enabled = false)
	public void use_of_set_script_timeout_for_window() {
        driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
        // setScriptTimeout () method deprecated, so giving you warning, this method is going to be out from selenium
        // you use @SuppressWarnings("deprecation")
		driver.get("https://www.ebay.com");		
	}
	
	@Test(enabled = false)
	public void logoDisplayedTest01() {
		homePage.logoDisplayed(); // Actual Outcome
		Assert.assertTrue(true); // Expected outcome
	}
	
	@Test (enabled = false)
	public void logoDisplayedTest02 () {
		homePage.logoDisplayed (); // Actual Result or outcome which doesn't match with your below expectation
		Assert.assertTrue(false); // Expected Result // java.lang.AssertionError: expected [true] but found [false]
		// Although the outcome is true, but because of difference between expected vs actual is not same, the test case failed
	}
	
	@Test (enabled = false)
	public void logoDisplayedTest03 () {
		homePage.logoDisplayed(); // Actual Result : true
		Assert.assertFalse(false, "Application Logo is not Displayed ..... ..... "); // false false means true
		// Assert.assertTrue(true, "Application Logo is not Displayed ..... ..... ");  // Expected Result with error message if failed
	}
	

	@Test (enabled = false)
	public void logoDisplayedTest04 () {
		homePage.logoDisplayed(); // Actual Result : true
		Assert.assertFalse(true, "Application Logo is Displayed, but expected result is not to dispaly ..... ..... ");
		// java.lang.AssertionError: Application Logo is not Displayed ..... .....  expected [false] but found [true]
		// error message will be appeared when the assertion failed 
	}
	
	// A regular title test
	@Test(enabled = false)
	public void use_of_getTitle_method01() throws InterruptedException {
		String actual = driver.getTitle();
		Thread.sleep(5000);	
		System.out.println("The title of the Page is: " + actual);
	}
	
	// Will Pass
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion01() throws InterruptedException {
		// Your expected Title
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("The Title of the home Page is: " + actual);
		Assert.assertEquals(actual, expected, "Home page Title doesn't match");
		// Hard Assertion will not go to next line if failed, but move to next line when passed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	
	}
	
	// Will fail
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion02() throws InterruptedException {
		// Your expected Title
		String expected = "CMS Enterprise Portal        ";
		String actual = driver.getTitle();
		System.out.println("The Title of the home Page is: " + actual);
		Assert.assertEquals(actual, expected, "Home page Title doesn't match"); // Hard Assertion, execution stopped here if Assertion fail
		// java.lang.AssertionError: Home Page Title doesn't match .......  expected [CMS Enterprise Portal           ] but found [CMS Enterprise Portal]
		// Hard Assertion will not go to next line if failed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	
	}
	
	// Will pass
	@Test(enabled = false)
	public void use_of_getTitle_method_with_assertion03() throws InterruptedException {
		// Your expected Title
		String expected = "CMS Enterprise Portal        ";
		String actual = driver.getTitle();
		System.out.println("The Title of the home Page is: " + actual);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "Home page Title doesn't match"); 
		// Soft Assertion, execution will not stopped here if Assertion is failed in above line
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
	}
	
	// Very very importan for use in framework and also a interview question
	// similar like above, nothing different, extra example
	@Test(enabled = false)
	public void use_of_mouse_hoverAction_on_ourLocations () throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		WebElement ourLocations = driver.findElement(By.xpath("//a[normalize-space(text()) = 'Our Locations' and @class='hidden-xs dropdown']")); 
		Thread.sleep(4000);
		actions = new Actions(driver); // Actions class is instantiated in base class, actions object came form there
		actions.moveToElement(ourLocations).build().perform();
		Thread.sleep(6000);		
		System.out.println("\nThe text of this web element is: "+ ourLocations.getText());
	
	}
	
	// Regular click method
	@Test(enabled = false)
	public void use_of_click_method_in_loginButtonTest () throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).click();
		Thread.sleep(3000);
	}
	
	// interview question: what are the alternative of click()
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest01() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}
	
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest02() throws InterruptedException {
		driver.findElement(By.id("cms-login-submit")).sendKeys(Keys.RETURN);
		Thread.sleep(3000);
	}
	
	// important
	// alternate of click()
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest03() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.id("cms-login-submit"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", loginButton);
		// arguments[0] means, find the web element of index 0, first occurrence
		Thread.sleep(4000);
	}	
	
	// alternate of click()
	// "arguments[0].click()" --- easy to memorize, memorize it, if you want
	// follow the above one, because you can use any kind of locator 
	// (specially xpath is difficult to create by below one)
	// Que: what is the alternative of click() method or click an web element 
	// or how to find a hidden web element-- very important interview question 
	// don't follow this one, but if you ever see it, i hope you can recognize it
	@Test(enabled = false)
	public void alternate_of_click_method_in_loginButtonTest04() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("document.getElementById('cms-login-submit').click();");
		Thread.sleep(4000);
	}
	
	// From here till line 564, this is high level, so just see, don't take them seriously
	// alternative to click an web element in many ways (never memorize, a collection of code)
	// Not important
	
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest06() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.click(homepageLoginButton).perform();
	}
	
	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest07() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.moveToElement(homepageLoginButton).click().perform();
	}

	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest08() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.clickAndHold(homepageLoginButton).release().perform();
	}

	// Not important
	// alternate of click()
	@Test(enabled = false)
	public void homepageLoginButtonTest09() {
		WebElement homepageLoginButton = driver.findElement(By.xpath("//button[@id='cms-login-submit']"));
		actions.sendKeys(homepageLoginButton, Keys.RETURN).perform();
	}
	
	// login process regular to compare with line 579
	@Test(enabled = false)
	public void use_of_sendKeys_method_then_click() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='cms-login-userId']")).sendKeys("January 2023");
		Thread.sleep(4000);
		driver.findElement(By.name("pass-d")).sendKeys("Enthrall@12345");
		Thread.sleep(4000);
		driver.findElement(By.name("Submit Login")).click();
		Thread.sleep(4000);		
	}
	
	// login process by JavascriptExecutor
	// alternative of sendKeys()
	@Test(enabled = false)
	public void use_of_sendKeys_method_by_javascriptExecutor_then_click() throws InterruptedException {
		WebElement userId = driver.findElement(By.xpath("//input[@id='cms-login-userId']"));
		WebElement password = driver.findElement(By.name("pass-d"));
		WebElement loginButton = driver.findElement(By.name("Submit Login"));
		js = (JavascriptExecutor) driver; // we instantiated in Base class
		js.executeScript("arguments[0].value = 'August 2023'", userId); // how to send text inside a field by JavascriptExecutor
		Thread.sleep(4000);
		js.executeScript("arguments[0].value = 'Enthrall@12345'", password);
		Thread.sleep(4000);
		js.executeScript("arguments[0].click()", loginButton); 
		Thread.sleep(4000);
	}
	
	// it will fail
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_regular_selenium_method() throws InterruptedException {
		Thread.sleep(5000);	
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		// identify the 'Hide' element and click on it [line603]
		// The search field will be disappeared, but we can pass value on it, as we get info before
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(4000);
		// identify element and set/input text or value (line 606)
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("May2023");
		// it will fail by below error message
		// org.openqa.selenium.ElementNotInteractableException: element not interactable
		// whenever you find element not interactable in console, that is for sure a hidden element
	
	}
	
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_javascriptExecutor() throws InterruptedException {
		Thread.sleep(5000);	
		driver.navigate().to("https://www.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(4000);
		// identify the 'Hide' element and click on it [line603]
		// The search field will be disappeared, but we can pass value on it, as we get info before
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(4000);
		// identify element and set/input text or value by JavascriptExecutor
		WebElement searchField = driver.findElement(By.xpath("//input[@id='displayed-text']")); 
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = 'May 2023' ", searchField);
		Thread.sleep(4000);
		
		// not important
		// Extra code
		// Extra not related to hidden elements and not important
		// How to get title of the page by JavaScriptExecutor?
		// How to read a JavaScript variable in Selenium WebDriver?
		// alternate of getTitle()
		String title = (String) js.executeScript("return document.title");
		System.out.println("Title of the webpage :" + title);
		
	}
	
	/*
	// very very important
	// "request An Appointment" web element IN MOUNTSINAI.ORG
	// using visibilityOfElementLocated() method
	// This is a very common scenario in industry to use explicitly wait
	@Test(enabled = true)
	public void use_of_explicitly_wait_in_MountSinai01() throws InterruptedException {
		Thread.sleep(5000);	
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		// Request an Appointment element
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space(text())='Our Locations' and @class='hidden-xs dropdown']"))).click();
		Thread.sleep(5000);
		// the below line is not part of testing, finding doctor name by putting a name in the field
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='form-control']//parent::div[@class='form-group form-inline']"))).sendKeys("Andrea Perez");
		// driver.findElement(By.xpath("(//div[@class='button-div hidden-xs'])[1]")).click();
		driver.findElement(By.cssSelector("C-24-Call-To-Action.mshs-sidebar.pink-cta-bg")).click();
		Thread.sleep(4000);
	
	
		//cms-unlock-account
	}
	*/
	
	
	
	// very very important
	// when the web element always failed in test, use explicitly wait, in this web site doesn't have that complex scenario
	// "unlock" web element 
	// using visibilityOfElementLocated() method
	// This is a very common scenario in industry to use explicitly wait
	@Test(enabled = false)
	public void use_of_explicitly_wait_in_MountSinai01() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cms-unlock-account"))).click();
		Thread.sleep(5000);
	
	}
	
	// very very important
	// when the web element always failed in test, use explicitly wait, in this web site doesn't have that complex scenario
	// "unlock" web element 
	// using elementToBeClickable() method
	@Test(enabled = false)
	public void use_of_explicitly_wait_in_MountSinai02() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element01 = driver.findElement(By.id("cms-unlock-account"));
		wait.until(ExpectedConditions.elementToBeClickable(element01)).click();
		Thread.sleep(5000);
	
	}
	
	// important
	// when the web element always failed in test, use explicitly wait, in this web site doesn't have that complex scenario
	// "unlock" web element 
	// using visibilityOf() method
	@Test(enabled = false)
	public void use_of_explicitly_wait_in_MountSinai03() throws InterruptedException {
		Thread.sleep(2000);
		WebElement element02 = driver.findElement(By.id("cms-unlock-account"));
		wait.until(ExpectedConditions.visibilityOf(element02)).click();
		Thread.sleep(5000);
	
	}
	
	// Not important, you can use it to practice
	// "unlock" web element 
	// using visibilityOf() method
	@Test(enabled = false)
	public void use_of_explicitly_wait_in_MountSinai04() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cms-unlock-account"))).click();
		Thread.sleep(5000);
	
	}

	// Not important, you can use it to practice
	// "New User Registration" web element 
	// using textToBePresentInElement() method
	// this is not a clickable method, just to recognize the web element
	@Test(enabled = false)
	public void use_of_explicitly_wait_in_MountSinai05() throws InterruptedException {
		Thread.sleep(2000);
		WebElement nur = driver.findElement(By.xpath("//a[text()='New User Registration']")); 
		boolean outcome = wait.until(ExpectedConditions.textToBePresentInElement(nur, "New User Registration"));
		System.out.println(outcome);
		Thread.sleep(5000);
	
	}
	
	// important interview question
	// 1st way: Scroll by Actions class
	// scroll bottom and then top
	@Test (enabled = false)
	public void use_of_scroll_down_and_scroll_up_by_actions_class_01 () throws InterruptedException {
		Thread.sleep(5000);
		actions = new Actions(driver);
		// for Scroll Down using Actions class, to go at the bottom of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		// for Scroll Up using Actions class at the top of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(5000);
		//Keys.UP or Keys.Down doesn't change much but the test case passes, we will not use them
	}
	
	// important interview question
	// 1st way: Scroll by Actions class
	// scroll bottom and then top
	@Test (enabled = false)
	public void use_of_scroll_down_by_actions_class_do_the_dropdpwn () throws InterruptedException {
		Thread.sleep(5000);
		actions = new Actions(driver);
		// for Scroll Down using Actions class, to go at the bottom of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		// Just we clicked on the dropdown, but unfortunately that is not developed by drop down
		driver.findElement(By.xpath("//div[@class='ng-input']")).click();
		Thread.sleep(4000);		
		// for Scroll Up using Actions class at the top of the page
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(5000);
		//Keys.UP or Keys.Down doesn't change much but the test case passes, we will not use them
	}
	
	// important interview question
	// 2nd way: Scroll by javascriptExecutor
	// scroll in a certain position (not at the bottom or up)
	@Test (enabled = false)
	public void use_of_scroll_down_and_scroll_up_by_javascriptExecutor () throws InterruptedException {
		// This will scroll down the page by 1000 pixel vertically
		// here 0 is x axis, 1000 y axis
		// you choose your pixel accordingly to reach to that web element
		Thread.sleep(5000);	
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000)", ""); // scroll down till 1000px
		// You can change the value of 3000, and put your own to see the web element you wanna test
		Thread.sleep(5000);	
		js.executeScript("window.scrollBy(0, -1000)", ""); // scroll up till 1000px
		// minus when it goes opposite of down
		Thread.sleep(4000);
		
		// not related with this test
		// How to refresh by Javascript, 
		js.executeScript("history.go(0)"); // To do refresh by Javascript
		// How to getTitle by Javascript, 
		String sText = js.executeScript("return document.title;").toString(); // fetching page title by javascript
		System.out.println("The title of the Page is: "+sText);
	}
	
	// Another code for scrolling and then search for hidden web element [save this code]
	@Test(enabled = false)
	public void how_to_handle_hidden_element_by_javascriptExecutor02() throws InterruptedException {
		Thread.sleep(5000);	
		driver.navigate().to("https://enthrallit.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Click on Selenium from Header
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Thread.sleep(4000);
		// Scrolling to ses the web element
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1200)", ""); // scroll down till 1000px
		// identify the 'Hide' element and click on it
		// The search field will be disappeared, but we can pass value on it, as we get info before
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[@id='formButton3']")).click();
		// identify element and set/input text or value by JavascriptExecutor
		WebElement serchField = driver.findElement(By.xpath("//input[@class='form-control']//parent::form[@id='form3']"));
		js.executeScript("arguments[0].value='January 2023' ", serchField);
		Thread.sleep(4000);
	}
	
	// not important, just to know
	@Test (enabled = false)
	public void use_of_scroll_down_and_scroll_up_by_robot_class () throws InterruptedException, AWTException {
		// For some reason, they are not going completely Up or Down
		Robot robot = new Robot();
		// Scroll Down using Robot class
		robot.keyPress(KeyEvent.VK_PAGE_DOWN); // Constant for the PAGE_DOWN virtual key.
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(5000);
		
		// Scroll Up using Robot class
        robot.keyPress(KeyEvent.VK_PAGE_UP); // Constant for the PAGE_UP virtual key. 
        robot.keyRelease(KeyEvent.VK_PAGE_UP);
        Thread.sleep(5000);
        
        driver.navigate().back();
        Thread.sleep(5000);
		
	}

	// scroll Into View The Element
	// This is important, standard interview question
	// This is better to use
	@Test(enabled = false)
	public void scrollIntoViewTheElement() throws InterruptedException {
		Thread.sleep(4000);
		// it's crossing the web element, but working
		WebElement enterprisePortal = driver.findElement(By.xpath("//h1[text()='Enterprise Portal']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", enterprisePortal);
		Thread.sleep(4000);
	}
	
	// important for interview
	@Test(enabled = false)
	public void web_based_alert_accept_test () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.accept();
		Thread.sleep(4000);
		// line 866, not part of the accept function, 
		// we just added to know about, the text is present in the alert or not
			
		}
	
	// important for interview
	@Test(enabled = false)
	public void web_based_alert_dismiss_test () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("http://softwaretestingplace.blogspot.com/2017/03/javascript-alert-test-page.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		Thread.sleep(4000);
		System.out.println("The text present in the alert is: " + alert.getText());
		alert.dismiss();
		Thread.sleep(4000);
		// line 885, not part of the accept function, 
		// we just added to know about, the text is present in the alert or not
			
		}
	
	// only important for interview
	@Test(enabled = false)
	public void authenticationPopUpTest () throws InterruptedException {
		Thread.sleep(5000);	
		String userName = "admin";
		String password = "admin";
		// adding user name, password with URL
		// original one is: "https://the-internet.herokuapp.com/basic_auth";
		// Updated one is: "https://admin:admin@the-internet.herokuapp.com/basic_auth";
		String url = "https://" + userName + ":" + password + "@" + "the-internet.herokuapp.com/basic_auth"; // learn this line, important interview question	
		driver.get(url);
		Thread.sleep(5000);	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		
		// The below part is not part of this test
		// identify and get text after authentication of popup
		String t = driver.findElement(By.tagName("p")).getText(); // we use tag name as a locator in our course
		System.out.println("Text is: " + t);
	}
	
	// only important for interview
	@Test(enabled = false)
	public void use_of_right_click_action () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement rcButton = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(rcButton).contextClick().build().perform();
		Thread.sleep(4000);
		// From Line 929, not part of testing, just completed the scenario
		// Just keep below code, Can't find the web element for Edit at present, the line 929 is from my collection.
		// Below 2 is not relevant to right click, just doing some extra, which we know already
		// Next: I want to click on Edit link on the displayed menu options
		WebElement edit = driver.findElement(By.xpath("//span[text()='Edit']"));
		Thread.sleep(4000);
		edit.click(); // a regular click , not a right click
		Thread.sleep(5000);
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		Thread.sleep(4000);
	}
	
	// only important for interview
	@Test(enabled = false)
	public void use_of_double_click_action () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(4000);
		WebElement dcButton = driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions actions = new Actions(driver);
		actions.doubleClick(dcButton).build().perform();
		Thread.sleep(4000);
		// Not part of the double click action
		// Switch to the alert box and click on OK button
		Alert alert = driver.switchTo().alert();
		System.out.println("\nAlert Text:" + alert.getText());
		alert.accept();
		Thread.sleep(4000);
	}

	// not important for interview
	@Test(enabled = false)
	public void use_of_drag_and_drop_action () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demo.guru99.com/test/drag_drop.html");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Element which needs to drag (Bank)
		WebElement sourceLocator = driver.findElement(By.id("credit2")); // Web element of the Bank button, it will be dragged
		// Element where need to be dropped.(In 'Account' field of debit side)
		WebElement targetLocator = driver.findElement(By.xpath("//ol[@id='bank']")); // and it will be dropped here
		// We Use Actions class for drag and drop.
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceLocator, targetLocator).build().perform();
		Thread.sleep(4000);	
		
	}

	// not important
	@Test(enabled = false)
	public void use_of_slider_action () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));
		// Move mouse to x offset 50 i.e. in horizontal direction
		Thread.sleep(5000);
		// to test the slider is working or not
		// dragAndDropBy (element, int xoffset, int yoffset)
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slider, 50, 0).build().perform(); // learn from here, 50 is in pixel which might not match with real volume change, real volume 60
		Thread.sleep(5000);
		// slider.click();
		System.out.println("Moved slider in horizontal directions");
	}
		
	
	// not important (alternate)
	@Test(enabled = false)
	public void use_of_slider_action_alternate () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demoqa.com/slider/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// Retrieve WebElemnt 'slider' to perform mouse hover
		// This is the field where volume is increased
		WebElement slider = driver.findElement(By.cssSelector("input.range-slider.range-slider--primary")); 
		// Move mouse to x offset 65 i.e. in horizontal direction
		Thread.sleep(5000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(slider);
		Thread.sleep(5000);
		actions.moveByOffset(65, 0).build().perform(); // pixel 65, real volume 63
		Thread.sleep(5000);
		System.out.println("Moved slider in horizontal directions");
		
	}

	@Test(enabled = false)
	public void mouseHoverActionOnAboutUs() throws InterruptedException {
		Thread.sleep(4000);
		driver.navigate().to("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); 
		WebElement aboutUs = driver.findElement(By.xpath("//a[normalize-space(text()) = 'About Us' and @class='hidden-xs dropdown']")); 
		Thread.sleep(4000);
		actions = new Actions(driver); // Actions class is instantiated in base class, actions object came form there
		actions.moveToElement(aboutUs).build().perform();
		Thread.sleep(6000);		
		// Use of findElements()
		List<WebElement> listOfAboutUs = driver.findElements(By.xpath("//a[normalize-space(text()) = 'About Us' and @class='hidden-xs dropdown']//following-sibling::div//child::div//child::div"));
		
		for(int i = 0; i< listOfAboutUs.size(); i++) {
			System.out.println(listOfAboutUs.get(i).getText());
		}
	
	}
	/*
	// same but another example from costco
	@Test(enabled = true)
	public void mouseHoverActionOnDeals() throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://www.costco.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement deals = driver.findElement(By.xpath("//a[@id='Home_Ancillary_2']"));
		Thread.sleep(5000);
		actions = new Actions(driver); 
		actions.moveToElement(deals).build().perform();
		Thread.sleep(5000);
		List<WebElement> listofDeals =  driver.findElements(By.xpath("//a[@id='Home_Ancillary_2']//child::div//child::div//child::div//child::div//child::div"));
		int numberOfElements = listofDeals.size();
		System.out.println("Number of web Elements: "+ numberOfElements);
		for(int i=0; i<numberOfElements; i++) {
			System.out.println(listofDeals.get(i).getText());
		}
		// repeating 3 times, there is an issue
		
	}
	*/
	
	// How to read the content of a Table 
	@Test(enabled = false)
	public void read_table () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		// WebElement table = driver.findElement(By.tagName("table")); // we can use tag name too
		WebElement table = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon"));
		System.out.println(table.getText());
	}
	
	// How to read the row of a Table 
	@Test(enabled = false)
	public void readAnyRowofTheTable () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(5000);
		actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		WebElement row = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(1)"));
		System.out.println(row.getText());
	}
	
	// How to read a cell of a Table 
	@Test(enabled = false)
	public void readAnyCellOfARowofTheTable () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://www.amazon.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(10000);
		//actions = new Actions(driver); 
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(5000);
		WebElement cell = driver.findElement(By.cssSelector("table.navFooterMoreOnAmazon tr:nth-child(3) td:nth-child(1)"));
		System.out.println(cell.getText());			
	}
	
	@Test (enabled = false, priority = 1, groups = {"functionalTest", "sanityTest", "smokeTest", "regressionTest"})
	public void use_of_getTitle_method_with_assertion11() throws InterruptedException {
		// Your expected Title
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("The Title of the home Page is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");  
		// Hard Assertion will not go to next line of failed, but move to next line when passed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
		
	}
	
	@Test(enabled = false, priority = 1, groups = {"regressionTest"})
	public void use_of_getTitle_method_with_assertion12() throws InterruptedException {
		// Your expected Title
		String expected = "CMS Enterprise Portal           ";
		String actual = driver.getTitle();
		System.out.println("The Title of the home Page is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match ....... ");  // Hard Assertion, execution stopped here if Assertion fail
		// Hard Assertion will not go to next line of failed, but move to next line when passed
		String currentURL = driver.getCurrentUrl();
		System.out.println("The current url is: " + currentURL);
		
	}
	
	@Test(enabled = false, priority = 1, groups = {"sanityTest", "regressionTest"})
	public void use_of_getTitle_method_with_assertion13() throws InterruptedException {
		String expected = "A CMS Enterprise Portal"; // WHICH is wrong
		String actual = driver.getTitle();
		System.out.println("Home Page Title is: "+actual);
		SoftAssert softAssert = new SoftAssert(); 	// Soft Assertion, mainly interview question, not used generally
		softAssert.assertEquals(actual, expected, "Home Page Title doesn't match ..." );
		String currentURL =	driver.getCurrentUrl();
		System.out.println("The current url from priority 3 is: "+currentURL);
	
	}
	
	@Test (enabled = false, priority = 4, groups = {"smokeTest", "sanityTest", "functionalTest", "regressionTest"})
	public void logoTest(){
		WebElement logo = driver.findElement(By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	// error message will be appeared when the assertion failed 
	
	}
	
	@Test(enabled = false)
	public void use_of_expectedExceptions01 () {
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will fail");
		int i = 1/0;	
	}
	
	@Test(enabled = false, expectedExceptions = ArithmeticException.class)
	public void use_of_expectedExceptions02 () {
		System.out.println("We can verify whether a code throws the expected exception or not. Here it will pass");
		int i = 1/0;	
	}
	
	// wrong login button
	@Test(enabled = false, expectedExceptions = NoSuchElementException.class)
	public void use_of_expectedExceptions03 () throws InterruptedException {
		driver.findElement(By.id("ms-login-submit")).click();
		Thread.sleep(3000);
	}
	
	@Test(enabled = false)
	public void switchBetweenWindow01 () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window ID: " + parentWindow + "\n");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='New Window']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='New Window']")).click();  // clicked twice to open 2 child window
		Thread.sleep(3000);
		// very very important interview question 100%:  How you handle windows from parent to child? 
		// or how you can recognize the parent and child window	
		// getWindowHandles() -- Get all window handles -- include parent + child = Total 3 here
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate [a set of String]
		Set <String> allWindowHandles =  driver.getWindowHandles();
		System.out.println("Total Windows Opened: " + allWindowHandles.size()); 
		// Extract Parent and child window from all window handles
		String parent =(String)allWindowHandles.toArray()[0];
		String child1 = (String)allWindowHandles.toArray()[1];
		String child2 = (String)allWindowHandles.toArray()[2];
		System.out.println("Parent Window ID: " + parent + "\n");
		System.out.println("Child1 Window ID: " + child1 + "\n");
		System.out.println("Child2 Window ID: " + child2 + "\n");
		// Then switch from one window to other window (parent to child) by below
		driver.switchTo().window(child1);
		WebElement header = driver.findElement(By.id("sampleHeading"));
		System.out.println("The Text for the Web Element is: " + header.getText());
		System.out.println("The driver moved to the child 1 window");
				
	}
	
	// same way for moving from child to window for different url
	@Test(enabled = false)
	public void switchBetweenWindow02 () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://enthrallit.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// to click seelenium
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Thread.sleep(3000);
		
		// This will scroll up the page by 1000 pixel vertically
		Thread.sleep(4000); // used to see the scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", ""); // scroll down
		Thread.sleep(4000);
		
		String mainWindow = driver.getWindowHandle(); // learn this line
		System.out.println("Main Window ID: " + mainWindow + "\n");
		
		// click on the Open Window button
		driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
		Thread.sleep(5000);
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Windows Open After Click: " + allWindowHandles.size());
		
		// Extract Parent and child window from all window handles
		String parent = (String) allWindowHandles.toArray()[0]; // first index: parent
		String child = (String) allWindowHandles.toArray()[1]; // second index: child 

		//	Use window handle to switch from one window to other window (parent to child)
		driver.switchTo().window(child); // switchTo() -- method is used to switch from one to another
		System.out.println("The driver moved to the child window");
		
	}
	
	// different way for moving from child to window for different url
	@Test(enabled = false)
	public void switchBetweenWindow03 () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://enthrallit.com");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(7000);	
		driver.findElement(By.xpath("//a[text()='Selenium']")).click();
		Thread.sleep(3000);
		
		// This will scroll up the page by 1000 pixel vertically
		Thread.sleep(4000); // used to see the scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)", ""); // scroll down
		Thread.sleep(4000);
		
		String mainWindow = driver.getWindowHandle(); // learn this line
		System.out.println("Main Window ID: " + mainWindow + "\n");
		
		// click on the Open Window button
		driver.findElement(By.xpath("(//button[text()='Open Window'])[1]")).click();
		Thread.sleep(5000);
		
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Total Windows Open: " + allWindowHandles.size());
		
		// for each loop, line 1284, get title and get current url is not related to this code
		for (String wh : allWindowHandles) {
			if (mainWindow.equals(wh)) {
				System.out.println("\t Parent: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			} else {
				driver.switchTo().window(wh);
				System.out.println("\t Child: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			}
		}		
		
	}
	
	// different way for moving from child to window for different url
	@Test(enabled = true)
	public void switchBetweenWindow04 () throws InterruptedException {
		Thread.sleep(5000);	
		driver.get("https://www.amerihealth.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		Thread.sleep(7000);	
		
		WebElement careers = driver.findElement(By.xpath("//a[text()='Careers']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", careers);
		Thread.sleep(5000);
		js.executeScript("arguments[0].click()", careers);
		Thread.sleep(5000);
		
		String mainWindow = driver.getWindowHandle(); // learn this line
		System.out.println("Main Window ID: " + mainWindow + "\n");
		
		// click on the see current job opening
		driver.findElement(By.xpath("//a[text()='See current job openings']")).click();
		Thread.sleep(5000);
		
		// interview question:  How you handle windows from parent to child? or how you can recognize the parent and child window
		
		// Get all window handles -- include parent + child
		// why we are using set? because we don't want duplicate, and set doesn't allow duplicate
		Set<String> allWindowHandles = driver.getWindowHandles();
		System.out.println("Total Windows Open: " + allWindowHandles.size());
		
		// for each loop, line 1284, get title and get current url is not related to this code
		for (String wh : allWindowHandles) {
			if (mainWindow.equals(wh)) {
				System.out.println("\t Parent: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			} else {
				driver.switchTo().window(wh);
				System.out.println("\t Child: \t" + wh + "\n \t URL: \t \t" + driver.getCurrentUrl()
						+ "\n \t Title: \t \t" + driver.getTitle());
			}
		}	
		
		// type "QA" in find jobs and click on Search.	
		WebElement findJobs = driver.findElement(By.xpath("//input[@id='keyword']"));
		js.executeScript("arguments[0].value = 'Technician'", findJobs);
		Thread.sleep(3000);
		WebElement search = driver.findElement(By.xpath("//span[text()='Search']"));
		js.executeScript("arguments[0].click()", search);
		Thread.sleep(5000);
		
	}
	
	// Mostly TestNG feature
	@Test (enabled = false)
	public void b_logoTest01(){
		WebElement logo = driver.findElement(By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	
	}
	
	@Test(enabled = false, dependsOnMethods = "b_logoTest01")
	public void a_newUserRegistrationTest01() {
		boolean nurButtonEnabled = driver.findElement(By.xpath("//a[text()='New User Registration']")).isEnabled();
		System.out.println("Is the New User Registration Button Enable? Ans: " + nurButtonEnabled);
	}	
	
	
	
	// change the logoTest02 method to fail and see the above method skipped as it depends on logoTest02
	
	@Test (enabled = false)
	public void b_logoTest02(){
		// the xpath is wrong
		WebElement logo = driver.findElement(By.xpath("//mmem[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
		boolean flag = logo.isDisplayed();
		System.out.println("Is the logo displayed? Ans: "+flag);
		Assert.assertTrue(true, "Application Logo is not displayed .....");	
	}
	
	@Test(enabled = false, dependsOnMethods = "b_logoTest02")
	public void a_newUserRegistrationTest02() {
		boolean nurButtonEnabled = driver.findElement(By.xpath("//a[text()='New User Registration']")).isEnabled();
		System.out.println("Is the New User Registration Button Enable? Ans: " + nurButtonEnabled);
	}	
	
	@Test(enabled = false, groups = { "functionalTest" })
	public void nonSkipHomePageTitleTest() {
		String expected = "CMS Enterprise Portal";
		String actual = driver.getTitle();
		System.out.println("home page title is: " + actual);
		Assert.assertEquals(actual, expected, "Home Page Title doesn't match...");	
		System.out.println("No need to skip the test");
	}	
	
	// below examples of where 'throw' is used
	// How to skip a test?
	@Test(enabled = false, groups = { "functionalTest" })
	public void skipHomePageTitleTest01() {
		String title = "CMS Enterprise Portal";
		if (title.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}	
	
	@Test(enabled = false, groups = { "functionalTest" })
	public void skipHomePageTitleTest02() {
		// expected is different than actual
		String title = "CMS Enterprise Portal                      "; // title will not match
		if (title.equals(driver.getTitle())) {
			throw new SkipException("Skipping -- as the title matches as expected");
		} else {
			System.out.println("Home Page Title doesn't match...");
		}
		System.out.println("I am out of the if else condition");
	}	
	
	// Tough, don't try to understand the code, just understand the concept: time+condition+frequency
	// Interview question, generally not used in industry
	@Test (enabled = false)
	public void logoTest04() throws InterruptedException {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class); // line ends here
		WebElement logo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(
						By.xpath("//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']"));
			}
		});
		logo.isDisplayed();
	}






	

















	
	
	
	
	








	
	
	

}
