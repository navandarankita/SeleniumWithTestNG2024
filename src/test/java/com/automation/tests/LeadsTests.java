package com.automation.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseLogin;

public class LeadsTests extends BaseLogin{
	
	@Test
	public void leadsTab()
	{
		goToLeadsTab();
	}
	
	@Test
	public void leadsSelectView()
	{
		goToLeadsTab();
		
		WebElement leadsDropdown = driver.findElement(By.xpath("//select[@id='fcf']"));
		clickElement(leadsDropdown, "leadsDropdown");
		
		WebElement option1 = driver.findElement(By.xpath("//select[@id='fcf']/option[1]"));
		Assert.assertEquals(option1.getText(), "All Open Leads");
		
		WebElement option2 = driver.findElement(By.xpath("//select[@id='fcf']/option[2]"));
		Assert.assertEquals(option2.getText(), "My Unread Leads");
		
		WebElement option3 = driver.findElement(By.xpath("//select[@id='fcf']/option[3]"));
		Assert.assertEquals(option3.getText(), "Recently Viewed Leads");
		
		WebElement option4 = driver.findElement(By.xpath("//select[@id='fcf']/option[4]"));
		Assert.assertEquals(option4.getText(), "Today's Leads");
				
//		List<WebElement> elements= driver.findElements(By.xpath("//select[@id='fcf']"));
//		for(WebElement elem: elements) {
//			System.out.println(elem.getText());
//		}
				
		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		clickElement(userMenuDropdown, "user menu dropdown");

		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");
	}
	
	@Test
	public void defaultView() 
	{
		for(int i = 0; i < 2; i++)
		{
			goToLeadsTab();
			
			if(i == 0)
			{
	            WebElement dropdownElement = driver.findElement(By.xpath("//select[@id='fcf']"));
	            Select dropdown = new Select(dropdownElement);
	            dropdown.selectByVisibleText("Today's Leads");
	            WebElement selectedOption = dropdown.getFirstSelectedOption();
	            System.out.println("Selected option: " + selectedOption.getText());
			}
			else {
			      WebElement t=driver.findElement(By.xpath("//select[@id='fcf']"));
			      Select dropdown = new Select(t);
			      WebElement selectedOption = dropdown.getFirstSelectedOption();
		          String selectedText = selectedOption.getText();
		          System.out.println("selected: "+selectedText);
		          WebElement goButton=driver.findElement(By.xpath("//input[@title='Go!']"));
		          clickElement(goButton, "go button");  
			}	
		
			WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
			clickElement(userMenuDropdown, "user menu dropdown");
			WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
			clickElement(logout, "logout");	
		}		
	}
	
	@Test
	public void todaysLeads() 
	{
		goToLeadsTab();
		
		WebElement t=driver.findElement(By.xpath("//select[@id='fcf']"));
	    Select dropdown = new Select(t);
	    
	    WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        System.out.println("selected: "+selectedText);
        
        WebElement goButton=driver.findElement(By.xpath("//input[@title='Go!']"));
        clickElement(goButton, "go button");  
		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		clickElement(userMenuDropdown, "user menu dropdown");
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");
		
	}
	
	@Test
	public void clickOnNew() 
	{
		goToLeadsTab();
		
        WebElement newButton=driver.findElement(By.xpath("//input[@title='New']"));
        clickElement(newButton, "new button");
        
        WebElement lastName = driver.findElement(By.xpath("//input[@id='name_lastlea2']"));
        lastName.sendKeys("ABCD");
        
        WebElement companyName = driver.findElement(By.xpath("//input[@id='lea3']"));
        companyName.sendKeys("ABCD");
        
        WebElement saveButton = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]"));
        clickElement(saveButton, "save button");
        
        WebElement savedText = driver.findElement(By.xpath("//h2[@class='topName']"));
        Assert.assertEquals(savedText.getText(), "ABCD");
       
		WebElement userMenuDropdown = driver.findElement(By.xpath("//*[@id='userNavLabel']"));
		clickElement(userMenuDropdown, "user menu dropdown");
		WebElement logout = driver.findElement(By.xpath("//*[@id='userNav-menuItems']/a[5]"));
		clickElement(logout, "logout");			
	}
}
