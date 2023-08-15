package common;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class CommonActions {
	
	// Create this method after showing a wrong web element searching [wrongNewUserRegistration in homePage class]
	public static void clickElement(WebElement element) {
		try {
			element.click();
		} catch (NoSuchElementException | NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void inputText (WebElement element, String input) {
		try {
			element.sendKeys(input);
		} catch (NoSuchElementException | NullPointerException f) {
			// f.printStackTrace();
			System.out.println("Exception is: " + f);
		}
	}

}
