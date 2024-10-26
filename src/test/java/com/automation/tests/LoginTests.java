package com.automation.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.automation.base.BaseLogin;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class LoginTests extends BaseLogin{

	String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
	String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");

	@Test
	public void loginError()
	{

		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, usernameData, "user name");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "", "password");

		WebElement login= driver.findElement(By.id("Login"));
		clickElement(login, "login");

		WebElement errorMessage= driver.findElement(By.xpath("//*[@id='error']"));

		String expectedText= "Please enter your password.";

		String actualText = errorMessage.getText();
		try {
			Assert.assertEquals(actualText, expectedText);
		}
		catch(Throwable e)
		{
			System.out.println("Inside catch......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}

	}

	@Test
	public void validLogin()
	{
		login_salesforce();
	}

	@Test
	public void checkRememberMe()
	{
		String expectedText = "Ann Abcd";

		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, usernameData, "user name");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, passwordData, "password");

		WebElement rememberMeCheckbox = driver.findElement(By.xpath("//*[@id='rememberUn']"));
		checkBoxSelected(rememberMeCheckbox, "Remember me");

		WebElement login= driver.findElement(By.id("Login"));
		clickElement(login, "login");

		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		String actualText = userMenuDropdown.getText();

		try {
			Assert.assertEquals(actualText, expectedText);
		}
		catch(Throwable e)
		{
			System.out.println("Inside catch......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}

		clickElement(userMenuDropdown, "user menu dropdown");

		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");

	}


	@Test
	public void forgotPassword() 
	{

		WebElement forgotPassword = driver.findElement(By.xpath("//*[@id='forgot_password_link']"));
		clickElement(forgotPassword, "forgot password");

		WebElement userName = driver.findElement(By.xpath("//*[@id='un']"));
		enterText(userName, usernameData, "username");

		WebElement continueButton = driver.findElement(By.xpath("//*[@id='continue']"));
		clickElement(continueButton, "continue button");

		WebElement emailSentText = driver.findElement(By.xpath("//*[@id='header']"));

		System.out.println(emailSentText.getText());

	}


	@Test
	public void incorrectLogin() 
	{

		WebElement userName = driver.findElement(By.id("username"));
		enterText(userName, "123", "user name");

		WebElement password = driver.findElement(By.id("password"));
		enterText(password, "22131", "password");

		WebElement login= driver.findElement(By.id("Login"));
		clickElement(login, "login");

		WebElement errorMessage= driver.findElement(By.xpath("//*[@id='error']"));

		String expectedText= "Please check your username and password If you still can't log in, contact your Salesforce administrator.";

		String actualText = errorMessage.getText();
		try {
			Assert.assertEquals(actualText, expectedText);
		}
		catch(Throwable e)
		{
			System.out.println("Inside catch......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}
	}


}

