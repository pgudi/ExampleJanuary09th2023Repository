package com.sgtesting.om;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LoginLogoutDemo {
	public static String fileName=null;
	public static WebDriver oBrowser=null;
	public static ObjectMap om=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
		login();
		minimizeFlyOutWindow();
		logout();
		closeApp();
	}
	
	private static void launchBrowser()
	{
		try
		{
			System.setProperty("webdriver.chrome.driver", ".\\Library\\drivers\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			oBrowser=new ChromeDriver(options);
			//Object Map Creation
			fileName=".//objectmap//objectmap.properties";
			om=new ObjectMap(fileName);
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
			oBrowser.findElement(om.getLocator("loginusername")).sendKeys("admin");
			oBrowser.findElement(om.getLocator("loginpassword")).sendKeys("manager");
			oBrowser.findElement(om.getLocator("loginloginbutton")).click();
			Thread.sleep(4000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void minimizeFlyOutWindow()
	{
		try
		{
			oBrowser.findElement(om.getLocator("homepageflyoutwin")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void logout()
	{
		try
		{
			oBrowser.findElement(om.getLocator("homepagelogout")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void closeApp()
	{
		try
		{
			oBrowser.quit();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
