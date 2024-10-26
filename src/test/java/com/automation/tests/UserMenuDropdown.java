package com.automation.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseLogin;

public class UserMenuDropdown extends BaseLogin{
	
	@Test
	public void checkUserdropdownContent()
	{
		goToUserMenuDropdown();
								
		WebElement profile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]"));
		String option1 = profile.getText();
		
		WebElement settings = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		String option2 = settings.getText();

		WebElement devConsole = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[3]"));
		String option3 = devConsole.getText();
		
		WebElement switchToLightningExp = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[4]"));
		String option4 = switchToLightningExp.getText();
		
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		String option5 = logout.getText();
				
		Assert.assertEquals(option1, "My Profile");
		Assert.assertEquals(option2, "My Settings");
		Assert.assertEquals(option3, "Developer Console");
		Assert.assertEquals(option4, "Switch to Lightning Experience");
		Assert.assertEquals(option5, "Logout");
				
		clickElement(logout, "logout");
	}

	@Test
	public void myProfile() 
	{
		goToUserMenuDropdown();
		String filepath = "/Users/ankitakasat/Desktop/File1.docx";
		
		WebElement profile = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[1]"));
		clickElement(profile, "profile");
		
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
		
		WebElement post = driver.findElement(By.xpath("//span[text()='Post']"));
		clickElement(post, "post");
		
		By frame = By.xpath("//iframe[@class='cke_wysiwyg_frame cke_reset']");
        driver.switchTo().frame(driver.findElement(frame));
        
        WebElement textArea = driver.findElement(By.xpath("/html/body"));
		enterText(textArea, "Hello World!!", "post");
		
		driver.switchTo().defaultContent();

		WebElement share = driver.findElement(By.xpath("//div[@class='bottomBarRight']"));
		clickElement(share, "share");
		
		WebElement file = driver.findElement(By.xpath("//span[text()='File']"));
		clickElement(file, "file");
		
		WebElement uploadAfileButton = driver.findElement(By.xpath("//td[@id='chatterUploadFileActionPanel']"));
		clickElement(uploadAfileButton, "uploadAfileButton");
		
		WebElement chooseFileButton = driver.findElement(By.xpath("//input[@id='chatterFile']"));		
		//chooseFileButton.sendKeys(filepath);
		enterText(chooseFileButton, filepath, "chooseFileButton");
		
		WebElement shareButton = driver.findElement(By.xpath("//div[@class='bottomBarRight']"));
		clickElement(shareButton, "shareButton");


		
	}
	
	@Test
	public void mySettings() 
	{
		goToUserMenuDropdown();
		
		String filepath = "/Users/ankitakasat/Downloads";
	
		WebElement settings = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[2]"));
		Assert.assertEquals(settings.getText(), "My Settings");
		clickElement(settings, "settings");
		
		WebElement personalLink = driver.findElement(By.xpath("//div[@id='PersonalInfo']"));
		clickElement(personalLink, "personalLink");
		
		WebElement loginHistoryLink = driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		clickElement(loginHistoryLink, "loginHistoryLink");
		
//		String originalWindow = driver.getWindowHandle();
//
//		WebElement downloadLoginhistory = driver.findElement(By.xpath("//div[@class='pShowMore']/a"));
//		clickElement(downloadLoginhistory, "downloadLoginhistory");
//		enterText(downloadLoginhistory, filepath, "downloadLoginhistory");
//		
		String originalWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                WebElement downloadLoginhistory = driver.findElement(By.xpath("//div[@class='pShowMore']/a"));
        		clickElement(downloadLoginhistory, "downloadLoginhistory");
        		enterText(downloadLoginhistory, filepath, "downloadLoginhistory");
                driver.close();
                break;
            }
        }
	    driver.switchTo().window(originalWindow);
 
		WebElement displayAndLayout = driver.findElement(By.xpath("//*[@id='DisplayAndLayout']"));
		clickElement(displayAndLayout, "displayAndLayout");
		
		WebElement customizeTabs = driver.findElement(By.xpath("//*[@id='DisplayAndLayout_child']/div[1]"));
		clickElement(customizeTabs, "customize tabs");
		
		WebElement customeApp = driver.findElement(By.xpath("//*[@id='p4']"));
		Select select = new Select(customeApp);
		select.selectByVisibleText("Salesforce Chatter");
		
		WebElement availableTab = driver.findElement(By.id("duel_select_0"));
		Select select1 = new Select (availableTab);
		select1.selectByValue("report");
		
		WebElement addButton = driver.findElement(By.id("duel_select_0_right"));
		clickElement(addButton, "add");

		String val ="Reports";
		
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id='duel_select_1']"));
		for(WebElement elem : elements)
		{
			System.out.println(elem.getText());

			if(val.equals(elem.getText()))
			{
				System.out.println("Reports available in selected tabs");
			}
			else {
				System.out.println("Reports not available in selected tabs");
			}
		}
	}
	
	@Test
	public void devConsole() 
	{
		goToUserMenuDropdown();
		
		WebElement devConsole = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[3]"));
		clickElement(devConsole, "dev Console");
				
		List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
		 if (windowHandles.size() > 1) {
			 System.out.println(windowHandles.size());
	            // Switch to the new window (the last one in the list)
	            driver.switchTo().window(windowHandles.get(windowHandles.size() - 1));

	            // Now you can interact with the new window
	            System.out.println("Title of new window: " + driver.getTitle());

	            // Optionally, switch back to the original window
	            driver.switchTo().window(windowHandles.get(0));
	            System.out.println("Back to original window: " + driver.getTitle());
	        }
	}
	
	@Test
	public void logout()
	{
		goToUserMenuDropdown();
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");

	}
}
