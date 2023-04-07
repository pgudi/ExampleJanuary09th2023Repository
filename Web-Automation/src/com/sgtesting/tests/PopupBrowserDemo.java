package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class PopupBrowserDemo {
	public static WebDriver oBrowser;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
		handlePopups();
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
	
	private static void handlePopups()
	{
		try
		{
			System.out.println("Before click on link Number of Popus:"+getPopupCount());
			oBrowser.findElement(By.linkText("actiTIME Inc.")).click();
			Thread.sleep(2000);
			System.out.println("After click on link Number of Popus:"+getPopupCount());
			if(getPopupCount()>0)
			{
				popupBrowsers();
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static int getPopupCount()
	{
		int count=0;
		count=oBrowser.getWindowHandles().size()-1;
		return count;
	}
	
	private static void popupBrowsers()
	{
		try
		{
			String parentBrowser=null;
			parentBrowser=oBrowser.getWindowHandle();
			System.out.println("Parent Browser :"+parentBrowser);
			Object[] popups=oBrowser.getWindowHandles().toArray();
			for(int i=1;i<popups.length;i++)
			{
				String childBrowser=popups[i].toString();
				System.out.println("Child Browser :"+childBrowser);
				oBrowser.switchTo().window(childBrowser);
				Thread.sleep(2000);
				String title=oBrowser.getTitle();
				System.out.println("Title :"+title);
				String url=oBrowser.getCurrentUrl();
				System.out.println("URL :"+url);
				Thread.sleep(2000);
				oBrowser.findElement(By.linkText("Try Free")).click();
				Thread.sleep(2000);
			}
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
