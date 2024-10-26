package com.automation.base;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	protected static WebDriver driver = null;
	private WebDriverWait wait = null;
	
	public static void launchBrowser(String browserName){
		
		switch(browserName.toLowerCase()){
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			break;
		default:
			break;
		}		
	}
	
	public static void goToUrl(String url)
	{
		driver.get(url);
	}
	
	public static void closeDriver()
	{
		driver.close();
	}
	
	public static void enterText(WebElement ele, String data, String objectName)
	{
		if(data!= "")
		{
			if(ele.isDisplayed())
			{
				ele.clear();
				ele.sendKeys(data);
				System.out.println("data is entered in the " +objectName);
			}
			else
			{
				System.out.println(objectName+ " textbox is not displayed");
			}
		}
		else {
			System.out.println(objectName+ " can not be empty");
		}
		
	}
	
	public static void radioButton(WebElement ele, String objectName)
	{
		if(!ele.isSelected())
		{
			ele.click();
			System.out.println(objectName+ " selected");
		}
		else
		{
			System.out.println(objectName+ " button is already selected");
		}
	}
	
	public static void clickElement(WebElement ele, String objectName)
	{
		if(ele.isEnabled())
		{
			ele.click();
			System.out.println(objectName +" button is clicked");
		}
		else {
			System.out.println(objectName +" button is not enabled");
		}
	}
	
	public void selectByTextData(WebElement ele, String value)
	{
		Select select =  new Select(ele);
		select.selectByVisibleText(value);
		
	}
	
	public void selectByValueData(WebElement ele, String value)
	{
		Select select =  new Select(ele);
		select.selectByValue(value);
	}
	
	public void selectByIndexData(WebElement ele, int value)
	{
		Select select =  new Select(ele);
		select.deselectByIndex(value);	
	}
	
	public static void checkBoxSelected(WebElement ele, String objectName)
	{
		if(!ele.isSelected())
		{
			ele.click();
			System.out.println(objectName+ " Checkbox selected");
		}
	}
	
	public static void selected(WebElement ele, String value,String objectName)
	{
		Select select = new Select(ele);
		select.selectByValue(value);
		System.out.println(objectName + "is selected");
	}
	
	public void waitForVisibility1(WebElement ele, long timeInSec,String objectName)
	{
		System.out.println("waiting for visiblity of "+objectName+ " for " +timeInSec);
		wait = new WebDriverWait(driver, timeInSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}
	
	public void takeScreenshot(String filepath)
	{
		System.out.println("inside take screenshot");
		System.out.println(filepath);
		TakesScreenshot screenCapture = (TakesScreenshot)driver;
		File src = screenCapture.getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		try {
			Files.copy(src, destFile);
			System.out.println("Screen captured");
		}
		catch(IOException e)
		{
			e.printStackTrace();
			System.out.println("Problem occured while taking screenshot");
		}	
	}
}
