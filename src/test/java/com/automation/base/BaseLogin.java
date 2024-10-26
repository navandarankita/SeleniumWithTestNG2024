package com.automation.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.automation.utility.Constants;
import com.automation.utility.PropertiesUtility;

public class BaseLogin extends BaseTest{
    
	private boolean actionNeeded = false;

	@BeforeMethod
	public void setUpBeforeMethod()
	{
		System.out.println("******* SetUpBeforeMethod *******");
		launchBrowser("chrome");
		String url= PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "url");
		goToUrl(url);
	}
	
	@AfterMethod
	public void tearDownAfterMethod()
	{
		if(actionNeeded) {
			
			setUpBeforeMethod();
	    }
		
		System.out.println("******* tearDownAfterMethod *******");
		closeDriver();
	}
	
	
	public void login_salesforce()
	{
		String usernameData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "username");
		String passwordData = PropertiesUtility.readDataFromPropertyFile(Constants.APPLICATION_PROPERTIES, "password");
		
		WebElement userName = driver.findElement(By.id("username"));
		waitForVisibility1(userName, 30, "userName");
		enterText(userName, usernameData, "user name");
		
		WebElement password = driver.findElement(By.id("password"));
		enterText(password, passwordData, "password");
		
		WebElement login= driver.findElement(By.id("Login"));
		clickElement(login, "login");
	}
	
	public void goToUserMenuDropdown()
	{
		login_salesforce();
		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		waitForVisibility1(userMenuDropdown, 30, "userMenuDropdown");
		Assert.assertEquals(userMenuDropdown.getText(), "Ann Abcd");
		clickElement(userMenuDropdown, "user menu dropdown");
	}
	
	public void goToAccountTab()
	{
		login_salesforce();
		WebElement account = driver.findElement(By.xpath("//*[@id='Account_Tab']"));
		waitForVisibility1(account, 30, "accountTab");
		clickElement(account, "account tab");
	}
	
	public void goToContactTab()
	{
		login_salesforce();
		WebElement contactTab = driver.findElement(By.xpath("//li[@id='Contact_Tab']"));
		waitForVisibility1(contactTab, 30, "contactTab");
		clickElement(contactTab, "contact tab");
	}
	
	public void goToLeadsTab()
	{
		login_salesforce();
		WebElement leadsTab = driver.findElement(By.xpath("//li[@id='Lead_Tab']"));
		waitForVisibility1(leadsTab, 30, "leadsTab");
		clickElement(leadsTab, "leads tab");
		WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='pageType']"));
		String expectedText = "Leads";
		Assert.assertEquals(pageTitle.getText(), expectedText);
	}
	
	public void goToOpportunitiesTab()
	{
		login_salesforce();
		WebElement oppoTab = driver.findElement(By.xpath("//li[@id='Opportunity_Tab']"));
		waitForVisibility1(oppoTab, 30, "oppoTab");
		clickElement(oppoTab, "opportunities tab");
	}
	
	public void randomScenarios()
	{
		login_salesforce();
		WebElement homeTab = driver.findElement(By.xpath("//li[@id='home_Tab']"));
		waitForVisibility1(homeTab, 30, "homeTab");
		clickElement(homeTab, "homeTab");

	}
}
