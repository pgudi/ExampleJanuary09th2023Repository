package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WithWebElementDemo {

	public static WebDriver oBrowser;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
		login();
	
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
			oBrowser.navigate().to("http://localhost/login.do");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	private static void login()
	{
		
		try
		{
			WebElement oEle=null;
			oEle=oBrowser.findElement(By.id("username"));
			oEle.sendKeys("DemoUser1");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser2");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser3");
			Thread.sleep(2000);
			oEle.clear();
			Thread.sleep(2000);
			oEle.sendKeys("DemoUser12345");
			Thread.sleep(2000);
			String val1=oEle.getAttribute("value");
			System.out.println(val1);
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
