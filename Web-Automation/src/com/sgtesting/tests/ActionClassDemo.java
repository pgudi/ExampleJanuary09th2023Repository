package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionClassDemo {

	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
		moveToHomeMenuOption();
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
			oBrowser.navigate().to("https://www.flipkart.com/");
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private static void moveToHomeMenuOption()
	{
		try
		{
			oBrowser.findElement(By.xpath("//button[text()='✕']")).click();
			Thread.sleep(5000);
			Actions oMouse=new Actions(oBrowser);
			WebElement oHome=oBrowser.findElement(By.xpath("//div[text()='Home']"));
			oMouse.moveToElement(oHome).build().perform();
			Thread.sleep(2000);
			WebElement oKitchen=oBrowser.findElement(By.xpath("//a[text()='Kitchen & Dining']"));
			oMouse.moveToElement(oKitchen).build().perform();
			Thread.sleep(2000);
			WebElement oLunchBox=oBrowser.findElement(By.xpath("//a[text()='Lunchboxes, Bottles & Flasks']"));
			oMouse.moveToElement(oLunchBox).build().perform();
			Thread.sleep(2000);
			oMouse.click(oLunchBox).build().perform();
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
