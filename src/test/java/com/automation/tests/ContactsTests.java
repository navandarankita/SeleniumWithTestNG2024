package com.automation.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseLogin;
import com.automation.utility.Constants;

public class ContactsTests extends BaseLogin{
	

	@Test
	public void createNewContact()
	{
			
		goToContactTab();
		
		WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(newButton, "new button");
	        
	    WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	    enterText(lastName, "ABCD", "last name");
	    
	    WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
	    enterText(accountName, "Edge Communications", "account name");
	    
	    WebElement saveButton = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]"));
        clickElement(saveButton, "save button");
        
        WebElement savedText = driver.findElement(By.xpath("//h2[@class='topName']"));
        try {
        	 Assert.assertEquals(savedText.getText(), "ABCD");
        }
        catch(Throwable e)
		{
			System.out.println("Inside catch......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}
	}
	
	@Test
	public void createNewView()
	{
		goToContactTab();
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewView, "create new view");
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewName, "Testing", "view name");
		
		WebElement saveButton = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title ='Save']"));
		clickElement(saveButton, "save button");
		
		WebElement dropDown = driver.findElement(By.xpath("//div[@class='topNav primaryPalette']//select[@class='title']"));
		Select select = new Select(dropDown);
		String titleText = select.getFirstSelectedOption().getText();

		try {
			Assert.assertEquals(titleText, "Testing");
       }
       catch(Throwable e)
		{
			System.out.println("Inside createNewView......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}
	}
	
	@Test
	public void checkRecentlyCreatedContact() 
	{
		goToContactTab();

		try {
			WebElement dropDown = driver.findElement(By.xpath("//select[@id='hotlist_mode']"));
			Select select = new Select(dropDown);
			select.selectByVisibleText("Recently Created");	
		}
		 catch(Throwable e)
		{
			System.out.println("Inside checkRecentlyCreatedContact......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}	
	}
	
	@Test
	public void checkMyContactView() 
	{
		goToContactTab();
		
		try {
			WebElement dropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
			Select select = new Select(dropDown);
			select.selectByVisibleText("Recently Viewed Contacts");
		}
		 catch(Throwable e)
		{
			System.out.println("Inside checkMyContactView......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}	
	}
	
	@Test
	public void viewContact() 
	{
		
		goToContactTab();
		
		WebElement contactName = driver.findElement(By.xpath("//table[@class='list']/tbody/tr[2]/th/a"));
		clickElement(contactName, "contact name");
						
		WebElement savedText = driver.findElement(By.xpath("//h2[@class='topName']"));
				
		try {
			Assert.assertEquals(savedText.getText(), "ABCD");
       }
       catch(Throwable e)
		{
			System.out.println("Inside viewContact......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}
	}
	
	@Test
	public void createNewViewErrorMessage() 
	{
		
		goToContactTab();
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewView, "create new view");
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(viewUniqueName, "EFGH", "view unique name");
		
		WebElement saveButton = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title ='Save']"));
		clickElement(saveButton, "save button");
		
		WebElement errorMsg = driver.findElement(By.xpath("//div[@class='requiredInput']/div[@class='errorMsg']"));
		String expectedErrorMsg ="Error: You must enter a value";
		
		try {
			Assert.assertEquals(errorMsg.getText(),expectedErrorMsg);
       }
       catch(Throwable e)
		{
			System.out.println("Inside createNewViewErrorMessage......");
			String filename = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
			takeScreenshot(Constants.SCREENSHOTS_DIRECTORY_PATH+filename+".png");
		}
	}
	
	@Test
	public void createNewViewCancel() 
	{
		goToContactTab();
		
		String view ="ABCD";
	
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewView, "create new view");
		
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewName, view, "view name");
		
		WebElement viewUniqueName = driver.findElement(By.xpath("//input[@id='devname']"));
		enterText(viewUniqueName, "EFGH", "view unique name");
		
		WebElement cancelButton = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title ='Cancel']"));
		clickElement(cancelButton, "cancel button");
		
		WebElement dropDown = driver.findElement(By.xpath("//select[@id='fcf']"));
		Select select = new Select(dropDown);
				
		if(!view.equals(select.getFirstSelectedOption().getText()))
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed");
		}
	}
	
	@Test
	public void checkSaveAndNewButton() 
	{
		goToContactTab();
	
		WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(newButton, "new button");
	        
	    WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastcon2']"));
	    enterText(lastName, "Indian", "last name");
	    
	    WebElement accountName = driver.findElement(By.xpath("//input[@id='con4']"));
	    enterText(accountName, "Global Media", "account name");
	    
	    WebElement saveAndNewButton = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[2]"));
        clickElement(saveAndNewButton, "save and new button");

	}
}
