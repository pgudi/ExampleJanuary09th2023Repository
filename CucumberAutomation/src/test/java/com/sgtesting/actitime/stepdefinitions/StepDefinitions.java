package com.sgtesting.actitime.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	public static WebDriver oBrowser=null;
	/**
	 *  I launch the Chrome Browser
	 */
	@Given("^I launch the Chrome Browser$")
	public void I_launch_the_Chrome_Browser()
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
	
	/**
	 *  I navigate the application url
	 */
	@Given("^I navigate the application url$")
	public void I_navigate_the_application_url()
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
	
	/**
	 *  I enter the username in username text field
	 */
	@When("^I enter the \"(.*)\" in username text field$")
	public void I_enter_the_username_in_username_text_field(String username)
	{
		try
		{
			oBrowser.findElement(By.id("username")).sendKeys(username);
			Thread.sleep(1000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I enter the password in password text field
	 */
	@And("^I enter the \"(.*)\" in password text field$")
	public void I_enter_the_password_in_password_text_field(String password)
	{
		try
		{
			oBrowser.findElement(By.name("pwd")).sendKeys(password);
			Thread.sleep(1000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	/**
	 *  I click on login button
	 */
	@And("^I click on login button$")
	public void I_click_on_login_button()
	{
		try
		{
			oBrowser.findElement(By.xpath("//*[@id='loginButton']/div")).click();
			Thread.sleep(5000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I find the Home Page
	 */
	@Then("^I find the Home Page$")
	public void I_find_the_Home_Page()
	{
		try
		{
			WebElement oEle=oBrowser.findElement(By.xpath("//td[text()='Enter Time-Track']"));
			Assert.assertTrue(oEle.isDisplayed());
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I minimize the flyout window
	 */
	@And("^I minimize the flyout window$")
	public void I_minimize_the_flyout_window()
	{
		try
		{
			oBrowser.findElement(By.id("gettingStartedShortcutsPanelId")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I click on Logout link
	 */
	@When("^I click on Logout link$")
	public void I_click_on_Logout_link()
	{
		try
		{
			oBrowser.findElement(By.linkText("Logout")).click();
			Thread.sleep(2000);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 *  I find the login page
	 */
	@Then("^I find the login page$")
	public void I_find_the_login_page()
	{
		try
		{
			String expected,actual;
			expected="actiTIME - Login";
			actual=oBrowser.getTitle();
			Assert.assertEquals(expected, actual);
		}catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	@Given("^I connect to the Oracle Database$")
	public void I_connect_to_the_Oracle_Database()
	{
		System.out.println("I connect to the Oracle Database");
	}
	
	@When("^I fetch records from Database tables$")
	public void I_fetch_records_from_Database_tables()
	{
		System.out.println("I fetch records from Database tables");
	}
}
