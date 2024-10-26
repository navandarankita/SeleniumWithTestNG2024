package com.automation.tests;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.BaseLogin;

public class RandomScenarios extends BaseLogin{
	
	@Test
	public void checkFirstAndLastName()
	{
		randomScenarios();
		
		String name = "Ann Abcd";

		WebElement homePage = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		Assert.assertEquals(homePage.getText(), name);
		clickElement(homePage, "userName");
		
//		WebElement profilePage = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));	
//		waitForVisibility1(profilePage, 30, "profilePage");
//		Assert.assertEquals(name, profilePage.getText());
	}
	
	@Test
	public void verifyEditedName()
	{
		
		randomScenarios();
		
		WebElement userName = driver.findElement(By.xpath("//h1[@class='currentStatusUserName']/a"));
		clickElement(userName, "userName");
		
		WebElement editName = driver.findElement(By.xpath("//a[@class='contactInfoLaunch editLink']"));
		clickElement(editName, "edit name");
		
		driver.switchTo().frame("contactInfoContentId"); 
		
		WebElement about = driver.findElement(By.xpath("//li[@id='aboutTab']"));
		clickElement(about, "about");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
		enterText(lastName, "Abcd", "edited last name");
		
		WebElement saveAllButton = driver.findElement(By.xpath("//div/input[@value='Save All']"));
		clickElement(saveAllButton, "save all button");
		
		driver.switchTo().defaultContent();
		
		WebElement updatedUserNameLeft = driver.findElement(By.xpath("//span[@id='tailBreadcrumbNode']"));
		System.out.println(updatedUserNameLeft.getText());	
		
		WebElement updatedUserNameRight = driver.findElement(By.xpath("//span[@id='userNavLabel']"));
		System.out.println(updatedUserNameRight.getText());
		
		String name1 = updatedUserNameLeft.getText();

		Assert.assertEquals(name1.trim(), updatedUserNameRight.getText());

	}
	


	@Test
	public void verifyTab() 
	{
		login_salesforce();
		
		WebElement allTab = driver.findElement(By.xpath("//li[@id='AllTab_Tab']"));
		waitForVisibility1(allTab, 30, "allTab");
		clickElement(allTab, "all tab");
		
		WebElement customizeMyTab = driver.findElement(By.xpath("//input[@value='Customize My Tabs']"));
		clickElement(customizeMyTab, "customize my tab");
				
		WebElement selectedTabEle = driver.findElement(By.xpath("//select[@id='duel_select_1']/option[@value='AppLauncher']"));
		clickElement(selectedTabEle, "selected tab element");
		
		WebElement removeButton = driver.findElement(By.xpath("//a[@id='duel_select_0_left']"));
		clickElement(removeButton, "remove button");
		
		WebElement saveButton = driver.findElement(By.xpath("//input[@title='Save']"));
		clickElement(saveButton, "save button");
		
		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		clickElement(userMenuDropdown, "user menu dropdown");
		
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");
		
		verifyTabContainsOrNot();
		//waitForVisibility1(userName, 30, "userName");
	}
	
	
	@Test
	public void verifyTabContainsOrNot()
	{

		//actionNeeded = true;
		login_salesforce();
		
		List<WebElement> tabElem = driver.findElements(By.xpath("//ul[@id='tabBar']/li"));
		for(WebElement elem: tabElem)
		{
			if(!elem.getText().equals("AppLauncher"))
			{
				System.out.println("Test passed");
			}
		}	
	}
	
	
	@Test
	public void blockingEventCalender() 
	{
		randomScenarios();
		
		WebElement dateLink = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));
		clickElement(dateLink, "date link");
		
		WebElement calenderLink = driver.findElement(By.xpath("//a[contains(text(), '8:00 PM')]"));
		clickElement(calenderLink, "calender link");
		
		WebElement newEvent = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/a"));
		clickElement(newEvent, "new event");
		
		String originalWindow = driver.getWindowHandle();
		
		 Set<String> allWindows = driver.getWindowHandles();
	        for (String window : allWindows) {
	            if (!window.equals(originalWindow)) {
	                // Switch to the new window
	                driver.switchTo().window(window);
	                // Perform actions in the new window if needed
	                WebElement other = driver.findElement(By.xpath("//ul/li[5]"));
	        		waitForVisibility1(other, 30, "other");
	        		clickElement(other, "other");
	                // Close the new window after actions
	                driver.close();
	                break; // Exit the loop after closing the new window
	            }
	        }
		
		driver.switchTo().window(originalWindow);
		
		WebElement pickAdate = driver.findElement(By.xpath("//input[@id='EndDateTime_time']"));
		clickElement(pickAdate, "pickAdate");
		
		WebElement savButton = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]"));
		clickElement(savButton, "savButton");
	}
	
	@Test
	public void blockingEventCalenderWeeklyReaccurance()
	{
		randomScenarios();

		WebElement dateLink = driver.findElement(By.xpath("//span[@class='pageDescription']/a"));
		clickElement(dateLink, "date link");
		
		WebElement calenderLink = driver.findElement(By.xpath("//a[contains(text(), '4:00 PM')]"));
		clickElement(calenderLink, "calender link");
		
		WebElement newEvent = driver.findElement(By.xpath("//table/tbody/tr[2]/td[2]/div/a"));
		clickElement(newEvent, "new event");
		
		WebElement other = driver.findElement(By.xpath("//ul/li[5]"));
		clickElement(other, "other");
				
		WebElement checkReccurence = driver.findElement(By.xpath("//input[@id='IsRecurrence']"));
		checkBoxSelected(checkReccurence, "checkReccurence");
		
		WebElement radioSelected = driver.findElement(By.xpath("//input[@id='rectypeftw']"));
		radioButton(radioSelected, "radioSelected");
		
		WebElement saveButton = driver.findElement(By.xpath("//td[@id='topButtonRow']/input[@title='Save']"));
		clickElement(saveButton, "save button");

	}

}
