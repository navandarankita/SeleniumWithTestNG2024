package com.automation.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseLogin;

public class AccountTests extends BaseLogin{
	
	@Test
	public void createAnAccount() 
	{
		goToAccountTab();
		
		WebElement newButton = driver.findElement(By.xpath("//*[@id='hotlist']/table/tbody/tr/td[2]/input"));
		clickElement(newButton, "new button"); 
		
		WebElement accountName = driver.findElement(By.xpath("//*[@id='acc2']"));
		enterText(accountName, "abc", "account name");
		
		WebElement selectType = driver.findElement(By.xpath("//*[@id='acc6']"));
		Select select = new Select(selectType);
		select.selectByValue("Technology Partner");
		
		WebElement customerPriority = driver.findElement(By.xpath("//*[@id='00Nbm000004QE1q']"));
		Select select1 = new Select(customerPriority);
		select1.selectByValue("High");
		
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='bottomButtonRow']/input[1]"));
		clickElement(saveButton, "save button");
		
		WebElement displayedName = driver.findElement(By.xpath("//*[@id='contactHeaderRow']/div[2]/h2"));
		
		System.out.println(displayedName.getText());
				
	}
	
	@Test
	public void createNewView() 
	{
	
		goToAccountTab();
		
		WebElement createNewView = driver.findElement(By.xpath("//a[text()='Create New View']"));
		clickElement(createNewView, "create new view");
				
		WebElement viewName = driver.findElement(By.xpath("//input[@id='fname']"));
		enterText(viewName, "dan", "view name");
		
		WebElement saveButton = driver.findElement(By.xpath("//div[@class='pbHeader']//input[@title ='Save']"));
		clickElement(saveButton, "save button");
		
		WebElement dropDown = driver.findElement(By.xpath("//div[@class='topNav primaryPalette']//select[@class='title']"));
		waitForVisibility1(dropDown, 30, "dropDown");

		Select select = new Select(dropDown);
		String titleText = select.getFirstSelectedOption().getText();
		System.out.println(titleText);
		String expectedText = "dan";
		
		Assert.assertEquals(titleText, expectedText);
	
	}
	
	@Test
	public void editView()
	{
		
		goToAccountTab();
		
		WebElement editButton = driver.findElement(By.xpath("//*[@id='filter_element']/div/span/span[2]/a[1]"));
		clickElement(editButton,"edit button");
		
		WebElement viewName = driver.findElement(By.xpath("//*[@id='fname']"));
		enterText(viewName, "dannie", "new view Name");
		
		WebElement accountName = driver.findElement(By.xpath("//*[@id='fcol1']"));
		Select selectAccountName = new Select(accountName);
		selectAccountName.selectByValue("ACCOUNT.NAME");
		
		WebElement operator = driver.findElement(By.xpath("//*[@id='fop1']"));
		Select selectOperator = new Select(operator);
		selectOperator.selectByValue("c");
		
		WebElement accountValue = driver.findElement(By.xpath("//*[@id='fval1']"));
		enterText(accountValue, "<a>", "account value");
		
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='editPage']/div[3]/table/tbody/tr/td[2]/input[1]"));
		clickElement(saveButton,"save button");
	}
	
	@Test
	public void mergeAccounts() 
	{
		goToAccountTab();
		
		WebElement mergeButton = driver.findElement(By.xpath("//*[@id='toolsContent']//a[text()='Merge Accounts']"));
		clickElement(mergeButton, "merge button");
		
		WebElement findAccounts = driver.findElement(By.xpath("//input[@id='srch']"));
		enterText(findAccounts, "abc", "findAccounts");
		
		WebElement findAccountsButton = driver.findElement(By.xpath("//*[@id='stageForm']/div/div[2]/div[4]/input[2]"));
		clickElement(findAccountsButton, "findAccountsButton");
		
		WebElement nextButton = driver.findElement(By.xpath("//div[@class='pbBottomButtons']/input[1]"));
		clickElement(nextButton, "nextButton");
		
		WebElement merge = driver.findElement(By.xpath("//div[@class='pbBottomButtons']/input[2]"));
		clickElement(merge,"merging");
		
		Alert alert = driver.switchTo().alert();
		
        alert.accept();
        
		WebElement displayedText = driver.findElement(By.xpath("//tr[2]/th/a"));
		String actualText = "abc";
		Assert.assertEquals(displayedText.getText(), actualText);

	}
	
	@Test
	public void createReport() {
		
		goToAccountTab();
		
		WebElement reportLink = driver.findElement(By.xpath("//*[@id='toolsContent']//a[text()='Accounts with last activity > 30 days']"));
		clickElement(reportLink, "report link");
		
		//select created date in dropdown datefield
		
//		WebElement DateField = driver.findElement(By.xpath("//*[@id='ext-gen20']"));
//		clickElement(DateField, "DateField");
//		
		WebElement fromDate = driver.findElement(By.xpath("//*[@id='ext-gen152']"));
		clickElement(fromDate, "fromDate");
		
		WebElement todayButton = driver.findElement(By.xpath("//button[text()='Today']"));
		clickElement(todayButton, "todayButton");
				
		WebElement saveButton = driver.findElement(By.xpath("//button[text()='Save']"));
		clickElement(saveButton, "saveButton");
		
		WebElement modal = driver.findElement(By.id("saveReportDlg"));
		
		WebElement reportName = modal.findElement(By.xpath("//input[@id='saveReportDlg_reportNameField']"));
		enterText(reportName, "abc", "report name");
		
		WebElement saveRunReport = modal.findElement(By.xpath("//button[text()='Save and Run Report']"));
		clickElement(saveRunReport, "save and run report");
	
	}

}
