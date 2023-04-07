package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class JavaScriptExecutorDemo {

	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
		displayTitle();
		displayURL();
		displayLinksCount();
	//	enterValueInTextField1();
	//	enterValueInTextField2();
	//	clickOnButton1();
	//	clickOnButton2();
	//	clickOnCheckBox1();
	//	clickOnCheckBox2();
	//	clickOnRadioButton1();
	//	clickOnRadioButton2();
		selectItemsFromDropDown();
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
	
	private static void displayTitle()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		String title=(String) js.executeScript("var kk=document.title;return kk;");
		System.out.println("Title of the Web Page :"+title);
	}

	private static void displayURL()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		Object url=js.executeScript("let kk=document.URL;return kk;");
		System.out.println("URL of the Web Page :"+url);
	}
	
	private static void displayLinksCount()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		Object count= js.executeScript("var link=document.getElementsByTagName('A');return link.length");
		System.out.println("# of Links in the Web Page :"+count);
	}
	/**
	 *  Identify Text Fields
	 */
	private static void enterValueInTextField1()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('uid1user1name1').value='DemoUser1';");
	}
	/**
	 *  Identify Text Fields
	 */
	private static void enterValueInTextField2()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		WebElement oEle=oBrowser.findElement(By.id("pwd1pass1word1"));
		js.executeScript("arguments[0].value='DemoUser123';", oEle);
	}
	/**
	 *  Identify Buttons
	 */
	private static void clickOnButton1()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('btn1submit1button1').click();");
	}
	
	/**
	 *  Identify Buttons
	 */
	private static void clickOnButton2()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		WebElement oEle=oBrowser.findElement(By.id("btn1submit1button1"));
		js.executeScript("arguments[0].click();", oEle);
	}
	
	/**
	 *  Identify CheckBox
	 */
	private static void clickOnCheckBox1()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('chk1windows').click();");
	}
	
	/**
	 *  Identify CheckBox
	 */
	private static void clickOnCheckBox2()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		WebElement oEle=oBrowser.findElement(By.id("chk2linux"));
		js.executeScript("arguments[0].click();", oEle);
	}
	
	/**
	 *  Identify Radio Button
	 */
	private static void clickOnRadioButton1()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		js.executeScript("document.getElementById('rad1chrome').click();");
	}
	
	/**
	 *  Identify Radio Button
	 */
	private static void clickOnRadioButton2()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		WebElement oEle=oBrowser.findElement(By.id("rad2firefox"));
		js.executeScript("arguments[0].click();", oEle);
	}
	
	/**
	 * Select Items from Drop Down
	 * 
	 */
	private static void selectItemsFromDropDown()
	{
		JavascriptExecutor js=(JavascriptExecutor) oBrowser;
		String str="var list=document.getElementById('tools');";
		str+="for(var i=0;i<list.length;i++)";
		str+="{";
		str+="if(list[i].text=='Selenium RemoteControl')";
		str+="{";
		str+="list[i].selected='1';";
		str+="}";
		str+="}";
		js.executeScript(str);
	}
}
