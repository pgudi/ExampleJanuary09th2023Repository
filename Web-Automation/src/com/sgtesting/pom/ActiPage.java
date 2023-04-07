package com.sgtesting.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPage {
	
	public ActiPage(WebDriver oBrowser)
	{
		PageFactory.initElements(oBrowser, this);
	}
	
	//WebElement for User Name text field
	private WebElement username;
	
	public WebElement getUserName()
	{
		return username;
	}
	
	//WebElement for password text field
	private WebElement pwd;
	public WebElement getPassword()
	{
		return pwd;
	}
	
	//WebElement for Login Button
	@FindBy(xpath="//div[text()='Login ']")
	private WebElement oLogin;
	public WebElement getLogin()
	{
		return oLogin;
	}
	
	//WebElement for flyoutwindow
	private WebElement gettingStartedShortcutsPanelId;
	public WebElement getFlyOutWindow()
	{
		return gettingStartedShortcutsPanelId;
	}
	
	//WebElement for Logout Link
	@FindBy(linkText = "Logout")
	private WebElement oLogout;
	public WebElement getLogout()
	{
		return oLogout;
	}

}
