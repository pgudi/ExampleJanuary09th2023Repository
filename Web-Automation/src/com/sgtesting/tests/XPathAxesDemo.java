package com.sgtesting.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XPathAxesDemo {

	private static WebDriver oBrowser=null;
	public static void main(String[] args) {
		launchBrowser();
		navigateURL();
	//	enterSalryForPersonSachinTendulkar();
	//	enterSalryForPersonWhoIsNextToSachinTendulkar();
	//	makeIndianFreedomFighterStatusAsActive();
	//	makeStatusAsActiveWhoIsPreviousToRahulDravid();
	//	makeStatusAsActiveBasedOnSalaryField();
		basedOnTableEnterSAlaryFor4thPerson();
		
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
			oBrowser.navigate().to("file:///E:/HTML/WebTableHTML.html");
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  following-sibling
	 *  case 1: Enter the salary for person Sachin Tendulkar
	 *  
	 */
	private static void enterSalryForPersonSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following-sibling::td[4]/input")).sendKeys("25000");
	}

	/**
	 *  following
	 *  case 2: Enter the salary for person who is next to Sachin Tendulkar
	 *  
	 */
	private static void enterSalryForPersonWhoIsNextToSachinTendulkar()
	{
		oBrowser.findElement(By.xpath("//td[text()='Sachin Tendulkar']/following::tr[1]/td[6]/input")).sendKeys("15000");
	}
	
	/**
	 *  preceding-sibling
	 *  case 3: Make Indian Freedom Fighter Status As Active
	 *  
	 */
	private static void makeIndianFreedomFighterStatusAsActive()
	{
		oBrowser.findElement(By.xpath("//td[text()='Indian Freedom Fighter']/preceding-sibling::td[1]/preceding-sibling::td[1]/input")).click();
	}
	
	/**
	 *  preceding
	 *  case 4: Make the Status As Active for Person Who is Previous to Rahul Dravid
	 *  
	 */
	private static void makeStatusAsActiveWhoIsPreviousToRahulDravid()
	{
		oBrowser.findElement(By.xpath("//td[text()='Rahul Dravid']/preceding::tr[1]/td[1]/input")).click();
	}
	
	/**
	 *  ancestor
	 *  case 5: Make the Status As Active Based On Salary Text Field
	 *  
	 */
	private static void makeStatusAsActiveBasedOnSalaryField()
	{
		oBrowser.findElement(By.xpath("//input[@id='edit2']/ancestor::tr[1]/td[1]/input")).click();
	}
	
	/**
	 *  descendant
	 *  case 6: Based ON Table tagName enter salary for 4th Record
	 *  
	 */
	private static void basedOnTableEnterSAlaryFor4thPerson()
	{
		oBrowser.findElement(By.xpath("//table[@id='tbl1']/descendant::tr[4]/td[6]/input")).sendKeys("15000");
	}
}
