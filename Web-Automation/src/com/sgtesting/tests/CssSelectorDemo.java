package com.sgtesting.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelectorDemo {

	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
	//	absolutecssSelector();
	//	relativecssPathUsingTagName();
	//	relativecssPathUsingTagNameAndIdAttributeValue();
	//	relativecssPathUsingIdAttributeValue();
	//	relativecssPathUsingTagNameAndClassAttributeValue();
	//	relativecssPathUsingClassAttributeValue();
	//	relativecssPathUsingTagNameWithAttributeNameValue();
	//	relativecssPathUsingAttributeNameValue();
	//	relativecssPathUsingTagNameWithMultipleAttributeNameValue();
	//	relativecssPathUsingTagNameWithAttributeNameandPartialAttributeValue();
	//	relativecssPathUsingTagNameWithAttributeName();
	//	relativecssPathUsingTagNameWithAttributeName_1();
	//	relativecssPathUsingTagNameWithAttributeName_2();
	//	relativecssPathUsingParentElementReference();
	//	relativecssPathUsingnthChild();
		relativecssPathUsingSibling();
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
	
	private static void absolutecssSelector()
	{
		oBrowser.findElement(By.cssSelector("html body div form input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 1: identify the Element based on tagName
	 * Syntax : <tagName>
	 */
	private static void relativecssPathUsingTagName()
	{
		oBrowser.findElement(By.cssSelector("input")).sendKeys("DemoUser2");
	}

	/**
	 * Case 2: identify the Element based on tagName with id attribute value
	 * Syntax : <tagName>#<id attribute value>
	 */
	private static void relativecssPathUsingTagNameAndIdAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input#pwd1pass1word1")).sendKeys("DemoUser3");
	}
	
	/**
	 * Case 3: identify the Element based on id attribute value
	 * Syntax : #<id attribute value>
	 */
	private static void relativecssPathUsingIdAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("#pwd1pass1word1")).sendKeys("DemoUser4");
	}
	
	/**
	 * Case 4: identify the Element based on tagName with class attribute value
	 * Syntax : <tagName>.<class attribute value>
	 */
	private static void relativecssPathUsingTagNameAndClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector("input.pass1word1")).sendKeys("DemoUser5");
	}
	
	/**
	 * Case 5: identify the Element based on class attribute value
	 * Syntax : .<class attribute value>
	 */
	private static void relativecssPathUsingClassAttributeValue()
	{
		oBrowser.findElement(By.cssSelector(".pass1word1")).sendKeys("DemoUser6");
	}
	
	/**
	 * Case 6: identify the Element based on <tagName> with attribute Name and Value combination
	 * Syntax : <tagName>[attributename='attributevalue']
	 */
	private static void relativecssPathUsingTagNameWithAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[value='Submit']")).click();
	}
	
	/**
	 * Case 7: identify the Element based on  attribute Name and Value combination
	 * Syntax : *[attributename='attributevalue']
	 */
	private static void relativecssPathUsingAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("*[value='Submit']")).click();
	}
	
	/**
	 * Case 8: identify the Element based on <tagName> with Multiple attribute Name and Value combination
	 * Syntax : <tagName>[attributename='attributevalue'][attributename='attributevalue']
	 */
	private static void relativecssPathUsingTagNameWithMultipleAttributeNameValue()
	{
		oBrowser.findElement(By.cssSelector("input[type='button'][value='Submit']")).click();
	}
	
	/**
	 * Case 9: identify the Element based on <tagName> with attribute Name and partial Value combination
	 * Syntax : <tagName>[attributename ^= 'attributevalue'] 
	 * Syntax : <tagName>[attributename $= 'attributevalue'] 
	 * Syntax : <tagName>[attributename *= 'attributevalue']
	 */
	private static void relativecssPathUsingTagNameWithAttributeNameandPartialAttributeValue()
	{
	//	oBrowser.findElement(By.cssSelector("input[id ^= 'btn1']")).click();
	//	oBrowser.findElement(By.cssSelector("input[id $= 'button1']")).click();
		oBrowser.findElement(By.cssSelector("input[id *= 'submit1']")).click();
	}
	
	/**
	 * Case 10: identify the Element based on <tagName> with attribute Name 
	 * Syntax : <tagName>[attributename]
	 */
	private static void relativecssPathUsingTagNameWithAttributeName()
	{
		// Find Number of Links available in the Web Page
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		System.out.println("Number of Links :"+oLinks.size());
	}
	
	private static void relativecssPathUsingTagNameWithAttributeName_1()
	{
		// Display Names of Links available in the Web Page
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<oLinks.size();i++)
		{
			WebElement link=oLinks.get(i);
			System.out.println(link.getText());
		}
	}
	
	private static void relativecssPathUsingTagNameWithAttributeName_2()
	{
		// Reproduce the Stale Element Reference Exception
		//org.openqa.selenium.StaleElementReferenceException: stale element reference: 
		// element is not attached to the page document
		List<WebElement> oLinks=oBrowser.findElements(By.cssSelector("a[href]"));
		for(int i=0;i<oLinks.size();i++)
		{
			WebElement link=oLinks.get(i);
			String linkText=link.getText();
			if(linkText.endsWith("Testing"))
			{
				link.click();
			}
		}
	}
	
	/**
	 * Case 11: identify the Element based on Parent Element Reference
	 * Syntax : <parentElement> ><childElement>
	 */
	private static void relativecssPathUsingParentElementReference()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 >input")).sendKeys("DemoUser1");
	}
	
	/**
	 * Case 12: identify the Element based on nth child concept
	 * Syntax : nthchild
	 */
	private static void relativecssPathUsingnthChild()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 >input:nth-child(4)")).sendKeys("DemoUser4");
		oBrowser.findElement(By.cssSelector("form#frm3 >input:nth-child(5)")).sendKeys("DemoUser5");
		oBrowser.findElement(By.cssSelector("form#frm3 >input:nth-child(6)")).sendKeys("DemoUser6");
	}
	
	/**
	 * Case 13: identify the Element based on sibling concept
	 * Syntax : sibling + sibling + sibling
	 */
	private static void relativecssPathUsingSibling()
	{
		oBrowser.findElement(By.cssSelector("form#frm3 >input + input")).sendKeys("DemoUser2");
		oBrowser.findElement(By.cssSelector("form#frm3 >input + input + input")).sendKeys("DemoUser3");
		oBrowser.findElement(By.cssSelector("form#frm3 >input + input + input + input")).sendKeys("DemoUser4");
	}
}
