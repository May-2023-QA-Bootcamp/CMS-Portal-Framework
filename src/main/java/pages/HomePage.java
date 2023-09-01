package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// new, you have to manually write it to get access
// this is possible when they are static in nature, * means all
// This is called static import
import static common.CommonActions.*;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		// PageFactory help to instantiate WebElements
		PageFactory.initElements(driver, this);
		// If no PageFactory class, Web element can't instantiate and show NullPointerException
	}
	
	// 1st way: Most common way to write the WebElement (@FindBy), you must know how to do that
	// Use of 'Id' attribute as locator
	@FindBy(id = "cms-login-submit")
	WebElement loginButton;
	
	// Use of 'name' attribute as locator
	@FindBy(name = "user-d")
	WebElement userId;
	
	// 2nd way to write the WebElement: not common, here I used the 'password'
	// Use of 'name' attribute as locator
	@FindBy(how = How.NAME, using = "pass-d")
	WebElement password;
	
	@FindBy(className = "cms-newuser-reg")
	WebElement newUserRegistration;
	
	// Used it to show the common action method exception
	@FindBy(className = "cms-newuser-registration")
	WebElement wrongNewUserRegistration;
	
	@FindBy(xpath = "//a[text()='User ID']")
	WebElement forgotUserId;
	
	@FindBy(xpath = "//em[@id='cms-homepage-header-logo-unauth' and @class='cms-icon cms-sprite-loggedout ms-3']")
	WebElement logo;
	
	// 3rd way to write the WebElement: not common, here I used unlock web element from the home page
	// instead of xpath, we can use id, name, class etc as locator.
	By unlock = By.xpath("//a[text()='unlock']");
	// Please see line 116 for clickUnlock() method
	
	// for logger test
	@FindBy (name = "user-d-wrong")
	WebElement wrongUserId;
	
	public void clickLoginButton() throws InterruptedException  {
		loginButton.click();
		Thread.sleep(5000);
	}
	
	public void clickUserId() {
		userId.click();
	}
	
	public void clickPassword() {
		password.click();
	}
	
	public void clickNewUserRegistration() {
		newUserRegistration.click();
		// We used try catch block to throw exception
		// as we used Thread.sleep either we can use throws or we can use try catch block
		// we used try catch block here, No relation of try catch with click() method
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void clickWrongNewUserRegistration() {
		wrongNewUserRegistration.click();
		// We used try catch block to throw exception
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void forgotUserIdClick() throws InterruptedException {
		clickElement(forgotUserId);
		Thread.sleep(5000);
	}
	
	// We are using sendKeys() to input text
	public void inputTextInUserIdField () {
		userId.sendKeys("May2023QABootcamp");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void inputTextInUserIdAndPasswordFieldThenClickLoginButton () throws InterruptedException {
		inputText(userId, "Enthrall_May_2023");
		Thread.sleep(4000);
		inputText(password, "AllLazyPeople@123");
		Thread.sleep(4000);
		clickElement(loginButton);
		Thread.sleep(4000);
	}
	
	public void clickUnlock() throws InterruptedException {
		Thread.sleep(3000);
		// new way to call the web element
		driver.findElement(unlock).click();
			Thread.sleep(5000);
	}
	
	public void clickLogo() throws InterruptedException {
		logo.click();
		Thread.sleep(5000);
	}
	
	public boolean logoDisplayed () {
		boolean flag = logo.isDisplayed();
		return flag;
	}

		
	
	

}
