package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import baseUtil.BaseClass;

public class ForgotUserIdTest extends BaseClass {
	
	@Test (enabled = false)
	public void forgotUserIdClickTest() {
		forgotUserId.forgotUserIdClick();
		System.out.println("The current url is: " + driver.getTitle());
		System.out.println("The current url is: " + driver.getCurrentUrl());
	}

	// drop down, all categories
	// drop down is a commonly asked interview question
	// here - using selectByIndex() method
	// This method is not suggested, or not used much
	// Because, adding a new web element or deleting a new one change the index number	
	@Test(enabled = false)
	public void use_of_dropdown_selectByIndex_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthDate']"));
		select = new Select(birthDate); // Select class is instantiated in Base class
		select.selectByIndex(13); // index type
		Thread.sleep(4000);		
	}
	
	// drop down is a commonly asked interview question
	// Most commonly use method in drop down --> selectByVisibleText()
	@Test(enabled = false)
	public void use_of_dropdown_selectByVisisbleText_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='cms-forgotid-birthMonth']"));
		select = new Select(birthMonth);
		select.selectByVisibleText("August"); // text type
		Thread.sleep(4000);
	}
	
	// drop down is a commonly asked interview question
	// use method --> selectByValue()
	@Test(enabled = false)
	public void use_of_dropdown_selectByValue_method() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthYear']"));
		select = new Select(birthYear);
		select.selectByValue("1998"); // you have to look for value attributes, and add the value of that value attributes
		Thread.sleep(4000);
	}
	
	@Test (enabled = true)
	public void forgotUserIdTest() throws InterruptedException {
		forgotUserIdClickTest();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@name='cms-forgotid-firstName']")).sendKeys("Mohammad");
		driver.findElement(By.xpath("//input[@name='cms-forgotid-lastName']")).sendKeys("Sharkar");
		WebElement birthMonth = driver.findElement(By.xpath("//select[@name='cms-forgotid-birthMonth']"));
		select = new Select(birthMonth);
		select.selectByVisibleText("August"); // text type
		WebElement birthDate = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthDate']"));
		select = new Select(birthDate); // Select class is instantiated in Base class
		select.selectByIndex(13); // index type
		WebElement birthYear = driver.findElement(By.xpath("//select[@id='cms-forgotid-birthYear']"));
		select = new Select(birthYear);
		select.selectByValue("1998");
		driver.findElement(By.xpath("//input[@id='cms-forgotid-forgotEmail']")).sendKeys("tofael483@gmail.com");
		driver.findElement(By.xpath("//input[@name='cms-forgotid-zipcode']")).sendKeys("10019");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Thread.sleep(5000);		
	
	}
	
	
	
	
	
	
}
