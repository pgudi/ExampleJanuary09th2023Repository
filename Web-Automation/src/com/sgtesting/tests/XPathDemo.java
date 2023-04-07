package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathDemo {
	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
	//	absoluteXPath();
	//	relativeXpathBasedOnTagName();
	//	relativeXpathBasedOnTagNameWithIndex();
	//	relativeXpathWithTagNameAndAttributeNameValue();
	//	relativeXpathWithAttributeNameValue();
	//	relativeXpathWithAttributeValue();
	//	relativeXpathWithTagNameWithMultipleAttributeNameValue();
	//	relativeXpathWithTagNameWithMultipleAttributeNameValueUsingOR();
	//	relativeXpathWithTagNameWithMultipleAttributeNameValueUsingAND();
	//	relativeXpathWithPartialMatchingOfAttributeValue();
	//	relativeXpathWithTagNameAndAttributeName();
	//	relativeXpathWithTagNameAndAttributeName_1();
	//	relativeXpathWithTagNameAndAttributeName_2();
	//	relativeXpathWithTagNameAndAttributeName_3();
	//	relativeXpathWithTagNameAndTextContent();
		relativeXpathWithTagNameAndPartialTextContent();
	}
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			oBrowser=new ChromeDriver(options);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void navigateURL()
	{
		try
		{
			oBrowser.navigate().to("file:///E:/HTML/Sample.html");
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	private static void absoluteXPath()
	{
		oBrowser.findElement(By.xpath("html/body/div/form/input")).sendKeys("DemoUser1");
		
	}
	
	/**
	 * Case 1: identify the element based on tagName
	 * syntax: //<tagName>
	 */
	private static void relativeXpathBasedOnTagName()
	{
		oBrowser.findElement(By.xpath("//input")).sendKeys("DemoUser1");
	}

	/**
	 * Case 2: identify the element based on tagName with index
	 * syntax: //<tagName>[index]
	 */
	private static void relativeXpathBasedOnTagNameWithIndex()
	{
		oBrowser.findElement(By.xpath("//input[2]")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 3: identify the element based on tagName with 
	 *			Attribute Name and Value Combination
	 * syntax: //<tagName>[@attributename='attributevalue']
	 */
	private static void relativeXpathWithTagNameAndAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//input[@value='Submit']")).click();
	}
	
	/**
	 * Case 4: irrespective of tagName,identify the element based on  
	 *			Attribute Name and Value Combination
	 * syntax: //*[@attributename='attributevalue']
	 */
	private static void relativeXpathWithAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//*[@value='Submit']")).click();
	}
	
	/**
	 * Case 5: irrespective of tagName, irrespective of  
	 *			Attribute Name, identify based on attribute Value 
	 * syntax: //*[@*='attributevalue']
	 */
	private static void relativeXpathWithAttributeValue()
	{
		oBrowser.findElement(By.xpath("//*[@*='Submit']")).click();
	}
	
	/**
	 * Case 6: identify the element based on tagName with 
	 *			Multiple Attribute Name and Value Combination
	 * syntax: //<tagName>[@attributename1='attributevalue'][@attributename2='attributevalue']
	 */
	private static void relativeXpathWithTagNameWithMultipleAttributeNameValue()
	{
		oBrowser.findElement(By.xpath("//input[@name='submit1btn1'][@value='Submit']")).click();
	}
	
	/**
	 * Case 7: identify the element based on tagName with 
	 *			Multiple Attribute Name and Value Combination using OR operator
	 * syntax: //<tagName>[@attributename1='attributevalue' or @attributename2='attributevalue']
	 */
	private static void relativeXpathWithTagNameWithMultipleAttributeNameValueUsingOR()
	{
		oBrowser.findElement(By.xpath("//input[@name='submit1btn1' or @value='Submit']")).click();
	}
	
	/**
	 * Case 8: identify the element based on tagName with 
	 *			Multiple Attribute Name and Value Combination using AND operator
	 * syntax: //<tagName>[@attributename1='attributevalue' and @attributename2='attributevalue']
	 */
	private static void relativeXpathWithTagNameWithMultipleAttributeNameValueUsingAND()
	{
		oBrowser.findElement(By.xpath("//input[@name='submit1btn1' and @value='Submit']")).click();
	}
	
	/**
	 * Case 9: identify the element based on  
	 *			partial matching of Attribute Value 
	 * syntax: 
	 *  starts-with(@attributeName,'attributeValue')
	 *  ends-with(@attributeName,'attributeValue')
	 *  contains(@attributeName,'attributeValue')
	 * 
	 *  //<tagName>[starts-with(@attributeName,'attributeValue')]
	 *  //<tagName>[ends-with(@attributeName,'attributeValue')]
	 *  //<tagName>[contains(@attributeName,'attributeValue')]
	 */
	private static void relativeXpathWithPartialMatchingOfAttributeValue()
	{
	//	oBrowser.findElement(By.xpath("//input[starts-with(@id,'btn1')]")).click();
		oBrowser.findElement(By.xpath("//input[contains(@id,'submit')]")).click();
	}
	
	/**
	 * Case 10: identify the element based on tagName with 
	 *			Attribute Name Combination
	 * syntax: //<tagName>[@attributename]
	 */
	private static void relativeXpathWithTagNameAndAttributeName()
	{
		// find out number of links in the application
		List<WebElement> links=oBrowser.findElements(By.xpath("//a[@href]"));
		System.out.println("# of Links in Application :"+links.size());
	}
	
	private static void relativeXpathWithTagNameAndAttributeName_1()
	{
		// Display all names of links in the application
		List<WebElement> links=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<links.size();i++)
		{
			WebElement link=links.get(i);
			System.out.println(link.getText());
		}
	}
	
	private static void relativeXpathWithTagNameAndAttributeName_2()
	{
		// Based on ends with text content identify the link
		try
		{
			List<WebElement> links=oBrowser.findElements(By.xpath("//a[@href]"));
			for(int i=0;i<links.size();i++)
			{
				WebElement link=links.get(i);
				String linkContent=link.getText();
				if(linkContent.endsWith("HQ"))
				{
					link.click();
					Thread.sleep(2000);
					break;
				}
			}
			oBrowser.navigate().back();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void relativeXpathWithTagNameAndAttributeName_3()
	{
		// org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// element is not attached to the page document
		List<WebElement> links=oBrowser.findElements(By.xpath("//a[@href]"));
		for(int i=0;i<links.size();i++)
		{
			WebElement link=links.get(i);
			String linkContent=link.getText();
			if(linkContent.endsWith("HQ"))
			{
				link.click();
			}
		}
	}
	
	/**
	 * Case 11: identify the element based on tagName with 
	 *			Text Content Combination
	 * syntax: //<tagName>[text()='text Content']
	 */
	private static void relativeXpathWithTagNameAndTextContent()
	{
		oBrowser.findElement(By.xpath("//a[text()='POI Apache']")).click();
	}
	
	/**
	 * Case 12: identify the element based on tagName with 
	 *			Partial Text Content
	 * syntax: 
	 *  starts-with(text(),'partial text content')
	 *  ends-with(text(),'partial text content')
	 *  contains(text(),'partial text content')
	 *  
	 *  //<tagName>[starts-with(text(),'partial text content')]
	 *  //<tagName>[ends-with(text(),'partial text content')]
	 *  //<tagName>[contains(text(),'partial text content')]
	 */
	private static void relativeXpathWithTagNameAndPartialTextContent()
	{
	//	oBrowser.findElement(By.xpath("//a[starts-with(text(),'Eclipse')]")).click();
		oBrowser.findElement(By.xpath("//a[contains(text(),'Software')]")).click();
	}
}
