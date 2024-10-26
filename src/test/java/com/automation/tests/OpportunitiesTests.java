package com.automation.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.base.BaseLogin;

public class OpportunitiesTests extends BaseLogin{

	@Test
	public void opportunitiesDropDown() 
	{
		goToOpportunitiesTab();
				
		WebElement oppoOption1 = driver.findElement(By.xpath("//*[@id='fcf']/option[1]"));
		String option1 = oppoOption1.getText();
		
		WebElement oppoOption2 = driver.findElement(By.xpath("//*[@id='fcf']/option[2]"));
		String option2 = oppoOption2.getText();

		WebElement oppoOption3 = driver.findElement(By.xpath("//*[@id='fcf']/option[3]"));
		String option3 = oppoOption3.getText();
		
		WebElement oppoOption4 = driver.findElement(By.xpath("//*[@id='fcf']/option[4]"));
		String option4 = oppoOption4.getText();
		
		WebElement oppoOption5 = driver.findElement(By.xpath("//*[@id='fcf']/option[6]"));
		String option5 = oppoOption5.getText();
		
		WebElement oppoOption6 = driver.findElement(By.xpath("//*[@id='fcf']/option[9]"));
		String option6 = oppoOption6.getText();
		
		WebElement oppoOption7 = driver.findElement(By.xpath("//*[@id='fcf']/option[10]"));
		String option7 = oppoOption7.getText();
		
		Assert.assertEquals(option1, "All Opportunities");
		Assert.assertEquals(option2, "Closing Next Month");
		Assert.assertEquals(option3, "Closing This Month");
		Assert.assertEquals(option4, "My Opportunities");
		Assert.assertEquals(option5, "New This Week");
		Assert.assertEquals(option6, "Recently Viewed Opportunities");
		Assert.assertEquals(option7, "Won");
	}
	
	@Test
	public void createNewOpportunity() 
	{
		goToOpportunitiesTab();
				
		WebElement newButton = driver.findElement(By.xpath("//input[@title='New']"));
		clickElement(newButton, "new button");
		
		WebElement oppoName = driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(oppoName, "opp12", "oppoName");
		
		WebElement accountName = driver.findElement(By.xpath("//input[@id='opp3']"));
		enterText(accountName, "Ann", "accountName");
		
		WebElement closeDate = driver.findElement(By.xpath("//input[@id='opp9']"));
		clickElement(closeDate, "closeDate");
		
		WebElement selectDate = driver.findElement(By.xpath("//a[text()='Today']"));
		clickElement(selectDate, "selectDate");
		
		WebElement stage = driver.findElement(By.xpath("//select[@id='opp11']/option[@value='Closed Won']"));
		clickElement(stage, "stage");
		
		WebElement probability = driver.findElement(By.xpath("//input[@id='opp12']"));
		enterText(probability, "1", "probability");
		
		WebElement leadSource = driver.findElement(By.xpath("//select[@id='opp6']/option[@value='Web']"));
		clickElement(leadSource, "leadSource");
		
		WebElement camSource = driver.findElement(By.xpath("//input[@id='opp17']"));
		enterText(camSource, "1", "camSource");
		
		WebElement saveButton = driver.findElement(By.xpath("//*[@id='topButtonRow']/input[1]"));
		clickElement(saveButton, "saveButton");
	}
	
	@Test
	public void testOpportunityPiplineReport() 
	{
		goToOpportunitiesTab();
				
		WebElement oppoPipeline = driver.findElement(By.xpath("//div[@class='toolsContentLeft']//a[text()='Opportunity Pipeline']"));
		clickElement(oppoPipeline, "oppoPipeline");
		
		WebElement titleText = driver.findElement(By.xpath("//h1[text()='Opportunity Pipeline']"));
		Assert.assertEquals(titleText.getText(), "Opportunity Pipeline");
	}
	
	@Test
	public void testStuckOpportunityReport() 
	{
		goToOpportunitiesTab();
				
		WebElement oppoPipeline = driver.findElement(By.xpath("//div[@class='toolsContentLeft']//a[text()='Stuck Opportunities']"));
		clickElement(oppoPipeline, "oppoPipeline");
		
		WebElement titleText = driver.findElement(By.xpath("//h1[text()='Stuck Opportunities']"));
		Assert.assertEquals(titleText.getText(), "Stuck Opportunities");
	}
	
	@Test
	public void testQuarterlySummaryReport() 
	{
		goToOpportunitiesTab();
		
		WebElement runReport = driver.findElement(By.xpath("//input[@value='Run Report']"));
		clickElement(runReport, "runReport");
		
		WebElement titleText = driver.findElement(By.xpath("//h1[text()='Opportunity Report']"));
		Assert.assertEquals(titleText.getText(), "Opportunity Report");
	}
}
